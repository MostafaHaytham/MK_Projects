/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author BigGuy
 */
public class ConnectToServer extends javax.swing.JFrame {

    Socket ser;     // Socket to connect with server
    Socket ser2;
    /**
     * Creates new form ConnectToServer
     */
    public ConnectToServer(Socket in, String name, Socket in2) throws IOException {
        initComponents();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
       
        ser = in;
        ser2 = in2;
        PrintStream outToServer = new PrintStream(ser.getOutputStream());   //opens output stream to server
        PrintStream outToServer2 = new PrintStream(ser2.getOutputStream());   //opens output stream to server
     
        outToServer.println(name); 
         outToServer2.println(name); // Sends name to server
        Thread t = new Thread(new Runnable() {  // Create a thread to continue listening to incoming messages from server.
            public void run() {
                Scanner inFromServer;   
                try {
                    inFromServer = new Scanner(ser.getInputStream());  
ImageIcon newIconc = new ImageIcon("C:\\Users\\lenovo\\Desktop\\Tst.jpg");
                        jLabel2.setIcon(newIconc);
                 // Gets input stream from server
                    while (true) {  // loop will continue to run as long as there is data from server
                        String NxtFrme = inFromServer.nextLine();
                        long NxtTimeStamp =  Long.parseLong(inFromServer.nextLine());
                        if(!NxtFrme.equals(" ")){
                             String NxtFrmee = NxtFrme.replace("\\", "\\\\");
                       System.out.println(NxtFrmee);
                        ImageIcon newIcon = new ImageIcon(NxtFrmee);
                        
                        jLabel2.setIcon(newIcon);
                        int x = Integer.parseInt(Long.toString(System.currentTimeMillis()-NxtTimeStamp));
                        if (x<=200){
                        jTextField1.setText("The Current Statue IS "+"Synchronozied ");
                         jTextField1.setBackground(new java.awt.Color(51,255,0));
                        jTextField1.setForeground(new java.awt.Color(0, 0, 153));
                        }
                else{
                       jTextField1.setText("The Current Statue IS "+"Asynchronozied ");
                        jTextField1.setBackground(new java.awt.Color(255, 51, 51));
                        jTextField1.setForeground(new java.awt.Color(0,51,51));
                        }
                        }
                        
                        
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();
        
        
        
         Thread t2 = new Thread(new Runnable() {  // Create a thread to continue listening to incoming messages from server.
            public void run() {
                Scanner inFromServer2;   
                try {
                    inFromServer2 = new Scanner(ser2.getInputStream());  
ImageIcon newIconc = new ImageIcon("C:\\Users\\lenovo\\Desktop\\Capture.png");
                        jLabel1.setIcon(newIconc);
                 // Gets input stream from server
                    while (true) {  // loop will continue to run as long as there is data from server
                        
                        
                         String NxtFrme = inFromServer2.nextLine();
                         
                         long NxtTimeStamp =  Long.parseLong(inFromServer2.nextLine());
                      

// String NxtFrme = inFromServer.nextLine().replaceAll("\\", "\\\\");
                       // view.setText(view.getText() + "\n " +NxtFrme );
                        
                        if(!NxtFrme.equals(" ")){
                             String NxtFrmee = NxtFrme.replace("\\", "\\\\");
                       System.out.println(NxtFrmee);
                        ImageIcon newIcon = new ImageIcon(NxtFrmee);
                        
                        jLabel1.setIcon(newIcon);
                        int x = Integer.parseInt(Long.toString(System.currentTimeMillis()-NxtTimeStamp));
                        if (x<=200){
                       jTextField1.setText("The Current Statue IS "+"Synchronozied ");
                       jTextField1.setBackground(new java.awt.Color(51,255,0));
                       jTextField1.setForeground(new java.awt.Color(0, 0, 153));
                        }
                else{
                       jTextField1.setText("The Current Statue IS "+"Asynchronozied ");
                        jTextField1.setBackground(new java.awt.Color(255, 51, 51));
                        jTextField1.setForeground(new java.awt.Color(0,51,51));
                        }
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t2.start();
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disconnect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        disconnect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        disconnect.setText("Disconnect From Server");
        disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 153, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setBackground(new java.awt.Color(0, 51, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("No Streaming avaliable now");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectActionPerformed
        try {
            ser.close();    // closes connection with server
            dispose();  // disposes the open window with that specific server
        } catch (IOException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_disconnectActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton disconnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
