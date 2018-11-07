
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metelevamd
 */
public class ReceiptProcessor {
    
    private static String desiredCode = "";                                     // искомый код
    private static boolean codeEqual = false;                                   // флаг совпадения кодов
    private static ArrayList<ArrayList<String>> receipts = new ArrayList<>();   // массив чеков
    private static int processMode = 0;                                         // режим обработки
    
    // возвращает строку, где сформированы данные по чекам без лишней информации
    // и запускает поиск продукции с нужным кодом в чеках 
    public static String start(ArrayList<String> receiptStringsArray, String code, String path, String TT, String IP) {
        
        desiredCode = code;
        
        // приводим строки к нижнему регистру
        for (int i = 0; i < receiptStringsArray.size(); i++) receiptStringsArray.set(i, receiptStringsArray.get(i).toLowerCase());        
        
        // выделяем нужную информацию по чекам и ищем нужный код
        receipts = parse(receiptStringsArray);
        
        if (receipts.isEmpty()) JOptionPane.showMessageDialog(null, "Ничего не найдено");
        else ExcelWriter.write(receipts, path, TT, IP);
        
        return printReceiptsData();
           
    }
    
    // деление текста на отдельные чеки
    private static ArrayList<ArrayList<String>> parse(ArrayList<String> receiptStringsArray) {
        
        int stage = 0;
        ArrayList<ArrayList<String>> receipts = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        String productString = "";
        int stringCounter = 0;
        
        // режим обработки зависит от вида чиков, 
        // главное их различие -- в длине строки, остальные тонкости
        // учитываются по ходу дела
        
        for (int i = 0; i < receiptStringsArray.size(); i++) 
            if (receiptStringsArray.get(i).contains("чек №")) {
                if (receiptStringsArray.get(i).length() > 44) processMode = 2;
                    else processMode = 1;
                break;
            }
        
        for (int i = 0; i < receiptStringsArray.size(); i++) {
            
            String S = receiptStringsArray.get(i).trim();
            
            if (S.contains("false")) {
                stage = 0;
                productString = "";
                continue;
            }
            
            if (S.contains("кассир")) continue;
            
            if (!S.isEmpty()) {
            
                switch (stage) {
                    // нулевая стадия -- ищем начало чека
                    case 0 : { 
                        
                        stringCounter = 0;
                        
                        // пытаемся получить номер чека из строки
                        String num = getReceiptNumber(S);

                        if (!num.equals("NON")) {

                            // ищу копии чека
                            boolean f = false;
                            for (ArrayList<String> r : receipts) {
                                if (r.get(0).equals(num)) {
                                    f = true;
                                    break;
                                }
                            } 

                            // если копий нет, то начинаем обработку нового чека
                            if (!f) {
                                list.clear();
                                list.add(num);
                                stage++;
                            }

                        } 

                        break;
                    }

                    // первая стадия -- считывание товаров из чека
                    case 1 : {
                        
//                        if (!S.equals("------------------------------------------") && !S.equals("==========================================")) {
                        if (!isProductDelimiter(S, '-') && !isProductDelimiter(S, '=')) {
                            productString += S + "\n"; 
                            stringCounter++;
                        } else {
                            if (stringCounter > 2) list.add(proccesProductString(productString));                        
                            productString = "";
                        }

//                        if (S.equals("==========================================")) {
                        if (isProductDelimiter(S, '=')) {
                            stringCounter = 0;
                            stage++;
                        }

                        break;
                    }

                    // обработка строки "ИТОГО"
                    case 2 : {                    
                        list.add(getCheckAmount(S));
                        stage++;
                        break;
                    }

                    // обработка даты и времени, запись чека в массив
                    case 3 : {

                        if (codeEqual && !S.contains("продавец")) {
                            
                            String dataAndTime[] = getDataAndTime(S);
                            list.add(dataAndTime[0]);
                            list.add(dataAndTime[1]);

                            ArrayList<String> listCopy = new ArrayList<>();
                            for (String s : list) listCopy.add(s);                    
                            receipts.add(listCopy);

                            codeEqual = false;
                        }
                        
                        if (!S.contains("продавец")) stage = 0;
                        break;
                    }

                }
            }
            
        }      
        
        return receipts;
        
    }
    
    // возвращает номер чека:
    // если строка соответсвует формату, то будет возвращён номер, 
    // иначе значение "NON"
    private static String getReceiptNumber(String S) {
        
        String res = "";        
        S = S.replaceAll(" ", "");
        S = S.trim();
        
        Pattern p = Pattern.compile("чек№\\d+");  
        Matcher m = p.matcher(S); 
        
        if (m.matches()) res = S.substring(S.indexOf('№') + 1, S.length());
            else res = "NON";
        
        return res;       
        
    }
     
    private static String proccesProductString(String S) {
        
        String code     = "", // код
               product  = "", // название продукта
               sum      = "",
               number   = ""; // сумма
        
        ArrayList<String> strings = new ArrayList<>();
        
        // делим строку на подстроки по знаку переноса строки
        StringTokenizer st = new StringTokenizer(S, "\n");
        
        // записываем подстроки в массив
        while (st.hasMoreTokens()) {
            strings.add(st.nextToken());
        }
        
        switch (processMode) {
            
            case 1 : {
                
                // ищем строку содержащую слово "ставка"
                int lastString = 0;
                for (int i = 0; i < strings.size(); i++) {
                    if (strings.get(i).contains("ставка") || strings.get(i).contains("скидка") || strings.get(i).contains("скидака")) {  // Скидака
                        lastString = i;
                        break;
                    } 
                }

                boolean f = false;
                int index = 0;
                while (!f)
                    try {
                        sum = strings.get(lastString - index);
                        number = strings.get(lastString - index);

                        // количество товара
                        int indexOfDelimiter = number.indexOf("*");
                        number = number.substring(0, indexOfDelimiter);
                        number = number.trim();

                        f = true;
                    } catch (Exception e) {
                        index++;                
                    }

                //получаем сумму товара
                int count = 0;
                for (int i = 0; i < sum.length(); i++) 
                    if (sum.charAt(i) == '.') {
                        count++;
                        if (count > 2) {                    
                            for (int j = i; j < sum.length(); j++)
                                if (isDigit(sum.charAt(j))) { 
                                    sum = sum.substring(j);
                                    break;
                                }                    
                            break;                    
                        }
                    }

                // получаем строку, содержащую код и наименование товара 
                String codeAndProduct = "";
                for (int i = 0; i < lastString - index; i++) {
                    codeAndProduct += strings.get(i);
                }

                // получение кода и продукта отдельно
                int stage = 0,
                    a = 0, b = 0; 
                boolean end = false;
                for (int i = 0; i < codeAndProduct.length(); i++) {

                    char c = codeAndProduct.charAt(i);

                    switch (stage) {

                        case 0 : {  

                            if (c == '(' || c == '{' || c == '\'') a = i + 1;
                            else if (c == ')' || c == '}' || c == '\'') {
                                b = i;
                                code = codeAndProduct.substring(a, b);                        
                                if (desiredCode.equals("NON") || code.equals(desiredCode)) codeEqual = true;
                                stage++;
                            }

                            break;
                        }

                        case 1 : {

                            product = codeAndProduct.substring(b + 1);
                            product = product.trim();
                            product = deleteExtraDelimiters(product);
                            end = true;

                            break;
                        }

                    }
                    if (end) break; 
                }                
                
                break;
            }
            
            case 2: {
                
                int codeString = 0;
                for (int i = 0; i < strings.size(); i++) {
                    
                    String s = strings.get(i);
                    
                    if (s.contains("код")) {
                        codeString = i;
                        code = getProductSum(strings.get(i));
                        int index = code.indexOf(" ");
                        code = code.substring(index).trim();
                        if (desiredCode.equals("NON") || code.equals(desiredCode)) codeEqual = true;
                    } else if (s.contains("всего")) 
                        sum = getProductSum(strings.get(i));
                    else if (s.contains("количество"))
                        number = getProductSum(strings.get(i));
                    
                }
                
                for (int i = 0; i < codeString; i++) product += strings.get(i);
                int index = product.indexOf(".");
                product = product.substring(index + 1).trim();
                product = deleteExtraDelimiters(product);
                
            }
            
        }
        
        return code + "|" + product + "|" + sum + "|" + number; 
        
    }
    
    private static boolean isDigit(char c) {
        return "0123456789".indexOf(c) != -1;
    }
    
    private static boolean isSpace(char c) {
        return "    ".indexOf(c) != -1;
    }
    
    private static String deleteExtraDelimiters(String S) {
        
        String newS = "";
        S += '$';
        
        int i = 0;
        while (S.charAt(i) != '$') {
            if (!isSpace(S.charAt(i)) || (isSpace(S.charAt(i)) && !isSpace(S.charAt(i + 1)))) newS += S.charAt(i);
            i++;
        }
        
//        int index = 0;
//        for (i = newS.length() - 1; i > 0; i--) {
//            if (newS.charAt(i) == '.' && newS.charAt(i - 1) == '.') index = i - 1;
//        } 
        
//        newS = newS.substring(0, index);        
        return newS;
        
    }
    
    private static String getCheckAmount(String S) {
        
        String total = "";
        
        for (int i = 0; i < S.length(); i++) 
            if (isDigit(S.charAt(i))) {
                total = S.substring(i);
                break;
            }
        
        return total;
    }
    
    private static String[] getDataAndTime(String S) {
        
        String result[] = new String[2];
        
        int index = S.indexOf(' ');
        if (index != -1) {
            
            result[0] = S.substring(0, index);
            result[1] = S.substring(index + 1);
            
        }
        
        return result;
        
    }
    
    private static String[] divideString(String S) {
        
        String result[] = new String[4];        
        int index = 0;
            StringTokenizer st = new StringTokenizer(S, "|");
            while (st.hasMoreTokens()) {                
                if (index < 4) {
                    result[index] = st.nextToken();
                    index++;
                }       
            }
        
        return result;
    }
    
    private static String printReceiptsData() {
        
        String result = "";
        
        for (ArrayList<String> receipt : receipts) {
            for (int i = 0; i < receipt.size(); i++) {
                
                if (i == 0)                                                     // заголовок  "чек №..." 
                    result += (">> чек №" + receipt.get(i) + "\n");
                
                else if (i == receipt.size() - 3)                                // общая сумма чека "ИТОГО"
                    result += ("  > итого = " + receipt.get(i) + "\n"); 
                
                else if ((i == receipt.size() - 2) || (i == receipt.size() - 1))// дата  и время 
                    result += ("  > " + receipt.get(i) + "\n");
                else {                                                          // строки с товарами
                    String parts[] = divideString(receipt.get(i));                    
                    result += ("      (" + parts[0] + ") " + parts[1] + " [" + parts[3] + " * " + parts[2] + "]\n");
                }
            }
            
            result += "\n";
            
        }
        
        return result;       
        
    }
    
    private static boolean isProductDelimiter(String S, char c) {        
        for (int i = 0; i < S.length(); i++) 
            if (S.charAt(i) != c) return false;  
        return true;        
    }
    
    private static String getProductSum(String s) {
        
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) 
            if (s.charAt(i) == '.') {
                count++;
                if (count > 2) {                    
                    for (int j = i; j < s.length(); j++)
                        if (isDigit(s.charAt(j))) { 
                            s = s.substring(j);
                            break;
                        }                    
                    break;                    
                }
            }
        
        return s;
        
    }
}
