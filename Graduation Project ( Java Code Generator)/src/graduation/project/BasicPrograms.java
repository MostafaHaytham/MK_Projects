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
public class BasicPrograms {

    QuestionAnswer q = new QuestionAnswer();
    int counter = 0;
    String choice = "";

    public void mainQuestion() {
        counter++;
        String mainQuestion = "Choose the program you need to display how it's done:\n";
        String mainQuestionChoices = "1.Calculator\n2.Simple write in file and read from file program\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                choice = q.jTextField1.getText();
                if (choice.equals("1")) {
                    Calculator c = new Calculator();
                    q.setVisible(false);
                    c.handler();
                }
                else if (choice.equals("2")) {
                    SimpleIOProgram s = new SimpleIOProgram();
                    q.setVisible(false);
                    s.handler();
                }

            }
        });
    }

}
