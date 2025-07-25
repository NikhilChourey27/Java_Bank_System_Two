package bank_management_system;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {


    JRadioButton r1,r2;
    JButton next;
  
    JTextField textName , textFname , textEmail , textAdd , textCity , textState;
    

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {

    super("APPLICATION FORM");

     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/bank.png"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(30,10,100,100);
    add(image);
    

    JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
    label1.setBounds(160,20,600,40);
    label1.setFont(new Font("Raleway", Font.BOLD, 38));
    label1.setFont(new Font("Raleway", Font.BOLD, 38));
    add(label1);

    JLabel label2 = new JLabel("Page 1");
    label2.setFont(new Font("Ralway", Font.BOLD, 22));
    label2.setBounds(330,70,600,30);
    add(label2);

    JLabel label3 = new JLabel("Personal Details");
    label3.setFont(new Font("Raleway", Font.BOLD, 22));
    label3.setBounds(290,90,600,30);
    add(label3);

    JLabel labelName = new JLabel("Name : ");
    labelName.setFont(new Font("Raleway", Font.BOLD, 20));
    labelName.setBounds(100,190,100,30);
    add(labelName);


    textName = new JTextField();
    textName.setFont(new Font("Raleway", Font.BOLD, 14));
    textName.setBounds(300,190,400,30);
    add(textName);
    
    
    JLabel labelfName = new JLabel("Father 's Name : ");
    labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
    labelfName.setBounds(100,240,200,30);
    add(labelfName);


    textFname = new JTextField();
    textFname.setFont(new Font("Raleway", Font.BOLD, 14));
    textFname.setBounds(300,240,400,30);
    add(textFname);


    JLabel labelG = new JLabel("Gender ");
    labelG.setFont( new Font("Raleway",Font.BOLD,20));
    labelG.setBounds(100,290,200,30);
    add(labelG);

     r1 = new JRadioButton("Male");
     r1.setFont(new Font("Raleway", Font.BOLD, 14));
     r1.setBackground(new Color(222,255,228));
     r1.setBounds(300,290,60,30);
     add(r1);

     r2 = new JRadioButton("Female");
     r2.setFont(new Font("Raleway", Font.BOLD, 14));
     r2.setBackground(new Color(222,255,228));
     r2.setBounds(450,290,90,30);
     add(r2);

     ButtonGroup buttonGroup = new ButtonGroup();
     buttonGroup.add(r1);
    buttonGroup.add(r2);


    JLabel labelEmail = new JLabel("Email address : ");
    labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
    labelEmail.setBounds(100,330,200,30);
    add(labelEmail);


    textEmail = new JTextField();
    textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
    textEmail.setBounds(300,330,400,30);
    add(textEmail);


    JLabel labelAdd = new JLabel("Address : ");
    labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
    labelAdd.setBounds(100,380,200,30);
    add(labelAdd);


    textAdd = new JTextField();
    textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
    textAdd.setBounds(300,380,400,30);
    add(textAdd);


    JLabel labelCity = new JLabel("City : ");
    labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
    labelCity.setBounds(100,430,200,30);
    add(labelCity);


    textCity = new JTextField();
    textCity.setFont(new Font("Raleway", Font.BOLD, 14));
    textCity.setBounds(300,430,400,30);
    add(textCity);

    JLabel labelState = new JLabel("State : ");
    labelState.setFont(new Font("Raleway", Font.BOLD, 20));
    labelState.setBounds(100,480,200,30);
    add(labelState);


    textState = new JTextField();
    textState.setFont(new Font("Raleway", Font.BOLD, 14));
    textState.setBounds(300,480,400,30);
    add(textState);

    
    next = new JButton("Next");
    next.setFont(new Font("Raleway", Font.BOLD, 14));
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setBounds(620,710,80,30);
    next.addActionListener(this);
    add(next);


        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }
     
  
  @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";

        }else if(r2.isSelected()){
            gender = "Female";

        }
        String email = textEmail.getText();
        String address = textAdd.getText();
        String city = textCity.getText();
        String state = textState.getText();

        try {
            if (textName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the details");
               

            }else{

            TestConnection con = new TestConnection();
              String q = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"')";
             con.statement.executeUpdate(q);
            new SignupTwo(formno);
            setVisible(false);


        }
            
        } catch (Exception E) {
           E.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        new Signup();
    }

    
}
