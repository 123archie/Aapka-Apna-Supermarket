import javax.security.auth.login.LoginException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import javafx.scene.layout.BorderWidths;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager.*;
public class AdminDashboard extends JFrame{
    JPanel pnl1, pnl2, pnl3, pnl4, MainPnl;
    JButton btnprodCat, btnprod, btnSeller, btnadmin;
    AdminDashboard(){
        setUndecorated(true);
        pnl1=new JPanel();
        pnl2=new JPanel();
        pnl3=new JPanel();
        pnl4=new JPanel();
        MainPnl=new JPanel();
        MainPnl.setLayout(new GridLayout(2, 2, 40, 40));
        MainPnl.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        btnprodCat=new JButton("MANAGE CATEGORIES");
        btnprodCat.setBackground(new Color(249, 76, 16));
        btnprodCat.setForeground(Color.white);
        btnprodCat.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btnprodCat.addActionListener(new ProductCategory());
        btnprod=new JButton("MANAGE PRODUCTS");
        btnprod.setBackground(new Color(249, 76, 16));
        btnprod.setForeground(Color.white);
        btnprod.setFont(new Font("SansSerif", Font.PLAIN, 20));
        // btnprod.addActionListener(new ManageProduct());
        btnSeller=new JButton("MANAGE SELLERS");
        btnSeller.setBackground(new Color(249, 76, 16));
        btnSeller.setForeground(Color.white);
        btnSeller.setFont(new Font("SansSerif", Font.PLAIN, 20));
        // btnSeller.addActionListener(new ManageSeller());
        btnadmin=new JButton("MANAGE ORDERS");
        btnadmin.setBackground(new Color(249, 76, 16));
        btnadmin.setForeground(Color.white);
        btnadmin.setFont(new Font("SansSerif", Font.PLAIN, 20));
        // btnadmin.addActionListsner(new ManageOrders());
        MainPnl.add(btnprodCat);
        MainPnl.add(btnprod);
        MainPnl.add(btnSeller);
        MainPnl.add(btnadmin);
        add(MainPnl);
        setSize(800, 600);
        show();
    }    
    public static void main(String[] args){
        new AdminDashboard();
    }
}
