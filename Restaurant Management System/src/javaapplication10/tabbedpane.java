/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Toolkit;

/**
 *
 * @author Abdulrahman.Ellaithy
 */
public class tabbedpane extends javax.swing.JFrame {

    /**
     * Creates new form tabbedpane
     */
    int orderNumber = 1;
    java.sql.Connection con = null;
    ResultSet rs = null;
    Statement st;
    ResultSet rs2 = null;
    Statement st2;
    String path = System.getProperty("user.dir");
    ArrayList<String> menuCategories = new ArrayList<String>();
    ArrayList<String> categoryParents = new ArrayList<String>();
    ArrayList<ArrayList<String>> menuItems = new ArrayList<ArrayList<String>>();
    //String connect="jdbc:derby://localhost:1527/";
    String connect = "jdbc:derby:";
    String conn = "jdbc:mysql://localhost:3306/tasberadb" + "?useUnicode=yes&characterEncoding=UTF-8";
    String pageType = "Menu";

    public tabbedpane(String pageType) {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/logo2.jpg")));
        this.pageType = pageType;
        this.getContentPane().setBackground(Color.WHITE);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.RIGHT);

        try {
            con = DriverManager.getConnection(conn, "root", "");
            st = (Statement) con.createStatement();
            rs = st.executeQuery("SELECT * FROM MENUCATEGORIES WHERE CATEGORYPARENT='الكل' OR CATEGORYPARENT='" + pageType + "' ");

            while (rs.next()) {
                String categoryName = rs.getString("CATEGORYNAME");
                String categoryParent = rs.getString("CATEGORYPARENT");
                menuCategories.add(categoryName);
                categoryParents.add(categoryParent);
            }
            for (int i = 0; i < menuCategories.size(); i++) {
                ArrayList<String> items = new ArrayList<String>();
                st2 = (Statement) con.createStatement();
                rs2 = st.executeQuery("SELECT * FROM ITEMS WHERE ITEMCATEGORY='" + menuCategories.get(i) + "' AND CATEGORYPARENT='" + categoryParents.get(i) + "'");
                while (rs2.next()) {
                    items.add(rs2.getString("ITEMNAME") + "%%" + rs2.getDouble("ITEMPRICE"));

                }
                menuItems.add(items);

            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "لم يتم الاتصال بقاعدة البيانات", "خطا", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();

        }
        panelSetUp();
        
    }

    public void panelSetUp() {
        JButton buttons[] = new JButton[menuCategories.size()];
        this.jPanel2.setLayout(new GridLayout(0, 4, 20, 20));
        this.jPanel2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jPanel2.setBackground(Color.WHITE);
        this.jPanel2.setPreferredSize(new Dimension(500, 250));
        this.jPanel3.setLayout(new GridLayout(4, 5, 20, 20));
        this.jPanel3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jPanel3.setBackground(Color.WHITE);
        this.jPanel3.setPreferredSize(new Dimension(730, 280));
        for (int i = 0; i < menuCategories.size(); i++) {
            buttons[i] = new JButton(menuCategories.get(i));
            if (categoryParents.get(i).equals("الكل")) {
                buttons[i].setBackground(Color.LIGHT_GRAY);
            }
            buttons[i].setPreferredSize(new Dimension(120, 100));
            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearPanel();
                    reloadPanel();
                    JButton typeButtons[] = new JButton[menuItems.get(index).size()];
                    for (int z = 0; z < menuItems.get(index).size(); z++) {
                        final String nameAndPrice[] = menuItems.get(index).get(z).split("%%");
                        typeButtons[z] = new JButton();
                        typeButtons[z].setText("<html><center>" + nameAndPrice[0] + "<br>" + nameAndPrice[1]
                                + "</center></html>");
                        typeButtons[z].setPreferredSize(new Dimension(100, 60));
                        typeButtons[z].setBackground(Color.orange);
                        typeButtons[z].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                        typeButtons[z].addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    double price = Double.parseDouble(nameAndPrice[1]);
                                    String item = "";
                                    item += nameAndPrice[0];
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "خطا في سعر الصنف", "خطا", JOptionPane.INFORMATION_MESSAGE);

                                }
                            }
                        });
                        addButton(typeButtons[z]);
                    }
                    reloadPanel();
                }
            });
            this.jPanel2.add(buttons[i]);
        }
    }

    public void reloadPanel() {
        this.jPanel3.revalidate();
        this.jPanel3.repaint();
    }

    public void clearPanel() {
        this.jPanel3.removeAll();
    }

    public void addButton(JButton button) {
        this.jPanel3.add(button);
    }

    public tabbedpane() {
        initComponents();
        jTabbedPane1.addTab("otlob", new JPanel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(73, 73, 73))
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        System.out.println("Tab Changed!!!");
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
            java.util.logging.Logger.getLogger(tabbedpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabbedpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabbedpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabbedpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabbedpane().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
