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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Asus
 */
public class Home extends JFrame{
    public int height = 700;
    public int width = 1000;
    AudioPlayer ap =AudioPlayer.player;
    AudioStream ms;
    AudioData md;
    ContinuousAudioDataStream loop = null;

    public Home(){
        initAll(width,height);
    }
    
    public void initAll(int width,int height){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Snake Java");
        getContentPane().setLayout(null);
        music();
        
        JLabel backgroundImg = new JLabel();
        backgroundImg.setIcon(new ImageIcon(resizeBg("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\bg.png")));
        backgroundImg.setBounds(0, 0, width, height);
        backgroundImg.setVisible(true);
        add(backgroundImg);
        
        JLabel mainLogo = new JLabel();
        mainLogo.setIcon(new ImageIcon(resizeLogo("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\logo01.png")));
        mainLogo.setBounds(300, 100, 400, 200);
        mainLogo.setVisible(true);
        backgroundImg.add(mainLogo);
        
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\menu.png")));
        menu.setBounds(850, 0, 50, 50);
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
        backgroundImg.add(menu);
        
        JLabel exit = new JLabel();
        exit.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\no.png")));
        exit.setBounds(930, 0, 50, 50);
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
                Home.super.setVisible(false);
                Home.super.dispose();
               
            }
        });
        backgroundImg.add(exit);
        
        JLabel btnOp = new JLabel();
        btnOp.setIcon(new ImageIcon(resizeImage("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\play.png")));
        btnOp.setBounds(300, 400, 400, 100);
        btnOp.setVisible(true);
        btnOp.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                btnOp.setIcon(new ImageIcon(resizeImage("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\play2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                btnOp.setIcon(new ImageIcon(resizeImage("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\play.png")));
            }
            
           @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                ap.stop(ms);
                new Background(1000,700).setVisible(true);
                Home.super.setVisible(false);
                Home.super.dispose();
            } 
        
        });
        backgroundImg.add(btnOp);
        
    }
    private Image resizeImage(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
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
    private Image resizeLogo(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }
    private Image resizeBg(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }
    
    public void music(){
    
                       
            try{
                InputStream test = new FileInputStream("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\music\\List BG\\01 Title Screen.wav");
                ms = new AudioStream(test);
                AudioPlayer.player.start(ms);
                //md = ms.getData();
                //loop = new ContinuousAudioDataStream(md);
            }catch(FileNotFoundException e){
                System.out.println(e.toString());
            }catch(IOException err){
                System.out.println(err.toString());
            }
             
    }
    
}
