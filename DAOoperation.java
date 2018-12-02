/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DAOoperation {
    Connection dbCon = null;
    
    public void insertScore(int sc){
        
        String name = JOptionPane.showInputDialog("Name : ");
        try { 
            String URL="jdbc:mysql://localhost:3306/snake";
            Connection dbCon = DriverManager.getConnection(URL, "root","");
            Statement st = dbCon.createStatement(); 
            st.executeUpdate("INSERT INTO score(nama,score)" + 
                "VALUES("+"'"+name+"'"+","+sc+")"); 

            dbCon.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
        if(dbCon != null){
            try {
                dbCon.close();
                System.out.println("Koneksi tertutup");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
