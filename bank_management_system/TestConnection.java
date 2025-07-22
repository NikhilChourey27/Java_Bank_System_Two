package bank_management_system;

import java.sql.*;

public class TestConnection {
    public Connection conn;
    public Statement statement;

    public TestConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagementSystem?useSSL=false&serverTimezone=UTC",
                "root",
                "12345678"
            );
            statement = conn.createStatement();
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
