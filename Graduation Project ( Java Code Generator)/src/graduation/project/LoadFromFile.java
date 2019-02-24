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
public class LoadFromFile {    
    QuestionAnswer q = new QuestionAnswer();
    int counter=0;
    String fileName="";
    String choice="";
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
                    fileName = q.jTextField1.getText();
                    if (!fileName.equals("")) {
                        handler();
                    }
                }
                else if(counter==2)
                {
                    choice = q.jTextField1.getText();
                    if (!choice.equals("")) {
                        counter=3;
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
        String ques1 = "What do you want to read from the file? \n Enter the number of your choice:";
        String ques1choices="1.Read a word\n2.Read a line\n3.Read the whole file\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String message="//you shoud add this library before the class name => import java.io.*;\n";
        message+="String fileName = \""+fileName+".txt\" ;\n";
        message+="try {\n";
        message+="FileReader fileReader = new FileReader(fileName);\n";
        message+="BufferedReader br = new BufferedReader(fileReader);\n";
        if(choice.equals("1"))
        {
            message+="String word=br.read();\n";
            message+="System.out.print(word);\n";
        }
        else if(choice.equals("2"))
        {
            message+="String line=br.readLine();\n";
            message+="System.out.println(line);\n";
        }
        else if(choice.equals("3"))
        {
            message+="String newLine=br.readLine();\n";
            message+="while(newLine!=null) {\n";
            message+="System.out.println(newLine);\n";
            message+="newLine=br.readLine();\n";
            message+="}\n";
        }
        message+="br.close();\n";
        message+="fileReader.close();\n";
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
