import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager.*;
public class SignUpPage extends JFrame{
    JLabel lblhead, lblname, lblemail, lblpass, lblconpass, lblphone;

    SignUpPage(){

    }
    public static void main(String[] args){
        new SignUpPage();
    }
}
