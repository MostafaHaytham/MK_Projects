
import java.rmi.RemoteException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Haytham
 */
public class Client {

    public void workasClient() throws RemoteException {
        Summer summer = new Summer();
        Scanner s = new Scanner(System.in);
        int choice;
        int check = 0;
        String username = "";
        String password = "";
        String email = "";
        String title, day, hour, month, desc, newtitle, id;
        boolean log, checkid;
        boolean checklogin = false;
        for (int i = 0; i < 100; i++) {
            System.out.println();
            System.out.println("1.Create Account.");
            System.out.println("2.Login.");
            System.out.println("3.Modify/View Events.");
            System.out.println("4.Aggregated analysis.");
            System.out.println("5.Logout");
            System.out.println("6. Exit.");
            System.out.print("Enter Your choice: ");
            choice = s.nextInt();
            log = false;
            check = 0;
            if (choice == 1) {//Create Account
                while (!log) {
                    if (check == 0) {
                        System.out.print("Enter Your Email: ");
                        email = s.next();
                        System.out.print("Enter Your Username: ");
                        username = s.next();
                        System.out.print("Enter Your Password: ");
                        password = s.next();
                        check = summer.createaccount(email, username, password);
                    } else if (check == 1) {
                        System.out.println("Email Already used.. choose another email! ");
                        email = s.next();
                        check = summer.createaccount(email, username, password);
                    } else if (check == 2) {
                        System.out.println("Username Already used.. choose another Username! ");
                        username = s.next();
                        check = summer.createaccount(email, username, password);
                    } else if (check == 3) {
                        log = true;
                        System.out.println("Your have successfully registered!");
                        
                    }

                }
            } else if (choice == 2) {//Login
                System.out.print("Enter your username: ");
                username = s.next();
                System.out.print("Enter your password: ");
                password = s.next();
                checklogin = summer.login(username, password);
                if (checklogin) {
                    System.out.println("Login Succesfull!");
                } else {
                    System.out.println("Login Failed!");
                }
            } else if (choice == 3) {//Modify/View Events
                if (checklogin) {
                    System.out.println("Choose From the options: ");
                    System.out.println("1.Create Event");
                    System.out.println("2.Modify Event");
                    System.out.println("3.View Events");
                    System.out.println("4.Share Event");
                    System.out.print("Enter your choice: ");
                    choice = s.nextInt();
                    if (choice == 1) {//create event

                        System.out.print("Enter the id: ");
                        id = s.next();
                        System.out.print("Enter the month: ");
                        month = s.next();
                        System.out.print("Enter the day: ");
                        day = s.next();
                        System.out.print("Enter the hour: ");
                        hour = s.next();
                        System.out.print("Enter the title: ");
                        title = s.next();
                        System.out.print("Enter the description: ");
                        desc = s.next();
                        checkid = false;
                        checkid = summer.Createevent(username, id, month, hour, title, day, desc);
                        while (!checkid) {
                            System.out.print("Id already taken.. Enter Another id: ");
                            id = s.next();
                            checkid = summer.Createevent(username, id, month, hour, title, day, desc);
                        }
                        System.out.println("Your Event is created!");
                    } else if (choice == 2) {
                        System.out.println("1.Edit Event");
                        System.out.println("2. Delete Event");
                        System.out.print("Enter your choice: ");
                        choice = s.nextInt();
                        if (choice == 1)//edit
                        {
                            System.out.print("Enter the id of the event: ");
                            id = s.next();
                            System.out.println("What do you wanna modify? (1.month,2.day,3.hour,4.title,5.description)");
                            choice = s.nextInt();
                            String Updateby = "";
                            String Updatevalue = "";
                            if (choice == 1)//edit by month
                            {
                                System.out.print("Enter the month: ");
                                Updatevalue = s.next();
                                Updateby = "month";
                            } else if (choice == 2)//edit by day
                            {
                                System.out.print("Enter the day: ");
                                Updatevalue = s.next();
                                Updateby = "day";
                            } else if (choice == 3)//edit by hour
                            {
                                System.out.print("Enter the hour: ");
                                Updatevalue = s.next();
                                Updateby = "hour";
                            } else if (choice == 4)//edit by title
                            {
                                System.out.print("Enter the title: ");
                                Updatevalue = s.next();
                                Updateby = "title";
                            } else if (choice == 5)//edit by description
                            {
                                System.out.print("Enter the description: ");
                                Updatevalue = s.next();
                                Updateby = "description";
                            }
                            String event = summer.edit(Updateby, Updatevalue, id, username);
                            System.out.println(event);

                        } else if (choice == 2)//delete
                        {
                            System.out.print("Enter the id of the event: ");
                            id = s.next();
                            String deleteevent = summer.delete(id, username);
                            System.out.println(deleteevent);
                        }
                    } else if (choice == 3) {//View Events
                        System.out.println("1.View all events.");
                        System.out.println("2.View Specific events.");
                        System.out.println("3. View all my events.");
                        System.out.print("Enter your choice: ");
                        choice = s.nextInt();
                        if (choice == 1) {//viewall
                            String events[] = summer.viewall();
                            for (int z = 0; z < 100; z++) {
                                if (!"end".equals(events[z])) {
                                    System.out.println(events[z]);
                                } else {
                                    break;
                                }
                            }
                        } else if (choice == 2) {
                            System.out.println("What you wanna view your events? (1.month,2.day,3.hour,4.title,5.description)");
                            System.out.print("Enter your choice: ");
                            choice = s.nextInt();
                            String Searchby = "";
                            String Searchvalue = "";
                            if (choice == 1)//view by month
                            {
                                System.out.print("Enter the month: ");
                                Searchvalue = s.next();
                                Searchby = "month";
                            } else if (choice == 2)//view by day
                            {
                                System.out.print("Enter the day: ");
                                Searchvalue = s.next();
                                Searchby = "day";
                            } else if (choice == 3)//view by hour
                            {
                                System.out.print("Enter the hour: ");
                                Searchvalue = s.next();
                                Searchby = "hour";
                            } else if (choice == 4)//biew by title
                            {
                                System.out.print("Enter the title: ");
                                Searchvalue = s.next();
                                Searchby = "title";
                            } else if (choice == 5)//view by description
                            {
                                System.out.print("Enter the description: ");
                                Searchvalue = s.next();
                                Searchby = "description";
                            }
                            String events[] = summer.viewaspecific(Searchby, Searchvalue);
                            for (int z = 0; z < 100; z++) {
                                if (!"end".equals(events[z])) {
                                    System.out.println(events[z]);
                                } else {
                                    break;
                                }
                            }
                        } else if (choice == 3) {//viewmyevents
                            String events[] = summer.viewmyevents(username);
                            for (int z = 0; z < 100; z++) {
                                if (!"end".equals(events[z])) {
                                    System.out.println(events[z]);
                                } else {
                                    break;
                                }
                            }
                        }

                    } else if (choice == 4)//share event with user
                    {
                        System.out.print("Enter the id of the event: ");
                        id = s.next();
                        System.out.print("Enter the username of the shareduser: ");
                        String newuser = s.next();
                        String share = summer.shareevent(id, newuser, username);
                        System.out.println(share);
                    }
                } else {
                    System.out.println("You have to login first!");
                    System.out.println();
                }

            } else if (choice == 4) {//Search
                System.out.print("How you wanna know the data? (1.day/2.hour)");
                choice = s.nextInt();
                if (choice == 1) {
                  String lasttitle[]=  summer.map("day");
                    for (int n = 0; n < 100; n++) {
                        if (!"end".equals(lasttitle[n])) {
                            System.out.println(lasttitle[n]);
                        } else {
                            n = 101;
                        }
                    }
                } else if (choice == 2) {
                    String lasttitle[]=  summer.map("hour");
                    for (int n = 0; n < 100; n++) {
                        if (!"end".equals(lasttitle[n])) {
                            System.out.println(lasttitle[n]);
                        } else {
                            n = 101;
                        }
                    }
                }
            } else if (choice == 5)//Logout
            {
                if (checklogin) {
                    System.out.println("You have successfully logged out!");
                    checklogin = false;
                } else {
                    System.out.println("You are net logged in!");
                }
                checklogin = false;
            } else if (choice == 6) {//Exit
                i = 101;
            } else {
                System.out.println("Wrong Choice");
            }
        }
    }

}
