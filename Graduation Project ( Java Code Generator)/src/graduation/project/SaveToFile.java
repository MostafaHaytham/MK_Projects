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
public class SaveToFile {   
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String fileName="";
    String choice="";
    String choice2="";
    String word="";
    String lines[]=new String [100];
    int linesCounter=0;
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
        else if(counter==3)
        {
            question3();
        }
        else if(counter==4)
        {
            question4();
        }
        else if(counter==6)
        {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(counter==1)
                {
                    fileName = q.jTextField1.getText();
                    if (!fileName.equals("")) {
                        handler();
                    }
                }
                else if(counter==2)
                {
                    choice = q.jTextField1.getText();
                    if (choice.equals("1")) {
                        handler();
                    }
                    else if (choice.equals("2")) {
                        counter=4;
                        handler();
                    }
                    else if (choice.equals("3")) {
                        choice2="1";
                        counter=4;
                        handler();
                    }
                }
                else if(counter==3)
                {
                    word = q.jTextField1.getText();
                    if (!word.equals("")) {
                        counter=6;
                        handler();
                    }
                }
                else if(counter==4)
                {
                    choice2= q.jTextField1.getText();
                    if (choice2.equals("1")) {
                        handler();
                    }
                    else if (choice2.equals("2")) {
                        counter=6;
                        handler();
                    }
                }
                else if(counter==5)
                {
                    lines[linesCounter] = q.jTextField1.getText();
                    if (!lines[linesCounter].equals("") && choice2.equals("1")) {
                        linesCounter++;
                        counter=3;
                        handler();
                    }
                    else if (!lines[linesCounter].equals("") && choice2.equals("")) {
                        counter=6;
                        handler();
                    }
                }
                
            }
        });
    }
    public void mainQuestion() {
        counter++;
        String mainQuestion = "Enter is the name of the file?";
        String mainQuestionChoices = "The file must be created in your project folder and contains some text.\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "What do you want to write in the file? \n Enter the number of your choice:";
        String ques1choices="1.Write a word\n2.Write a line\n3.Write more than one line\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question2() {
        counter++;
        String ques2 = "Enter the word:";
        String ques2choices = "This word will be in the file and if you added another word it will be next to it\n";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question3() {
        counter++;
        String ques3 = "Do you want to add more lines ?\n Enter the number of the choice:";
        String ques3choices = "1.Yes\n2.No\n";
        q.jTextArea1.setText(ques3);
        q.jTextArea2.setText(ques3choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    
    public void question4() {
        counter++;
        String ques4 = "Enter the line:";
        String ques4choices = "This line will be in the file and anything you will enter after it will be entered in a new line\n";
        q.jTextArea1.setText(ques4);
        q.jTextArea2.setText(ques4choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display() {
        String message="//you shoud add this library before the class name => import java.io.*;\n";
        message+="String fileName = \""+fileName+".txt\" ;\n";
        message+="try {\n";
        message+="FileWriter fileWriter = new FileWriter(fileName);\n";
        message+="BufferedWriter bw = new BufferedWriter(fileWriter);\n";
        if(choice.equals("1"))
        {
            message+="bw.write("+word+");\n";
        }
        else if(choice.equals("2"))
        {
            message+="bw.write("+lines[0]+");\n";
            message+="bw.newLine();\n";
        }
        else if(choice.equals("3"))
        {
            for(int count=0; count<linesCounter; count++)
            {
                message+="bw.write("+lines[count]+")\n";
                message+="bw.newLine();\n";
            }
        }
        message+="bw.close();\n";
        message+="fileWriter.close();\n";
        message+="}\n";
        message+="catch (FileNotFoundException ex) {\n";
        message+="System.out.println(\"Unable to open file '\" + fileName+\"'\" );\n }\n";
        message+="catch (IOException ex) {\n";
        message+="System.out.println(\"Error reading file ' \" + fileName+\" '\" );\n }\n";
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
        
    }
    
}
