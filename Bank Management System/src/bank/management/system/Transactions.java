package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrwl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(1350,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,900);
        add(image);
        
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(450,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(340,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrwl=new JButton("Cash Withdrwl");
        withdrwl.setBounds(720,415,150,30);
        withdrwl.addActionListener(this);
        image.add(withdrwl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(340,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(720,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(340,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton(" Balance Enquiry");
        balanceenquiry.setBounds(720,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add (balanceenquiry);
        
        exit=new JButton("Exit");
        exit.setBounds(720,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(1550,900);
        setLocation(5,0);
        //setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
        {
          System.exit(0);
          
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrwl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
       }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        
       new  Transactions("");
    }
}
