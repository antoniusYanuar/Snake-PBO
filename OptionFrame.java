/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
        setTitle("Snake Java");
        getContentPane().setBackground(Color.lightGray);
        getContentPane().setLayout(null);
        
        JPanel pnf = new JPanel();
        pnf.setBounds(0,0,200, 200);
        pnf.setBackground(Color.lightGray);
        add(pnf);
        
        JButton btn3 = new JButton("Save");
        btn3.setPreferredSize(new Dimension(150, 40));
        btn3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                OptionFrame.super.setVisible(false);
                OptionFrame.super.dispose();
            }
        });
        
        JCheckBox checkbox = new JCheckBox("Fullscreen");
        JButton btn4 = new JButton("Apply");
        btn4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                if (checkbox.isSelected()) {
                    SG.setSwidth(FSwidth);
                    SG.setSheight(FSheight);
                    new Background(SG.getSwidth(),SG.getSheight()).setVisible(true);
                    
                }
            }
        });        
        
        pnf.add(checkbox);
        pnf.add(btn4);
        pnf.add(btn3);
    }
}
