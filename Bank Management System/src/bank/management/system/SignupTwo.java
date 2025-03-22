package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno){
       
       this.formno=formno;
       setLayout(null); 
        
       setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
       
       JLabel additionalDetails = new JLabel("Page 2: Additional Details");
       additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
       additionalDetails.setBounds(550, 80, 400, 30);
       add(additionalDetails);
       
       JLabel name = new JLabel("Religion:");
       name.setFont(new Font("Raleway", Font.BOLD, 20));
       name.setBounds(220, 140, 200, 30);
       add(name);
       
       String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
       religion=new JComboBox(valReligion);
       religion.setBounds(430, 140, 400, 30);
       religion.setBackground(Color.WHITE);
       add(religion);
       
       JLabel fname = new JLabel("Category:");
       fname.setFont(new Font("Raleway", Font.BOLD, 20));
       fname.setBounds(220, 190, 200, 30);
       add(fname);
       
       String valCategory[]={"General","OBC","SC","ST","Other"};
       category=new JComboBox(valCategory);
       category.setBounds(430, 190, 400, 30);
       category.setBackground(Color.WHITE);
       add(category);
       
       JLabel dob = new JLabel("Income:");
       dob.setFont(new Font("Raleway", Font.BOLD, 20));
       dob.setBounds(220, 240, 200, 30);
       add(dob);
       
       String incomeCategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
       income=new JComboBox(incomeCategory);
       income.setBounds(430, 240, 400, 30);
       income.setBackground(Color.WHITE);
       add(income);
       
       JLabel gender = new JLabel("Educational");
       gender.setFont(new Font("Raleway", Font.BOLD, 20));
       gender.setBounds(220, 290, 200, 30);
       add(gender);
       
       JLabel email = new JLabel("Qualification:");
       email.setFont(new Font("Raleway", Font.BOLD, 20));
       email.setBounds(220, 315, 200, 30);
       add(email);
       
       String educationValues[]={"Non-Graduation","Graduate","Post-Graduation","Doctorate","Engineering","Others"};
       education=new JComboBox( educationValues);
       education.setBounds(430, 315, 400, 30);
       education.setBackground(Color.WHITE);
       add(education);
      
       JLabel marital = new JLabel("Occupation:");
       marital.setFont(new Font("Raleway", Font.BOLD, 20));
       marital.setBounds(220, 390, 200, 30);
       add(marital);
       
       String occupationValues[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
       occupation=new JComboBox( occupationValues);
       occupation.setBounds(430, 390, 400, 30);
       occupation.setBackground(Color.WHITE);
       add(occupation);
       
       JLabel address = new JLabel("PAN Number:");
       address.setFont(new Font("Raleway", Font.BOLD, 20));
       address.setBounds(220, 440, 200, 30);
       add(address);
       
       pan = new JTextField();
       pan.setFont(new Font("Raleway", Font.BOLD, 14));
       pan.setBounds(430, 440, 400, 30);
       add(pan);
       
       JLabel city = new JLabel("Aadhar Number:");
       city.setFont(new Font("Raleway", Font.BOLD, 20));
       city.setBounds(220, 490, 200, 30);
       add(city);
       
       aadhar= new JTextField();
       aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
       aadhar.setBounds(430, 490, 400, 30);
       add(aadhar);
       
       JLabel state = new JLabel("Senior Citizen:");
       state.setFont(new Font("Raleway", Font.BOLD, 20));
       state.setBounds(220, 540, 200, 30);
       add(state);
       
       syes = new JRadioButton("Yes");
       syes.setBounds(425, 540, 100, 30);
       syes.setBackground(Color.WHITE);
       add(syes);
       
       sno = new JRadioButton("No");
       sno.setBounds(570, 540, 100, 30);
       sno.setBackground(Color.WHITE); 
       add(sno);
       
       ButtonGroup maritalrgroup = new ButtonGroup();
       maritalrgroup.add(syes);
       maritalrgroup.add(sno);
       
       JLabel pincode = new JLabel("Exisiting Account:");
       pincode.setFont(new Font("Raleway", Font.BOLD, 20));
       pincode.setBounds(220, 590, 200, 30);
       add(pincode);
       
       eyes = new JRadioButton("Yes");
       eyes.setBounds(425, 590, 100, 30);
       eyes.setBackground(Color.WHITE);
       add(eyes);
       
       eno = new JRadioButton("No");
       eno.setBounds(570, 590, 100, 30);
       eno.setBackground(Color.WHITE); 
       add(eno);
       
       ButtonGroup emaritalrgroup = new ButtonGroup();
       emaritalrgroup.add(eyes);
       emaritalrgroup.add(eno);
       
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway", Font.BOLD, 14));
       next.setBounds(750, 660, 80, 30);
       next.addActionListener(this);
       add(next);
       
       getContentPane().setBackground(Color.WHITE);
       
       setSize(1500, 800);
       setLocation(10, 10);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
   
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome= (String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen= null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if(sno.isSelected()) {
            seniorcitizen = "NO";
        }
        
        String exisitingaccount = null;
        if(eyes.isSelected())
        {    
            exisitingaccount="Yes";
        }
        else if(eno.isSelected())
        {
            exisitingaccount="No";
        }
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try
        {
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
                c.s.executeUpdate(query);
                
                //Signup3 Object
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
    }        
    
    public static void main (String[]args){
        new SignupTwo("");
    }
}