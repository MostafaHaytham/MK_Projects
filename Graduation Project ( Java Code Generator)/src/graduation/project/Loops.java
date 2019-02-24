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
public class Loops {

    QuestionAnswer q = new QuestionAnswer();
    int counter = 0;
    String choice = "";
    String startingValue = "";
    String finishingValue = "";
    String condition = "";

    public void handler() {
        if (counter == 0) {
            mainQuestion();
        } else if (counter == 1) {
            question1();
        } else if (counter == 2) {
            question2();
        } else if (counter == 3) {
            question3();
        } else if (counter == 5) {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (counter == 1) {
                    choice = q.jTextField1.getText();
                    if (choice.equals("1")) {
                        handler();
                    } else if (choice.equals("2") || choice.equals("3")) {
                        counter = 3;
                        handler();
                    }
                } else if (counter == 2) {
                    startingValue = q.jTextField1.getText();
                    if (!startingValue.equals("")) {
                        handler();
                    }
                } else if (counter == 3) {
                    finishingValue = q.jTextField1.getText();
                    if (!finishingValue.equals("")) {
                        counter = 5;
                        handler();
                    }
                } else if (counter == 4) {
                    condition = q.jTextField1.getText();
                    if (!condition.equals("")) {
                        counter = 5;
                        handler();
                    }
                }

            }
        });

    }

    public void mainQuestion() {
        counter++;
        String mainQuestion = "Enter the type of the loop ?\n Enter the number of the choice";
        String mainQuestionChoices = "1.For loop\n2.While loop\n3.Do-While loop\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }

    public void question1() {
        counter++;
        String ques1 = "Enter the starting value of the loop: \n";
        String ques1choices = "The counter of this loop will be intialized by this value\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void question2() {
        counter++;
        String ques2 = "Enter the finishing value of the loop:";
        String ques2choices = "This value will be added to condition to stop the loop when it reach this value\n";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void question3() {

        counter++;
        String ques3 = "Enter the condition?";
        String ques3choices = "Types of Conditions:\n";
        ques3choices += "The Relational Operators:\n";
        ques3choices += "Assume variable A holds 10 and variable B holds 20, then:\n";
        ques3choices += "== (equal to) --> Example: (A == B) is not true.\n";
        ques3choices += "!= (not equal to) --> Example: (A != B) is true.\n";
        ques3choices += "> (greater than) --> Example: (A > B) is not true.\n";
        ques3choices += "< (less than) --> Example: (A < B) is true.\n";
        ques3choices += ">= (greater than or equal to) --> Example (A >= B) is not true.\n";
        ques3choices += "<= (less than or equal to) --> Example(A <= B) is true.\n";
        ques3choices += "---------------------------------------------------------------\n";
        ques3choices += "The Logical Operators:\n";
        ques3choices += "Assume Boolean variables A holds true and variable B holds false, then:\n";
        ques3choices += "&& (boolean)--> Example (A) is true.\n";
        ques3choices += "&& (logical and)--> Example (A && B) is false.\n";
        ques3choices += "|| (logical or)--> Example (A || B) is true.\n";
        ques3choices += "! (logical not)--> Example !(A && B) is true.\n";
        ques3choices += "---------------------------------------------------------------\n";
        ques3choices += "The Bitwise Operators:\n";
        ques3choices += "Assume integer variable A holds 60 and variable B holds 13 then:\n";
        ques3choices += "a = 0011 1100\n";
        ques3choices += "b = 0000 1101\n";
        ques3choices += "& (bitwise and) Binary AND Operator copies a bit to the result if it exists in both operands. --> Example: (A & B) will give 12 which is 0000 1100\n";
        ques3choices += "| (bitwise or) Binary OR Operator copies a bit if it exists in either operand. --> Example: (A | B) will give 61 which is 0011 1101\n";
        ques3choices += "^ (bitwise XOR) Binary XOR Operator copies the bit if it is set in one operand but not both. --> Example: (A ^ B) will give 49 which is 0011 0001\n";
        ques3choices += "~ (bitwise compliment) Binary Ones Complement Operator is unary and has the effect of 'flipping' bits. --> Example: (~A ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.\n";
        ques3choices += "<< (left shift) Binary Left Shift Operator. The left operands value is moved left by the number of bits specified by the right operand --> Example: A << 2 will give 240 which is 1111 0000\n";
        ques3choices += ">> (right shift) Binary Right Shift Operator. The left operands value is moved right by the number of bits specified by the right operand. --> Example: A >> 2 will give 15 which is 1111\n";
        ques3choices += ">>> (zero fill right shift) Shift right zero fill operator. The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros. --> Example: A >>>2 will give 15 which is 0000 1111\n";

        q.jTextArea1.setText(ques3);
        q.jTextArea2.setText(ques3choices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }

    public void display() {
        String message = "";
        if (choice.equals("1")) {
            int sv = Integer.parseInt(startingValue);
            int fv = Integer.parseInt(finishingValue);
            String operator = "";
            String incrDecr = "";
            if (sv <= fv) {
                operator = "<";
                incrDecr = "++";

            } else {
                operator = ">";
                incrDecr = "--";
            }
            message += "for (int count=" + startingValue + " ; count" + operator + finishingValue + " ; count" + incrDecr + " ) {\n\n }";
        }
        else if(choice.equals("2"))
        {
            message+="while ("+condition+") {\n \n }";
        }
        else if(choice.equals("3"))
        {
            message+="do {\n \n }while ("+condition+") ;";
        }
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
    }
}
