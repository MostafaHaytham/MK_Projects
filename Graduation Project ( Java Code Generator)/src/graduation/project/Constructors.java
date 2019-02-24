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
public class Constructors {
    
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String className="";
    String [] dataTypes= new String [100];
    String [] variableName= new String [100];
    int variablesCounter=0;
    
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
                    dataTypes[variablesCounter]=q.jTextField1.getText();
                    if (!dataTypes[variablesCounter].equals("") && dataTypes[variablesCounter].equals("0")) {
                        counter=4;
                        handler();
                    }
                    else if(!dataTypes[variablesCounter].equals("") && !dataTypes[variablesCounter].equals("0"))
                    {
                        handler();
                    }
                }
                else if(counter==3)
                {
                    variableName[variablesCounter]=q.jTextField1.getText();
                    if (!variableName[variablesCounter].equals("") ) {
                        counter=1;
                        variablesCounter++;
                        handler();
                    }
                }
                
            }
        });
    }
    public void mainQuestion() {

        counter++;
        String mainQuestion = "Enter the class name?";
        String mainQuestionChoices = "The class name that you will include theses constructor in\n";
        mainQuestionChoices += "This tab create all constructors but default constructor is created in the class tab\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "Enter all the Variables you want to use in the constructor and that declared already in the class\n";
        ques1+="Variable data type? (Enter \"0\" if there are no variable you want to add to this constructor!)";
        String ques1choices = "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question2() {
        counter++;
        String ques2 = "Variable name?";
        String ques2choices = "Any name you want but does not start with a number or a symbol and you declared it before in the class!";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String body="";
        String constructor="public "+className+" ( ";
        for(int count=0; count<variablesCounter;count++)
        {
            if(count!=0)
            {
                constructor+=" , ";
            }
            constructor+=dataTypes[count]+" "+variableName[count];
            body+="this."+variableName[count]+" = "+variableName[count]+ " ;\n";
        }
        constructor+=" ) { \n";
        constructor+=body;
        constructor+=" }";
        Display d= new Display();
        d.jTextArea1.setText(constructor);
        q.setVisible(false);
        d.setVisible(true);
    }
}
