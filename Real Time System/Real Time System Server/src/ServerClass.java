/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.ToolFactory;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BigGuy
 * This Class is used to create a connection for the client, i simply moved it from the original server file and put it
 * on its own
 */
public class ServerClass implements Runnable {
     Socket csocket;    // Client Socket
     String name;   // Name of client
    public ServerClass(Socket csocket) {
        this.csocket = csocket;
        
    }
    @Override
    public void run() {
      try {
          // Create Streams up streams
          PrintStream pstream ;
          Scanner inpstream = new Scanner( csocket.getInputStream());
          
          IMediaReader mediaReader = ToolFactory.makeReader(SplittVideo.inputFilename);

        // stipulate that we want BufferedImages created in BGR 24bit color space
        mediaReader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
        
        mediaReader.addListener(new SplittVideo.ImageSnapListener());
        
          //First input from client is the name, that is the first piece of data sent from there
          name =inpstream.nextLine();   
          //; While loop will run as long as there is a connection
          
          String Prev=" ";
         while(mediaReader.readPacket() == null)
         {
          //int    x=0;
           //    System.out.println("In the loop for the "+x++);
            int size = MultiServer2.connections.size();        // gets size of currently connected clients               
                //Loop to send the message to all clients
                for(int i =0; i<size;i++)
                {   
                   //  System.out.println("inner loop "+i);
                     pstream = new PrintStream(MultiServer2.connections.get(i).getOutputStream()); // conects to each clients outputstream and sends data
                
                     if(!SplittVideo.outputFilename.equals(Prev)){
                     
                     Prev = SplittVideo.outputFilename;
                    // String TimeStamp = Prev.substring(34, 47);
                    String TimeStamp = Long.toString(System.currentTimeMillis());
                     System.out.println(TimeStamp);
                     pstream.println(SplittVideo.outputFilename);
                     pstream.println(TimeStamp);
                     }
                }
                
         }
      }
      catch (Exception e) {
         System.out.println("Connection Closed From : "+name); 
         e.printStackTrace();// Displayed on server side when connection is closed
      } 
   }
   public synchronized boolean book(int c) throws InterruptedException
   {
         return false;
       
   }
     
     
}
