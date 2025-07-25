package bank_management_system;

import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

public class Withdrawl extends JFrame implements ActionListener{
    String pin;
  TextField textField; 
  JButton b1Button,b2Button;
    Withdrawl(String pin){
     this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/atm2.png"));
   Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel l3 = new JLabel(i3);
   l3.setBounds(0,0,1550,830);
   add(l3);


   

   
   JLabel label1 = new JLabel("MAXIMUM WITHDRAWL IS RS. 10,000");
   label1.setForeground(Color.WHITE);
   label1.setFont(new Font("System",Font.BOLD,16));
   label1.setBounds(460,180,700,35);
   l3.add(label1);

   JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
   label2.setForeground(Color.WHITE);
   label2.setFont(new Font("System",Font.BOLD,16));
   label2.setBounds(460,220,400,35);
   l3.add(label2);


   textField = new TextField();
   textField.setBackground(new Color(65,125,128));
   textField.setForeground(Color.WHITE);
   textField.setBounds(460,260,320,25);
   textField.setFont(new Font("Raleway",Font.BOLD,22));
   l3.add(textField);

  b1Button =  new JButton("WITHDRAW");
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
        if (e.getSource()==b1Button) {
                
            try {
            
            String amount = textField.getText();
            Date date = new Date();
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
            }else{
                TestConnection con = new TestConnection();
                ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                con.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','WITHDRAWL','"+amount+"')");
                 JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully ");
                 setVisible(false);
                 new Transaction(pin);  
            
            }
            
        }catch (Exception E) {

        
    }
  } else if(e.getSource()==b2Button){
     setVisible(false);
     new Transaction(pin);
  }
     }

     public static void main(String[] args) {
        new Withdrawl("");
    }
    
}
