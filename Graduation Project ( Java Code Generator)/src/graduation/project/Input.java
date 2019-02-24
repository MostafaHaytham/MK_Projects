/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.project;

/**
 *
 * @author Haytham
 */
public class Input {
    public void start()
    {
        String message="//you shoud add this library before the class name => import java.util.Scanner;\n";
        message+="//and add this line of code inside the class you want to get input from the user ==> Scanner scan = new Scanner(System.in);\n";
        message+="//if you want the user to enter integer ==> int userInput=scan.nextInt();\n";
        message+="//for double ==> double userInput=scan.nextDouble();\n";
        message+="//for float ==> float userInput=scan.nextFloat();\n";
        message+="//for byte ==> byte userInput=scan.nextByte();\n";
        message+="//for long ==> long userInput=scan.nextLong();\n";
        message+="//for short ==> short userInput=scan.nextShort();\n";        
        message+="//for String ==> String userInput=scan.next();\n";       
        message+="//for Line ==> String userInput=scan.nextLine();\n";
        Display d = new Display ();
        d.jTextArea1.setText(message);
        d.setVisible(true);
    }
    
}
