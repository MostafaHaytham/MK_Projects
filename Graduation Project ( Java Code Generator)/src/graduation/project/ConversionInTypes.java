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
public class ConversionInTypes {

    QuestionAnswer q = new QuestionAnswer();
    int counter = 0;
    String variableName = "";
    String dataType1 = "";
    String dataType2 = "";

    public void handler() {
        if (counter == 0) {
            mainQuestion();
        } else if (counter == 1) {
            question1();
        } else if (counter == 2) {
            question2();
        } else if (counter == 4) {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (counter == 1) {
                    dataType1 = q.jTextField1.getText();
                    if (!dataType1.equals("")) {
                        handler();
                    }
                } else if (counter == 2) {
                    dataType2 = q.jTextField1.getText();
                    if (!dataType2.equals("") && !dataType2.equals(dataType1)) {
                        handler();
                    }
                } else if (counter == 3) {
                    variableName = q.jTextField1.getText();
                    if (!variableName.equals("")) {
                        counter = 4;
                        handler();
                    }
                }

            }
        });

    }

    public void mainQuestion() {
        counter++;
        String mainQuestion = "Choose your basic variable type?\n can happen between all datatypes except boolean\n"
                + "Enter the number of your choice not the datatype name:\n";
        String mainQuestionChoices = "1.int\n2.short\n3.long\n4.byte\n5.float\n6.char\n7.double\n8.String\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }

    public void question1() {
        counter++;
        String ques1 = "Choose the type you want to convert your variable to:\n"
                + "Enter the number of your choice not the datatype name:\n";
        String ques1choices = "1.int\n2.short\n3.long\n4.byte\n5.float\n6.char\n7.double\n8.String\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void question2() {
        counter++;
        String question2 = "Variable name ?";
        String question2choices = "Any name you want but does not start with a number or a symbol!";
        q.jTextArea1.setText(question2);
        q.jTextArea2.setText(question2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    
    public void display() {
        String message = "";
        if(dataType2.equals("1"))
        {
            dataType2="int";
        }
        else if(dataType2.equals("2"))
        {
            dataType2="short";
        }
        else if(dataType2.equals("3"))
        {
            dataType2="long";
        }
        else if(dataType2.equals("4"))
        {
            dataType2="byte";
        }
        else if(dataType2.equals("5"))
        {
            dataType2="float";
        }
        else if(dataType2.equals("6"))
        {
            dataType2="char";
        }
        else if(dataType2.equals("7"))
        {
            dataType2="double";
        }
        else if(dataType2.equals("8"))
        {
            dataType2="String";
        }
        
        if (!dataType1.equals("8")) {
            if (!dataType2.equals("String")) {

                message += dataType2 + " newVariable = (" + dataType2 + ") " + variableName + ";\n";

            } else {

                message += dataType2 + " newVariable = String.valueOf(" + variableName + ");\n";
            }
        }
        else
        {
            if(dataType2.equals("int"))
            {
                message += dataType2 + " newVariable = Integer.parseInt(" + variableName + ");\n";
            }
            else if(dataType2.equals("short"))
            {
                message += dataType2 + " newVariable = Short.parseShort(" + variableName + ");\n";
            }
            else if(dataType2.equals("long"))
            {
                message += dataType2 + " newVariable = Long.parseLong(" + variableName + ");\n";
            }
            else if(dataType2.equals("byte"))
            {
                message += dataType2 + " newVariable = Byte.parseByte(" + variableName + ");\n";
            }
            else if(dataType2.equals("float"))
            {
                message += dataType2 + " newVariable = Float.parseFloat(" + variableName + ");\n";
            }
            else if(dataType2.equals("char"))
            {
                message += dataType2 + " newVariable = "+variableName+".charAt(0);\n";
            }
            else if(dataType2.equals("double"))
            {
                message += dataType2 + " newVariable = Double.parseDouble(" + variableName + ");\n";
            }
            
        }
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);

    }

}
