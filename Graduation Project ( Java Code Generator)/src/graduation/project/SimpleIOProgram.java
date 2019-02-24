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
public class SimpleIOProgram {

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
                else if(s.jComboBox1.getSelectedItem().toString().equals("Step 6"))
                {
                    Step6();
                    handler();
                }
                else if(s.jComboBox1.getSelectedItem().toString().equals("Display All") && !stop)
                {
                    display();
                }
                
            }
        });

    }
    public SimpleIOProgram() {
        s.jLabel1.setText("Simple Input & Ouput using file program");
        s.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Step 0","Step 1", "Step 2", "Step 3", "Step 4","Step 5","Step 6","Display All" }));
    }
    public void mainStep() {
        String step0 = "Step 0\n"
                + "Launch the NetBeans IDE.\n"
                + "In the NetBeans IDE, choose File then New Project.\n"
                + "In the New Project wizard, expand the Java category and select Java Application.\n"
                + "Write in Project name\"Input Output File\".\n"
                + "Click finish.\n";
        s.jTextArea1.setText(step0);
        s.setVisible(true);
    }
    public void Step1() {
        String step1 = "Step 1\n"
                + "//Add this code in the main\n"
                + "//Start declaring the variables you will use\n"
                + "String fileName=\"\";\n"
                + "String choice=\"\";\n";
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
                + "//Add this function under the main function\n"
                + "// this is the write in file function\n"
                + " public static void write(String fileName){\n"
                + "// intialize the scanner variable"
                + " Scanner scan= new Scanner(System.in);"
                + "//asks user to enter the line he/she wants to add to the file\n"
                + "System.out.println(\"Enter the line:\");\n"
                + "String line=scan.next();\n"
                + "//Intialize the file writer objects\n"
                + "//start with a try clause to catch exceptions\n"
                + "try {\n"
                + "FileWriter fileWriter = new FileWriter(fileName);\n"
                + "BufferedWriter bw = new BufferedWriter(fileWriter);\n"
                + "bw.write(line);\n"
                + "bw.newLine();\n"
                + "bw.close();\n"
                + "fileWriter.close();\n"
                + "}\n"
                + "catch (FileNotFoundException ex) {\n"
                + "System.out.println(\"Unable to open file '\" + fileName+\"'\" );\n }\n"
                + "catch (IOException ex) {\n"
                + "System.out.println(\"Error reading file ' \" + fileName+\" '\" );\n }\n"
                + "}\n\n";
        s.jTextArea1.setText(step3);
        s.revalidate();
    }
    public void Step4() {
        String step4 = "Step 4\n"
                + "//Add this function under the main function\n"
                + "// this is the read from file function\n"
                + " public static void read(String fileName){\n"
                + "//Intialize the file reader objects\n"
                + "//start with a try clause to catch exceptions\n"
                + "try {\n"
                + "FileReader fileReader = new FileReader(fileName);\n"
                + "BufferedReader br = new BufferedReader(fileReader);\n"
                + "String newLine=br.readLine();\n"
                + "while(newLine!=null) {\n"
                + "System.out.println(newLine);\n"
                + "newLine=br.readLine();\n}\n"
                + "br.close();\n"
                + "fileReader.close();\n"
                + "}\n"
                + "catch (FileNotFoundException ex) {\n"
                + "System.out.println(\"Unable to open file '\" + fileName+\"'\" );\n }\n"
                + "catch (IOException ex) {\n"
                + "System.out.println(\"Error reading file ' \" + fileName+\" '\" );\n }\n"
                + "}\n\n";
        s.jTextArea1.setText(step4);
        s.revalidate();
    }
    public void Step5() {
        String step5 = "Step 5\n"
                + "//Add this code in the main\n"
                + "// intialize the scanner variable\n"
                + " Scanner scan= new Scanner(System.in);\n"
                + "//asks user to enter the file name\n"
                + "System.out.println(\"Enter the file name:\");\n"
                + "fileName=scan.next();\n"
                + "System.out.println(\"1.Write,2.Read\");\n"
                + "choice=scan.next();\n";
        s.jTextArea1.setText(step5);
        s.revalidate();
    }
    public void Step6() {
        String step6 = "Step 6\n"
                + "//Add this code in the main\n"
                + "// the conditions for each operation\n"
                + "if(choice.equals(\"1\") { //write\n"
                + "write(fileName);\n}\n"
                + "else if(choice.equals(\"2\") { //read\n"
                + "read(fileName);\n}\n";
        s.jTextArea1.setText(step6);
        s.revalidate();
    }
    public void display() {
        stop=true;
        String message = "//Code Should be like this\n"
                + "package input.output.file;\n"
                + "import java.util.Scanner;\n"
                + "public class InputOutputFile {\n"
                + "public static void main(String[] args) {\n"
                + "//Start declaring the variables you will use\n"
                + "String fileName=\"\";\n"
                + "String choice=\"\";\n"
                + "// intialize the scanner variable\n"
                + " Scanner scan= new Scanner(System.in);\n"
                + "//asks user to enter the file name\n"
                + "System.out.println(\"Enter the file name:\");\n"
                + "fileName=scan.next();\n"
                + "System.out.println(\"1.Write,2.Read\");\n"
                + "choice=scan.next();\n"               
                + "// the conditions for each operation\n"
                + "if(choice.equals(\"1\") { //write\n"
                + "write(fileName);\n}\n"
                + "else if(choice.equals(\"2\") { //read\n"
                + "read(fileName);\n}\n"
                + "}\n"
                + "// this is the write in file function\n"
                + " public static void write(String fileName){\n"
                + "// intialize the scanner variable\n"
                + " Scanner scan= new Scanner(System.in);\n"
                + "//asks user to enter the line he/she wants to add to the file\n"
                + "System.out.println(\"Enter the line:\");\n"
                + "String line=scan.next();\n"
                + "//Intialize the file writer objects\n"
                + "//start with a try clause to catch exceptions\n"
                + "try {\n"
                + "FileWriter fileWriter = new FileWriter(fileName);\n"
                + "BufferedWriter bw = new BufferedWriter(fileWriter);\n"
                + "bw.write(line);\n"
                + "bw.newLine();\n"
                + "bw.close();\n"
                + "fileWriter.close();\n"
                + "}\n"
                + "catch (FileNotFoundException ex) {\n"
                + "System.out.println(\"Unable to open file '\" + fileName+\"'\" );\n }\n"
                + "catch (IOException ex) {\n"
                + "System.out.println(\"Error reading file ' \" + fileName+\" '\" );\n }\n"
                + "}\n\n"
                + "// this is the read from file function\n"
                + " public static void read(String fileName){\n"
                + "//Intialize the file reader objects\n"
                + "//start with a try clause to catch exceptions\n"
                + "try {\n"
                + "FileReader fileReader = new FileReader(fileName);\n"
                + "BufferedReader br = new BufferedReader(fileReader);\n"
                + "String newLine=br.readLine();\n"
                + "while(newLine!=null) {\n"
                + "System.out.println(newLine);\n"
                + "newLine=br.readLine();\n}\n"
                + "br.close();\n"
                + "fileReader.close();\n"
                + "}\n"
                + "catch (FileNotFoundException ex) {\n"
                + "System.out.println(\"Unable to open file '\" + fileName+\"'\" );\n }\n"
                + "catch (IOException ex) {\n"
                + "System.out.println(\"Error reading file ' \" + fileName+\" '\" );\n }\n"
                + "}\n\n"
                + "}\n";
        Display d = new Display();
        d.jTextArea1.setText(message);
        s.setVisible(false);
        d.setVisible(true);
    }
    
}
