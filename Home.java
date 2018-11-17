/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class Home extends JFrame{
    public int height = 700;
    public int width = 1000;
   
    public Home(){
        initAll(width,height);
    }
    
    public void initAll(int width,int height){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0,0,width,height);
        setResizable(false);
        setTitle("Snake Java");
        getContentPane().setBackground(Color.black);
        getContentPane().setLayout(null);
        
        JButton btnOp = new JButton("PLAY");
        btnOp.setBounds(450, 300, 70, 50);
        btnOp.setVisible(true);
        btnOp.addMouseListener(new MouseAdapter(){
           @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                Home.super.setVisible(false);
                Home.super.dispose();
                new Background(1000,700).setVisible(true);
            } 
        
        });
        add(btnOp);
        
    }
    
}
