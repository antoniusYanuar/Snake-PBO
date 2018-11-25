/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.snake;

import static com.sun.management.jmx.Trace.isSelected;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.reflect.Array.set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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
    public int speed = 0;
    
    public Home(){
        initAll(width,height);
    }
    
    public void initAll(int width,int height){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0,0,width,height);
        setResizable(false);
        setTitle("Snake Java");
        getContentPane().setLayout(null);
        //music();
        
        JLabel backgroundImg = new JLabel();
        backgroundImg.setIcon(new ImageIcon(resizeBg("D:\\belajar\\prak PBO\\snake\\src\\snakes\\bg.png")));
        backgroundImg.setBounds(0, 0, width, height);
        backgroundImg.setVisible(true);
        add(backgroundImg);
        
        JLabel mainLogo = new JLabel();
        mainLogo.setIcon(new ImageIcon(resizeLogo("D:\\belajar\\prak PBO\\snake\\src\\snakes\\logo01.png")));
        mainLogo.setBounds(300, 100,
                400, 200);
        mainLogo.setVisible(true);
        backgroundImg.add(mainLogo);
        
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon(resizeIcon("D:\\belajar\\prak PBO\\snake\\src\\snakes\\menu.png")));
        menu.setBounds(850, 0, 50, 50);
        menu.setVisible(true);
        menu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                menu.setIcon(new ImageIcon(resizeIcon("D:\\belajar\\prak PBO\\snake\\src\\snakes\\menu2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                menu.setIcon(new ImageIcon(resizeIcon("D:\\belajar\\prak PBO\\snake\\src\\snakes\\menu.png")));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                new Menu().setVisible(true);
            }
        });
        backgroundImg.add(menu);
        
        JLabel exit = new JLabel();
        exit.setIcon(new ImageIcon(resizeIcon("D:\\belajar\\prak PBO\\snake\\src\\snakes\\no.png")));
        exit.setBounds(930, 0, 50, 50);
        exit.setVisible(true);
        exit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
                exit.setIcon(new ImageIcon(resizeIcon("D:\\belajar\\prak PBO\\snake\\src\\snakes\\no2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                exit.setIcon(new ImageIcon(resizeIcon("D:\\belajar\\prak PBO\\snake\\src\\snakes\\no.png")));
            }            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Home.super.setVisible(false);
                Home.super.dispose();
            }
        });
        backgroundImg.add(exit);

                
        JRadioButton easy = new JRadioButton("easy", false);
        JRadioButton medium = new JRadioButton("medium", false);
        JRadioButton hard = new JRadioButton("hard", false);
        easy.setBounds(300, 500, 100, 40);
        easy.setVisible(true);
        
        

        backgroundImg.add(easy);
        
        medium.setBounds(400, 500, 100, 40);
        medium.setVisible(true);

        backgroundImg.add(medium);
        
        hard.setBounds(500, 500, 100, 40);         
        hard.setVisible(true);
        
        backgroundImg.add(hard);
        
        
        
        JLabel btnOp = new JLabel();
        btnOp.setIcon(new ImageIcon(resizeImage("D:\\belajar\\prak PBO\\PBO Snake\\src\\pbo\\snake\\play.png")));
        btnOp.setBounds(300, 400, 400, 100);
        btnOp.setVisible(true);
        btnOp.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                btnOp.setIcon(new ImageIcon(resizeImage("D:\\belajar\\prak PBO\\snake\\src\\snakes\\play2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                btnOp.setIcon(new ImageIcon(resizeImage("D:\\belajar\\prak PBO\\snake\\src\\snakes\\play.png")));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                easy.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                if(easy.isSelected()){
                    easy.setSelected(true);
                    }
                }
                });
                medium.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                if(medium.isSelected()){
                    medium.setSelected(true);
                    }
                }
                });
                hard.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                if(hard.isSelected()){
                    hard.setSelected(true);
                    }
                }
                });
                
                if(easy.isSelected()){
                    speed=300;
                    setSpeed(300);
                }else if(medium.isSelected()==true){
                    speed=200;
                }else if(hard.isSelected()==true){
                    speed=100;
                }
               
                
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
    
            AudioPlayer ap =AudioPlayer.player;
            AudioStream ms;
            AudioData md;
            
            ContinuousAudioDataStream loop = null;
            
//            try{
//                InputStream test = new FileInputStream("D:\\belajar\\prak PBO\\snake\\src\\snakes\\go.wav");
//                ms = new AudioStream(test);
//                AudioPlayer.player.start(ms);
//                //md = ms.getData();
//                //loop = new ContinuousAudioDataStream(md);
//            }catch(FileNotFoundException e){
//                System.out.println(e.toString());
//            }catch(IOException err){
//                System.out.println(err.toString());
//            }
            ap.start(loop);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    

    
}
