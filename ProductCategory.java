import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.sql.DriverManager.*;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class ProductCategory extends JFrame implements ActionListener{
    JPanel pnl1, pnl2, pnlHead, pnlcatIDName, pnldes, pnlerr, pnlbtn, pnlcatID, pnlcatName;
    JLabel lblhead, lblcatID, lblcatName, lbldes, lblerr;
    JTextField txtcatID, txtcatName;
    JTextArea txtdes;
    JButton btnadd, btnclear, btnedit, btndelete, btnupdate;
    JTable lstcat;
    javax.swing.table.JTableHeader jth;
    String catid, catname, catdes;
    Vector heading, col, row;
    ResultSet r;
    public void actionPerformed(ActionEvent ae){
        // setUndecorated(true);
        setSize(800, 600);
        setLayout(new GridLayout(5, 1, 40, 40));
        pnl1=new JPanel();
        pnl2=new JPanel();
        pnlHead=new JPanel();
        pnlcatIDName=new JPanel();
        pnldes=new JPanel();
        pnlbtn=new JPanel();
        pnlcatID=new JPanel();
        pnlcatName=new JPanel();
        pnlerr=new JPanel();
        heading=new Vector<>();
        row=new Vector<>();
        heading.add("Category ID");
        heading.add("Category Name");
        heading.add("Description");
        heading.add("");
        heading.add("");
        heading.add("");
        lblhead=new JLabel("MANAGE CATEGORIES");
        lblhead.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblhead.setForeground(new Color(249, 76, 16));
        lblcatID=new JLabel("Category ID:  ");
        lblcatID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblcatID.setForeground(new Color(249, 76, 16));
        lblcatName=new JLabel("  Category Name:  ");
        lblcatName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblcatName.setForeground(new Color(249, 76, 16));
        lbldes=new JLabel("Description:  ");
        lblerr=new JLabel("Fill all the details");
        lbldes.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lbldes.setForeground(new Color(249, 76, 16));
        txtcatID=new JTextField(10);
        txtcatID.setFont(new Font("SansSerif", Font.PLAIN, 20));
        txtcatName=new JTextField(10);
        txtcatName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        txtdes=new JTextArea(10, 10);
        txtdes.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnadd=new JButton("ADD");
        btnadd.setBackground(new Color(249, 76, 16));
        btnadd.setForeground(Color.white);
        btnadd.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnadd.addActionListener(new addClick());
        btnclear=new JButton("CLEAR");
        btnclear.setBackground(new Color(249, 76, 16));
        btnclear.setForeground(Color.white);
        btnclear.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnclear.addActionListener(new clearDetails());
        btnedit=new JButton("EDIT");
        btnedit.setBackground(new Color(249, 76, 16));
        btnedit.setForeground(Color.white);
        btnedit.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btndelete=new JButton("DELETE");
        btndelete.setBackground(new Color(249, 76, 16));
        btndelete.setForeground(Color.white);
        btndelete.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnupdate=new JButton("UPDATE");
        btnupdate.setBackground(new Color(249, 76, 16));
        btnupdate.setForeground(Color.white);
        btnupdate.setFont(new Font("SansSerif", Font.PLAIN, 20));
        Connection con=null;
                    Statement stmt=null;
                    ResultSet rs=null;
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", ""); 
                        stmt=con.createStatement();
                        rs=stmt.executeQuery("Select * from manage_categories");
                        while(rs.next()){
                            col=new Vector<>();
                            col.add(rs.getString("Category_ID"));
                            col.add(rs.getString("Category_Name"));
                            col.add(rs.getString("Description"));
                            btnedit.setVisible(true);
                            btndelete.setVisible(true);
                            btnupdate.setVisible(true);
                            col.add(btnedit);
                            col.add(btndelete);
                            col.add(btnupdate);
                            row.add(col);
                        }
                            lstcat=new JTable(row, heading);
                            jth=lstcat.getTableHeader(); 
                        rs.close();
                        stmt.close();
                        con.close();
                            }catch(Exception ie){
                        System.out.println(ie.getMessage());
                    }
        lstcat=new JTable(row, heading);
        jth=lstcat.getTableHeader();
        pnlHead.add(lblhead);
        pnlcatID.add(lblcatID);
        pnlcatID.add(txtcatID);
        pnlcatName.add(lblcatName);
        pnlcatName.add(txtcatName);
        pnlcatIDName.add(pnlcatID);
        pnlcatIDName.add(pnlcatName);
        pnlerr.add(lblerr);
        pnlerr.setVisible(false);
        pnldes.add(lbldes);
        pnldes.add(txtdes);
        pnlerr=new JPanel();
        pnlbtn.add(btnadd);
        pnlbtn.add(btnclear);
        pnl2.setBorder (BorderFactory.createTitledBorder(null, "Product Categories",TitledBorder.CENTER, TitledBorder.TOP, new Font("SansSerif", Font.PLAIN, 20), new Color(249, 76, 16)));
        pnl2.add(new JScrollPane(lstcat));
        add(pnlHead);
        add(pnlcatIDName);
        add(pnldes);
        add(pnlbtn);
        add(pnl2);
        show();
        } 
        public class addClick implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(txtcatID.getText().length()==0 || txtcatName.getText().length()==0 || txtdes.getText().length()==0){
                    pnlerr.setVisible(true);
                    txtcatID.setText("");
                    txtcatName.setText("");
                    txtdes.setText("");
                }else{
                       Connection con=null;
                       Statement stmt=null;
                       Vector row=new Vector<>();
                       try{
                       Class.forName("com.mysql.cj.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", ""); 
                        stmt=con.createStatement(); 
                        stmt.executeUpdate("Insert into manage_categories values('"+txtcatID.getText()+"','"+txtcatName.getText()+"','"+txtdes.getText()+"')"); 
                        // col=new Vector<>();
                        //     col.add(txtcatID.getText());
                        //     col.add(txtcatName.getText());
                        //     col.add(txtdes.getText());
                        //     btnedit.setVisible(true);
                        //     btndelete.setVisible(true);
                        //     btnupdate.setVisible(true);
                        //     col.add(btnedit);
                        //     col.add(btndelete);
                        //     col.add(btnupdate);
                        //     row.add(col);
                        //     lstcat=new JTable(row, heading);

                        stmt.close();
                        con.close();
                            }catch(Exception ie){
                        System.out.println(ie.getMessage());
                    } 
                    
            }}}
        class clearDetails implements ActionListener{
            public void actionPerformed(ActionEvent e){
                txtcatID.setText("");
                txtcatName.setText("");
                txtdes.setText("");
            }
        }
    public static void main(String[] args){
        new ProductCategory();
    }
}
        