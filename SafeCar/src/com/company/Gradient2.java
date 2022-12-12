package com.company;

import java.awt.*;
import javax.swing.*;

public class Gradient2 extends JPanel {
    public Gradient2(){
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D gd = (Graphics2D) g.create();
        super.paintComponent(g);
        gd.setPaint(new GradientPaint(0,80,Color.decode("#FBFBFB"),0, getHeight(),Color.decode("#8B9098")));
        gd.fillRect(0,0,getWidth(),getHeight());
        gd.dispose();
    }

}
