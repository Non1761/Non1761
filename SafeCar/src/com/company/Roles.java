package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Roles extends JFrame implements ActionListener {

    Gradient1 background = new Gradient1();

    Gradient1 header = new Gradient1();
    JLabel label = new JLabel("SafeCar");

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

    JLabel title = new JLabel("Choose your role");

    JLabel admin = new JLabel("Login as admin");
    JButton adminButton = new JButton("Admin");

    JLabel user = new JLabel("Login as a user");
    JButton userButton = new JButton("User");

    JButton menu = new JButton("Main Menu");
    JButton signup = new JButton("Register");

    public Roles() throws IOException {

        setTitle("Roles");

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);

        add(header);
        header.setSize(1600,100);
        header.add(logo);
        logo.setSize(500,500);
        logo.setBounds(0,0,140,90);

        header.add(label);
        label.setBounds(100,20,1000,50);
        label.setFont(new Font("Times New Roman", Font.BOLD, 38));

        header.add(menu);
        menu.setBounds(1270,35,100,25);
        menu.setFont(new Font("Calibri", Font.PLAIN, 15));
        menu.setBackground(Color.decode("#5F727A"));
        menu.setForeground(Color.white);
        menu.setUI(new StyledButtonUI());
        menu.addActionListener(this);

        header.add(signup);
        signup.setBounds(1400,35,85,25);
        signup.setFont(new Font("Calibri", Font.PLAIN, 15));
        signup.setBackground(Color.decode("#5F727A"));
        signup.setForeground(Color.white);
        signup.setUI(new StyledButtonUI());
        signup.addActionListener(this);

        add(background);
        background.setLayout(null);
        background.add(title);
        title.setBounds(620,120,400,100);
        title.setFont(new Font("Times New Roman", Font.BOLD, 38));

        background.add(admin);
        background.add(adminButton);
        admin.setBounds(250,350,400,100);
        admin.setFont(new Font("Times New Roman", Font.PLAIN,38));
        adminButton.setBounds(270,470,200,50);
        adminButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        adminButton.setBackground(Color.decode("#5F727A"));
        adminButton.setForeground(Color.white);
        adminButton.setUI(new StyledButtonUI());
        adminButton.addActionListener(this);

        background.add(user);
        background.add(userButton);
        user.setBounds(950,350,400,100);
        user.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        userButton.setBounds(970,470,200,50);
        userButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        userButton.setBackground(Color.decode("#5F727A"));
        userButton.setForeground(Color.white);
        userButton.setUI(new StyledButtonUI());
        userButton.addActionListener(this);


        setSize(1600,1000);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == adminButton){
            try {
                setVisible(false);
                new AdminLogin().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if (source == userButton){
            try {
                setVisible(false);
                new UserLogin().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else if (source == menu){
            try {
                setVisible(false);
                new HomePageWindow().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else if (source == signup){
            try {
                setVisible(false);
                new UserRegistration().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
