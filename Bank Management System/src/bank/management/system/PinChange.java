
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends  JFrame implements ActionListener {
	
	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;
	PinChange(String pinnumber){
		this.pinnumber=pinnumber;
        setLayout(null);
		
	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	    Image i2=i1.getImage().getScaledInstance(1350,900,Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel image=new JLabel(i3);//jlabel use for set the image
	    image.setBounds(0,0,1550,900);//set image in the left corner of the frame
	    add(image);
	    
	    JLabel text=new JLabel("CHANGE YOUR PIN");
	    text.setBounds(500,280,500,35);
	    text.setForeground(Color.WHITE);
	    text.setFont(new Font("Raleway",Font.BOLD,18));
	    image.add(text);
	    
	    JLabel pintext=new JLabel("New PIN:");
	    pintext.setBounds(350,340,180,25);
	    pintext.setForeground(Color.WHITE);
	    pintext.setFont(new Font("System",Font.BOLD,16));
	    image.add(pintext);
	    
	    pin=new JPasswordField();
	    pin.setFont(new Font("Raleway",Font.BOLD,25));
	    pin.setBounds(500,340,180,25);
	    image.add(pin);
	    
	    JLabel repintext=new JLabel("Re-Enter New PIN:");
	    repintext.setBounds(350,380,180,25);
	    repintext.setForeground(Color.WHITE);
	    repintext.setFont(new Font("System",Font.BOLD,16));
	    image.add(repintext);
	    

	    repin=new JPasswordField();
	    repin.setFont(new Font("Raleway",Font.BOLD,25));
	    repin.setBounds(500,380,180,25);
	    image.add(repin);
	    
	    change=new JButton("CHANGE");
	    change.setBounds(720,485,150,30);
	    change.addActionListener(this);
	    image.add(change);
	    
	    back=new JButton("BACK");
	    back.setBounds(720,520,150,30);
	    back.addActionListener(this);
	    image.add(back);
	    
	    setSize(1550,900);
	    setLocation(5,0);
	    //setUndecorated(true);
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		  try {
			String npin=pin.getText();
			String rpin=repin.getText();
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter PIN");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
				return;
			}
			Conn conn=new Conn();
			String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
			String query2="update login set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
			String query3="update signupthree set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
			
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed successfully");
			
			setVisible(false);
			new Transactions(rpin).setVisible(true);
		  
		}catch(Exception e) {
			System.out.println(e);
		  }
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
      new PinChange("").setVisible(true);

	}

}
