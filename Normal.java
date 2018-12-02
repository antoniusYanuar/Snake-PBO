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

/**
 *
 * @author Asus
 */
public class Normal extends Food{
    
    int score = 10;
    int foodS = 20;
    
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D head = new Ellipse2D.Double(0, 0, foodS-2, foodS-2);
        
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke (3));
        g2.draw(head);
        g2.setColor(Color.BLUE);
        g2.fill(head);
        
    }
    @Override
     public void SetPos(int posX, int posY){
    
        setBounds(posX, posY, foodS, foodS);
    
    }
    
}
