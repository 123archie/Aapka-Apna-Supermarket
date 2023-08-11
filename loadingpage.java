import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class loadingpage extends JFrame{
    Container con;
    JPanel pnl, pnl1, pnl2, pnl3, pnl4;
    JLabel lblhead, lblload, lblpercent;
    JProgressBar progbar;
    loadingpage(){
        con=getContentPane();
        setUndecorated(true);
        setLocation(200, 200);
        pnl=new JPanel();
        pnl.setLayout(new GridLayout(4, 1));
        pnl1=new JPanel();
        pnl2=new JPanel();
        pnl3=new JPanel();
        pnl4=new JPanel();
        lblhead=new JLabel("AAPKA APNA SUPERMARKET");
        lblhead.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblhead.setForeground(Color.white);
        lblload=new JLabel("LOADING... ");
        lblpercent=new JLabel("0%");
        lblpercent.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblpercent.setForeground(Color.white);
        lblload.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblload.setForeground(Color.WHITE);
        progbar=new JProgressBar(0, 100);
        progbar.setValue(0);
        progbar.setPreferredSize(new Dimension(450, 20));        
        pnl3.setBackground(new Color(249, 76, 16));
        pnl.setBackground(new Color(249, 76, 16));
        pnl1.setBackground(new Color(249, 76, 16));
        pnl2.setBackground(new Color(249, 76, 16));
        pnl1.add(lblhead);
        pnl2.add(lblload);
        pnl2.add(lblpercent);
        pnl3.add(progbar);
        pnl.add(pnl1);
        pnl.add(pnl2);
        pnl.add(pnl3);
        con.add(pnl);
        setSize(800, 600);
        setVisible(true);
        fill();
    }
    public void fill(){
        int i=0;
        while(i<=100){
            progbar.setValue(i);
            lblpercent.setText(i+"%");
            try{
            Thread.sleep(50);
            }catch(InterruptedException ie){

            }
            i+=5;
        }
        if(i>100){
            dispose();
            new LoginFrame();
        }
    }
    public static void main(String[] args){
        new loadingpage();
    }
}
