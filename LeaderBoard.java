/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class LeaderBoard extends JFrame{
    public int height = 400;
    public int width = 400;
    LeaderBoard(){
        initAll();    
        
    }
    
    private void initAll(){
        JFrame j = new JFrame();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100,100,width,height);
        setResizable(false);
        setTitle("Snake Java");
        getContentPane().setBackground(Color.lightGray);
        getContentPane().setLayout(null);
        
        
        String query = "SELECT * FROM score ORDER BY score DESC";
        try { 
            String URL="jdbc:mysql://localhost:3306/snake";
            Connection dbCon = DriverManager.getConnection(URL, "root","");
            PreparedStatement st = dbCon.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            String[] namaKolom = {"Nama","Score"};

            int row = 0;
            if(rs.last()){
                row = rs.getRow();
            }
            Object [][] arrObj = new Object[row][2];
            System.out.println(row+" record's");
            rs.beforeFirst();
            int i=0;
            while(rs.next()&&i<=row){

                arrObj[i][0] = rs.getString(2);
                arrObj[i][1] = rs.getString(3);
                i++;
            }
            JTable tblScore = new JTable(arrObj,namaKolom);
            JScrollPane jScroll = new JScrollPane(tblScore);
            tblScore.setBounds(50, 70, 250, 200);
            tblScore.setFillsViewportHeight(true);
            add(tblScore);
            add(jScroll);
        } catch (SQLException err) { 
            System.err.println("Got an exception! "); 
            System.err.println(err.getMessage()); 
        }
                
        JButton btn1 = new JButton("Ok");
        btn1.setBounds(300, 300, 50, 20);
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
         
                LeaderBoard.super.dispose();
            
            }
            
        });
        add(btn1);
    }
}
