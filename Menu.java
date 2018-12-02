/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class Menu extends JFrame{
    int height = 400;
    int width = 400;
    
    Menu(){
        initAll();
    }
    
    public void initAll(){
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100,100,width,height);
        setResizable(false);
        setTitle("Menu");
        getContentPane().setLayout(null);
        
        JLabel option = new JLabel("Option");
        option.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\option.png")));
        option.setBounds(width-350, 50, 50, 50);
        option.setVisible(true);
        option.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                option.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\option2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                option.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\option.png")));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                new Menu().setVisible(true);
            }
        });
        add(option);
        
        JLabel sound = new JLabel("sound");
        sound.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\sound.png")));
        sound.setBounds(width-350, 120, 50, 50);
        sound.setVisible(true);
        sound.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                sound.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\sound2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                sound.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\sound3.png")));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                sound.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\sound3.png")));
                
            }
        });
        add(sound);
        JLabel lblLead = new JLabel();
        lblLead.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\leaderBoard.png")));
        lblLead.setBounds(width-350, 190, 50, 50);
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
                LeaderBoard lb = new LeaderBoard();
                lb.setVisible(true);
            }

        });
        add(lblLead);
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
