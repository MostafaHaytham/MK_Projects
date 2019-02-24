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
public class Arrays {

    QuestionAnswer q = new QuestionAnswer();
    String choice = "";
    String variableName = "";
    String dataType = "";
    String value = "";
    String size = "";
    String index = "";
    int counter = 0;
    boolean display = false;

    public void handler() {
        if (counter == 0) {
            mainQuestion();
        } else if (counter == 1) {
            if (choice.equals("1")) {
                declartionQues1();
            } else if (choice.equals("2")) {
                intializtionQues1();
            } else if (choice.equals("3")) {
                declIntiQues1();
            }

        } else if (counter == 2) {
            if (choice.equals("1")) {
                declartionQues2();
            } else if (choice.equals("2")) {
                intializtionQues2();
            } else if (choice.equals("3")) {
                declIntiQues2();
            }
        } else if (counter == 3) {
            if (choice.equals("1")) {
                declartionQues3();
            } else if (choice.equals("2")) {
                intializtionQues3();
            } else if (choice.equals("3")) {
                declIntiQues3();
            }
        } else if (counter == 4) {
            if (choice.equals("1") && !size.equals("")) {
                display = true;
            } else if (choice.equals("2") && !index.equals("")) {
                display = true;
            } else if (choice.equals("3") && !value.equals("")) {
                display = true;
            }
        }

        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (counter == 1) {
                    choice = q.jTextField1.getText();
                    if (!choice.equals("")) {
                        handler();
                    }
                } else if (counter == 2) {
                    if (choice.equals("1")) {
                        variableName = q.jTextField1.getText();
                    } else if (choice.equals("2")) {
                        variableName = q.jTextField1.getText();
                    } else if (choice.equals("3")) {
                        variableName = q.jTextField1.getText();
                    }
                    if (!variableName.equals("")) {
                        handler();
                    }
                } else if (counter == 3) {
                    if (choice.equals("1")) {
                        dataType = q.jTextField1.getText();
                    } else if (choice.equals("2")) {
                        value = q.jTextField1.getText();
                    } else if (choice.equals("3")) {
                        dataType = q.jTextField1.getText();
                    }
                    if (!dataType.equals("") || !value.equals("")) {
                        handler();
                    }
                } else if (counter == 4 && !display) {
                    if (choice.equals("1")) {
                        size = q.jTextField1.getText();
                    } else if (choice.equals("2")) {
                        index = q.jTextField1.getText();
                    } else if (choice.equals("3")) {
                        value = q.jTextField1.getText();
                    }
                    if (!size.equals("") || !index.equals("") || !value.equals("")) {
                        handler();
                    }
                }
            }
        });
        if (display) {
            if (choice.equals("1")) {
                declartionDisplay();
            } else if (choice.equals("2")) {
                intializtionDisplay();
            } else if (choice.equals("3")) {
                declIntiDisplay();
            }
        }

    }

    public void mainQuestion() {

        counter++;
        String mainQuestion = "Do you want to declare an array or intialize it or Declare and intialize it in one line of code?";
        String mainQuestionChoices = "1. Declare. \n2. Intialize.\n3.Declare&intialize";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }

    public void declartionQues1() {
        counter++;
        String question1 = "Array name ?";
        String question1choices = "Any name you want but does not start with a number or a symbol!";
        q.jTextArea1.setText(question1);
        q.jTextArea2.setText(question1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void declartionQues2() {
        counter++;
        String question2 = "Array data type?";
        String question2choices = "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void declartionQues3() {
        counter++;
        String question2 = "Array size?";
        String question2choices = " any size you need but smaller than 2,147,483,647 and bigger than -1 ";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void declartionDisplay() {
        String displayMessage = "" + dataType + "[] " + variableName + " = new " + dataType + " [" + size + "] ;";
        Display d = new Display();
        d.jTextArea1.setText(displayMessage);
        d.setVisible(true);
    }

    public void intializtionQues1() {
        counter++;
        String question1 = "Array name ?";
        String question1choices = "Enter the name of the variable you want to intialize";
        q.jTextArea1.setText(question1);
        q.jTextArea2.setText(question1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void intializtionQues2() {
        counter++;
        String question2 = "Value to intialize with ?";
        String question2choices = "if the type of the variable: \nString put your value between \" \"\nchar put your value between \' \' \n";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void intializtionQues3() {
        counter++;
        String question2 = "index of array to intialize with ?";
        String question2choices = "must be smaller than size and bigger than -1";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void intializtionDisplay() {
        String displayMessage = " " + variableName + "[" + index + "] " + "= " + value + " ;";
        Display d = new Display();
        d.jTextArea1.setText(displayMessage);
        q.setVisible(false);
        d.setVisible(true);
    }

    public void declIntiQues1() {
        counter++;
        String question1 = "Array name ?";
        String question1choices = "Any name you want but does not start with a number or a symbol!";
        q.jTextArea1.setText(question1);
        q.jTextArea2.setText(question1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void declIntiQues2() {
        counter++;
        String question2 = "Array data type?";
        String question2choices = "int \t \t short \nlong \t \t byte \nfloat \t \t double \nchar \t \t boolean \nEnter the name of the data type not the number of the choice \n ";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void declIntiQues3() {
        counter++;
        String question2 = "Enter all the values respectivally ";
        String question2choices = " Separate the values by \' , \'  ";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void declIntiDisplay() {
        String displayMessage = "" + dataType + "[] " + variableName + " = { " + value + " };";
        Display d = new Display();
        d.jTextArea1.setText(displayMessage);
        q.setVisible(false);
        d.setVisible(true);
    }
}
