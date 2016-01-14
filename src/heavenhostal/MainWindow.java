/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heavenhostal;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Hashim
 */
public class MainWindow extends JFrame{
    MainWindow(){
        setTitle("Heaven Boys Hostal Management System");
        setSize(1366,786);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        add(new JLabel(new ImageIcon(getClass().getResource("logo.png"))));
        
        MyHandler handler = new MyHandler();
        // Customer Databse
        JMenu menu = new JMenu("Customer Database");
        
        menu.setIcon(new ImageIcon(getClass().getResource("data.png")));
        
        JMenuItem item1 = new JMenuItem("Add New Customer");
        item1.addActionListener(handler);
        item1.setIcon(new ImageIcon(getClass().getResource("adduser.png")));
        menu.add(item1);
        
        JMenuItem item2 = new JMenuItem("Search Customer");
        item2.addActionListener(handler);
        item2.setIcon(new ImageIcon(getClass().getResource("searchuser.png")));
        menu.add(item2);
        item2.add(new JSeparator());
        
        JMenuItem item3 = new JMenuItem("Delete Customer");
        item3.addActionListener(handler);
        item3.setIcon(new ImageIcon(getClass().getResource("deleteuser.png")));
        menu.add(item3);
        item3.add(new JSeparator());
        
        JMenuItem item4 = new JMenuItem("Edit Customer");
        item4.setIcon(new ImageIcon(getClass().getResource("edituser.png")));
        menu.add(item4);
        item4.add(new JSeparator());
        
        JMenuItem item5 = new JMenuItem("List All Customer");
        item5.addActionListener(handler);
        item5.setIcon(new ImageIcon(getClass().getResource("listuser.png")));
        menu.add(item5);
        item5.add(new JSeparator());
        
        // Room DataBase
        JMenu menu2 = new JMenu("Rooms Database");
        menu2.setIcon(new ImageIcon(getClass().getResource("data.png")));
        JMenuItem item6 = new JMenuItem("Add New Rooms");
        item6.setIcon(new ImageIcon(getClass().getResource("room.png")));
        menu2.add(item6);
        
        JMenuItem item7 = new JMenuItem("Delete Room");
        item7.setIcon(new ImageIcon(getClass().getResource("room.png")));
        menu2.add(item7);
        item7.add(new JSeparator());
        
        JMenuItem item8 = new JMenuItem("List All Rooms");
        item8.setIcon(new ImageIcon(getClass().getResource("room.png")));
        menu2.add(item8);
        item8.add(new JSeparator());
        
        // Financial DataBase
        JMenu menu3 = new JMenu("Financial Database");
        menu3.setIcon(new ImageIcon(getClass().getResource("data.png")));
        
        JMenuItem item9 = new JMenuItem("Pay Room Rent");
        item9.setIcon(new ImageIcon(getClass().getResource("money.png")));
        menu3.add(item9);
        
        JMenuItem item10 = new JMenuItem("List All Defaulters");
        item10.setIcon(new ImageIcon(getClass().getResource("money.png")));
        menu3.add(item10);
        item10.add(new JSeparator());
        
        JMenuItem item11 = new JMenuItem("Generate Report");
        item11.setIcon(new ImageIcon(getClass().getResource("money.png")));
        menu3.add(item11);
        item11.add(new JSeparator());
        
        // Settings Menu
        JMenu menu4 = new JMenu("Settings");
       
        menu4.setIcon(new ImageIcon(getClass().getResource("settings.png")));
        
        JMenuItem item12 = new JMenuItem("Add new User");
        item12.setIcon(new ImageIcon(getClass().getResource("adduser.png")));
        menu4.add(item12);
        
        JMenuItem item13 = new JMenuItem("Delete User");
        item13.setIcon(new ImageIcon(getClass().getResource("deleteuser.png")));
        menu4.add(item13);
        item13.add(new JSeparator());
        
        JMenuItem item14 = new JMenuItem("Edit User");
        item14.setIcon(new ImageIcon(getClass().getResource("edituser.png")));
        menu4.add(item14);
        item14.add(new JSeparator());
        
        
        
        
        
        
        JMenuBar mainbar = new  JMenuBar();
        mainbar.setBackground(Color.YELLOW);
        mainbar.add(menu);
        mainbar.add(menu2);
        mainbar.add(menu3);
        mainbar.add(menu4);
        setJMenuBar(mainbar);
    
    }
    
    public class MyHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Add New Customer")){
                AddCustomer add = new AddCustomer();
                add.setVisible(true);
            
            }else if(e.getActionCommand().equals("Search Customer")){
                SearchCustomer sc = new SearchCustomer();
                sc.setVisible(true);
            
            }else if(e.getActionCommand().equals("List All Customer")){
                ListAllCustomer lac = new ListAllCustomer();
                lac.setVisible(true);
            }else if(e.getActionCommand().equals("Delete Customer")){
                DeleteCustomer dc = new DeleteCustomer();
                dc.setVisible(true);
            
            }
        }
    
    
    }

    
    
}
