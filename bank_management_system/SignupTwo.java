package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {
    JComboBox comboBox ,Income , Education , Occupation;
    JTextField textPan , textAdhar;
    JButton next;
    String formno;
    SignupTwo(String first){
        super("APPLICATION FORM");

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/bank.png"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(150,20,100,100);
    add(image);

   this.formno = formno;

JLabel l1 = new JLabel("Page 2 : -");
l1.setFont(new Font("Raleway",Font.BOLD,22));
l1.setBounds(300,60,150,40);
add(l1);


JLabel l2 = new JLabel("Additional Details : ");
l2.setFont(new Font("Raleway",Font.BOLD,22));
l2.setBounds(300,120,600,40);
add(l2);


JLabel l3 = new JLabel("Category : ");
l3.setFont(new Font("Raleway",Font.BOLD,18));
l3.setBounds(100,180,100,30);
add(l3);

String category[] = {"General","OBC","SC","ST","Others"};
comboBox = new JComboBox(category);
comboBox.setBackground(new Color(252,208,76));
comboBox.setFont(new Font("Raleway",Font.BOLD,14));
comboBox.setBounds(350,180,320,30);
add(comboBox);



JLabel l4 = new JLabel(" Year Income : ");
l4.setFont(new Font("Raleway",Font.BOLD,18));
l4.setBounds(100,250,150,30);
add(l4);

String income[] = {"Null","<50,000","<1,50,000","<2,50,000","<5,00,000"};
Income = new JComboBox(income);
Income.setBackground(new Color(252,208,76));
Income.setFont(new Font("Raleway",Font.BOLD,14));
Income.setBounds(350,250,320,30);
add(Income);



JLabel l5 = new JLabel(" Education : ");
l5.setFont(new Font("Raleway",Font.BOLD,18));
l5.setBounds(100,320,150,30);
add(l5);

String education[] = {"Null","High-school","Higher-sec-school","Graduate","Post-graduate"};
Education = new JComboBox(education);
Education.setBackground(new Color(252,208,76));
Education.setFont(new Font("Raleway",Font.BOLD,14));
Education.setBounds(350,320,320,30);
add(Education);



JLabel l6 = new JLabel(" Occupation : ");
l6.setFont(new Font("Raleway",Font.BOLD,18));
l6.setBounds(100,380,150,30);
add(l6);

String occupation[] = {"Student","Un-employed","Salaried","Business","Others"};
Occupation = new JComboBox(occupation);
Occupation.setBackground(new Color(252,208,76));
Occupation.setFont(new Font("Raleway",Font.BOLD,14));
Occupation.setBounds(350,380,320,30);
add(Occupation);


JLabel l7 = new JLabel(" PAN Number : ");
l7.setFont(new Font("Raleway",Font.BOLD,18));
l7.setBounds(100,450,150,30);
add(l7);


textPan = new JTextField();
textPan.setFont((new Font("Raleway",Font.BOLD,18)));
textPan.setBounds(350, 450, 250, 30);
add(textPan);



JLabel l8 = new JLabel(" Adhar Number : ");
l8.setFont(new Font("Raleway",Font.BOLD,18));
l8.setBounds(100,520,150,30);
add(l8);


textAdhar = new JTextField();
textAdhar.setFont((new Font("Raleway",Font.BOLD,18)));
textAdhar.setBounds(350, 520, 250, 30);
add(textAdhar);



JLabel l9= new JLabel(" Form No : ");
l9.setFont(new Font("Raleway",Font.BOLD,18));
l9.setBounds(700,20,150,30);
add(l9);


JLabel l10= new JLabel(formno);
l10.setFont(new Font("Raleway",Font.BOLD,18));
l10.setBounds(760,20,150,30);
add(l10);

next = new JButton("Next");
next.setFont(new Font("Raleway",Font.BOLD,14));
next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);
next.setBounds(630,640,100,30);
next.addActionListener(this);
add(next);








    setLayout(null);
    setSize(850,750);
    setLocation(450,80);
    getContentPane().setBackground(new Color(252,208,76));
     setVisible(true);
    }

    

     @Override
    public void actionPerformed(ActionEvent e) {
   
        String cate = (String) comboBox.getSelectedItem();
        String inc = (String) Income.getSelectedItem();
        String edu = (String) Education.getSelectedItem();
        String occu = (String) Occupation.getSelectedItem();

        String pan = textPan.getText();
        String adhar = textAdhar.getText();


        try {

            if(textPan.getText().equals("") || textAdhar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else{
                TestConnection con = new TestConnection();
                String q = "insert into signuptwo values('"+formno+"','"+cate+"','"+inc+"','"+edu+"','"+occu+"','"+pan+"','"+adhar+"')";
                con.statement.executeUpdate(q);
                new SignupThree(formno);
                setVisible(false);
            }
            
     

        } catch (Exception E) {
            // TODO: handle exception
        }
        

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
    public static void main(String[] args) {
        new SignupTwo(" ");
    }
   
}
   
