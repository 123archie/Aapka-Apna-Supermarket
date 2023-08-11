import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginFrame extends JFrame{
    JLabel lblLoginhead;
    Container con;
    JPanel pnl1, pnl2,MainPnl;
    LoginFrame(){
        con=getContentPane();
        MainPnl=new JPanel();
        MainPnl.setLayout(new GridLayout(1, 2));
        pnl1=new JPanel();
        pnl1.setSize(1000, MainPnl.HEIGHT);
        pnl2=new JPanel();
        lblLoginhead=new JLabel("Login Here");
        lblLoginhead.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblLoginhead.setForeground(new Color(249, 76, 16));
        pnl1.setBackground(new Color(249, 76, 16));
        pnl2.add(lblLoginhead);
        MainPnl.add(pnl1);
        MainPnl.add(pnl2);
        con.add(MainPnl);
        setSize(800, 600);
        setVisible(true);
    }
    public static void main(String[] args){
        new LoginFrame();
    }
}
