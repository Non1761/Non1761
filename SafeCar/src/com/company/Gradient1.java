package com.company;

import java.awt.*;
import javax.swing.*;

public class Gradient1 extends JPanel {
    public Gradient1(){
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D gd = (Graphics2D) g.create();
        super.paintComponent(g);
        gd.setPaint(new GradientPaint(0,90,Color.decode("#F8FFFF"),0, getHeight(),Color.decode("#5F727A")));
        gd.fillRect(0,0,getWidth(),getHeight());
        gd.dispose();
    }

}
