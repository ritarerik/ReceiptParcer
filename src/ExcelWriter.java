
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
    
    public static void write(ArrayList<ArrayList<String>>receipts, String path) { // "poi-generated-file.xls"

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(new File(path));
            workbook = new HSSFWorkbook(inputStream);
        } catch (Exception ex) {
            workbook = new HSSFWorkbook();
        }
        
        int count = workbook.getNumberOfSheets() + 1;
        HSSFSheet sheet = workbook.createSheet("Лист" + count);
        
        //--------------------------------------------------------------------//
        // шапка файла
        HSSFCellStyle headStyle = createStyleForTitle(workbook, true);
        Row headRow = sheet.createRow(0);
        Cell cell; 
        
        cell = headRow.createCell(0, CellType.STRING);
        cell.setCellValue("Торговая точка");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(1, CellType.STRING);
        cell.setCellValue("Дата");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(2, CellType.STRING);
        cell.setCellValue("№ чека");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(3, CellType.STRING);
        cell.setCellValue("Время транз.");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(4, CellType.STRING);
        cell.setCellValue("Сумма чека");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(5, CellType.STRING);
        cell.setCellValue("Код");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(6, CellType.STRING);
        cell.setCellValue("Товар");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(7, CellType.STRING);
        cell.setCellValue("Сумма");
        cell.setCellStyle(headStyle);
        
        cell = headRow.createCell(8, CellType.STRING);
        cell.setCellValue("Артикул");
        cell.setCellStyle(headStyle);
        
//--------------------------------------------------------------------//
        // заполнение строк с данными
        int rowCount = 1;
        HSSFCellStyle style = createStyleForTitle(workbook, false);
        for (ArrayList<String> receipt : receipts)
            for (int i = 1; i < receipt.size() - 3; i++) {
                
                String A[] = parseProductString(receipt.get(i));                
                Row row = sheet.createRow(rowCount);
                
                // дата
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(receipt.get(receipt.size() - 2));
                cell.setCellStyle(style);
                
                //№ чека
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(receipt.get(0));
                cell.setCellStyle(style);
                
                // время транзации
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(receipt.get(receipt.size() - 1));
                cell.setCellStyle(style);
                
                // сумма чека
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(receipt.get(receipt.size() - 3));
                cell.setCellStyle(style);
                
                // код товара
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(A[0]);
                cell.setCellStyle(style);
                
                // товар
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(A[1]);
                cell.setCellStyle(style);
                
                // сумма товара
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(A[2]);
                cell.setCellStyle(style);
                
                rowCount++;
                
            }
        
        //--------------------------------------------------------------------//
        // автовыравнивание столбцов
        for(int i = 0; i < 9; i++) {
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
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Не удалось записать файл", "Ошибка", JOptionPane.ERROR_MESSAGE);
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
