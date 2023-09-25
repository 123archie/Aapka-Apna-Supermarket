import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.awt.*;
import java.sql.DriverManager.*;
import java.util.Vector;
public class ManageSeller extends JFrame{
    JTable jtb;
    JTableHeader jth;
    Vector row, heading, col;
    ManageSeller(){
        setSize(800, 600);
        setUndecorated(true);
        Connection conn=null;
        Statement stmt=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from signup_details");
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
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        jtb=new JTable(row, heading);
        jth=jtb.getTableHeader();
        setVisible(true);
    }
    public static void main(String[] args){
        new ManageSeller();
    }
}
