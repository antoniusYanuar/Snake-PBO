/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class Background extends JFrame{
    SetGet SG= new SetGet();

    Background(int width,int height){
        initAll(width,height);    
        
    }
    
    void initAll(int width,int height){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0,0,width,height);
        setResizable(false);
        setTitle("Snake Java");
        getContentPane().setBackground(Color.black);
        getContentPane().setLayout(null);
        JPanel pn1 = new JPanel();
        pn1.setBounds(width-200,0,200, height);
        pn1.setBackground(Color.lightGray);
        add(pn1);
        
        JLabel icon1 = new JLabel();
        icon1.setIcon(new ImageIcon(resizeImage("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\Untitled-11.png")));
        pn1.add(icon1);
        
        
        JButton btn2 = new JButton("Option");
        btn2.setPreferredSize(new Dimension(150, 40));
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                new OptionFrame().setVisible(true);
                
            }
            
        });
        pn1.add(btn2);
        JButton btn3 = new JButton("Leader Board");
        btn3.setPreferredSize(new Dimension(150, 40));
        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                new LeaderBoard().setVisible(true);
                
            }
            
        });
        pn1.add(btn3);
        JButton btn4 = new JButton("Exit");
        btn4.setPreferredSize(new Dimension(150, 40));
        btn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                JOptionPane.showMessageDialog(rootPane, "Yakin?");
                Background.super.setVisible(false);
                Background.super.dispose();
            }
            
        });
        pn1.add(btn4);
        
            
    }
   
    
    private Image resizeImage(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }
}
