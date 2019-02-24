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
public class Function {    
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String functionName="";
    String paramatersName[]=new String [100];
    String paramatersType[]=new String[100];
    int paramatersCount=0;
    String returnName="";
    String returnType="";
    String access="";
    String choice="";
    
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
        else if(counter==4)
        {
            question4();
        }
        else if(counter==5)
        {
            question5();
        }
        else if(counter==6)
        {
            question6();
        }
        else if(counter==8)
        {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(counter==1)
                {
                    functionName = q.jTextField1.getText();
                    if (!functionName.equals("")) {
                        handler();
                    }
                }
                else if(counter==2)
                {
                    returnType=q.jTextField1.getText();
                    if ( !returnType.equals("") && returnType.equals("void") ) {
                        counter=3;
                        handler();
                    }
                    else if(!returnType.equals("") && !returnType.equals("void") )
                    {
                        handler();
                    }
                }
                else if(counter==3)
                {
                    returnName = q.jTextField1.getText();
                    if (!returnName.equals("")) {
                        handler();
                    }
                }
                else if(counter==4)
                {
                    choice = q.jTextField1.getText();
                    if (!choice.equals("") && choice.equals("1")) {
                        handler();
                    }
                    else if (!choice.equals("") && choice.equals("2")) {
                        counter=6;
                        handler();
                    }
                }
                else if(counter==5)
                {
                    paramatersType[paramatersCount] = q.jTextField1.getText();
                    if (!paramatersType[paramatersCount].equals("")) {
                        handler();
                    }
                }
                else if(counter==6)
                {
                    paramatersName[paramatersCount] = q.jTextField1.getText();
                    if (!paramatersName[paramatersCount].equals("")) {
                        counter=3;
                        paramatersCount++;
                        handler();
                    }
                }
                else if(counter==7)
                {
                    access = q.jTextField1.getText();
                    if (!access.equals("")) {
                        counter=8;
                        handler();
                    }
                }
                
            }
        });
    }
    public void mainQuestion() {
        counter++;
        String mainQuestion = "Enter the function name?";
        String mainQuestionChoices = "The function name could be anything like variable but a name you didnt use in this class  \n";
        mainQuestionChoices+="And does not start with a symbol or a number or operator\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "Does the function return anything? \n";
        ques1+="Enter void or datatype not a number!\n";
        String ques1choices="1.void , 2.Datatype\n";
        ques1choices+="DataTypes: \n";
        ques1choices += "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    
    public void question2() {
        counter++;
        String ques2 = "Enter the name of the variable you are going to return";
        String ques2choices = "A variable that was already declared in this function or this function's paramters!";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    
    public void question3() {
        counter++;
        String ques3 = "Does this function have more paramaters?";
        String ques3choices = "1.Yes\n2.No\n Enter the number of the choice\n";
        ques3choices+="Paramters are values or addresses sent to the function and can be used inside the function";
        q.jTextArea1.setText(ques3);
        q.jTextArea2.setText(ques3choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question4() {
        counter++;
        String ques4 = "Enter the paramter Type?";
        String ques4choices = "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(ques4);
        q.jTextArea2.setText(ques4choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    
    public void question5() {
        counter++;
        String ques5 = "Enter the paramter name?";
        String ques5choices = "Any name you want but does not start with a number or a symbol and you declared it before in the class!";
        q.jTextArea1.setText(ques5);
        q.jTextArea2.setText(ques5choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question6() {
        counter++;
        String ques6 = "Enter how the function should be accessed?";
        String ques6choices = "1.Public\n2.Private\n3.Protected\nEnter the number of your choice:";
        q.jTextArea1.setText(ques6);
        q.jTextArea2.setText(ques6choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String message="";
        if(access.equals("1"))
        {
            message+="public";
        }
        else if(access.equals("2"))
        {
            message+="private";
        }
        else if(access.equals("3"))
        {
            message+="protected";
        }
        
        message+=" "+returnType+" "+functionName+" ( ";
        for(int count=0; count<paramatersCount;count++)
        {
            if(count!=0)
            {
                message+=" , ";
            }
            message+=paramatersType[count]+" "+paramatersName[count];
        }
        message+=" ) {\n\n\n";
        if(!returnName.equals(""))
        {
            message+="return "+returnName+" ;\n";
        }
        message+=" }\n";
        Display d= new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
}
