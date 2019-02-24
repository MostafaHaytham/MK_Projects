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
public class ObjectOfClasses {
    
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String className="";
    String size="";
    String variableName="";
    
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
                    className = q.jTextField1.getText();
                    if (!className.equals("")) {
                        handler();
                    }
                }
                else if(counter==2)
                {
                    variableName=q.jTextField1.getText();
                    if (!variableName.equals("")) {
                        handler();
                    }
                }
                else if(counter==3)
                {
                    size=q.jTextField1.getText();
                    if (!size.equals("")) {
                        counter=4;
                        handler();
                    }
                }
                
            }
        });
    }
    public void mainQuestion() {

        counter++;
        String mainQuestion = "Enter the class name ?";
        String mainQuestionChoices = "This object can be used to call anything accessible in the class";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {

        counter++;
        String ques1 = "Enter the name of the object ?";
        String ques1Choices = "you can call the functions by writing the name of the object and then '.' and call the function name \n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1Choices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question2() {

        counter++;
        String ques2 = "Enter the size of the objects ?";
        String ques2Choices = "you can also create array of objects, so if you need to create one object enter 1 \n";
        ques2Choices+="if you want to create array of object enter the size of this array";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2Choices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void display()
    {
        String message="";
        if(size.equals("1"))
        {
            message+=className+" "+variableName+" = new "+className+" ();";
        }
        else if(!size.equals("1"))
        {
            message+=className+"[] "+variableName+" = new "+className+" ["+size+"] ;\n";
            message+="// you can intialize any index of this array by adding the next line of code"+"\n";
            message+=variableName+"[0] "+"= new "+className+" () ;\n";
            message+="// this line will intialize the first object in the array"+"\n";
        }
        Display d= new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
    
}
