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
public class Background extends JFrame{

    
    public int height2 = 700;
    public int width2 = 1000;
    AudioPlayer ap =AudioPlayer.player;
    AudioStream ms;
    AudioData md;
    ContinuousAudioDataStream loop = null;
    
    public Background(int x, int y){
        initAll(x, y);       
    }
    
    void initAll(int width, int height){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Snake Java");
        music();    
            
//        JLabel backgroundImg = new JLabel();
//        backgroundImg.setIcon(new ImageIcon(resizeBg("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\wood.png")));
//        backgroundImg.setBounds(0, 0, width, height);
//        backgroundImg.setVisible(true);
//        this.setContentPane(backgroundImg);
//        add(backgroundImg);
        
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
                ap.stop(ms);
            }
        });
       add(exit);
        
       MainControler c = new MainControler();
       add(c);
    }
   
    public void over() {
        Background.super.dispose();
        Background.super.setVisible(false);
        new Background(WIDTH, WIDTH).setVisible(true);
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
    
    private Image resizeBg(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }
    
    private void music(){
    
            
            try{
                InputStream test = new FileInputStream("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\music\\List BG\\03 Bol-Dor's Realm.wav");
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
