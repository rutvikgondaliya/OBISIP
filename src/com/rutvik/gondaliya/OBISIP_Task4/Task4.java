package com.rutvik.gondaliya.OBISIP_Task4;

import javax.swing.*;

class Task4
{
    //main() method start
    public static void main(String arg[])
    {
        try
        {
            //create instance of the CreateLoginForm
            com.rutvik.gondaliya.OBISIP_Task4.login form = new com.rutvik.gondaliya.OBISIP_Task4.login();
            form.setSize(500,100);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}