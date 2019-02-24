/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 * @author Haytham
 */
public class Arraylist {
    ArrayList<String> x= new ArrayList<String>(); 
    
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String arrayListName="";
    String arrayListType="";
    
    public void handler()
    {
        if(counter==0)
        {
            mainQuestion();
        }
        else if(counter==2)
        {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(counter==1)
                {
                    arrayListName = q.jTextField1.getText();
                    if (!arrayListName.equals("")) {
                        counter =2;
                        handler();
                    }
                }
                
            }
        });
    }
    public void mainQuestion() {
        counter++;
        String mainQuestion = "Enter the name of the arraylist?";
        String mainQuestionChoices = "The name you are going to use to add and remove from the list.\n";
        mainQuestionChoices+="The ArrayList class extends AbstractList and implements the List interface. ArrayList supports dynamic arrays that can grow as needed.\n";
        mainQuestionChoices+="Standard Java arrays are of a fixed length. After arrays are created, they cannot grow or shrink, which means that you must know in advance how many elements an array will hold.\n";
        mainQuestionChoices+="Array lists are created with an initial size. When this size is exceeded, the collection is automatically enlarged. When objects are removed, the array may be shrunk.\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void display() {
        String message="//you shoud add this library before the class name => import java.util.ArrayList;\n";        
        message+="ArrayList "+arrayListName+" = new ArrayList ();\n";
        message+="//This is how elements should be added to the array list\n";
        message+="//"+arrayListName+".add(\"Ajeet\");\n";
        message+="//"+arrayListName+".add(22);\n";
        message+="//The first item we've added to the list above are String objects. The second item is a number. But this will be a number object of type Integer, rather than the primitive data type int.\n";
        message+="//Add element at the index 0\n";
        message+="//"+arrayListName+".add(0, \"Rahul\");\n";
        message+="//Remove elements with string \"Chaitanya\" from array list like this\n";
        message+="//"+arrayListName+".remove(\"Chaitanya\");\n";
        message+="//Remove element from the index 1\n";
        message+="//"+arrayListName+".remove(1);\n";
        message+="//Get element at the index 2\n";
        message+="//System.out.println("+arrayListName+".get(2));\n";
        message+="//Displaying array list elements\n";
        message+="//System.out.println(\"Current array list is:\"+"+arrayListName+");\n";
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
        
    }
    
}
