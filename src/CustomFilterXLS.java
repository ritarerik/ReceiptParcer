
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Маргарита
 */
public class CustomFilterXLS extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".xls");
        }
        @Override
        public String getDescription() {
            return "Excel file (*.xls)";
        }
    } 
