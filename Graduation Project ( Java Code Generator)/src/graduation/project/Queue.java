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
public class Queue {
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String queueName="";
    String queueSize="";
    String queueType="";
    
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
                    queueName = q.jTextField1.getText();
                    if (!queueName.equals("")) {
                        handler();
                    }
                }
                else if(counter==2)
                {
                    queueSize = q.jTextField1.getText();
                    if (!queueSize.equals("")) {
                        handler();
                    }
                }
                else if(counter==3)
                {
                    queueType = q.jTextField1.getText();
                    if (!queueType.equals("")) {
                        counter=4;
                        handler();
                    }
                }
                
            }
        });
        
    }
    public void mainQuestion() {
        counter++;
        String mainQuestion = "Enter the name of the queue?";
        String mainQuestionChoices = "The queue class represents a first-in-first-out (FIFO) queue of elements.\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "Enter the size of the queue? \n";
        String ques1choices="The size is the maximum elements the queue can hold\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question2() {
        counter++;
        String ques2 = "Enter the type of the elements that the queue will hold:";
        String ques2choices = "Queue can only hold one type of elements\n";
        ques2choices+= "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String message="1.Select File > New File from the menu at the top.\n";
        message+="2.At the New File screen, select \"Java\" for Category, \"Java Class\" for the File Type and click the \"Next\" button.\n";
        message+="3.Then enter in the class name \"Queue\" and then click \"Finsh\"\n";
        message+="-------------------------------------------------------\n";
        message+="// Code inside the class\n";
        message+="int const size="+queueSize+";\n";
        message+=queueType+"[] "+queueName+" = "+" new "+queueType+" [size] ;\n";
        message+="int front=-1;\n";
        message+="int rear=0'\n";
        message+="// this enqueue function is to add element to the queue"+"\n";
        message+="public void enqueue("+queueType+" var1 ) {\n if(!isFull()) {\n front++;\n" +queueName+"[front]=var1 ;\n }\n }";
        message+="// this dequeue function is to remove element from the queue and return it \n";
        message+="public "+queueType+" dequeue( ) {\n if(!isEmpty()) {\n return "+queueName+"[rear] ;\nrear++;\n }\n return -1;\n }\n";
        message+="// this isEmpty function is to check if the queue is empty or not"+"\n";
        message+="public boolean isEmpty( ) {\n if(front<rear || front==-1) {\n return true;\n }\n return false;\n }\n";
        message+="// this isFull function is to check if the queue is full or not"+"\n";
        message+="public boolean isFull( ) {\n if(front==size-1) {\n return true;\n }\n return false;\n }\n";
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
    
}
