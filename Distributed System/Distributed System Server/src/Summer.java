

import java.rmi.RemoteException;
import java.util.Scanner;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Summer implements Manager {
    private static Mongo mongo;
    private static DB db;
    private static DBCollection collection;
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
    private static DBCursor cursor;
    int fin;

    Summer() {
        Scanner s = new Scanner(System.in);
        mongoLogger.setLevel(Level.SEVERE);
        mongo = new Mongo("localhost", 27017);
        db = mongo.getDB("usersdatabase");
        fin = 0;
    }

    public synchronized int createaccount(String email, String username , String password)throws RemoteException {

        collection = db.getCollection("Testusers");
        BasicDBObject document = new BasicDBObject();
        for (int i = 0; i < 100; i++) {
            document.put("email", email);
            cursor = collection.find(document);
            if (!cursor.hasNext()) {
                i = 101;
            } else {
                return 1;
            }
        }
        BasicDBObject document1 = new BasicDBObject();
        for (int i = 0; i < 101; i++) {
            document1.put("username", username);
            cursor = collection.find(document1);
            if (!cursor.hasNext()) {
                i = 101;
            } else {
                return 2;
            }
        }
        BasicDBObject doc = new BasicDBObject("username", username).
                        append("email", email).
                        append("password", password);
                collection.insert(doc);
        return 3;

    }

    public synchronized boolean login(String un, String ps) throws RemoteException{
        collection = db.getCollection("Testusers");
        BasicDBObject document = new BasicDBObject();
        document.put("username", un);
        String checkpass = " ";
        cursor = collection.find(document);
        if (cursor.hasNext()) {
            BasicDBObject dbObject = (BasicDBObject) cursor.next();
            checkpass = dbObject.getString("password");
        } else {
            return false;
        }
        if (!ps.equals(checkpass)) {
            return false;
        }
        return true;

    }
    public synchronized boolean Createevent( String username ,String id ,String month, String hour, String title , String day , String desc ) throws RemoteException{
        collection = db.getCollection("Testevents");       
        BasicDBObject document = new BasicDBObject();        
        document.put("id", id);
        cursor = collection.find(document);
        if (cursor.hasNext()) {
            return false;
        }
        BasicDBObject doc = new BasicDBObject("username", username).
                append("id", id).
                append("month", month).
                append("day", day).
                append("hour", hour).
                append("title", title).
                append("description", desc);
        collection.insert(doc);
        return true;
    }
    public synchronized String [] viewall()throws RemoteException {
            collection = db.getCollection("Testusers");
            cursor = collection.find();
            String usernames[]=new String[100];
            int countusers=0;
            while(cursor.hasNext())
            {
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                usernames[countusers] = dbObject.getString("username");
                countusers++;
            }
            collection = db.getCollection("Testevents");       
            BasicDBObject document = new BasicDBObject(); 
            cursor = collection.find();
            String username ,id , month , day , hour , title , desc ;
            String sharedusers="" ;
            String events[]=new String[100];
            int count=0;
            String []newusers= new String[100];
            int countnew=0;
            while (cursor.hasNext()) {
                countnew=0;
                sharedusers=" ";
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                username = dbObject.getString("username");
                id = dbObject.getString("id");
                month = dbObject.getString("month");
                day = dbObject.getString("day");
                hour = dbObject.getString("hour");
                title = dbObject.getString("title");
                desc = dbObject.getString("description");
                for(int k=0;k<countusers;k++)
                {
                    String check = dbObject.getString(usernames[k]);
                    if("shareduser".equals(check))
                    {
                        newusers[countnew]=usernames[k];
                        countnew++;
                    }
                }
                for(int k=0;k<countnew;k++)
                {
                    sharedusers =sharedusers+" "+newusers[k]+",";
                }
                events[count]="Username: "+username+" ,Id: "+id+" ,Month: "+month+" ,Day: "+day+" ,Hour: "+hour+" ,Title: "+title+" ,Description: "+desc+" ,Sharedusers:"+sharedusers;
                count++;
            }
            events[count]="end";
            return events;
            
    }
    public synchronized String [] viewmyevents(String username) throws RemoteException{
           collection = db.getCollection("Testusers");
            cursor = collection.find();
            String usernames[]=new String[100];
            int countusers=0;
            while(cursor.hasNext())
            {
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                usernames[countusers] = dbObject.getString("username");
                countusers++;
            }
            collection = db.getCollection("Testevents");       
            BasicDBObject document = new BasicDBObject();  
            document.put("username", username);
            cursor = collection.find(document);
            String id , month , day , hour , title , desc ;
            String sharedusers="" ;
            String events[]=new String[100];
            int count=0;
            String []newusers= new String[100];
            int countnew=0;
            while (cursor.hasNext()) {
                countnew=0;
                sharedusers=" ";
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                id = dbObject.getString("id");
                month = dbObject.getString("month");
                day = dbObject.getString("day");
                hour = dbObject.getString("hour");
                title = dbObject.getString("title");
                desc = dbObject.getString("description");
                for(int k=0;k<countusers;k++)
                {
                    String check = dbObject.getString(usernames[k]);
                    if("shareduser".equals(check))
                    {
                        newusers[countnew]=usernames[k];
                        countnew++;
                    }
                }
                for(int k=0;k<countnew;k++)
                {
                    sharedusers =sharedusers+" "+newusers[k]+",";
                }
                events[count]="Username: "+username+" ,Id: "+id+" ,Month: "+month+" ,Day: "+day+" ,Hour: "+hour+" ,Title: "+title+" ,Description: "+desc+" ,Sharedusers:"+sharedusers;
                count++;
            }
            BasicDBObject document2 = new BasicDBObject();  
            document2.put(username, "shareduser");
            DBCursor cursor2 = collection.find(document2);
            events[count]="Shared Events:";
            count++;
            while (cursor2.hasNext()) {
                countnew=0;
                sharedusers=" ";
                BasicDBObject dbObject = (BasicDBObject) cursor2.next();
                username= dbObject.getString("username");
                id = dbObject.getString("id");
                month = dbObject.getString("month");
                day = dbObject.getString("day");
                hour = dbObject.getString("hour");
                title = dbObject.getString("title");
                desc = dbObject.getString("description");
                for(int k=0;k<countusers;k++)
                {
                    String check = dbObject.getString(usernames[k]);
                    if("shareduser".equals(check))
                    {
                        newusers[countnew]=usernames[k];
                        countnew++;
                    }
                }
                for(int k=0;k<countnew;k++)
                {
                    sharedusers =sharedusers+" "+newusers[k]+",";
                }
                events[count]="Username: "+username+" ,Id: "+id+" ,Month: "+month+" ,Day: "+day+" ,Hour: "+hour+" ,Title: "+title+" ,Description: "+desc+" ,Sharedusers:"+sharedusers;
                count++;
            }
            events[count]="end";
            return events;
            
    }

    public synchronized String[] viewaspecific(String Searchby, String Searchvalue)throws RemoteException {
        collection = db.getCollection("Testevents");
        BasicDBObject document = new BasicDBObject();
        document.put(Searchby, Searchvalue);
        cursor = collection.find(document);
        String id , month , day , hour , title , desc ;
            String events[]=new String[100];
            int count=0;
            while (cursor.hasNext()) {
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                id = dbObject.getString("id");
                month = dbObject.getString("month");
                day = dbObject.getString("day");
                hour = dbObject.getString("hour");
                title = dbObject.getString("title");
                desc = dbObject.getString("description");
                events[count]="Id: "+id+" ,Month: "+month+" ,Day: "+day+" ,Hour: "+hour+" ,Title: "+title+" ,Description: "+desc;
                count++;
            }
            events[count]="end";
            return events;
    }
    public synchronized String edit(String Updateby, String Updatevalue , String id,String username) throws RemoteException{
        collection = db.getCollection("Testevents");
        boolean checkuser=false;
        String event = "";
        BasicDBObject document4 = new BasicDBObject();
        document4.put("id", id);
        cursor = collection.find(document4);
        if (cursor.hasNext()) {
            BasicDBObject dbObject = (BasicDBObject) cursor.next();
            String realuser = dbObject.getString("username");
            String shareduser=dbObject.getString(username);
            if(realuser.equals(username) || "shareduser".equals(shareduser))
            {
                checkuser=true;
            }
        }
        if (checkuser) {
            BasicDBObject document = new BasicDBObject();
            document.put("$set", new BasicDBObject().append(Updateby, Updatevalue));
            BasicDBObject searchQuery = new BasicDBObject().append("id", id);
            collection.update(searchQuery, document);
            BasicDBObject document1 = new BasicDBObject();
            document1.put("id", id);
            cursor = collection.find(document1);
            String month, day, hour, title, desc;
            if (cursor.hasNext()) {
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                id = dbObject.getString("id");
                month = dbObject.getString("month");
                day = dbObject.getString("day");
                hour = dbObject.getString("hour");
                title = dbObject.getString("title");
                desc = dbObject.getString("description");
                event = "Your new Event.. (Id: " + id + " ,Month: " + month + " ,Day: " + day + " ,Hour: " + hour + " ,Title: " + title + " ,Description: " + desc + " )";
            } else {
                event = "There is no event with this id!";
            }
        }
        else
        {
            event="you are not the real owner or a member of the event!";
        }
        return event;
    }
    public synchronized String delete(String id, String username)throws RemoteException {
        collection = db.getCollection("Testevents");
        BasicDBObject document = new BasicDBObject();
        document.put("id", id);
        String deleteevent;
        cursor = collection.find(document);
        if (cursor.hasNext()) {
            BasicDBObject dbObject = (BasicDBObject) cursor.next();
            String realuser = dbObject.getString("username");
            String shareduser=dbObject.getString(username);
            if(realuser.equals(username) || "shareduser".equals(shareduser))
            {
                collection.remove(document);
                deleteevent="Event is succesfully deleted!";
            }
            else
            {
                deleteevent="You are not the real owner of this event!";
            }
        }
        else
        {
            deleteevent="There is no event with this id!";
        }
        return deleteevent;
        
    }
    
    
    public synchronized String shareevent(String id, String newuser,String username)throws RemoteException {
        collection = db.getCollection("Testusers");
        String shareev;
        BasicDBObject document1 = new BasicDBObject();
        document1.put("username", newuser);
        cursor = collection.find(document1);
        if (!cursor.hasNext()) {
            shareev="There is no user with this username!";
        } else {

            collection = db.getCollection("Testevents");
            BasicDBObject document = new BasicDBObject();
            document.put("id", id);
            String shareduser = " ";
            cursor = collection.find(document);
            if (cursor.hasNext()) {
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                String realuser = dbObject.getString("username");
                shareduser = dbObject.getString(username);
                if (realuser.equals(username) || "shareduser".equals(shareduser)) {
                    BasicDBObject document2 = new BasicDBObject();
                    document2.put("$set", new BasicDBObject().append(newuser, "shareduser"));
                    BasicDBObject searchQuery = new BasicDBObject().append("id", id);
                    collection.update(searchQuery, document2);
                    shareev = "You shared your event with " + newuser;
                } else {
                    shareev = "You are not the owner or a member of this event!";
                }
            } else {
                shareev = "Wrong id!";
            }
        }
        return shareev;

    }


    public synchronized String[] reduce(String SearchType, String SearchValues[], int countSearch) throws RemoteException {
        collection = db.getCollection("Testevents");
        BasicDBObject document = new BasicDBObject();
        String mosttitles[]=new String [100];
        String titles[][] = new String[100][100];
        for (int i = 0; i < countSearch; i++) {
            document.put(SearchType, SearchValues[i]);
            cursor = collection.find(document);
            int count=0;
            while (cursor.hasNext()) {
                BasicDBObject dbObject = (BasicDBObject) cursor.next();
                titles[i][count] = dbObject.getString("title");
                count++;
            }            
            int counters[] = new int[count];
            for (int l = 0; l < count; l++) {
                for (int z = l + 1; z < count; z++) {
                    if (titles[i][l].equals(titles[i][z])) {
                        counters[l]++;
                    }
                }
            }
            int max = 0;
            int index = 0;
            for (int j = 0; j < count; j++) {
                if (max < counters[j]) {
                    max = counters[j];
                    index = j;
                }
            }
            mosttitles[i]=SearchType+": "+SearchValues[i]+",Title: "+titles[i][index]+", Number of times:"+(max+1);
        }
        mosttitles[countSearch]="end";
        return mosttitles;
    }

    public synchronized String[] map(String SearchType) throws RemoteException{
        collection=db.getCollection("Testevents");
        BasicDBObject document = new BasicDBObject();
        cursor = collection.find();
        String SearchValues[]= new String[100];
        int countsearch=0;
        while (cursor.hasNext()) {
            BasicDBObject dbObject = (BasicDBObject) cursor.next();
            SearchValues[countsearch]=dbObject.getString(SearchType);
            countsearch++;
        }
        String newSearchValues[]=new String[100];
        int countnew=0;
        int check=0;
        for(int i=0; i<countsearch;i++)
        {
            check=0;
            for (int z = 0; z < countnew; z++) {
                    if(SearchValues[i].equals(newSearchValues[z]))
                    {
                        check=-1;
                    }
                }
            if(check!=-1)
            {
                newSearchValues[countnew]=SearchValues[i];
                countnew++;
            }
        }
        String MostTitles[] = reduce(SearchType,newSearchValues, countnew);
        return MostTitles;

    }

    public boolean finished(){
        if(fin==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public synchronized void setfin()  {
        fin=1;
    }
    

}
