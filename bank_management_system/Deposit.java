package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
public class Deposit extends JFrame implements ActionListener {
   
  String pin;
  TextField textField; 
  JButton b1Button,b2Button;

    Deposit(String pin){
  this.pin = pin;

  
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/atm2.png"));
   Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel l3 = new JLabel(i3);
   l3.setBounds(0,0,1550,830);
   add(l3);

   
   JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
   label1.setForeground(Color.WHITE);
   label1.setFont(new Font("System",Font.BOLD,16));
   label1.setBounds(460,180,400,35);
   l3.add(label1);


   textField = new TextField();
   textField.setBackground(new Color(65,125,128));
   textField.setForeground(Color.WHITE);
   textField.setBounds(460,230,320,25);
   textField.setFont(new Font("Raleway",Font.BOLD,22));
   l3.add(textField);

  b1Button =  new JButton("DEPOSIT");
  b1Button.setBounds(700,362,150,35);
  b1Button.setBackground(new Color(65,125,128));
  b1Button.setForeground(Color.WHITE);
  b1Button.addActionListener(this);
  l3.add(b1Button);


  b2Button =  new JButton("BACK");
  b2Button.setBounds(700,406,150,35);
  b2Button.setBackground(new Color(65,125,128));
  b2Button.setForeground(Color.WHITE);
 b2Button.addActionListener(this);
  l3.add(b2Button);


    
    setLayout(null);
    setSize(1550,1080);
    setLocation(0,0);
    setVisible(true);
    }



     @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            String amount = textField.getText();
            Date date = new Date();
         if (e.getSource()==b1Button) {
            if (textField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");

            }else{
                TestConnection con = new TestConnection();
                con.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                setVisible(false);
                new Transaction(pin);
                 

            }
         }else if(e.getSource()==b2Button){
            setVisible(false);
            new Transaction(pin);

         }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
   
}
