/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import SnakeDAO.Conn;
import SnakeDAO.DAOoperation;
import SnakeDAO.User;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Asus
 */
public class PanelOver extends JFrame{
    
    int width = 400;
    int height = 400;
    int inp;
    LeaderBoard lb = new LeaderBoard();
    Conn conn = new Conn();
    DAOoperation conn2 = new DAOoperation();
    PanelOver(){
        
        initAll();
        
    }
    
    public void initAll(){
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Game Over");
        getContentPane().setLayout(null);     
               
        
        
        JLabel lblClose = new JLabel();
        lblClose.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no.png")));
        lblClose.setBounds(320, 300, 50, 50);
        lblClose.setVisible(true);
        lblClose.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
                lblClose.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                lblClose.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no.png")));
            }            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PanelOver.super.setVisible(false);
                PanelOver.super.dispose();
                
            }
        });
        add(lblClose);
        
        JLabel lblSave = new JLabel();
        lblSave.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\save.png")));
        lblSave.setBounds(250, 300, 50, 50);
        lblSave.setVisible(true);
        lblSave.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
                lblSave.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\save2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                lblSave.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\save.png")));
            }            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                save(inp);
            }
        });
        add(lblSave);
        
        JLabel lblLead = new JLabel();
        lblLead.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\leaderBoard.png")));
        lblLead.setBounds(180, 300, 50, 50);
        lblLead.setVisible(true);
        lblLead.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
                lblLead.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\leaderBoard2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                lblLead.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\leaderBoard.png")));
            }            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lb.setVisible(true);
            }

        });
        add(lblLead);
        
                       
    }
    
    
    public void showScore(int sc){
        JLabel lblScore = new JLabel();
        String scr = "Your Score : ";
        lblScore.setBounds(10, 0, 250, 50);
        lblScore.setText(scr+sc);
        lblScore.setFont(new Font(scr, Font.BOLD, 20));
        add(lblScore);
        inp = sc;
    }
    
    
    
    private void save(int sc){
        
        conn2.insertScore(sc);
        
    }
    
     private Image resizeIcon(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }

    
}
