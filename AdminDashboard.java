import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager.*;
public class AdminDashboard extends JFrame{
    AdminDashboard(){
        setSize(800, 600);
        show();
    }
    public static void main(String[] args){
        new AdminDashboard();
    }
}
