package bank_management_system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel label2;
    JButton b1Button;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430, 180, 700, 35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430, 220, 400, 35);
        l3.add(label2);

        b1Button = new JButton("BACK");
        b1Button.setBounds(700, 406, 150, 35);
        b1Button.setBackground(new Color(65, 125, 128));
        b1Button.setForeground(Color.WHITE);
        b1Button.addActionListener(this);
        l3.add(b1Button);

        int balance = 0;
        try {

            TestConnection con = new TestConnection();
            ResultSet resultSet = con.statement.executeQuery("Select * from bank where pin = '" + pin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        label2.setText(""+balance);




        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     setVisible(false);
     new Transaction(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

}
