/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobagui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class LeaderBoard extends JFrame{
     public int height = 400;
    public int width = 400;
    LeaderBoard(){
        initAll();    
        
    }
    
    private void initAll(){
        JFrame j = new JFrame();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100,100,width,height);
        setResizable(false);
        setTitle("Snake Java");
        getContentPane().setBackground(Color.lightGray);
        getContentPane().setLayout(null);
        
        JPanel pnf = new JPanel();
        pnf.setBounds(0,0,200, 200);
        pnf.setBackground(Color.lightGray);
        add(pnf);
        
        JButton btn1 = new JButton("Ok");
        btn1.setBounds(150, 150, 30, 20);
    }
}
