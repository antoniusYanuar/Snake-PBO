/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import SnakeDAO.Conn;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
    public Normal food = new Normal();
    public Special food2 = new Special();
    public Obstacle ob = new Obstacle(); 
    public Conn con = new Conn();
    public Timer sMove = null;
    public Random rand = null;
    public ArrayList<Character> List = new ArrayList();
    public ArrayList<Obstacle> List2 = new ArrayList();
    public JLabel tscore = new JLabel();
    public JLabel starter = new JLabel();
    public JLabel over = new JLabel();
    public int score=10;
    Thread t = new Thread(ob);  

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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
            tail();
        }
        
        showFood();
        showObs();
        add(sHead);

        
        add(over);
        add(starter);
        add(tscore);
        start();
    }  
   
    public void tail(){
        Character k = List.get(List.size()-1).charr();
        List.add(k);
        add(k);
    }
    
    public void showFood(){
        
        int width = getWidth()-30-food.foodS;
        int height = getHeight()-30-food.foodS;
        
        int posX = 30+Math.abs(rand.nextInt())%width;
        int posY = 30+Math.abs(rand.nextInt())%height;
        
        posX=posX-posX%20;
        posY=posY-posY%20;
        
        for(int i=0;i<List.size();i++){
            if((posX==List.get(i).getX())&&(posY==List.get(i).getY())){
                showFood();
            }
        }
        if((score % 30) == 0){
            remove(food);
            add(food2);
            food2.SetPos(posX, posY);
        }else{
            remove(food2);
            add(food);
            food.SetPos(posX, posY);
        }
    }
    
    public void showObs(){
        
        ob.setIcon(new ImageIcon(resizeObs("D:\\Kuliah\\Semester_3\\Prak PBO\\CobaGui\\img\\obs.png")));
        ob.setBounds(100, 100, 20, 20);
        
        this.add(ob);
        t.start();
    }
    
    
    
    public void chainM(){
        for(int i = List.size()-1;i>0;i--){
                
            Character hor = List.get(i-1);
            Character ver = List.get(i);
            
            List.get(i).select();
            ver.pil = hor.pil;
        }
        sHead.select();
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
        if(intersect(sHead, ob)){
            return true;
        }
        for(int i = 1; i<List.size(); i++){
            int X = List.get(i).getX();
            int Y = List.get(i).getY();
            
            if((X == sHead.getX()) && (Y == sHead.getY())){
                return true;
            }
        }
        if((intersect(sHead, food))||(intersect(sHead, food2))){
            tail();
            showFood();
            if((intersect(sHead, food2))){
                score += food2.score;
            }else{
                score += food.score;
            }
            scoring(score);
            System.out.println(score);
        }
        return false;
        
    }
    
    public void scoring(int sc){
    
        String scr = "Score : ";
        tscore.setBounds(10, 0, 250, 50);
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
        PanelOver po = new PanelOver();
        po.showScore(score);
        po.setVisible(true);
        
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
    
    private Image resizeObs(String url){
        Image img1 = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            img1 = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        
        return img1;
    }

    private boolean intersect(JLabel sHead1, JLabel obj) {
        Area a1 = new Area(sHead1.getBounds());
        Area a2 = new Area(obj.getBounds());
        return a1.intersects(a2.getBounds2D());
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
            chainM();
            if(IsCrash()==true){
                sMove.stop();
                t.stop();
                over();
            }
        }
    
    }
    
    
}