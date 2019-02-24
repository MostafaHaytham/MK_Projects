/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldb;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bb
 */
public class Search extends javax.swing.JFrame {

    FinalDB hp = new FinalDB();

    public void display(int row) {
        int reply = JOptionPane.showConfirmDialog(null, "هل تريد اظهار بيانات الشخص؟", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            DisplayPage dp = new DisplayPage(row, 2);
            dp.setVisible(true);
        }

    }

    public void manage(int row) {
        int reply = JOptionPane.showConfirmDialog(null, "هل تريد تعديل بيانات الشخص رقم " + (row + 1) + "؟ ", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            ManageUser mu = new ManageUser(row);
            mu.setVisible(true);
        }
    }

    public void add(int row) {
        int reply = JOptionPane.showConfirmDialog(null, "هل تريد اضافة شخص ليصبح رقم " + (row + 2) + "؟ ", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            AddUser au = new AddUser(row);
            au.setVisible(true);
        }

    }

    public void delete(int row) {
        int reply = JOptionPane.showConfirmDialog(null, "هل تريد حذف بيانات الشخص رقم " + (row + 1) + "؟ ", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                File file = new File("data.txt");
                Process p;
                p = Runtime.getRuntime().exec("attrib -h " + file.getPath());
                p.waitFor();
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt"), "UTF-8"));
                for (int i = 0; i < hp.amountOfUsers; i++) {
                    if (row != i) {
                        wr.append(hp.ranks.get(i));
                        wr.append("-&-");
                        wr.append(hp.names.get(i));
                        wr.append("-&-");
                        wr.append(hp.codes.get(i));
                        wr.append("-&-");
                        wr.append(hp.jobs.get(i));
                        wr.append("-&-");
                        wr.append(hp.areas.get(i));
                        wr.append("-&-");
                        wr.append(hp.tournaments.get(i));
                        wr.append("-&-");
                        wr.append(hp.startDate.get(i));
                        wr.append("-&-");
                        wr.append(hp.endDate.get(i));
                        wr.append("-&-");
                        for (int t = 0; t < hp.teams.get(i).size(); t++) {
                            wr.append(hp.teams.get(i).get(t));
                            if (t != hp.teams.get(i).size() - 1) {
                                wr.append("-&-");
                            }
                        }
                        wr.newLine();
                    }
                }

                wr.close();
                p = Runtime.getRuntime().exec("attrib +h " + file.getPath());
                p.waitFor();
                JOptionPane.showMessageDialog(null, "تم حذف الشخص بنجاح", "تنيبه", JOptionPane.INFORMATION_MESSAGE);
                hp.setArrays("data.txt");
                displayAllTable();
            } catch (IOException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void hideAll() {
        this.jLabel3.setVisible(false);
        this.jLabel4.setVisible(false);
        this.jComboBox2.setVisible(false);
        this.jTextField1.setVisible(false);
        this.jTextField1.setText("");
        this.jButton1.setVisible(false);
        this.jComboBox2.removeAllItems();
    }

    public void displayAllTable() {
        if (this.jTable1.getModel().getRowCount() != hp.amountOfUsers) {
            DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
            model.setRowCount(0);
            Vector row[] = new Vector[hp.amountOfUsers];
            for (int i = 0; i < hp.amountOfUsers; i++) {
                row[i] = new Vector();
                row[i].add("اظهر");
                row[i].add("تعديل");
                row[i].add("حذف");
                row[i].add("اضافة");
                row[i].add(hp.endDate.get(i));
                row[i].add(hp.startDate.get(i));
                row[i].add(hp.tournaments.get(i));
                String teams = "";
                for (int t = 0; t < hp.teams.get(i).size(); t++) {
                    String teamWithoutDate[] = hp.teams.get(i).get(t).split("!-!");
                    if (teamWithoutDate.length > 1) {
                        
                        teams+=teamWithoutDate[0];
                    } else {
                        teams += hp.teams.get(i).get(t);
                    }

                    if (t != hp.teams.get(i).size() - 1) {
                        teams += "/";
                    }
                }
                row[i].add(teams);
                row[i].add(hp.areas.get(i));
                row[i].add(hp.jobs.get(i));
                row[i].add(hp.codes.get(i));
                row[i].add(hp.names.get(i));
                row[i].add(hp.ranks.get(i));
                row[i].add(i + 1);
                model.addRow(row[i]);
            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.RIGHT);

            this.jTable1.setDefaultRenderer(String.class, centerRenderer);

            this.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int row = jTable1.rowAtPoint(e.getPoint());
                    int rowNumber = Integer.parseInt(jTable1.getValueAt(row, 13).toString());
                    int col = jTable1.columnAtPoint(e.getPoint());
                    if (col == 0) {
                        display(rowNumber - 1);
                    } else if (col == 1) {
                        manage(rowNumber - 1);
                    } else if (col == 2) {
                        delete(rowNumber - 1);
                    } else if (col == 3) {
                        add(rowNumber - 1);
                    }

                }
            });
        }

    }

    public Search() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        ((JLabel) this.jComboBox1.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        ((JLabel) this.jComboBox2.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        //hideAll();
        displayAllTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "اظهر", "تعديل", "حذف", "اضافة", "تاريخ الانتهاء", "تاريخ الانعقاد", "الدورة", "اسم الفرقة", "جهة العمل", "العمل المسند", "رقم الأقدمية", "إسم الضباط", "الرتبة", "م"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1.getColumnModel().getColumn(7).setMinWidth(100);
            jTable1.getColumnModel().getColumn(8).setMinWidth(120);
            jTable1.getColumnModel().getColumn(9).setMinWidth(120);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(11).setMinWidth(150);
            jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(13).setMaxWidth(30);
        }

        jLabel1.setFont(new java.awt.Font("PT Bold Heading", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" الصفحة الرئيسية");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("البحث في:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("كلمة البحث:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر", "الرتبة", "اسم الضباط", "رقم الأقدمية", "العمل المسند", "جهة العمل", "اسم الفرقة", "الدورة", "تاريخ الانعقاد", "تاريخ النتهاء" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("ابحث");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("اغلاق");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("البحث المتاح:");

        jButton3.setText("الغاء البحث");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("عدد الأشخاص:");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton4.setText("احضار العدد");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("احتفاظ بنسخة من البيانات");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("استرجاع من النسخة");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(573, 573, 573))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(387, 387, 387)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(577, 577, 577)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(494, 494, 494)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int searchIn = this.jComboBox1.getSelectedIndex();
        String searchWord = this.jTextField1.getText();
        String searchCategory = this.jComboBox2.getSelectedItem().toString();
        String searchText = "";
        DefaultTableModel dModel = (DefaultTableModel) this.jTable1.getModel();
        if (searchWord.equals("")) {
            searchText = searchCategory;
        } else {
            searchText = searchWord;
        }
        this.jComboBox1.setSelectedIndex(0);
        int rowsCount = this.jTable1.getRowCount();
        if (searchIn == 1) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 12).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 2) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 11).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 3) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 10).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 4) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 9).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 5) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 8).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 6) {
            boolean contain;
            for (int cell = 0; cell < rowsCount; cell++) {
                String line = this.jTable1.getModel().getValueAt(cell, 7).toString();
                String teams[] = line.split("/");
                contain = false;
                for (int t = 0; t < teams.length; t++) {
                    if (teams[t].contains(searchText)) {
                        contain = true;
                    }
                }
                if (!contain) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }

            }
        } else if (searchIn == 7) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 6).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 8) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 5).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 9) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 4).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int selectedIndex = this.jComboBox1.getSelectedIndex();
        if (selectedIndex == 0) {
            //hideAll();
            this.jComboBox2.removeAllItems();
        } else {
            this.jComboBox2.removeAllItems();
            Set<String> cleanList = new HashSet<>();
            int rowsCount = this.jTable1.getRowCount();
            if (selectedIndex == 1) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 12).toString());
                }
            } else if (selectedIndex == 2) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 11).toString());
                }
            } else if (selectedIndex == 3) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 10).toString());
                }
            } else if (selectedIndex == 4) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 9).toString());
                }
            } else if (selectedIndex == 5) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 8).toString());
                }
            } else if (selectedIndex == 6) {
                for (int cell = 0; cell < rowsCount; cell++) {

                    String line = this.jTable1.getModel().getValueAt(cell, 7).toString();
                    String teams[] = line.split("/");
                    for (int t = 0; t < teams.length; t++) {
                        cleanList.add(teams[t]);
                    }
                }

            } else if (selectedIndex == 7) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 6).toString());
                }
            } else if (selectedIndex == 8) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 5).toString());
                }
            } else if (selectedIndex == 9) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 4).toString());
                }
            }

            for (String item : cleanList) {
                this.jComboBox2.addItem(item);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        displayAllTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String rowCount = Integer.toString(this.jTable1.getModel().getRowCount());
        this.jTextField2.setText(rowCount);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "هل تريد الاحتفاظ بنسخة من البيانات؟", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            hp.backupFile("data2.txt");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "هل تريد استخدام البيانات من النسخة هذا سيضيع البيانات الحالية؟", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            hp.setArrays("data2.txt");
            hp.backupFile("data.txt");
            displayAllTable();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
