
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
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
public class GUI extends javax.swing.JFrame {
    
    private static ArrayList<String> receiptStringsArray = new ArrayList<>();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        textAreaCode = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReceipt = new javax.swing.JTextArea();
        btnOpen = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        textAreaPath = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        textAreaTT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        mOpen = new javax.swing.JMenuItem();
        mSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mExit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Receipt Parser");

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel1.setText("Код:");

        textAreaCode.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        btnOK.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        btnOK.setText("ОК");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        jLabel2.setText("   ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textAreaReceipt.setEditable(false);
        textAreaReceipt.setColumns(20);
        textAreaReceipt.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        textAreaReceipt.setRows(5);
        jScrollPane1.setViewportView(textAreaReceipt);

        btnOpen.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btnOpen.setText("Открыть...");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOpenActionPerformed(evt);
            }
        });

        btnSaveAs.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btnSaveAs.setText("Сохранить как...");
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnSaveAsActionPerformed(evt);
            }
        });

        textAreaPath.setEditable(false);
        textAreaPath.setBackground(new java.awt.Color(255, 255, 255));
        textAreaPath.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N

        textAreaTT.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Торговая точка:");

        mainMenu.setText("Файл");
        mainMenu.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N

        mOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mOpen.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        mOpen.setText("Открыть...");
        mOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOpenActionPerformed(evt);
            }
        });
        mainMenu.add(mOpen);

        mSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mSaveAs.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        mSaveAs.setText("Сохранить как...");
        mSaveAs.setToolTipText("");
        mSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnSaveAsActionPerformed(evt);
            }
        });
        mainMenu.add(mSaveAs);
        mainMenu.add(jSeparator1);

        mExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mExit.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        mExit.setText("Выход");
        mExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExitActionPerformed(evt);
            }
        });
        mainMenu.add(mExit);

        menuBar.add(mainMenu);

        jMenu1.setText("Правка");
        jMenu1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jMenuItem1.setText("Очистить");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaTT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveAs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAreaPath)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnSaveAs)
                    .addComponent(textAreaPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAreaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mExitActionPerformed

    private void mOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOpenActionPerformed
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setFileFilter(new CustomFilter());
        fileChooser.setDialogTitle("Открыть");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            File file = fileChooser.getSelectedFile();
            
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));

                receiptStringsArray.clear();
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.isEmpty()) receiptStringsArray.add(line);
                }            

                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при открытии файла", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            
            this.setTitle("Receipt Parser - [" + file.getAbsolutePath() + "]");
            
        }
    }//GEN-LAST:event_mOpenActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        btnOK.setEnabled(false);        
        boolean numeric = true;
        try {
            Integer.parseInt(textAreaCode.getText());
        } catch (Exception ex) {
            numeric = false;
        }
        
        if (receiptStringsArray.isEmpty() || textAreaCode.getText().isEmpty() || textAreaPath.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите все данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else if (!numeric) 
            JOptionPane.showMessageDialog(null, "Код должен являться числом", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else 
            textAreaReceipt.setText(ReceiptProcessor.start(receiptStringsArray, textAreaCode.getText(), textAreaPath.getText(), textAreaTT.getText()));
        
        btnOK.setEnabled(true);
    }//GEN-LAST:event_btnOKActionPerformed

    private void mbtnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnSaveAsActionPerformed
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG); 
        fileChooser.setFileFilter(new CustomFilterXLS());
        fileChooser.setDialogTitle("Сохранение");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {            
            File file = fileChooser.getSelectedFile();            
            String path = file.getPath();
            if (!path.endsWith(".xls")) path += ".xls";            
            textAreaPath.setText(path);            
        }
    }//GEN-LAST:event_mbtnSaveAsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setTitle("Receipt Parser");
        textAreaPath.setText("");
        textAreaCode.setText("");
        textAreaReceipt.setText("");
        receiptStringsArray.clear();        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenuItem mOpen;
    private javax.swing.JMenuItem mSaveAs;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField textAreaCode;
    private javax.swing.JTextField textAreaPath;
    private javax.swing.JTextArea textAreaReceipt;
    private javax.swing.JTextField textAreaTT;
    // End of variables declaration//GEN-END:variables
}
