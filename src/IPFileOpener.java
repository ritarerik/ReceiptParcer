
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class IPFileOpener {
    
    public static ArrayList<String> run(String IP) {
        
        ArrayList<String> receiptStringsArray = new ArrayList<>();
        File dir = new File("//" + IP + "/Tranz");
        
        if(dir.isDirectory()) {
            for(File file : dir.listFiles()) {
              
                 if(!file.isDirectory()){
                      
                     try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));

                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (!line.isEmpty()) receiptStringsArray.add(line);
                        }          

                        reader.close();
                    } catch (Exception ex) {  
                        JOptionPane.showMessageDialog(null, "Не удалось открыть файл " + file.getName(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }                     
                     
                 }
                 
             }
        } 
        
        return receiptStringsArray;
    }
    
}
