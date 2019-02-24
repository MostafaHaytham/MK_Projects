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
public class Classes {
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String className="";
    String [] access= new String [100];
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
        else if(counter==3)
        {
            question3();
        }
        else if(counter==5)
        {
            displayClass();
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
                    access[variablesCounter]=q.jTextField1.getText();
                    if (!access[variablesCounter].equals("") && access[variablesCounter].equals("4")) {
                        counter=5;
                        handler();
                    }
                    else if(!access[variablesCounter].equals("") && !access[variablesCounter].equals("4"))
                    {
                        handler();
                    }
                }
                else if(counter==3)
                {
                    dataTypes[variablesCounter]=q.jTextField1.getText();
                    if (!dataTypes[variablesCounter].equals("") ) {
                        handler();
                    }
                }
                else if(counter==4)
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
        String mainQuestionChoices = "The class name is name that you will use to create objects to this class";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {

        counter++;
        String mainQuestion = "Enter the controlling access to the next variable (the number of the choice)?";
        String mainQuestionChoices = "1.Public \n2.Private \n3.Protected\n4.No more variables(Display the class code)\n";
        mainQuestionChoices+="Public variables, are variables that are visible to all classes.\n";
        mainQuestionChoices+="Private variables, are variables that are visible only to the class to which they belong.\n";
        mainQuestionChoices+="Protected variables, are variables that are visible only to the class to which they belong, and any subclasses.";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question2() {
        counter++;
        String ques2 = "Variable data type?";
        String ques2choices = "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question3() {
        counter++;
        String ques3 = "Variable name?";
        String ques3choices = "Any name you want but does not start with a number or a symbol and you didnt use it before in this class!";
        q.jTextArea1.setText(ques3);
        q.jTextArea2.setText(ques3choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void displayClass()
    {
        String publicVariables="";
        String privateVariables="";
        String protectedVariables="";
        String mutators="";
        String accessors="";
        String constructor="Public "+className+" () { \n";
        for(int count=0; count<variablesCounter; count++)
        {
            if(access[count].equals("1"))
            {
                publicVariables+="public "+dataTypes[count]+" "+variableName[count]+" ;\n";
            }
            else if(access[count].equals("2"))
            {
                privateVariables+="private "+dataTypes[count]+" "+variableName[count]+" ;\n";
            }
            else if(access[count].equals("3"))
            {
                protectedVariables+="protected "+dataTypes[count]+" "+variableName[count]+" ;\n";
            }
            mutators+="Public void "+"set"+variableName[count]+"( "+dataTypes[count]+" "+variableName[count]+" ) { \n";
            mutators+="this."+variableName[count]+" = "+variableName[count]+" ;\n } \n";
            accessors+="Public "+dataTypes[count]+" get"+variableName[count]+"( ) { \n";
            accessors+="return this."+variableName[count]+" ;\n } \n";
            if(dataTypes[count].equals("String"))
            {             
                constructor+="this."+variableName[count]+" = \" \" ;\n";
            }
            else if(dataTypes[count].equals("char"))
            {
                constructor+="this."+variableName[count]+" = \' \' ;\n";
            }
            else if(dataTypes[count].equals("int") || dataTypes[count].equals("short") || dataTypes[count].equals("byte") )
            {
                constructor+="this."+variableName[count]+" = 0 ;\n";
            }
            else if(dataTypes[count].equals("long"))
            {
                constructor+="this."+variableName[count]+" = 0L ;\n";
            }
            else if(dataTypes[count].equals("float"))
            {
                constructor+="this."+variableName[count]+" = 0.0f ;\n";
            }
            else if(dataTypes[count].equals("double"))
            {
                constructor+="this."+variableName[count]+" = 0.0d ;\n";
            }
            else if(dataTypes[count].equals("boolean"))
            {
                constructor+="this."+variableName[count]+" = false ;\n";
            }
            else
            {
                constructor+="this."+variableName[count]+" = null ;\n";
            }
            
        }
        constructor+="\n } \n";
        String message="1.Select File > New File from the menu at the top.\n";
        message+="2.At the New File screen, select \"Java\" for Category, \"Java Class\" for the File Type and click the \"Next\" button.\n";
        message+="3.Then enter the class name and then click \"Finsh\"\n";
        message+="-------------------------------------------------------\n";
        message+="// Code inside the class\n";       
        message+=publicVariables;
        message+=privateVariables;
        message+=protectedVariables;
        message+=constructor;
        message+=mutators;
        message+=accessors;
        Display d= new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
    
}
