/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heavenhostal;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashim
 */
public class DBConnection {
    DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
        
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
            JOptionPane.showMessageDialog(null,"Error Loading MYSQL Drivers", "Error",0);
        }
    
    }
    
    public Connection db(){
        Connection conn=null;
        try{
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://localhost/hostal";
            conn = DriverManager.getConnection(url, user, pass);
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Connecting to Database","Error",0);
        }
        return conn;
    }
    
    
}
