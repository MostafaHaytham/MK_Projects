/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Haytham
 */
public class Calculator {

    Steps s = new Steps();
    int counter = 0;
    boolean stop=false;

    public void handler() {
        if(counter==0)
        {
            mainStep();
            counter++;
        }
        s.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(s.jComboBox1.getSelectedItem().toString().equals("Step 0"))
                {
                    mainStep();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Step 1"))
                {
                    Step1();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Step 2"))
                {
                    Step2();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Step 3"))
                {
                    Step3();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Step 4"))
                {
                    Step4();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Step 5"))
                {
                    Step5();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Display All")&& !stop)
                {
                    display();
                }
                
            }
        });

    }

    public Calculator() {
        s.jLabel1.setText("\tCalculator");
        s.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Step 0","Step 1", "Step 2", "Step 3", "Step 4","Step 5","Display All" }));
    }

    public void mainStep() {
        String step0 = "Step 0\n"
                + "Launch the NetBeans IDE.\n"
                + "In the NetBeans IDE, choose File then New Project.\n"
                + "In the New Project wizard, expand the Java category and select Java Application.\n"
                + "Write in Project name\"Calculator\".\n"
                + "Click finish.\n";
        s.jTextArea1.setText(step0);
        s.setVisible(true);
    }

    public void Step1() {
        String step1 = "Step 1\n"
                + "//Add this code in the main\n"
                + "//Start declaring the variables we will use the double datatype\n"
                + "double var1=0.0;\n"
                + "double var2=0.0;\n"
                + "double result=0.0;\n"
                + "String choice=\"\";";
        s.jTextArea1.setText(step1);
        s.revalidate();
    }

    public void Step2() {
        String step2 = "Step 2\n"
                + "//Add the scanner library before the class\n"
                + "import java.util.Scanner;\n";
        s.jTextArea1.setText(step2);
        s.revalidate();
    }

    public void Step3() {
        String step3 = "Step 3\n"
                + "//Add this code in the main\n"
                + "// intialize the scanner variable"
                + " Scanner scan= new Scanner(System.in);"
                + "//asks user to enter the two variables and choose which operation to use\n"
                + "System.out.println(\"Enter the number of the operation you want to use:\");\n"
                + "System.out.println(\"1.Add,2.Substraction,3.Multiply,4.Divided\");"
                + "choice=scan.next();\n"
                + "System.out.println(\"Enter variable1:\");\n"
                + "var1=scan.nextDouble();\n"
                + "System.out.println(\"Enter variable2:\");\n"
                + "var2=scan.nextDouble();\n";
        s.jTextArea1.setText(step3);
        s.revalidate();
    }

    public void Step4() {
        String step4 = "Step 4\n"
                + "//Add this code in the main\n"
                + "// the conditions for each operation\n"
                + "if(choice.equals(\"1\") { //add\n"
                + "result=var1+var2;\n}\n"
                + "else if(choice.equals(\"2\") { //sub\n"
                + "result=var1-var2;\n}\n"
                + "else if(choice.equals(\"3\") { //mul\n"
                + "result=var1*var2;\n}\n"
                + "else if(choice.equals(\"4\") { //div\n"
                + "if(var2!=0) { //because you can divide number by 0 \n"
                + "result=var1+var2;\n}\n}\n";
        s.jTextArea1.setText(step4);
        s.revalidate();
    }

    public void Step5() {
        String step5 = "Step 5\n"
                + "//Add this code in the main\n"
                + "//Display the result\n"
                + "System.out.println(result);\n";
        s.jTextArea1.setText(step5);
    }

    public void display() {
        stop=true;
        String message = "//Code Should be like this\n"
                + "package calculator;\n"
                + "import java.util.Scanner;\n"
                + "public class Calculator {\n"
                + "public static void main(String[] args) {\n"
                + "//Start declaring the variables we will use the double datatype\n"
                + "double var1=0.0;\n"
                + "double var2=0.0;\n"
                + "double result=0.0;\n"
                + "String choice=\"\";"
                + "// intialize the scanner variable"
                + " Scanner scan= new Scanner(System.in);"
                + "//asks user to enter the two variables and choose which operation to use\n"
                + "System.out.println(\"Enter the number of the operation you want to use:\");\n"
                + "System.out.println(\"1.Add,2.Substraction,3.Multiply,4.Divided\");"
                + "choice=scan.next();\n"
                + "System.out.println(\"Enter variable1:\");\n"
                + "var1=scan.nextDouble();"
                + "System.out.println(\"Enter variable2:\");\n"
                + "var2=scan.nextDouble();"
                + "// the conditions for each operation\n"
                + "if(choice.equals(\"1\") { //add\n"
                + "result=var1+var2;\n}\n"
                + "if(choice.equals(\"2\") { //sub\n"
                + "result=var1-var2;\n}\n"
                + "if(choice.equals(\"3\") { //mul\n"
                + "result=var1*var2;\n}\n"
                + "if(choice.equals(\"4\") { //div\n"
                + "if(var2!=0) { //because you can divide number by 0 \n"
                + "result=var1+var2;\n}\n}\n"
                + "//Display the result\n"
                + "System.out.println(result);\n"
                + "}\n}\n";
        Display d = new Display();
        d.jTextArea1.setText(message);     
        s.setVisible(false);
        d.setVisible(true);
    }

}
