package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Transaction extends JFrame implements ActionListener {
   
    JButton buttonB1 ,buttonB2 , buttonB3 ,buttonB4 ,buttonB5 ,buttonB6 ,buttonB7;
    String pin;
      Transaction(String pin){
      this.pin = pin;


    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/atm2.png"));
   Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel l3 = new JLabel(i3);
   l3.setBounds(0,0,1550,1080);
   add(l3);


   JLabel label =new JLabel("Please Select Your Transaction");
   label.setBounds(430,320,700,35);
   label.setForeground(Color.WHITE);
   label.setFont(new Font("System",Font.BOLD , 28));
   l3.add(label);

     buttonB1 = new JButton("DEPOSIT");
     buttonB1.setForeground(Color.WHITE);
     buttonB1.setBackground(new Color(65,125,128));
     buttonB1.setBounds(408,395 ,150,35);
     buttonB1.addActionListener(this);
     l3.add(buttonB1);

     buttonB2 = new JButton("CASH WITHDRAWL");
     buttonB2.setForeground(Color.WHITE);
     buttonB2.setBackground(new Color(65,125,128));
     buttonB2.setBounds(700,395 ,150,35);
     buttonB2.addActionListener(this);
     l3.add(buttonB2);

     buttonB3 = new JButton("FAST CASH");
     buttonB3.setForeground(Color.WHITE);
     buttonB3.setBackground(new Color(65,125,128));
     buttonB3.setBounds(408,443 ,150,35);
     buttonB3.addActionListener(this);
     l3.add(buttonB3);
     
     buttonB4 = new JButton("MINI STATEMENT");
     buttonB4.setForeground(Color.WHITE);
     buttonB4.setBackground(new Color(65,125,128));
     buttonB4.setBounds(700,443 ,150,35);
     buttonB4.addActionListener(this);
     l3.add(buttonB4);
 

      buttonB5 = new JButton("PIN CHANGE");
     buttonB5.setForeground(Color.WHITE);
     buttonB5.setBackground(new Color(65,125,128));
     buttonB5.setBounds(408,490 ,150,35);
     buttonB5.addActionListener(this);
     l3.add(buttonB5);


      buttonB6 = new JButton("BALANCE ENQUIRY");
     buttonB6.setForeground(Color.WHITE);
     buttonB6.setBackground(new Color(65,125,128));
     buttonB6.setBounds(700,490 ,150,35);
     buttonB6.addActionListener(this);
     l3.add(buttonB6);


      buttonB7= new JButton("EXIT");
     buttonB7.setForeground(Color.WHITE);
     buttonB7.setBackground(new Color(65,125,128));
     buttonB7.setBounds(700 ,535 ,150,35);
     buttonB7.addActionListener(this);
     l3.add(buttonB7);
      





        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
      }

      @Override
      public void actionPerformed(ActionEvent e) {

        if (e.getSource()==buttonB1) {
            new Deposit(pin);
            setVisible(false);
        }else if(e.getSource()==buttonB7){
          System.exit(0);
        }else if(e.getSource()==buttonB2){
         new Withdrawl(pin);
         setVisible(false);
        }else if(e.getSource()==buttonB6){
           new BalanceEnquiry(pin);
           setVisible(false);
        }else if(e.getSource()==buttonB3){
          new FastCash(pin);
          setVisible(false);
        }else if(e.getSource()==buttonB5){
          new PinChange(pin);
          setVisible(false);
        }else if (e.getSource()==buttonB4) {
          new Mini(pin);
          
        }
      }
      public static void main(String[] args) {
        new Transaction("");
        
      }
      
}
