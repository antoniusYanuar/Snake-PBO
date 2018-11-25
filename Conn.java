/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.snake;

import java.sql.*;
import java.util.ArrayList;
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
    
    public ArrayList<User> lead(){
        
        ArrayList<User> listUser = new ArrayList();
        String query = "SELECT * FROM score ORDER BY score DESC";
        try { 
            String URL="jdbc:mysql://localhost:3306/snake";
            Connection dbCon = DriverManager.getConnection(URL, "root","");
            PreparedStatement st = dbCon.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
            
                User us = new User();
                us.setName(rs.getString("nama"));
                us.setSco(Integer.parseInt(rs.getString("score")));
                listUser.add(us);
                System.out.println(us.getName());
                System.out.println(us.getSco());
            }
 
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
        
        return listUser;
    }
    
}
