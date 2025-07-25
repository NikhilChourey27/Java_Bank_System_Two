package bank_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
// import java.sql.Date;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
// import java.awt.TextField;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.ResultSet;
// import java.util.Date;

// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

public class FastCash extends JFrame implements ActionListener {

    JButton buttonB1, buttonB2, buttonB3, buttonB4, buttonB5, buttonB6, buttonB7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank_management_system/icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 1080);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(425, 320, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 28));
        l3.add(label);

        buttonB1 = new JButton("Rs. 100");
        buttonB1.setForeground(Color.WHITE);
        buttonB1.setBackground(new Color(65, 125, 128));
        buttonB1.setBounds(408, 395, 150, 35);
        buttonB1.addActionListener(this);
        l3.add(buttonB1);

        buttonB2 = new JButton("Rs. 500");
        buttonB2.setForeground(Color.WHITE);
        buttonB2.setBackground(new Color(65, 125, 128));
        buttonB2.setBounds(700, 395, 150, 35);
        buttonB2.addActionListener(this);
        l3.add(buttonB2);

        buttonB3 = new JButton("Rs. 1000");
        buttonB3.setForeground(Color.WHITE);
        buttonB3.setBackground(new Color(65, 125, 128));
        buttonB3.setBounds(408, 443, 150, 35);
        buttonB3.addActionListener(this);
        l3.add(buttonB3);

        buttonB4 = new JButton("Rs. 2000");
        buttonB4.setForeground(Color.WHITE);
        buttonB4.setBackground(new Color(65, 125, 128));
        buttonB4.setBounds(700, 443, 150, 35);
        buttonB4.addActionListener(this);
        l3.add(buttonB4);

        buttonB5 = new JButton("Rs. 5000");
        buttonB5.setForeground(Color.WHITE);
        buttonB5.setBackground(new Color(65, 125, 128));
        buttonB5.setBounds(408, 490, 150, 35);
        buttonB5.addActionListener(this);
        l3.add(buttonB5);

        buttonB6 = new JButton("Rs. 10000");
        buttonB6.setForeground(Color.WHITE);
        buttonB6.setBackground(new Color(65, 125, 128));
        buttonB6.setBounds(700, 490, 150, 35);
        buttonB6.addActionListener(this);
        l3.add(buttonB6);

        buttonB7 = new JButton("BACK");
        buttonB7.setForeground(Color.WHITE);
        buttonB7.setBackground(new Color(65, 125, 128));
        buttonB7.setBounds(700, 535, 150, 35);
        buttonB7.addActionListener(this);
        l3.add(buttonB7);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonB7) {
            setVisible(false);
            new Transaction(pin);
        } else {
            String amount = ((JButton) e.getSource()).getText().substring(4);
            TestConnection con = new TestConnection();
            Date date = new Date();

            try {

                ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {

                        balance += Integer.parseInt(resultSet.getString("amount"));

                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));

                    }
                }
                String num = "17";

                if (e.getSource() != buttonB7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                con.statement.executeUpdate(
                        "insert into bank values('" + pin + "', '" + date + "', 'withdrawl','" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully ");

            } catch (Exception E) {
                E.printStackTrace();
            }
            setVisible(false);
            new Transaction(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }

}
