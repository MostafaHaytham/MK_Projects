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
public class MathLibrary {

    QuestionAnswer q = new QuestionAnswer();
    int counter = 0;
    String choice = "";
    String value = "";
    String firstValue = "";
    String secondValue = "";
    String dataType="";

    public void handler() {
        if (counter == 0) {
            mainQuestion();
        } else if (counter == 1) {
            question1();
        } else if (counter == 2) {
            question2();
        } else if (counter == 3) {
            question3();
        }
         else if (counter == 4) {
            question4();
        }else if (counter == 6) {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (counter == 1) {
                    choice = q.jTextField1.getText();
                    if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("17") || choice.equals("18") || choice.equals("19")) {
                        counter = 2;
                        handler();
                    } else if (choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8") || choice.equals("9") || choice.equals("10") || choice.equals("11")) {
                        handler();
                    } else if (choice.equals("12") || choice.equals("13") || choice.equals("14") || choice.equals("15") || choice.equals("16") || choice.equals("21")) {
                        handler();
                    } else if (choice.equals("20")) {
                        counter = 6;
                        handler();
                    }
                } else if (counter == 2) {
                    value = q.jTextField1.getText();
                    if (!value.equals("") && choice.equals("5") || choice.equals("13") || choice.equals("14") ) {
                        counter=4;
                        handler();
                    }
                    else if (!value.equals("") && !choice.equals("5") || !choice.equals("13") || !choice.equals("14"))
                    {
                        counter=6;
                        handler();
                    }
                } else if (counter == 3) {
                    firstValue = q.jTextField1.getText();
                    if (!firstValue.equals("")) {
                        handler();
                    }
                } else if (counter == 4) {
                    secondValue = q.jTextField1.getText();                   
                    if (!secondValue.equals("") && !choice.equals("19")) {
                        handler();
                    }
                    else if (!secondValue.equals("") && choice.equals("19")) {
                        counter = 6;
                        handler();
                    }
                } else if (counter == 5) {
                    dataType = q.jTextField1.getText();
                    if (!dataType.equals("")) {
                        counter = 6;
                        handler();
                    }
                }

            }
        });

    }

    public void mainQuestion() {
        counter++;
        String mainQuestion = "Choose one of the following operations?\n Enter the number of your choice:\n";
        mainQuestion += "DataTypes used are int, float, double, long but not all these datatypes works with all the following operations!\n";
        String mainQuestionChoices = "1.Add\n2.Multiply\n3.Divided\n4.Substraction\n"
                + "5.Absolute(Returns the absolute value) (All datatypes can be used).\n"
                + "6.Sin(Returns the trigonometric sine of an angle)(double only)!\n"
                + "7.Cos(Returns the trigonometric cosine of an angle.)(double only)!\n"
                + "8.Tan(Returns the trigonometric tangent of an angle.)(double only)!\n"
                + "9.Exponential(Returns Euler's number e raised to the power of a double value.)(double only)!\n"
                + "10.SinH(Returns the hyperbolic sine of a double value.)(double only)!\n"
                + "11.CosH(Returns the hyperbolic cosine of a double value.)(double only)!\n"
                + "12.TanH(Returns the hyperbolic tangent of a double value.)(double only)!\n"
                + "13.Increment(Increase number by 1)(All datatypes)\n"
                + "14.Decrement(Decrease number by 1)(All datatypes)\n"
                + "15.Log(Returns the natural logarithm (base e) of a double value.)(double only)!\n"
                + "16.Log10(Returns the base 10 logarithm of a double value.)(double only)!\n"
                + "17.Max(Returns the greater of two value)(All datatypes can be used but the two values must bs the same datatype)\n"
                + "18.Min(Returns the smaller of two value)(All datatypes can be used but the two values must bs the same datatype)\n"
                + "19.Pow(Returns the value of the first argument raised to the power of the second argument.)(double only)!\n"
                + "20.Random(Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.)(double only)!\n"
                + "21.Sqrt(Returns the correctly rounded positive square root of a double value.)(double only)!\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }

    public void question1() {
        counter++;
        String ques1 = "Enter the value/variable you need to use in the operation you chose:";
        String ques1choices = "The value or variable must be acceptable by the operation\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void question2() {
        counter++;
        String ques2 = "Enter the first value/variable you will use in the operation:";
        String ques2choices = "The value or variable must be acceptable by the operation\nThe order is important in some operations\n";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void question3() {
        counter++;
        String ques3 = "Enter the second value/variable you will use in the operation:";
        String ques3choices = "The value or variable must be acceptable by the operation\nThe order is important in some operations\n";
        q.jTextArea1.setText(ques3);
        q.jTextArea2.setText(ques3choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question4() {
        counter++;
        String ques4 = "Enter the type of the values you entered:\n Enter the number of your choice:";
        String ques4choices = "Accepted Datatypes are:\n1.int\n2.float\n3.double\n4.long\n";
        q.jTextArea1.setText(ques4);
        q.jTextArea2.setText(ques4choices);
        q.jTextField1.setText("");
        q.revalidate();
    }

    public void display() {
        String message = "//you should import this library before the class name ==> import static java.lang.Math.*;\n";
        if(!dataType.equals(""))
        {
            if(dataType.equals("1"))
            {
                dataType="int";
            }
            else if(dataType.equals("2"))
            {
                dataType="float";
            }
            else if(dataType.equals("3"))
            {
                dataType="double";
            }
            else if(dataType.equals("4"))
            {
                dataType="long";
            }
        }
        if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("17") || choice.equals("18") || choice.equals("19")) {
            if(choice.equals("1"))
            {
                message+=dataType+" result = "+firstValue+" + "+secondValue+" ;\n";               
            }
            else if(choice.equals("2"))
            {
                message+=dataType+" result = "+firstValue+" * "+secondValue+" ;\n";               
            }
            else if(choice.equals("3"))
            {
                message+="if(secondValue!=0) {\n";
                message+=dataType+" result = "+firstValue+" / "+secondValue+" ;\n}\n";               
            }
            else if(choice.equals("4"))
            {
                message+=dataType+" result = "+firstValue+" - "+secondValue+" ;\n";               
            }
            else if(choice.equals("17"))
            {
                message+=dataType+" maximum = max("+firstValue+","+secondValue+");\n";               
            }
            else if(choice.equals("18"))
            {
                message+=dataType+" minimum = min("+firstValue+","+secondValue+");\n";               
            }
            else if(choice.equals("19"))
            {
                message+="double result = pow("+firstValue+","+secondValue+");\n";               
            }
            
        } else if (choice.equals("20")) {
            
            message+="double randomNumber = random();\n"; 
        }
        else
        {
            if(choice.equals("5"))
            {
                message+=dataType+" result = abs("+value+") ;\n";               
            }
            else if(choice.equals("6"))
            {
                message+="double result = sin("+value+") ;\n";               
            }
            else if(choice.equals("7"))
            {
                message+="double result = cos("+value+") ;\n";               
            }
            else if(choice.equals("8"))
            {
                message+="double result = tan("+value+") ;\n";               
            }
            else if(choice.equals("9"))
            {
                message+="double result = exp("+value+") ;\n";               
            }
            else if(choice.equals("10"))
            {
                message+="double result = sinh("+value+") ;\n";               
            }
            else if(choice.equals("11"))
            {
                message+="double result = cosh("+value+") ;\n";               
            }
            else if(choice.equals("12"))
            {
                message+="double result = tanh("+value+") ;\n";               
            }
            else if(choice.equals("13"))
            {
                message+="double result = "+value+"++;\n";               
            }
            else if(choice.equals("14"))
            {
                message+="double result = "+value+"--;\n";               
            }
            else if(choice.equals("15"))
            {
                message+="double result = log("+value+") ;\n";               
            }
            else if(choice.equals("16"))
            {
                message+="double result = log10("+value+") ;\n";               
            }
            else if(choice.equals("21"))
            {
                message+="double result = sqrt("+value+") ;\n";               
            }
            
        }
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);

    }

}
