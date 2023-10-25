import javax.swing.*;
import javax.swing.table.JTableHeader;

import javafx.scene.layout.Border;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager.*;
import java.util.Vector;
public class ManageSeller extends JFrame implements ActionListener{
    JPanel pnl, pnlbtn;
    JTable jtb;
    JTableHeader jth;
    Vector row, heading, col;
    JButton jbtn;
    public void actionPerformed(ActionEvent e){
       pnl=new JPanel();
       pnlbtn=new JPanel();
       jbtn=new JButton("DELETE");
       pnlbtn.add(jbtn);
       setSize(800, 600);
       setUndecorated(true);
       row=new Vector<>();
       col=new Vector<>();
       heading=new Vector<>();
       heading.add("Seller_Id");
       heading.add("Seller Name");
       heading.add("User ID");
       heading.add("Password");
       heading.add("Phone No.");
       Connection conn=null;
       Statement stmt=null;
       ResultSet rs=null;
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", ""); 
        stmt=conn.createStatement();
        rs=stmt.executeQuery("Select * from signup_details");
        while(rs.next()){
           col=new Vector<>();
           col.add(rs.getString("Seller ID"));
           col.add(rs.getString("Name"));
           col.add(rs.getString("EmailID"));
           col.add(rs.getString("Password"));
           col.add(rs.getString("Phone"));    
           row.add(col);
        }
        rs.close();
        stmt.close();
        conn.close();
        jtb=new JTable(row, heading);
        jth=jtb.getTableHeader();
    }catch(Exception ee){
        System.out.println(ee);
    }
       pnl.add(jtb);
       setLayout(new BorderLayout());
       add(pnl, "Center");
       setVisible(true);
    }
    public static void main(String[] args){
        new ManageSeller();
    }
}
