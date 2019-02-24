import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class Server {

	public static void main(String[] args) throws RemoteException {
                int x=-1;
                System.out.println("Do you want to work as a server or a client? (1.Client/2.Server)");
                Scanner s= new Scanner(System.in);
                int choice=s.nextInt();
                if(choice==1)
                {
                    Client c= new Client();
                    c.workasClient();
                }
                else {
                Summer magicHere = new Summer();
                System.out.println("The Server is on! (Press 0 to Exit the server).");
                Manager remoteObj = magicHere;
                try {
                    Manager stub = (Manager) UnicastRemoteObject.exportObject(remoteObj, 0);
                    Registry registry;
                    //System.setProperty("java.rmi.server.hostname", "192.168.1.102");
                    try {

                        registry = LocateRegistry.createRegistry(1099);
                    } catch (Exception e) {
                        registry = LocateRegistry.getRegistry();
                    }
                    registry.rebind("Summer", stub);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                while (!magicHere.finished()) {
                    x=s.nextInt();
                    if(x==0)
                    {
                        magicHere.setfin();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
            System.exit(1);
        }

}
