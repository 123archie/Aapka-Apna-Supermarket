import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.sql.DriverManager.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class ManageProduct extends JFrame implements ActionListener{
    JLabel lblhead, lblprodID, lblprodName, lblcategory, lblprodQuantity, lblPrice;
    JPanel pnl1, pnl2, pnlHead, pnlprodIDName, pnlquanprice, pnlCategory, pnlerr, pnlbtn, pnlprodID, pnlprodName, pnlQuantity, pnlPrice;
    JTextField txtprodId, txtprodName, txtQuantity, txtPrice;
    JComboBox combocategory;
    JButton btnadd, btnclear;
    JTable jtable;
    ArrayList<String> arr;
    public void actionPerformed(ActionEvent aae){
        setSize(800, 600);
        setLayout(new GridLayout(6, 1));
        lblhead=new JLabel("MANAGE PRODUCTS");
        lblhead.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblhead.setForeground(new Color(249, 76, 16));
        lblprodID=new JLabel("Product ID:  ");
        lblprodID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblprodID.setForeground(new Color(249, 76, 16));
        lblprodName=new JLabel("Product Name:  ");
        lblprodName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblprodName.setForeground(new Color(249, 76, 16));
        lblcategory=new JLabel("Product Category:  ");
        lblcategory.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblcategory.setForeground(new Color(249, 76, 16));
        lblprodQuantity=new JLabel("Quantity:  ");
        lblprodQuantity.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblprodQuantity.setForeground(new Color(249, 76, 16));
        lblPrice=new JLabel("Price:  ");
        lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblPrice.setForeground(new Color(249, 76, 16));
        txtprodId=new JTextField(10);
        txtprodId.setFont(new Font("SansSerif", Font.PLAIN, 20));
        txtprodName=new JTextField(10);
        txtprodName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        txtQuantity=new JTextField(10);
        txtQuantity.setFont(new Font("SansSerif", Font.PLAIN, 20));
        txtPrice=new JTextField(10);
        txtPrice.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnadd=new JButton("ADD");
        btnadd.setBackground(new Color(249, 76, 16));
        btnadd.setForeground(Color.white);
        btnadd.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnclear=new JButton("CLEAR");
        btnclear.setBackground(new Color(249, 76, 16));
        btnclear.setForeground(Color.white);
        btnclear.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnclear.addActionListener(new cleardetails());
        pnl1=new JPanel();
        pnl2=new JPanel();
        pnlHead=new JPanel();
        pnlprodIDName=new JPanel();
        pnlquanprice=new JPanel();
        pnlCategory=new JPanel();
        pnlprodID=new JPanel();
        pnlprodName=new JPanel();
        pnlQuantity=new JPanel();
        pnlPrice=new JPanel();
        pnlbtn=new JPanel();
        pnlerr=new JPanel();
        pnlHead.add(lblhead);
        pnlprodID.add(lblprodID);
        pnlprodID.add(txtprodId);
        pnlprodName.add(lblprodName);
        pnlprodName.add(txtprodName);
        pnlprodIDName.add(pnlprodID);
        pnlprodIDName.add(pnlprodName);
        pnlQuantity.add(lblprodQuantity);
        pnlQuantity.add(txtQuantity);
        pnlPrice.add(lblPrice);
        pnlPrice.add(txtPrice);
        pnlquanprice.add(pnlQuantity);
        pnlquanprice.add(pnlPrice);
        pnlCategory.add(lblcategory);
        pnlbtn.add(btnadd);
        pnlbtn.add(btnclear);
        pnl1.add(pnlHead);
        pnl1.add(pnlprodIDName);
        pnl1.add(pnlquanprice);
        pnl1.add(pnlCategory);
        pnl1.add(pnlbtn);
        arr=new ArrayList<>();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", ""); 
            stmt=con.createStatement();
            rs=stmt.executeQuery("Select Category_Name from manage_categories");
            while(rs.next()){
               arr.add(rs.getString("Category_Name"));
            }
            rs.close();
            stmt.close();
            con.close();
            // combocategory=new JComboBox<>(arr);
            pnlCategory.add(combocategory);
        }
            catch(Exception ee){
            System.out.println(ee);
        }
        pnl2.add(jtable);
        show();
    }
    class cleardetails implements ActionListener{
        public void actionPerformed(ActionEvent e){
            txtprodId.setText("");
            txtprodName.setText("");
            txtQuantity.setText("");
            txtPrice.setText("");
        }
    }
    public static void main(String[] args){
        new ManageProduct();
    }
}
