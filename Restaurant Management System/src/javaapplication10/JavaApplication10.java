/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

/**
 *
 * @author bb
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        java.sql.Connection con = null;
        ResultSet rs = null;
        Statement st;
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        final JPasswordField pass = new JPasswordField(10);
        pass.setFocusable(true);
        panel.add(label);
        panel.add(pass);
        pass.addHierarchyListener(new HierarchyListener() {
            public void hierarchyChanged(HierarchyEvent e) {
                final Component c = e.getComponent();
                if (c.isShowing() && (e.getChangeFlags()
                        & HierarchyEvent.SHOWING_CHANGED) != 0) {
                    Window toplevel = SwingUtilities.getWindowAncestor(c);
                    toplevel.addWindowFocusListener(new WindowAdapter() {
                        public void windowGainedFocus(WindowEvent e) {
                            c.requestFocus();
                        }
                    });
                }
            }
        });
        String[] options = new String[]{"Cancel", "OK"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        if (option == 1) {
            String pass2 = new String(pass.getPassword());
            if (pass2.equals("tasbera2020")) {
                Main m = new Main();
                m.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "كلمة السر غير صحيحة", "خطا", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

}
