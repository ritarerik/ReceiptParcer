
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metelevamd
 */
public class Parser {
    
    // возвращает строку, где сформированы данные по чекам без лишней информации
    // и запускает поиск продукции с нужным кодом в чеках 
    public static String start(ArrayList<String> receiptStringsArray, String code) {
        
        String result = "";
        
        // приводим строки к нижнему регистру
        for (int i = 0; i < receiptStringsArray.size(); i++) receiptStringsArray.set(i, receiptStringsArray.get(i).toLowerCase());        
        
        // выделяем нужную информацию по чекам
        ArrayList<ArrayList<String>>receipts = getReceipts(receiptStringsArray);
        
        // ищем продукцию с нужным кодом в чеках
        searchCodeInReceipts(receipts, code);
        
        return printReceiptsData(receipts);    
           
    }
    
    // деление текста на отдельные чеки
    private static ArrayList<ArrayList<String>> getReceipts(ArrayList<String> receiptStringsArray) {
        
        int stage = 0;
        ArrayList<ArrayList<String>> receipts = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        String productString = "";
        
        for (int i = 0; i < receiptStringsArray.size(); i++) {
            
            String S = receiptStringsArray.get(i);
            
            switch (stage) {
                // нулевая стадия -- ищем начало чека
                case 0 : { 
                    
                    // пытаемся получить номер чека из строки
                    String num = getRecNumber(S);
                    
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
                    
                    if (!S.equals("------------------------------------------") && !S.equals("==========================================")) 
                        productString += S + "\n";
                    else {
                        list.add(proccesProductString(productString));                        
                        productString = "";
                    }
                    
                    if (S.equals("==========================================")) {
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
                    
                    String dataAndTime[] = getDataAndTime(S);
                    list.add(dataAndTime[0]);
                    list.add(dataAndTime[1]);
                    
                    ArrayList<String> listCopy = new ArrayList<>();
                    for (String s : list) listCopy.add(s);                    
                    receipts.add(listCopy);
                    stage = 0;
                    break;
                }
                
            }
            
            
        }      
        
        return receipts;
        
    }
    
    // возвращает номер чека:
    // если строка соответсвует формату, то будет возвращён номер, 
    // иначе значение "NON"
    private static String getRecNumber(String S) {
        
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
               sum      = ""; // сумма
        
        ArrayList<String> strings = new ArrayList<>();
        
        // делим строку на подстроки по знаку переноса строки
        StringTokenizer st = new StringTokenizer(S, "\n");
        
        // записываем подстроки в массив
        while (st.hasMoreTokens()) {
            strings.add(st.nextToken());
        }
        
        // ищем строку содержащую слово "ставка"
        int lastString = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).contains("ставка")) { 
                lastString = i;
                break;
            } 
        }
        
        //получаем сумму товара
        sum = strings.get(lastString - 1);
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
        for (int i = 0; i < lastString - 1; i++) {
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
                    
                    if (c == '(') a = i + 1;
                    else if (c == ')') {
                        b = i;
                        code = codeAndProduct.substring(a, b);
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
        
        return code + "|" + product + "|" + sum;      
        
    }
    
    private static boolean isDigit(char c) {
        return "0123456789".indexOf(c) != -1;
    }
    
    private static boolean isSpace(char c) {
        return " ".indexOf(c) != -1;
    }
    
    private static String deleteExtraDelimiters(String S) {
        
        String newS = "";
        S += '$';
        
        int i = 0;
        while (S.charAt(i) != '$') {
            if (!isSpace(S.charAt(i)) || (isSpace(S.charAt(i)) && !isSpace(S.charAt(i + 1)))) newS += S.charAt(i);
            i++;
        }
        
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
    
    public static String[] getDataAndTime(String S) {
        
        String result[] = new String[2];
        
        int index = S.indexOf(' ');
        if (index != -1) {
            
            result[0] = S.substring(0, index);
            result[1] = S.substring(index + 1);
            
        }
        
        return result;
        
    }
    
    private static String[] divideString(String S) {
        
        String result[] = new String[3];
        
        int index = 0;
            StringTokenizer st = new StringTokenizer(S, "|");
            while (st.hasMoreTokens()) {                
                if (index < 3) {
                    result[index] = st.nextToken();
                    index++;
                }       
            }
        
        return result;
    }
    
    public static String printReceiptsData(ArrayList<ArrayList<String>> receipts) {
        
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
                    result += ("      (" + parts[0] + ") " + parts[1] + " [" + parts[2] + "]\n");
                }
            }
            
            result += "\n";
            
        }
        
        return result;       
        
    }
    
    public static void searchCodeInReceipts(ArrayList<ArrayList<String>> receipts, String code) {
        
    }
}
