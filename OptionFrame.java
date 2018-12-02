/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class OptionFrame extends JFrame{
    public int height = 400;
    public int width = 400;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int FSwidth = (int) screenSize.getWidth();
    int FSheight = (int) screenSize.getHeight();
    SetGet SG= new SetGet();
    
    OptionFrame(){
        initAll();            
    }
    
    private void initAll(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100,100,width,height);
        setResizable(false);
        setTitle("Option");
        getContentPane().setLayout(null);
        
        JPanel pnf = new JPanel();
        pnf.setBounds(0,0,400, 400);
        pnf.setBackground(Color.getColor("#00FF7F"));
        add(pnf);
        
        
        JLabel btn4 = new JLabel("Fullscreen");
        btn4.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\full.png")));
        btn4.setBounds(100, 100, 100, 100);
        btn4.setVisible(true);
        btn4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                SG.setSwidth(FSwidth);
                SG.setSheight(FSheight);
                new Background(SG.getSwidth(),SG.getSheight()).setVisible(true);
                    
                
            }
        });        
        
        
        JLabel btn3 = new JLabel();
        btn3.setIcon(new ImageIcon(resizeImage("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\save.png")));
        btn3.setBounds(100, 350, 300, 200);
        btn3.setVisible(true);
        btn3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                OptionFrame.super.setVisible(false);
                OptionFrame.super.dispose();
            }
        });
        pnf.add(btn4);
        pnf.add(btn3);
    }
    
    private Image resizeImage(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }
    
    private Image resizeIcon(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }
}
