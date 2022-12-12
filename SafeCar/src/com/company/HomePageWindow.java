package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HomePageWindow extends JFrame implements ActionListener {

    JPanel background = new JPanel(new GridLayout(1,2));
    Gradient1 header = new Gradient1();
    JLabel name = new JLabel("SafeCar");

    BufferedImage myPicture1 = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\1.png"));
    BufferedImage myPicture2 = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\about1.png"));
    BufferedImage myPicture5 = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\why.png"));
    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
    JLabel picLabel3 = new JLabel("About us");
    JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
    JLabel picLabel4 = new JLabel("Why choose us");
    JLabel picLabel5 = new JLabel(new ImageIcon(myPicture5));

    JButton menu = new JButton("Main Menu");
    JButton login = new JButton("Login");
    JButton signup = new JButton("Register");

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    BufferedImage myLogo = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\6.png"));
    BufferedImage resizedLogo = resizeImage(myLogo,50,50);
    JLabel logo = new JLabel(new ImageIcon(resizedLogo));


    public HomePageWindow() throws IOException {
        setTitle("Home Page");
        header.setLayout(null);

        add(header);
        header.setSize(1600,100);
        header.add(logo);
        logo.setSize(500,500);
        logo.setBounds(0,0,140,90);

        name.setFont(new Font("Times New Roman", Font.BOLD, 38));
        header.add(name);
        name.setBounds(110,20,1000,50);

        header.add(menu);
        menu.setBounds(1135,35,100,25);
        menu.setFont(new Font("Calibri", Font.PLAIN, 15));
        menu.setBackground(Color.decode("#5F727A"));
        menu.setForeground(Color.white);
        menu.setUI(new StyledButtonUI());
        menu.addActionListener(this);

        header.add(login);
        login.setBounds(1250,35,85,25);
        login.setFont(new Font("Calibri", Font.PLAIN, 15));
        login.setBackground(Color.decode("#5F727A"));
        login.setForeground(Color.white);
        login.setUI(new StyledButtonUI());
        login.addActionListener(this);

        header.add(signup);
        signup.setBounds(1350,35,85,25);
        signup.setFont(new Font("Calibri", Font.PLAIN, 15));
        signup.setBackground(Color.decode("#5F727A"));
        signup.setForeground(Color.white);
        signup.setUI(new StyledButtonUI());
        signup.addActionListener(this);

        background.setBackground(Color.decode("#F8FFFF"));
        background.setLayout(null);
        add(background);
        background.setSize(1360,720);

        background.add(picLabel1);
        picLabel1.setSize(600,1000);
        picLabel1.setBounds(0,0,600,1000);

        background.add(picLabel3);
        picLabel3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        picLabel3.setBounds(700,0,750,400);

        background.add(picLabel2);
        picLabel2.setBounds(710,200,700,280);

        background.add(picLabel4);
        picLabel4.setFont(new Font("Times New Roman", Font.BOLD, 30));
        picLabel4.setBounds(700,300,750,400);

        background.add(picLabel5);
        picLabel5.setBounds(690,450,750,400);


        setSize(1600,1000);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == signup){
            try {
                setVisible(false);
                new UserRegistration().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (source == menu){
            try {
                setVisible(false);
                new HomePageWindow().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (source == login){
            try {
                setVisible(false);
                new Roles().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}

