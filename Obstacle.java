/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class Obstacle extends JLabel implements Runnable{
    
    private boolean reset = false;

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }
    
    
    Obstacle(){
    
    }
     
    @Override
    public void run() {
        
        while(true){
            
            reset = true;
            Random rand = new Random();
            int x = rand.nextInt(950);
            int y = rand.nextInt(690);
            
            this.setLocation(x, y);
            
            repaint();
            
            try{
                
                Thread.sleep(3000);
                reset = false;
                
            }catch(InterruptedException e){
                
                System.out.println(System.err);
                
            }
            
        }
        
    }
    
    public Obstacle obsta(){
    
        Obstacle o2 = new Obstacle();
        return o2;
            
    }
    
}
