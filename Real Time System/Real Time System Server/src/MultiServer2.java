import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableServer.THREAD_POLICY_ID;

class MultiServer2
{
   static ArrayList<Socket> connections = new ArrayList<>();
   public static void main(String args[]) 
   throws Exception {
      ServerSocket ssock = new ServerSocket(1234);
      System.out.println("Listening");
      while (true) {
         Socket sock = ssock.accept();
         System.out.println("Connected");
         connections.add(sock);
         new Thread(new ServerClass(sock)).start();
      }
   }
}