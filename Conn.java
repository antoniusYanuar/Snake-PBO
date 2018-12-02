/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeDAO;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class Conn {
    
     Connection dbCon = null;
    
    public Conn(){
        initAll();
    }
    public void initAll(){
         try{ 
            String URL="jdbc:mariadb://localhost:3306/snake";
            Connection dbCon = DriverManager.getConnection(URL, "root","");
            System.out.println("koneksi ke DB berhasil.");
            
            
        }catch(SQLException ex){
            System.out.println("Gagal koneksi ke DB: "+ex.getMessage());
            
            
        }
    }
    
    
    
    
}
