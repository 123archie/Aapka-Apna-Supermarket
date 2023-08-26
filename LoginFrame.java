import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager.*;
public class LoginFrame extends JFrame implements ItemListener{
    JLabel lblLoginhead, lblroletype, lblUID, lblPASS, lblerr;
    JComboBox chb;
    JTextField txtUID;
    JPasswordField txtPass;
    Container con;
    JPanel pnl1, pnl2,MainPnl, pnlHead, pnlroletype, pnlUID, pnlPass, pnlBtn, pnlerr;
    JButton btnlogin, btnclear, btnsignup;
    int i, c=0;
    String str="ADMIN";
    String []arr=new String[2];
    LoginFrame(){
        con=getContentPane();
        setUndecorated(true);
        MainPnl=new JPanel();
        MainPnl.setLayout(new GridLayout(1, 2));
        pnl1=new JPanel();
        pnl1.setSize(1000, MainPnl.HEIGHT);
        pnl2=new JPanel();
        pnl2.setLayout(new GridLayout(6, 1, 10, 10));
        pnlHead=new JPanel();
        pnlroletype=new JPanel();
        pnlUID=new JPanel();
        pnlPass=new JPanel();
        pnlerr=new JPanel();
        pnlBtn=new JPanel();
        lblLoginhead=new JLabel("Login Here");
        lblLoginhead.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblLoginhead.setForeground(new Color(249, 76, 16));
        lblroletype=new JLabel("Select Role            ");
        lblroletype.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblroletype.setForeground(new Color(249, 76, 16));
        arr[0]="  ADMIN  ";
        arr[1]="  Seller  ";
        chb=new JComboBox(arr);
        chb.setFont(new Font("SansSerif", Font.PLAIN, 15));
        chb.addItemListener(this);
        lblUID=new JLabel("UserID       ");
        lblUID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblUID.setForeground(new Color(249, 76, 16));
        txtUID=new JTextField(10);
        txtUID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblPASS=new JLabel("Password   ");
        lblPASS.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblPASS.setForeground(new Color(249, 76, 16));
        lblerr=new JLabel("Invalid Credentials");
        lblerr.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblerr.setForeground(Color.RED);
        txtPass=new JPasswordField(10);
        txtPass.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnlogin=new JButton("LOGIN");
        btnlogin.setBackground(new Color(249, 76, 16));
        btnlogin.setForeground(Color.white);
        btnlogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnclear=new JButton("CLEAR");
        btnclear.setBackground(new Color(249, 76, 16));
        btnclear.setForeground(Color.white);
        btnclear.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnsignup=new JButton("SIGNUP");
        btnsignup.setBackground(new Color(249, 76, 16));
        btnsignup.setForeground(Color.white);
        btnsignup.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnsignup.setVisible(false);
        btnsignup.addActionListener(new SignUpPageHelper());
        btnlogin.addActionListener(new btnloginclick());
        btnclear.addActionListener(new btnClear());
        pnlHead.add(lblLoginhead);
        pnlroletype.add(lblroletype);
        pnlroletype.add(chb);
        pnlerr.add(lblerr);
        pnlerr.setVisible(false);
        pnlBtn.add(btnlogin);
        pnlBtn.add(btnclear);
        pnlBtn.add(btnsignup);
        pnlUID.add(lblUID);
        pnlUID.add(txtUID);
        pnlPass.add(lblPASS);
        pnlPass.add(txtPass);
        pnl1.setBackground(new Color(249, 76, 16));
        pnl2.add(pnlHead);
        pnl2.add(pnlroletype);
        pnl2.add(pnlUID);
        pnl2.add(pnlPass);
        pnl2.add(pnlerr);
        pnl2.add(pnlBtn);
        MainPnl.add(pnl1);
        MainPnl.add(pnl2);
        con.add(MainPnl);
        setSize(800, 600);
        setVisible(true);
        
    }
    
    public void itemStateChanged(ItemEvent ie){
        str=String.valueOf(chb.getSelectedItem().toString());
        if(str.equals("  Seller  ")){
            btnsignup.setVisible(true);
        }else{
            btnsignup.setVisible(false);
        }
    }
    public static void main(String[] args){
        new LoginFrame();
    }
    class btnloginclick implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            String user="", pass="", typeUser="";
                Connection conn=null;
                Statement stmt=null;
                try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");  
			stmt=conn.createStatement();  
			  ResultSet rs;
	         		 rs = stmt.executeQuery("Select * from admin_login limit 1");
                     while(rs.next()){
	         		    user=rs.getString("UID");
                        pass=rs.getString("Password");
                        typeUser=rs.getString("Type_of_User");
                    if(txtUID.getText().equals(user) && String.valueOf(txtPass.getPassword()).equals(pass)){
                        pnlerr.setVisible(false);
                        if(str.equals("ADMIN") && typeUser.equals("ADMIN")){
                            new AdminDashboard();
                            dispose();
                        }else if(str.equals("Seller") && typeUser.equals("Seller")){
                            new SellerPage();
                            dispose();
                        }else{
                            c++;
                        }
                        System.out.println("Login Successful");
                    }
                else{
                    c++;
                }}
	        		
                    System.out.print(c);
                    System.out.print(rs.getRow());
                    if(c-1==rs.getRow()){
                        pnlerr.setVisible(true);
                        txtUID.setText(" ");
                        txtPass.setText("");
                    }
                    rs.close();
	         		stmt.close();
	         		conn.close();
                    System.out.println(pass);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

class btnClear implements ActionListener{
    public void actionPerformed(ActionEvent ae){
        pnlerr.setVisible(false);
        txtUID.setText(" ");
        txtPass.setText("");

    }
}
class SignUpPageHelper implements ActionListener{
    public void actionPerformed(ActionEvent ee){
        new SignUpPage();
        dispose();
    }
}}