package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SignupThree extends JFrame implements ActionListener {
   
    JCheckBox c1Box,c2Box,c3Box,c4Box;
    JButton submitButton, cancelButton;
    String formno;

    SignupThree( String formno){
      this.formno = formno;
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/bank.png"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(150,20,100,100);
    add(image);

   JLabel l1 = new JLabel("Page 3 :");
   l1.setFont(new Font("Raleway",Font.BOLD,22));
   l1.setBounds(280,40,400,40);
   add(l1);

   JLabel l2 = new JLabel("Accounts Details :");
   l2.setFont(new Font("Raleway",Font.BOLD,22));
   l2.setBounds(280,70,400,40);
   add(l2);


   JLabel l3 = new JLabel("Card Number :");
   l3.setFont(new Font("Raleway",Font.BOLD,25));
   l3.setBounds(100,150,200,40);
   add(l3);

   JLabel l4 = new JLabel("(Your 16-digit Card Number)");
   l4.setFont(new Font("Raleway",Font.BOLD,12));
   l4.setBounds(100,180,200,23);
   add(l4);

   JLabel l5= new JLabel("XXXX - XXXX - XXXX - 4841");
   l5.setFont(new Font("Raleway",Font.BOLD,25));
   l5.setBounds(390,170,350,23);
   add(l5);

   JLabel l8 = new JLabel("PIN:");
   l8.setFont(new Font("Raleway",Font.BOLD,25));
   l8.setBounds(100,230,200,30);
   add(l8);


   JLabel l9 = new JLabel("XXXX");
   l9.setFont(new Font("Raleway",Font.BOLD,25));
   l9.setBounds(390,230,200,30);
   add(l9);

   JLabel l10 = new JLabel("(4-digit Password)");
   l10.setFont(new Font("Raleway",Font.BOLD,14));
   l10.setBounds(100,255,200,23);
   add(l10);

   JLabel l11 = new JLabel("Services Required:");
   l11.setFont(new Font("Raleway",Font.BOLD,25));
   l11.setBounds(100,300,250,30);
   add(l11);


  c1Box = new JCheckBox("ATM CARD");
  c1Box.setBackground(new Color(215,252,252));
  c1Box.setFont(new Font("Raleway",Font.BOLD,18));
  c1Box.setBounds(100,350,200,30);
  add(c1Box);

  c2Box = new JCheckBox("Internet Banking");
  c2Box.setBackground(new Color(215,252,252));
  c2Box.setFont(new Font("Raleway",Font.BOLD,18));
  c2Box.setBounds(300,350,200,30);
  add(c2Box);

  c3Box = new JCheckBox("Mobile Banking");
  c3Box.setBackground(new Color(215,252,252));
  c3Box.setFont(new Font("Raleway",Font.BOLD,18));
  c3Box.setBounds(100,400,200,30);
  add(c3Box);

  c4Box = new JCheckBox("Email Alert"); 
  c4Box.setBackground(new Color(215,252,252));
  c4Box.setFont(new Font("Raleway",Font.BOLD,18));
  c4Box.setBounds(300,400,200,30);
  add(c4Box);


  JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knowledge.",true);
  c7.setBackground(new Color(215,252,252));
  c7.setFont(new Font("Raleway",Font.BOLD,16));
  c7.setBounds(100,500,1000,30);
  add(c7);



  JLabel l12= new JLabel(" Form No : ");
l12.setFont(new Font("Raleway",Font.BOLD,18));
l12.setBounds(700,20,150,30);
add(l12);


JLabel l13= new JLabel();
l13.setFont(new Font("Raleway",Font.BOLD,18));
l13.setBounds(760,20,150,30);
add(l13);


submitButton = new JButton("Submit");
submitButton.setFont(new Font("Raleway",Font.BOLD,14));
submitButton.setBackground(Color.BLACK);
submitButton.setForeground(Color.WHITE);
submitButton.setBounds(220,710,100,30);
submitButton.addActionListener(this);
add(submitButton);


cancelButton = new JButton("Cancel");
cancelButton.setFont(new Font("Raleway",Font.BOLD,14));
cancelButton.setBackground(Color.BLACK);
cancelButton.setForeground(Color.WHITE);
cancelButton.setBounds(420,710,100,30);
cancelButton.addActionListener(this);
add(cancelButton);


 



   getContentPane().setBackground(new Color(215,252,252));
   setSize(850,800);
   setLayout(null);
   setLocation(400,20);
   setVisible(true);

    }



  @Override
    public void actionPerformed(ActionEvent e) {
      String atype = null;
        
    Random ran = new Random();
    long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
    String cardno = "" + Math.abs(first7);


    long first3 = (ran.nextLong() % 9000L) + 1000L;
    String pin = "" + Math.abs(first3);

    String fac = "";
    if(c1Box.isSelected()){
      fac = fac+"ATM CARD";
    }else if(c2Box.isSelected()){
      fac = fac+"Internet Banking";
    }else if(c3Box.isSelected()){
      fac =fac+"Mobile Banking";
    }else if(c4Box.isSelected()){
      fac = fac+"Email Alert";
    }
    

    try {
       
      if (e.getSource()==submitButton) {
        if (fac.equals("")) {
          JOptionPane.showMessageDialog(null,"Fill all the fields");

        }else{
          TestConnection con = new TestConnection();
          String q1 = "insert into signupthree values('"+formno+"','"+cardno+"','"+pin+"','"+fac+"')";
          String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
          con.statement.executeUpdate(q1);
          con.statement.executeUpdate(q2);
          JOptionPane.showMessageDialog(null, "Card Number : "+cardno+"\n Pin  : "+pin );
          setVisible(false);

        }
        
      }else if(e.getSource()==cancelButton){

       System.exit(0);
      }



    } catch (Exception E) {
      // TODO: handle exception
    }


    }


    
    public static void main(String[] args) {
        
        new SignupThree("");
    }
   
   
    
}
