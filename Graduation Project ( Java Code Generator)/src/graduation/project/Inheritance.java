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
 * @author Mostafa
 */
public class Inheritance {    
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String choice="";
    String childClass="";
    String parentClass="";
    
    
    public void handler()
    {
        if(counter==0)
        {
            mainQuestion();
        }
        else if(counter==1)
        {
            question1();
        }
        else if(counter==2)
        {
            question2();
        }
        else if(counter==4)
        {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(counter==1)
                {
                    choice = q.jTextField1.getText();
                    if (choice.equals("1")) {
                        handler();
                    }
                    else if(choice.equals("2"))
                    {
                        ObjectOfClasses o = new ObjectOfClasses();
                        o.handler();
                    }
                }
                else if(counter==2)
                {
                    childClass=q.jTextField1.getText();
                    if (!childClass.equals("")) {
                        handler();
                    }
                }
                else if(counter==3)
                {
                    parentClass=q.jTextField1.getText();
                    if (!parentClass.equals("")) {
                        counter=4;
                        handler();
                    }
                }
                
            }
        });
        
    }
    public void mainQuestion() {
        counter++;
        String mainQuestion = "What type of inheritance you need?\n Enter the number of your choice:";
        String mainQuestionChoices = "1. Single Inheritance   \n";
        mainQuestionChoices+="Single inheritance is damn easy to understand. When a class extends another one class only then we  call it a single inheritance.\n";
        mainQuestionChoices+="2.Multiple Inheritance\n";
        mainQuestionChoices+="Multiple Inheritance” refers to the concept of one class extending (Or inherits) more than one base class. \n";
        mainQuestionChoices+="You will create an object of this class inside your class to use all it's public methods and variables";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "Enter your class name: \n";
        String ques1choices="The name of the child class that will inherit from the parent class\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question2() {
        counter++;
        String ques2 = "Enter the name of the other class: ";
        String ques2choices = "The name of the parent class\n";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String message="//replace this line of code with the first line in your chidl class \n";
        message+="public class "+childClass+" extends "+parentClass+"\n";
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
}
