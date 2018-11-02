
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author metelevamd
 */
public class ExcelWriter {
    
    public static void write(ArrayList<ArrayList<String>>receipts, String path, String TT, String IP) { // "poi-generated-file.xls"

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        
        try {
            inputStream = new FileInputStream(new File(path));
            workbook = new HSSFWorkbook(inputStream);
        } catch (Exception ex) {
            workbook = new HSSFWorkbook();
        }
        
//        int count = workbook.getNumberOfSheets() + 1;
        int count = 1;
        HSSFSheet sheet = null;
        boolean f = false;        
        while (!f) {            
            try {
                sheet = workbook.createSheet("Лист" + count);
                f = true;
            } catch (Exception ex) {
                count++;
            }            
        }
        
        //--------------------------------------------------------------------//
        // шапка файла
        HSSFCellStyle headStyle = createStyleForTitle(workbook, true);
        Row headRow = sheet.createRow(0);
        Cell cell; 
        
        cell = headRow.createCell(0, CellType.STRING);
        cell.setCellValue("Торговая точка");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(1, CellType.STRING);
        cell.setCellValue("IP");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(2, CellType.STRING);
        cell.setCellValue("Дата");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(3, CellType.STRING);
        cell.setCellValue("№ чека");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(4, CellType.STRING);
        cell.setCellValue("Время транз.");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(5, CellType.STRING);
        cell.setCellValue("Сумма чека");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(6, CellType.STRING);
        cell.setCellValue("Код");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(7, CellType.STRING);
        cell.setCellValue("Товар");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(8, CellType.STRING);
        cell.setCellValue("Сумма");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(9, CellType.STRING);
        cell.setCellValue("Артикул");
        cell.setCellStyle(headStyle);
        
        //--------------------------------------------------------------------//
        // заполнение строк с данными
        int rowCount = 1;
        HSSFCellStyle style = createStyleForTitle(workbook, false);
        HSSFCellStyle styleCash = createStyleForTitle(workbook, false);
        styleCash.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
        for (ArrayList<String> receipt : receipts)
            for (int i = 1; i < receipt.size() - 3; i++) {
                
                String A[] = parseProductString(receipt.get(i));                
                Row row = sheet.createRow(rowCount);
                
                // торговая точка
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(TT);
                cell.setCellStyle(style);
                
                // IP
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(IP);
                cell.setCellStyle(style);
                
                // дата
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(receipt.get(receipt.size() - 2));
                cell.setCellStyle(style);
                
                //№ чека
                try {
                    cell = row.createCell(3, CellType.NUMERIC);
                    cell.setCellValue(Float.parseFloat(receipt.get(0)));
                    cell.setCellStyle(style);
                } catch (Exception e) {
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(receipt.get(0));
                    cell.setCellStyle(style);
                }
                
                // время транзации
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(receipt.get(receipt.size() - 1));
                cell.setCellStyle(style);
                
                // сумма чека
                try {
                    cell = row.createCell(5, CellType.NUMERIC);
                    cell.setCellValue(Double.parseDouble(receipt.get(receipt.size() - 3)));
                    cell.setCellStyle(styleCash);
                } catch (Exception e) {
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(receipt.get(receipt.size() - 3));
                    cell.setCellStyle(styleCash);
                }
                
                // код товара
                try {
                    cell = row.createCell(6, CellType.NUMERIC); 
                    cell.setCellValue(Float.parseFloat(A[0]));
                    cell.setCellStyle(style);
                } catch (Exception e) {
                    cell = row.createCell(6, CellType.STRING); 
                    cell.setCellValue(A[0]);
                    cell.setCellStyle(style);
                }
                
                // товар
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(A[1]);
                cell.setCellStyle(style);
                
                // сумма товара
                try {
                    cell = row.createCell(8, CellType.NUMERIC);
                    cell.setCellValue(Double.parseDouble(A[2]));
                    cell.setCellStyle(styleCash);
                } catch (Exception e) {
                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue(A[2]);
                    cell.setCellStyle(styleCash);
                }
                
                rowCount++;
                
            }
        
        //--------------------------------------------------------------------//
        // автовыравнивание столбцов
        for(int i = 0; i < 10; i++) {
            sheet.autoSizeColumn(i);
        }
        
        //--------------------------------------------------------------------//
        // запись файла
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            
            fileOut.close();
            workbook.close();            
            
            File file = new File(path);
            Desktop.getDesktop().open(file);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Не удалось записать файл", "Ошибка", JOptionPane.ERROR_MESSAGE);
            try {
                workbook.close();
            } catch (Exception ex1) {                
            }
        } 
        
    }
    
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook, boolean isBold) {
        
        HSSFFont font = workbook.createFont();
        font.setBold(isBold);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
        
    }
    
    private static String[] parseProductString(String S) {
        
        String result[] = new String[3];
        
        int index = S.indexOf('|');
        
        result[0] = S.substring(0, index);
        
        String tmpS = S.substring(index + 1);
        index = tmpS.indexOf('|');
        
        result[1] = tmpS.substring(0, index);
        result[2] = tmpS.substring(index + 1);
        
        
        return result;
        
    }
    
}
