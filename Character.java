/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class Character extends JLabel{
    //atur ukuran snake
    public int size = 20;
    //atur default arah snake
    public int pil = Choice.down;
    
    Character(){
        //atur titik muncul dan ukuran
        setBounds(100, 100, size, size);
    }
    
    public void paint(Graphics g){
       
       super.paint(g);
       Graphics2D g2 = (Graphics2D)g;
       Ellipse2D head = new Ellipse2D.Double(1, 1, getWidth()-2, getHeight()-2);
       
       g2.setColor(Color.WHITE);
       g2.setStroke(new BasicStroke (2));
       g2.draw(head);
       g2.setColor(Color.red);
       g2.fill(head);
    
    }
    
    public void Left(){
        //get koordinat
        int posX = getX();
        int posY = getY();
        
        posX-=size;
        setBounds(posX, posY, size, size);
      
    }
    public void Right(){
        //get koordinat
        int posX = getX();
        int posY = getY();
        
        posX+=size;
        setBounds(posX, posY, size, size);
      
    }
    public void Up(){
        //get koordinat
        int posX = getX();
        int posY = getY();
        
        posY-=size;
        setBounds(posX, posY, size, size);
      
    }
    public void Down(){
        //get koordinat
        int posX = getX();
        int posY = getY();
        
        posY+=size;
        setBounds(posX, posY, size, size);
      
    }
     
    public Character Char(){
        
        Character c2 = new Character();
        int x = getX();
        int y = getY();
        
        c2.setBounds(x, y, size, size);
        c2.pil = -pil;
        c2.Select();
        c2.pil=pil;
        
        return c2;
        
    }
    
    public void Select(){
    
        if(pil == Choice.left){
            Left();
        }else if(pil == Choice.right){
                Right();
            }else if(pil == Choice.up){
                    Up();
                }else if(pil == Choice.down){
                        Down();
                    }
        
    }

    
}
