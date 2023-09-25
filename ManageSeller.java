import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.sql.DriverManager.*;
public class ManageSeller extends JFrame{
    JTable jtb;
    JTableHeader jth;
    ManageSeller(){
        setSize(800, 600);
        setUndecorated(true);
        jth=new JTableHeader()
        setVisible(true);
    }
    public static void main(String[] args){
        new ManageSeller();
    }
}
