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
public class IfCondition {   
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String conditions[]= new String[1000];
    String choice="";
    boolean elseCondition=false;
    int conditionsCounter=0;
    
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
        else if(counter==3)
        {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(counter==1)
                {
                    conditions[conditionsCounter] = q.jTextField1.getText();
                    if (!conditions[conditionsCounter].equals("")) {
                        conditionsCounter++;
                        handler();
                    }
                }
                else if(counter==2)
                {
                    choice=q.jTextField1.getText();
                    if(!choice.equals("") && choice.equals("1"))
                    {
                        counter=0;
                        handler();
                    }
                    else if(!choice.equals("") && choice.equals("2"))
                    {
                        counter=3;
                        elseCondition=true;
                        handler();
                    }
                    else if(!choice.equals("") && choice.equals("3") )
                    {
                        counter=3;
                        handler();
                    }
                }
                
            }
        });
    }
    public void mainQuestion() {

        counter++;
        String mainQuestion = "Enter the condition?";
        String mainQuestionChoices = "Types of Conditions:\n";
        mainQuestionChoices += "The Relational Operators:\n";
        mainQuestionChoices += "Assume variable A holds 10 and variable B holds 20, then:\n";
        mainQuestionChoices += "== (equal to) --> Example: (A == B) is not true.\n";
        mainQuestionChoices += "!= (not equal to) --> Example: (A != B) is true.\n";
        mainQuestionChoices += "> (greater than) --> Example: (A > B) is not true.\n";
        mainQuestionChoices += "< (less than) --> Example: (A < B) is true.\n";
        mainQuestionChoices += ">= (greater than or equal to) --> Example (A >= B) is not true.\n";
        mainQuestionChoices += "<= (less than or equal to) --> Example(A <= B) is true.\n";
        mainQuestionChoices += "---------------------------------------------------------------\n";
        mainQuestionChoices += "The Logical Operators:\n";
        mainQuestionChoices += "Assume Boolean variables A holds true and variable B holds false, then:\n";
        mainQuestionChoices += "&& (boolean)--> Example (A) is true.\n";
        mainQuestionChoices += "&& (logical and)--> Example (A && B) is false.\n";
        mainQuestionChoices += "|| (logical or)--> Example (A || B) is true.\n";
        mainQuestionChoices += "! (logical not)--> Example !(A && B) is true.\n";
        mainQuestionChoices += "---------------------------------------------------------------\n";
        mainQuestionChoices += "The Bitwise Operators:\n";
        mainQuestionChoices += "Assume integer variable A holds 60 and variable B holds 13 then:\n";
        mainQuestionChoices += "a = 0011 1100\n";
        mainQuestionChoices += "b = 0000 1101\n";
        mainQuestionChoices += "& (bitwise and) Binary AND Operator copies a bit to the result if it exists in both operands. --> Example: (A & B) will give 12 which is 0000 1100\n";
        mainQuestionChoices += "| (bitwise or) Binary OR Operator copies a bit if it exists in either operand. --> Example: (A | B) will give 61 which is 0011 1101\n";
        mainQuestionChoices += "^ (bitwise XOR) Binary XOR Operator copies the bit if it is set in one operand but not both. --> Example: (A ^ B) will give 49 which is 0011 0001\n";
        mainQuestionChoices += "~ (bitwise compliment) Binary Ones Complement Operator is unary and has the effect of 'flipping' bits. --> Example: (~A ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.\n";
        mainQuestionChoices += "<< (left shift) Binary Left Shift Operator. The left operands value is moved left by the number of bits specified by the right operand --> Example: A << 2 will give 240 which is 1111 0000\n";
        mainQuestionChoices += ">> (right shift) Binary Right Shift Operator. The left operands value is moved right by the number of bits specified by the right operand. --> Example: A >> 2 will give 15 which is 1111\n";
        mainQuestionChoices += ">>> (zero fill right shift) Shift right zero fill operator. The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros. --> Example: A >>>2 will give 15 which is 0000 1111\n";
        
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "Do you want to add else or else if condition to the if condition?\n";
        String ques1choices = "1.ElseIf\n2.Else\n3.End \nEnter the number of the choice: \n ";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String message="if ( "+conditions[0]+" )"+" { \n \n } \n";
        for(int count=1; count<conditionsCounter; count++)
        {
            message+="else if ( "+conditions[count]+" )"+" { \n \n } \n";
        }
        if(elseCondition)
        {
            message+="else { \n \n } \n";
        }
        Display d=new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
    
}
