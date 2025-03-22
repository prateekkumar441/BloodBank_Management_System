
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
	JButton back;
	String pinnumber;
	BalanceEnquiry(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(1350,900,Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel image=new JLabel(i3);//jlabel use for set the image
	    image.setBounds(0,0,1550,900);//set image in the left corner of the frame
	    add(image);
	    
	    back=new JButton("Back");
	    back.setBounds(720,520,150,30);
	    back.addActionListener(this);
	    image.add(back);
	    
	   Conn conn=new Conn();
	   int balance=0;
 	   try {
 		   ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
 		   while(rs.next()) {
 			   if(rs.getString("type").equals("Deposit")) {
 				   balance +=Integer.parseInt(rs.getString("amount"));
 			   }else {
 				   balance -=Integer.parseInt(rs.getString("amount"));
 			   }
 		   }
 	   }catch(Exception e) {
 		   System.out.println(e);
 	   }
 	   
 	   JLabel text =new JLabel("Your Current Account balance is Rs" + " " +balance);
 	   text.setForeground(Color.WHITE);
 	   text.setBounds(340,300,400,30);
           text.setFont(new Font("Raleway", Font.BOLD, 18));
 	   image.add(text);
	    
		setSize(1550,900);
		setLocation(5,0);
		//setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}

	public static void main(String[] args) {
       new BalanceEnquiry("");

	}

}


