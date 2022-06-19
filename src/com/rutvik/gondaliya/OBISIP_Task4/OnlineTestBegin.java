package com.rutvik.gondaliya.OBISIP_Task4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

class OnlineTestBegin extends JFrame implements ActionListener
{
    JLabel l;
    JLabel l1;


    JRadioButton jb[]=new JRadioButton[6];
    JButton b1,b2,log;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    java.util.Timer timer = new Timer();


    OnlineTestBegin(String s)
    {

        super(s);
        //countdown();
        l=new JLabel();
        l1 = new JLabel();

        add(l);
        add(l1);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Save and Next");
        b2=new JButton("Marked for Review");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);

        b1.setBounds(95,240,140,30);
        b2.setBounds(270,240,150,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 60;

            public void run() {

                l1.setText("Time left: " + i);
                i--;

                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Over");
                }
            }
        }, 0, 1000);

    }
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Marked for Review"))
        {
            JButton bk=new JButton("Review"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Review"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"Score ="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Who invented Java Programming?");
            jb[0].setText("Guido Van Rossum");jb[1].setText("James Gosling");jb[2].setText("Dennis Ritchie");jb[3].setText("Bjarne Stroustrup");
        }
        if(current==1)
        {
            l.setText("Que2: Which one of the following is not a Java feature?");
            jb[0].setText("Object-Oriented");jb[1].setText("Use of pointers");jb[2].setText("Portable");jb[3].setText("Dynamic and Extensible");
        }
        if(current==2)
        {
            l.setText("Que3: Which of these cannot be used for a variable name in Java?");
            jb[0].setText("Identifier & keyword");jb[1].setText("Identifier");jb[2].setText("Keyword");jb[3].setText("None of the mentioned");
        }
        if(current==3)
        {
            l.setText("Que4: What is the extension of java code files?");
            jb[0].setText(".js");jb[1].setText(".txt");jb[2].setText(".class");jb[3].setText(".java");
        }
        if(current==4)
        {
            l.setText("Que5: which of the following is not an OOPS concept in java?");
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Compilation");jb[3].setText("Encapsulation");
        }
        if(current==5)
        {
            l.setText("Que6: Which of these are selection statements in Java?");
            jb[0].setText("break");jb[1].setText("continue");jb[2].setText("for()");jb[3].setText("if()");
        }
        if(current==6)
        {
            l.setText("Que7: Which one among these is not a class? ");
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");
            jb[3].setText("Button");
        }
        if(current==7)
        {
            l.setText("Que8: which one among these is not a function of Object class?");
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");
            jb[3].setText("getDocumentBase");
        }
        if(current==8)
        {
            l.setText("Que9: Which of the below is not Java profiler?");
            jb[0].setText("JProfiler");jb[1].setText("Eclipse Profiler");jb[2].setText("JVM");jb[3].setText("JConsole");
        }
        if(current==9)
        {
            l.setText("Que10: Which one among these is not a valid component?");
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");
            jb[3].setText("JTextArea");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[1].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[3].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[2].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }


}
