/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bb
 */
public class Search extends javax.swing.JFrame {

    java.sql.Connection con = null;
    ResultSet rs = null;
    Statement st;
    String path = System.getProperty("user.dir");
    //String connect="jdbc:derby://localhost:1527/";
    String connect = "jdbc:derby:";
    String conn = "jdbc:mysql://localhost:3306/tasberadb" + "?useUnicode=yes&characterEncoding=UTF-8";

    public Search() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/logo2.jpg")));
        this.getContentPane().setBackground(Color.WHITE);
        ((JLabel) this.jComboBox1.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        ((JLabel) this.jComboBox2.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        try {
//          Class.forName("org.apache.derby.jdbc.ClientDriver");
//          con = DriverManager.getConnection(connect + path + "\\Databases\\TasberaDB", "root", "1234");
            con = DriverManager.getConnection(conn, "root", "");
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "لم يتم الاتصال بقاعدة البيانات", "خطا", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();

        }

        displayAll();

    }

    public void deleteOrder(int row) {
        try {
            DefaultTableModel dModel = (DefaultTableModel) this.jTable1.getModel();
            int orderId = Integer.parseInt(dModel.getValueAt(row, 12).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "هل تريد حذف هذا الطلب؟");
            if (dialogResult == JOptionPane.YES_OPTION) {
                con = DriverManager.getConnection(conn, "root", "");
                st = (Statement) con.createStatement();
                st.execute("DELETE FROM ORDERS WHERE ID=" + orderId + "");
                displayAll();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void displayAll() {
        try {
            con = DriverManager.getConnection(conn, "root", "");
            st = (Statement) con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*)As TotalRows FROM ORDERS");
            int totalRows = 0;
            if (rs.next()) {
                totalRows = rs.getInt("TOTALROWS");
                rs = st.executeQuery("select * from orders");
                DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
                model.setRowCount(0);
                Vector row[] = new Vector[totalRows];
                int i = 0;
                while (rs.next()) {
                    row[i] = new Vector();
                    row[i].add("حذف");
                    row[i].add("تعديل");
                    double itemPrice = rs.getDouble("ItemPrice");
                    int itemQuantity = rs.getInt("ItemQuantity");
                    double totalPrice = rs.getDouble("OrderTotal");
                    row[i].add(totalPrice);
                    row[i].add(rs.getDouble("DISCOUNT"));
                    row[i].add(itemQuantity);
                    row[i].add(itemPrice);
                    row[i].add(rs.getString("ItemName"));
                    row[i].add(rs.getDate("DATE"));
                    row[i].add(rs.getString("ClientPhone"));
                    row[i].add(rs.getString("ClientAddress"));
                    row[i].add(rs.getString("ClientName"));
                    row[i].add(rs.getString("ORDERTYPE"));
                    row[i].add(rs.getInt("ID"));
                    model.addRow(row[i]);
                    i++;
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.RIGHT);

                this.jTable1.setDefaultRenderer(String.class, centerRenderer);

                this.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        int row = jTable1.rowAtPoint(e.getPoint());
                        int col = jTable1.columnAtPoint(e.getPoint());
                        if (col == 0) {
                            deleteOrder(row);
                        } else if (col == 1) {

                        }
                    }
                });
                con.close();

            }
        } catch (Exception ex) {
            System.out.print(ex.toString());
            JOptionPane.showMessageDialog(null, "خطا في احضار البيانات", "خطا", JOptionPane.INFORMATION_MESSAGE);

        }

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
        jComboBox1 = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "حذف", "تعديل", "الإجمالي", "خضم", "عدد الصنف", "ثمن الصنف", "الصنف", "التاريخ", "تليفون العميل", "عنوان العميل", "اسم العميل", "عنوان الطلب", "رقم الطلب"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setMinimumSize(new java.awt.Dimension(400, 0));
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setMinWidth(40);
            jTable1.getColumnModel().getColumn(5).setMinWidth(50);
            jTable1.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1.getColumnModel().getColumn(7).setMinWidth(100);
            jTable1.getColumnModel().getColumn(8).setMinWidth(100);
            jTable1.getColumnModel().getColumn(9).setMinWidth(180);
            jTable1.getColumnModel().getColumn(10).setMinWidth(100);
            jTable1.getColumnModel().getColumn(11).setMinWidth(50);
            jTable1.getColumnModel().getColumn(12).setMinWidth(40);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(5, 121, 971, 480);

        jLabel1.setFont(new java.awt.Font("PT Bold Heading", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(251, 240, 2));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("البحث");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 10, 110, 39);

        jLabel2.setForeground(new java.awt.Color(251, 240, 2));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("البحث في:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(620, 50, 50, 14);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(750, 50, 167, 20);

        jLabel3.setForeground(new java.awt.Color(251, 240, 2));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("كلمة البحث:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(920, 50, 56, 14);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "اختر", "رقم الطلب", "عنوان الطلب", "رقم  تليفون العميل", "اسم العميل", "التاريخ", "الصنف" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(380, 50, 236, 20);

        jButton1.setForeground(new java.awt.Color(59, 24, 2));
        jButton1.setText("ابحث");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 80, 110, 33);

        jButton2.setForeground(new java.awt.Color(59, 24, 2));
        jButton2.setText("عودة إلي القائمة الرئيسية");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 620, 151, 30);

        jLabel4.setForeground(new java.awt.Color(251, 240, 2));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("البحث المتاح:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 52, 61, 14);

        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(10, 51, 180, 20);

        jLabel5.setForeground(new java.awt.Color(251, 240, 2));
        jLabel5.setText("عدد الطلبات:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 88, 94, 14);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(140, 80, 43, 32);

        jButton4.setForeground(new java.awt.Color(59, 24, 2));
        jButton4.setText("احضار العدد");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 80, 120, 34);

        jButton7.setForeground(new java.awt.Color(59, 24, 2));
        jButton7.setText("الغاء البحث");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(860, 80, 110, 35);

        jPanel1.setBackground(new java.awt.Color(101, 23, 13));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 700);

        pack();
        setLocationRelativeTo(null);
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
        String searchCategory = "";
        if (this.jComboBox2.getItemCount() > 0) {
            searchCategory = this.jComboBox2.getSelectedItem().toString();
        }
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
                if (!this.jTable1.getModel().getValueAt(cell, 12).toString().equals(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 2) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 11).toString().equals(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 3) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 8).toString().equals(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 4) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 10).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 5) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 7).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        } else if (searchIn == 6) {
            for (int cell = 0; cell < rowsCount; cell++) {
                if (!this.jTable1.getModel().getValueAt(cell, 6).toString().contains(searchText)) {
                    dModel.removeRow(cell);
                    cell--;
                    rowsCount = this.jTable1.getRowCount();
                }
            }
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
        this.jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Main m = new Main();
        m.setVisible(true);
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
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 8).toString());
                }
            } else if (selectedIndex == 4) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 10).toString());
                }
            } else if (selectedIndex == 5) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 7).toString());
                }
            } else if (selectedIndex == 6) {
                for (int cell = 0; cell < rowsCount; cell++) {
                    cleanList.add(this.jTable1.getModel().getValueAt(cell, 6).toString());
                }
            }

            for (String item : cleanList) {
                this.jComboBox2.addItem(item);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Set<String> cleanList = new HashSet<>();
        int rowsCount = this.jTable1.getRowCount();
        for (int cell = 0; cell < rowsCount; cell++) {
            cleanList.add(this.jTable1.getModel().getValueAt(cell, 12).toString());
        }
        String numberOfOrders = Integer.toString(cleanList.size());
        this.jTextField2.setText(numberOfOrders);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        displayAll();
        this.jTextField1.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
