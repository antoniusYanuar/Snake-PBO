/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Asus
 */
public class Background extends JFrame{
    public int height2 = 700;
    public int width2 = 1000;
    
    public Background(int x, int y){
        initAll(x, y);       
    }
    
    void initAll(int width, int height){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0,0,width,height);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#228B22"));
        setTitle("Snake Java");
        music();            
        
        JLabel icon1 = new JLabel();
        icon1.setBounds(850, 550, 150, 100);
        icon1.setIcon(new ImageIcon(resizeImage("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\logo01.png")));
        add(icon1);
        
        
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\menu.png")));
        menu.setBounds(width2-150, 0, 50, 50);
        menu.setVisible(true);
        menu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                menu.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\menu2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                menu.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\menu.png")));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                new Menu().setVisible(true);
            }
        });
        add(menu);
        
        JLabel exit = new JLabel();
        exit.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no.png")));
        exit.setBounds(width2-70, 0, 50, 50);
        exit.setVisible(true);
        exit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
                exit.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                exit.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no.png")));
            }            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Background.super.setVisible(false);
                Background.super.dispose();
            }
        });
        add(exit);
        
       MainControler c = new MainControler();
       add(c);
    }
   
    
    private Image resizeImage(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
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
    public void music(){
    
            AudioPlayer ap =AudioPlayer.player;
            AudioStream ms;
            AudioData md;
            
            ContinuousAudioDataStream loop = null;
            
            try{
                InputStream test = new FileInputStream("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\music\\go.wav");
                ms = new AudioStream(test);
                AudioPlayer.player.start(ms);
                //md = ms.getData();
                //loop = new ContinuousAudioDataStream(md);
            }catch(FileNotFoundException e){
                System.out.println(e.toString());
            }catch(IOException err){
                System.out.println(err.toString());
            }
            ap.start(loop);
    }
}
