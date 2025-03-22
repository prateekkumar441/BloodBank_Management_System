package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
        Image i2=i1.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(345,70,300,155);
        add(label);
        
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(580,130,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(450,240,150,30);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(600,240,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(450,310,250,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(600,310,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(600,380,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(730,380,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(600,430,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
      
        getContentPane().setBackground(Color.WHITE);
        
        setSize(1500,800);
        setVisible(true);
        setLocation(20,10);
    }      
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
           cardTextField.setText("");
           pinTextField.setText("");
        }   
        else if(ae.getSource()==login)
        {
           Conn conn=new Conn();
           String cardnumber=cardTextField.getText();
           String pinnumber=pinTextField.getText();
           String query="Select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            
           try
           {
               ResultSet rs=conn.s.executeQuery(query);
               if(rs.next())
               {
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
                  
               }
               else
               {
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
               }
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }  
    }    
    public static void main(String[]args)
    {            
        new Login();           
    }    
}
