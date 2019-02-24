/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Haytham
 */
public class ExceptionHandler {

    QuestionAnswer q = new QuestionAnswer();
    String choice = "";

    public void mainQuestion() {
        String mainQuestion = "Choose which exception you want to handle?\n";
        String mainQuestionChoices = "-Exceptions are the customary way in Java to indicate to a calling method that an abnormal condition has occurred. \n"
                + "-An exception (or exceptional event) is a problem that arises during the execution of a program.\n"
                + "1.ArithmeticException(Arithmetic error, such as divide-by-zero.)\n"
                + "2.ArrayIndexOutOfBoundsException(Array index is out-of-bounds.)\n"
                + "3.ArrayStoreException(Assignment to an array element of an incompatible type.)\n"
                + "4.ClassCastException(Invalid cast.)\n"
                + "5.IllegalArgumentException(Illegal argument used to invoke a method.)\n"
                + "6.IllegalMonitorStateException(Illegal monitor operation, such as waiting on an unlocked thread.)\n"
                + "7.IllegalStateException(Environment or application is in incorrect state.)\n"
                + "8.IllegalThreadStateException(Requested operation not compatible with current thread state.)\n"
                + "9.IndexOutOfBoundsException(Some type of index is out-of-bounds.)\n"
                + "10.NegativeArraySizeException(Array created with a negative size.)\n"
                + "11.NullPointerException(Invalid use of a null reference.)\n"
                + "12.NumberFormatException(Invalid conversion of a string to a numeric format.)\n"
                + "13.SecurityException(Attempt to violate security.)\n"
                + "14.StringIndexOutOfBounds(Attempt to index outside the bounds of a string.)\n"
                + "15.UnsupportedOperationException(An unsupported operation was encountered.)\n"
                + "16.ClassNotFoundException(Class not found.)\n"
                + "17.CloneNotSupportedException(Attempt to clone an object that does not implement the Cloneable interface.)\n"
                + "18.IllegalAccessException(Access to a class is denied.)\n"
                + "19.InstantiationException(Attempt to create an object of an abstract class or interface.)\n"
                + "20.InterruptedException(One thread has been interrupted by another thread.)\n"
                + "21.NoSuchFieldException(A requested field does not exist.)\n"
                + "22.NoSuchMethodException(A requested method does not exist.)\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                choice = q.jTextField1.getText();
                if (!choice.equals("")) {
                    display();
                }

            }
        });
    }
    public void display()
    {
        String message="try {\n //Protected code (code that might contain the abnormal condition)\n\n }\n"
                + "catch(";
        if(choice.equals("1"))
        {
            message+="ArithmeticException";
        }
        else if(choice.equals("2"))
        {
            message+="ArrayIndexOutOfBoundsException";
        }
        else if(choice.equals("3"))
        {
            message+="ArrayStoreException";
        }
        else if(choice.equals("4"))
        {
            message+="ClassCastException";
        }
        else if(choice.equals("5"))
        {
            message+="IllegalArgumentException";
        }
        else if(choice.equals("6"))
        {
            message+="IllegalMonitorStateException";
        }
        else if(choice.equals("7"))
        {
            message+="IllegalStateException";
        }
        else if(choice.equals("8"))
        {
            message+="IllegalThreadStateException";
        }
        else if(choice.equals("9"))
        {
            message+="IndexOutOfBoundsException";
        }
        else if(choice.equals("10"))
        {
            message+="NegativeArraySizeException";
        }
        else if(choice.equals("11"))
        {
            message+="NullPointerException";
        }
        else if(choice.equals("12"))
        {
            message+="NumberFormatException";
        }
        else if(choice.equals("13"))
        {
            message+="SecurityException";
        }
        else if(choice.equals("14"))
        {
            message+="StringIndexOutOfBounds";
        }
        else if(choice.equals("15"))
        {
            message+="UnsupportedOperationException";
        }
        else if(choice.equals("16"))
        {
            message+="ClassNotFoundException";
        }
        else if(choice.equals("17"))
        {
            message+="CloneNotSupportedException";
        }
        else if(choice.equals("18"))
        {
            message+="IllegalAccessException";
        }
        else if(choice.equals("19"))
        {
            message+="InstantiationException";
        }
        else if(choice.equals("20"))
        {
            message+="InterruptedException";
        }
        else if(choice.equals("21"))
        {
            message+="NoSuchFieldException";
        }
        else if(choice.equals("22"))
        {
            message+="NoSuchMethodException";
        }
        message+=" ex ) {\n //Catch block(the code that will execute if this exception occurs in the try clause\n\n }\n";
        message+="finally {\n //The finally block always executes(you can remove it or keep it)\n\n }\n";
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }

}
