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
 * @author Mostafa
 */
public class GUI {

    QuestionAnswer q = new QuestionAnswer();
    String choice = "";
    String variableName="";
    String variableName2="";
    String layout="";
    String width="";
    String height="";
    String color="";
    String imageName="";
    String rows="";
    String columns="";
    String text="";
    int counter=0;
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
        else if(counter==5)
        {
            question5();
        } 
        else if(counter==6)
        {
            question6();
        } 
        else if(counter==7)
        {
            question7();
        }
        else if(counter==8)
        {
            question8();
        } 
        else if(counter==9)
        {
            question9();
        }
        else if(counter==10)
        {
            question10();
        }
        else if(counter==12)
        {
            display();
        }
        q.jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(counter==1)
                {
                    choice = q.jTextField1.getText();
                    if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8") || choice.equals("9") ) {
                        counter=12;
                        handler();
                    }
                    else if(choice.equals("10"))
                    {
                        counter=8;
                        handler();
                    }
                    else if(!choice.equals(""))
                    {
                        handler();
                    }
                }
                else if(counter==2)
                {
                    variableName = q.jTextField1.getText();
                    if(!variableName.equals("") && choice.equals("11"))
                    {
                        handler();
                    } 
                    else if(!variableName.equals("") && choice.equals("13"))
                    {
                        counter=3;
                        handler();
                    }
                    else if(!variableName.equals("") && choice.equals("14"))
                    {
                        counter=5;
                        handler();
                    }
                    else if(!variableName.equals("") && choice.equals("16"))
                    {
                        counter=6;
                        handler();
                    }
                    else if(!variableName.equals("") && choice.equals("17") ||choice.equals("18")  )
                    {
                        counter=7;
                        handler();
                    }
                    else if(!variableName.equals(""))
                    {
                        counter=12;
                        display();
                    }
                }
                else if(counter==3)
                {
                    layout = q.jTextField1.getText();
                    if(layout.equals("3"))
                    {
                        counter=9;
                        handler();
                    }
                    else if(layout.equals("1")|| layout.equals("2"))
                    {
                        counter=12;
                        handler();
                    }
                }
                else if(counter==4)
                {
                    width = q.jTextField1.getText();
                    if(!width.equals(""))
                    {
                        handler();
                    }
                }
                else if(counter==5)
                {
                    height = q.jTextField1.getText();
                    if(!height.equals(""))
                    {
                        counter=12;
                        handler();
                    }
                }
                else if(counter==6)
                {
                    text = q.jTextField1.getText();
                    if(!text.equals(""))
                    {
                        counter=12;
                        handler();
                    }
                }
                else if(counter==7)
                {
                    variableName2 = q.jTextField1.getText();
                    if(!variableName2.equals(""))
                    {
                        counter=12;
                        handler();
                    }
                }
                else if(counter==8)
                {
                    color = q.jTextField1.getText();
                    if(!color.equals(""))
                    {
                        counter=12;
                        handler();
                    }
                }
                else if(counter==9)
                {
                    imageName = q.jTextField1.getText();
                    if(!imageName.equals(""))
                    {
                        counter=12;
                        handler();
                    }
                }
                else if(counter==10)
                {
                    rows = q.jTextField1.getText();
                    if(!rows.equals(""))
                    {
                        handler();
                    }
                }
                else if(counter==11)
                {
                    columns = q.jTextField1.getText();
                    if(!columns.equals(""))
                    {
                        counter=12;
                        handler();
                    }
                }
                
            }
        });
        
    }
    public void mainQuestion() {
        counter++;
        String mainQuestion = "Choose the component you want to create in your gui?\n";
        String mainQuestionChoices = "1.Create a Frame\n"
                + "2.Create a Panel\n"
                + "3.Create a Button\n"
                + "4.Create a Label\n"
                + "5.Create a CheckBox\n"
                + "6.Create a ComboBox\n"
                + "7.Create a Password Field\n"
                + "8.Create a Text Area\n"
                + "9.Create a Text Field\n"
                + "10.Create an Image\n"
                + "11.Set Layout (for Frame & Panel)\n"
                + "12.Make Component Visible (for all components)\n"
                + "13.Set Size (for all components)\n"
                + "14.Set Text (for all components except Frame & Panel )\n"
                + "15.Get Text (for all components except Frame & Panel )\n"
                + "16.Add components to Frame or Panel (For Frame & Panel))\n"
                + "17.Set Background color (For Frame & Panel)\n"
                + "18.Set Text color(for all components except Frame & Panel )\n"
                + "19.Set Action listener (for Buttons)\n"
                + "20.Get value of checkBox(for CheckBox)\n"
                + "21.Get ComboBox selected value(for ComboBox)\n"
                + "22.Refresh components (for Frame & Panel)\n";
        q.jTextArea1.setText(mainQuestion);
        q.jTextArea2.setText(mainQuestionChoices);
        q.jTextField1.setText("");
        q.setVisible(true);
    }
    public void question1() {
        counter++;
        String ques1 = "Enter Component Variable? \n";
        String ques1choices="The name associated with the component you created\n"
                + "Example: (JFrame fr=new JFrame();) fr is the component variable\n";
        q.jTextArea1.setText(ques1);
        q.jTextArea2.setText(ques1choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question2() {
        counter++;
        String ques2 = "Choose the Layout you need: \n";
        String ques2choices="1.BorderLayout (A BorderLayout places components in up to five areas: top, bottom, left, right, and center. All extra space is placed in the center area.)\n"
                + "2.FlowLayout (FlowLayout is the default layout manager for every JPanel. It simply lays out components in a single row, starting a new row if its container is not sufficiently wide.)\n"
                + "3.GridLayout(GridLayout simply makes a bunch of components equal in size and displays them in the requested number of rows and columns.)\n";
        q.jTextArea1.setText(ques2);
        q.jTextArea2.setText(ques2choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question3() {
        counter++;
        String ques3 = "Enter the width: \n";
        String ques3choices="The width of the component.\n";
        q.jTextArea1.setText(ques3);
        q.jTextArea2.setText(ques3choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question4() {
        counter++;
        String ques4 = "Enter the height: \n";
        String ques4choices="The height of the component.\n";
        q.jTextArea1.setText(ques4);
        q.jTextArea2.setText(ques4choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question5() {
        counter++;
        String ques5 = "Enter the text: \n";
        String ques5choices="This text will be placed with the component on the frame.\n";
        q.jTextArea1.setText(ques5);
        q.jTextArea2.setText(ques5choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question6() {
        counter++;
        String ques6 = "Enter the Component Variable that you want to add to Frame/Panel? \n";
        String ques6choices="The name associated with the component you created\n"
                + "Example: (JLabel lb=new JLabel();) lb is the component variable\n";
        q.jTextArea1.setText(ques6);
        q.jTextArea2.setText(ques6choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question7() {
        counter++;
        String ques7 = "Choose Your Color? \nEnter the number of your choice:\n";
        String ques7choices="1.Black\n2.Blue\n3.Cyan\n4.Dark Gray\n5.Gray\n6.Green\n"
                + "7.Light Gray\n8.Magenta\n9.Orange\n10.Pink\n11.Red\n12.White\n13.Yellow\n";
        q.jTextArea1.setText(ques7);
        q.jTextArea2.setText(ques7choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question8() {
        counter++;
        String ques8 = "Enter the image name:\n";
        String ques8choices="Example => image.jpg\n";
        q.jTextArea1.setText(ques8);
        q.jTextArea2.setText(ques8choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question9() {
        counter++;
        String ques9 = "Enter the number of rows you need in the grid layout:\n";
        String ques9choices="any number you want\n";
        q.jTextArea1.setText(ques9);
        q.jTextArea2.setText(ques9choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void question10() {
        counter++;
        String ques9 = "Enter the number of columns you need in the grid layout:\n";
        String ques9choices="any number you want\n";
        q.jTextArea1.setText(ques9);
        q.jTextArea2.setText(ques9choices);
        q.jTextField1.setText("");
        q.revalidate();
    }
    public void display()
    {
        String message="//you must add this library before the class name => import javax.swing.*;\n "
                + "// and also this library => import java.awt.*;\n";
        if(choice.equals("1"))
        {
            message+="JFrame frame= new JFrame();";
        }
        else if(choice.equals("2"))
        {
            message+="JPanel panel= new JPanel();";
        }
        else if(choice.equals("3"))
        {
            message+="JButton button= new JButton();";
        }
        else if(choice.equals("4"))
        {
            message+="JLabel label= new JLabel();";
        }
        else if(choice.equals("5"))
        {
            message+="JCheckBox checkBox= new JCheckBox();";
        }
        else if(choice.equals("6"))
        {
            message+="JComboBox comboBox= new JComboBox();";
        }
        else if(choice.equals("7"))
        {
            message+="JPasswordField pf= new JPasswordField();";
        }
        else if(choice.equals("8"))
        {
            message+="JTextArea textArea= new JTextArea();";
        }
        else if(choice.equals("9"))
        {
            message+="JTextField textField= new JTextField();";
        }
        else if(choice.equals("10"))
        {
            message+="ImageIcon icon= new ImageIcon(\""+imageName+"\");\n"
                    + "JLabel labelImage= new JLabel();\n"
                    + "labelImage.setIcon(icon);\n";
        }
        else if(choice.equals("11"))
        {
            message+=variableName+".setLayout( new ";
            if(layout.equals("1"))
            {
                message+="BorderLayout()";
            }
            else if(layout.equals("2"))
            {
                message+="FlowLayout()";
            }
            else if(layout.equals("3"))
            {
                message+="GridLayout("+rows+","+columns+")";
            }
            message+=");\n";
        }
        else if(choice.equals("12"))
        {
            message+=variableName+".setVisible(true);";
        }
        else if(choice.equals("13"))
        {
            message+=variableName+".setSize("+width+","+height+");";
        }
        else if(choice.equals("14"))
        {
            message+=variableName+".setText(\""+text+"\");";
        }
        else if(choice.equals("15"))
        {
            message+="String text="+variableName+".getText();";
        }
        else if(choice.equals("16"))
        {
            message+=variableName+".add("+variableName2+");";
        }
        else if(choice.equals("17") || choice.equals("18"))
        {
            if(choice.equals("17"))
            {
                message+=variableName+".getContentPane().setBackground(Color.";
            }
            else if(choice.equals("18"))
            {
                message+=variableName+".setForeground(Color.";
            }           
            if(color.equals("1"))
            {
                color="black";
            }
            else if(color.equals("2"))
            {
                color="blue";
            } 
            else if(color.equals("3"))
            {
                color="cyan";
            }
            else if(color.equals("4"))
            {
                color="darkGray";
            }
            else if(color.equals("5"))
            {
                color="gray";
            }
            else if(color.equals("6"))
            {
                color="green";
            }else if(color.equals("7"))
            {
                color="lightGray";
            }
            else if(color.equals("8"))
            {
                color="magenta";
            }else if(color.equals("9"))
            {
                color="orange";
            }else if(color.equals("10"))
            {
                color="pink";
            }
            else if(color.equals("11"))
            {
                color="red";
            }
            else if(color.equals("12"))
            {
                color="white";
            }
            else if(color.equals("13"))
            {
                color="yellow";
            }
            message+=color+");";
            
        }
        else if(choice.equals("19"))
        {
            message+="//you must add this library before the class name => import java.awt.event.ActionEvent;\n "
                + "// and also this library => import java.awt.event.ActionListener;\n"
                    + variableName+".addActionListener(new ActionListener() {\n"
                    + "public void actionPerformed(ActionEvent e) {\n"
                    + "//Enter the code you want to execute when the button is clicked\n\n"
                    + "}\n"
                    + "});\n";
        }
        else if(choice.equals("20"))
        {
            message+="Boolean check="+variableName+".isSelected();\n"
                    + "// check will contain true if the checkbox is checked & false if not checked";
        }
        else if(choice.equals("21"))
        {
            message+="String text="+variableName+".getSelectedItem().toString();";
        }
        else if(choice.equals("22"))
        {
            message+=variableName+".revalidate();";
        }
        Display d = new Display();
        d.jTextArea1.setText(message);
        q.setVisible(false);
        d.setVisible(true);
        
    }
    
}
