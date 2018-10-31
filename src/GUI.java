
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReceipt = new javax.swing.JTextArea();
        tabbedPane = new javax.swing.JTabbedPane();
        panelIP = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textAreaIP = new javax.swing.JTextField();
        btnOKIP = new javax.swing.JButton();
        btnSaveAsIP = new javax.swing.JButton();
        textAreaPathIP = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        textAreaTTIP = new javax.swing.JTextField();
        panelFile = new javax.swing.JPanel();
        btnOpen = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        textAreaPath = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textAreaCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textAreaTT = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnOpen1 = new javax.swing.JButton();
        btnSaveAsNoSearch = new javax.swing.JButton();
        textAreaPathNoSearch = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btnOKNoSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textAreaTTNoSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textAreaIPNoSearch = new javax.swing.JTextField();
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

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        jLabel2.setText("   ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textAreaReceipt.setEditable(false);
        textAreaReceipt.setColumns(20);
        textAreaReceipt.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        textAreaReceipt.setRows(5);
        jScrollPane1.setViewportView(textAreaReceipt);

        tabbedPane.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N

        panelIP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel4.setText("IP:");

        textAreaIP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        btnOKIP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        btnOKIP.setText("ОК");
        btnOKIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKIPActionPerformed(evt);
            }
        });

        btnSaveAsIP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btnSaveAsIP.setText("Сохранить как...");
        btnSaveAsIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnSaveAsIPActionPerformed(evt);
            }
        });

        textAreaPathIP.setEditable(false);
        textAreaPathIP.setBackground(new java.awt.Color(255, 255, 255));
        textAreaPathIP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel6.setText("Торговая точка:");

        textAreaTTIP.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelIPLayout = new javax.swing.GroupLayout(panelIP);
        panelIP.setLayout(panelIPLayout);
        panelIPLayout.setHorizontalGroup(
            panelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIPLayout.createSequentialGroup()
                        .addComponent(btnSaveAsIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAreaPathIP))
                    .addGroup(panelIPLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaIP, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaTTIP, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOKIP, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        panelIPLayout.setVerticalGroup(
            panelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAsIP)
                    .addComponent(textAreaPathIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textAreaIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOKIP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(textAreaTTIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        tabbedPane.addTab("По IP", panelIP);

        panelFile.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel1.setText("Код:");

        textAreaCode.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Торговая точка:");

        textAreaTT.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        btnOK.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        btnOK.setText("ОК");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFileLayout = new javax.swing.GroupLayout(panelFile);
        panelFile.setLayout(panelFileLayout);
        panelFileLayout.setHorizontalGroup(
            panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFileLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaTT, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFileLayout.createSequentialGroup()
                        .addComponent(btnOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveAs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAreaPath)))
                .addContainerGap())
        );
        panelFileLayout.setVerticalGroup(
            panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFileLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnSaveAs)
                    .addComponent(textAreaPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textAreaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        tabbedPane.addTab("Из файла", panelFile);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnOpen1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btnOpen1.setText("Открыть...");
        btnOpen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOpenActionPerformed(evt);
            }
        });

        btnSaveAsNoSearch.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btnSaveAsNoSearch.setText("Сохранить как...");
        btnSaveAsNoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnSaveAsNoSearchActionPerformed(evt);
            }
        });

        textAreaPathNoSearch.setEditable(false);
        textAreaPathNoSearch.setBackground(new java.awt.Color(255, 255, 255));
        textAreaPathNoSearch.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N

        btnOKNoSearch.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        btnOKNoSearch.setText("ОК");
        btnOKNoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKNoSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel5.setText("Торговая точка:");

        textAreaTTNoSearch.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel7.setText("IP:");

        textAreaIPNoSearch.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOpen1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveAsNoSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAreaPathNoSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaIPNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAreaTTNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOKNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen1)
                    .addComponent(btnSaveAsNoSearch)
                    .addComponent(textAreaPathNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAreaTTNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOKNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(textAreaIPNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Парсер без поиска", jPanel1);

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
            .addComponent(jScrollPane1)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
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
            textAreaReceipt.setText(ReceiptProcessor.start(receiptStringsArray, textAreaCode.getText(), textAreaPath.getText(), textAreaTT.getText(), ""));
        
        btnOK.setEnabled(true);
    }//GEN-LAST:event_btnOKActionPerformed

    private void mbtnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnSaveAsActionPerformed
        saveActionPerfomed(textAreaPath);
    }//GEN-LAST:event_mbtnSaveAsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setTitle("Receipt Parser");
        textAreaPath.setText("");
        textAreaCode.setText("");
        textAreaReceipt.setText("");
        textAreaTT.setText("");
        
        textAreaPathIP.setText("");
        textAreaIP.setText("");
        textAreaTTIP.setText("");
        
        textAreaPathNoSearch.setText("");
        textAreaTTNoSearch.setText("");
        textAreaIPNoSearch.setText("");
        
        receiptStringsArray.clear();        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnOKIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKIPActionPerformed

    private void mbtnSaveAsIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnSaveAsIPActionPerformed
        saveActionPerfomed(textAreaPathIP);
    }//GEN-LAST:event_mbtnSaveAsIPActionPerformed

    private void mbtnSaveAsNoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnSaveAsNoSearchActionPerformed
        saveActionPerfomed(textAreaPathNoSearch);
    }//GEN-LAST:event_mbtnSaveAsNoSearchActionPerformed

    private void btnOKNoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKNoSearchActionPerformed
        btnOKNoSearch.setEnabled(false);        
                
        if (receiptStringsArray.isEmpty() || textAreaPathNoSearch.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите все данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else 
            textAreaReceipt.setText(ReceiptProcessor.start(receiptStringsArray, "NON", textAreaPathNoSearch.getText(), textAreaTTNoSearch.getText(), textAreaIPNoSearch.getText()));
        
        btnOKNoSearch.setEnabled(true);
    }//GEN-LAST:event_btnOKNoSearchActionPerformed
    
    private void saveActionPerfomed(JTextField ta) {
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG); 
        fileChooser.setFileFilter(new CustomFilterXLS());
        fileChooser.setDialogTitle("Сохранение");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {            
            File file = fileChooser.getSelectedFile();            
            String path = file.getPath();
            if (!path.endsWith(".xls")) path += ".xls";            
            ta.setText(path);            
        }
    }
    
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
    private javax.swing.JButton btnOKIP;
    private javax.swing.JButton btnOKNoSearch;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnOpen1;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnSaveAsIP;
    private javax.swing.JButton btnSaveAsNoSearch;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenuItem mOpen;
    private javax.swing.JMenuItem mSaveAs;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelFile;
    private javax.swing.JPanel panelIP;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextField textAreaCode;
    private javax.swing.JTextField textAreaIP;
    private javax.swing.JTextField textAreaIPNoSearch;
    private javax.swing.JTextField textAreaPath;
    private javax.swing.JTextField textAreaPathIP;
    private javax.swing.JTextField textAreaPathNoSearch;
    private javax.swing.JTextArea textAreaReceipt;
    private javax.swing.JTextField textAreaTT;
    private javax.swing.JTextField textAreaTTIP;
    private javax.swing.JTextField textAreaTTNoSearch;
    // End of variables declaration//GEN-END:variables
}
