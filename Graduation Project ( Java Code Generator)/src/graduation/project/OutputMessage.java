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
public class OutputMessage {

    QuestionAnswer q = new QuestionAnswer();
    String message = "";

    public void mainQuestion() {

        String mainQuestion = "Enter your Message";
        String mainQuestionChoices = "Example of messages:\n";
        mainQuestionChoices += "String ex=\"string\" \n int x=1;\n";
        mainQuestionChoices += "message could be ==> \"anything you need to display \"+ex+x+\" \"+(1+2)\n";
        mainQuestionChoices += "output will be ==> anything you need to display string 1 3";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.setVisible(true);
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                message = q.jTextField1.getText();
                if (!message.equals("")) {

                    message = "System.out.println(" + q.jTextField1.getText() + " );";
                    Display d = new Display();
                    d.jTextArea1.setText(message);
                    q.setVisible(false);
                    d.setVisible(true);
                }
            }
        });
    }
}
