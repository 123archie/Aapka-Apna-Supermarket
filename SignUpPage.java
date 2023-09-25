import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager.*;
public class SignUpPage extends JFrame implements ActionListener{
    Container container;
    JLabel lblhead, lblname, lblUID, lblpass, lblconpass, lblphone, lblerr;
    JTextField txtName, txtUID, txtphone;
    JPasswordField txtpass, txtconpass;
    JButton btnsubmit, btnclear;
    JPanel MainPnl, pnl1, pnl2, pnlhead, pnlName, pnlUID, pnlPass, pnlconPass, pnlPhone, pnlerr, pnlbtn;
    SignUpPage(){
        container=getContentPane();
        setUndecorated(true);
        setSize(800, 600);
        MainPnl=new JPanel();
        MainPnl.setLayout(new GridLayout(1, 2));
        pnl1=new JPanel();
        pnl1.setSize(1000, MainPnl.HEIGHT);
        pnl2=new JPanel();
        pnl1.setBackground(new Color(249, 76, 16));
        pnl2.setLayout(new GridLayout(7, 1, 10, 10));
        lblhead=new JLabel("Fill Your Details");
        lblhead.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblhead.setForeground(new Color(249, 76, 16));
        pnlhead=new JPanel();
        pnlhead.add(lblhead);
        lblname=new JLabel("Name       ");
        lblname.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblname.setForeground(new Color(249, 76, 16));
        txtName=new JTextField(10);
        txtName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pnlName=new JPanel();
        pnlName.add(lblname);
        pnlName.add(txtName);
        lblUID=new JLabel("User ID       ");
        lblUID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblUID.setForeground(new Color(249, 76, 16));
        txtUID=new JTextField(10);
        txtUID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pnlUID=new JPanel();
        pnlUID.add(lblUID);
        pnlUID.add(txtUID);
        lblpass=new JLabel("Password       ");
        lblpass.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblpass.setForeground(new Color(249, 76, 16));
        txtpass=new JPasswordField(10);
        txtpass.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pnlPass=new JPanel();
        pnlPass.add(lblpass);
        pnlPass.add(txtpass);
        lblphone=new JLabel("Phone No.       ");
        lblphone.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblphone.setForeground(new Color(249, 76, 16));
        txtphone=new JTextField(10);
        txtphone.setFont(new Font("SansSerif", Font.PLAIN, 20)); 
        pnlPhone=new JPanel(); 
        pnlPhone.add(lblphone);
        pnlPhone.add(txtphone);
        lblerr=new JLabel("Fill all the details");
        lblerr.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblerr.setForeground(new Color(249, 76, 16));
        pnlerr=new JPanel();
        pnlerr.add(lblerr);
        pnlerr.setVisible(false);
        btnsubmit=new JButton("SIGN UP");
        btnsubmit.setBackground(new Color(249, 76, 16));
        btnsubmit.setForeground(Color.white);
        btnsubmit.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnclear=new JButton("CLEAR");
        btnclear.setBackground(new Color(249, 76, 16));
        btnclear.setForeground(Color.white);
        btnclear.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pnlbtn=new JPanel();
        pnlbtn.add(btnsubmit);
        pnlbtn.add(btnclear);
        pnl2.add(pnlhead);
        pnl2.add(pnlName);
        pnl2.add(pnlUID);
        pnl2.add(pnlPass);
        // pnl2.add(pnlconPass);
        pnl2.add(pnlPhone);
        pnl2.add(pnlerr);
        pnl2.add(pnlbtn);
        MainPnl.add(pnl1);
        MainPnl.add(pnl2);
        container.add(MainPnl);
        show();
        btnsubmit.addActionListener(this);
     }
     public void actionPerformed(ActionEvent ae){
        if(txtName.getText().length()==0 || txtUID.getText().length()==0 || txtpass.getPassword().toString().length()==0 || txtphone.getText().length()==0){
            pnlerr.setVisible(true);
        }else{
            pnlerr.setVisible(false);
            Connection conn=null;
            Statement stmt=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                stmt=conn.createStatement();
                System.out.println(txtName.getText()+" "+txtUID.getText()+" "+String.valueOf(txtpass.getPassword())+" "+txtphone.getText());
                stmt.executeUpdate("Insert into signup_details values('"+(int)(Math.random()*1000000)+"', '"+txtName.getText()+"', '"+txtUID.getText()+"', '"+String.valueOf(txtpass.getPassword())+"', '"+txtphone.getText()+"')");
                stmt.close();                   
                conn.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
     }
    
    public static void main(String[] args){
        new SignUpPage();
    }
}
