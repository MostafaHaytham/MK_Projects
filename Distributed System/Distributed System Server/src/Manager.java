
import java.rmi.RemoteException;


public interface Manager extends java.rmi.Remote {
	public int createaccount(String email, String username , String password)throws RemoteException;
        public boolean login(String un, String ps) throws RemoteException;
        public boolean Createevent( String username ,String id ,String month, String hour, String title , String day , String desc ) throws RemoteException;
        public String [] viewall()throws RemoteException ;
        public String [] viewmyevents(String username) throws RemoteException;
        public String[] viewaspecific(String Searchby, String Searchvalue)throws RemoteException ;
        public String edit(String Updateby, String Updatevalue , String id,String username) throws RemoteException;
        public String delete(String id, String username)throws RemoteException ;
        public String shareevent(String id, String newuser,String username)throws RemoteException ;
        public String[] reduce(String SearchTitle, String SearchType[], int countSearch)throws RemoteException ;
        public String[] map(String SearchTitle) throws RemoteException;
        public void setfin() throws RemoteException ;
}
