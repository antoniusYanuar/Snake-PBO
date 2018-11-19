/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static javafx.scene.text.Font.font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Asus
 */
public class MainControler extends JLabel{
    
    public Character sHead = new Character();
    public Food food = new Food();
    public Timer sMove = null;
    public Random rand = null;
    public ArrayList<Character> List = new ArrayList();
    public JLabel tscore = new JLabel();
    public JLabel starter = new JLabel();
    public JLabel over = new JLabel();
    int score;

    public MainControler(){
        InitAll();
    }
    
    
    public void InitAll(){
    
        rand = new Random(System.currentTimeMillis());
        addKeyListener(new Movement());
        setFocusable(true);
        sMove = new Timer(100,new AutoMove());
        List.add(sHead);
        for(int i = 0; i<1;i++){
            Tail();
        }
        
        ShowFood();
        add(sHead);
        add(food);
        add(over);
        add(starter);
        add(tscore);
        start();
    }  
   
    public void Tail(){
        Character K = List.get(List.size()-1).Char();
        List.add(K);
        add(K);
    }
    
    public void ShowFood(){
        
        int width = getWidth()-30-food.foodS;
        int height = getHeight()-30-food.foodS;
        
        int posX = 30+Math.abs(rand.nextInt())%width;
        int posY = 30+Math.abs(rand.nextInt())%height;
        
        posX=posX-posX%20;
        posY=posY-posY%20;
        
        for(int i=0;i<List.size();i++){
            if((posX==List.get(i).getX())&&(posY==List.get(i).getY())){
                ShowFood();
            }
        }
        food.SetPos(posX, posY);
    }
    
    public void ChainM(){
        for(int i = List.size()-1;i>0;i--){
                
            Character hor = List.get(i-1);
            Character ver = List.get(i);
            
            List.get(i).Select();
            ver.pil = hor.pil;
        }
        sHead.Select();
    }
    
    public boolean IsCrash(){
        
        int range = 10;
        int W = getWidth();
        int H = getHeight();
        
        if(sHead.getX()<=range){
            return true;
        }
        if(sHead.getY()<=range){
            return true;
        }
        if(sHead.getX()+sHead.size >= W-range){
            return true;
        }
        if(sHead.getY()+sHead.size >= H-range){
            return true;
        }
        for(int i = 1; i<List.size(); i++){
            int X = List.get(i).getX();
            int Y = List.get(i).getY();
            
            if((X == sHead.getX()) && (Y == sHead.getY())){
                return true;
            }
        }
        if((food.getX()==sHead.getX()) && (food.getY()==sHead.getY())){
            Tail();
            ShowFood();
            score += food.score;
            scoring(score);
            System.out.println(score);
        }
        return false;
    
    }
    
    public void scoring(int sc){
    
        String scr = "Score : ";
        tscore.setBounds(10, 0, 100, 50);
        tscore.setText(scr+sc);
        tscore.setFont(new Font(scr, Font.BOLD, 20));
        
    }
    
    public void start(){
    
        String scr2 = "Press ENTER to start";
        starter.setBounds(320, 200, 400, 100);
        starter.setText(scr2);
        starter.setFont(new Font(scr2, Font.BOLD, 30));
        
    }
    
    public void over(){
        String scr = "GAME OVER";
        over.setBounds(320, 200, 400, 100);
        over.setText(scr);
        over.setFont(new Font(scr, Font.BOLD, 50));
        new PanelOver().setVisible(true);
        
        JLabel lblRest = new JLabel();
        lblRest.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\restart.png")));
        lblRest.setBounds(450, 300, 50, 50);
        lblRest.setVisible(true);
        lblRest.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
                lblRest.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\restart2.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                lblRest.setIcon(new ImageIcon(resizeIcon("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\restart.png")));
            }            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        add(lblRest);
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
    
    class Movement implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
                if(sHead.pil!=Choice.right){
                    sHead.pil = Choice.left;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
                if(sHead.pil!=Choice.left){
                    sHead.pil = Choice.right;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
                if(sHead.pil!=Choice.down){
                    sHead.pil = Choice.up;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
                if(sHead.pil!=Choice.up){
                    sHead.pil = Choice.down;
                }
            }
            if(e.getKeyCode()== KeyEvent.VK_ENTER && IsCrash()==false){
                sMove.start();
                scoring(score);
                starter.setVisible(false);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }

    }
    
    class AutoMove implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ChainM();
            if(IsCrash()==true){
                sMove.stop();
                over();
            }
        }
    
    }
    
    
}