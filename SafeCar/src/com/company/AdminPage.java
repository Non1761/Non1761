package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AdminPage extends JFrame implements ActionListener {

    JPanel background = new JPanel();
    Gradient1 header =  new Gradient1();
    JLabel label = new JLabel("SafeCar");



    JPanel panel = new JPanel();

    BufferedImage myPicture1 = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\1.png"));
    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    BufferedImage myCar = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\1.png"));
    BufferedImage resizedCar = resizeImage(myCar,50,50);
    JLabel car = new JLabel(new ImageIcon(resizedCar));

    BufferedImage myLogo = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\6.png"));
    BufferedImage resizedLogo = resizeImage(myLogo,50,50);
    JLabel logo = new JLabel(new ImageIcon(resizedLogo));

    JButton add = new JButton("Add Vehicle");
    JButton service = new JButton("Add Service");
    JButton view1 = new JButton("View User List");
    JButton view2 = new JButton("View Vehicle List");
    JButton logout = new JButton("Logout");

    public AdminPage() throws IOException {
        add(background);
        background.setLayout(null);
        background.setBackground((Color.decode("#F8FFFF")));

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);
        header.add(label);
        label.setBounds(100,20,1000,50);
        label.setFont(new Font("Times New Roman", Font.BOLD, 38));

        header.add(logo);
        logo.setSize(500,500);
        logo.setBounds(0,0,140,90);

        background.add(panel);
        panel.setBackground(Color.decode("#2B2B2B"));
        panel.setBounds(850,250,405,400);
        panel.setLayout(null);

        panel.add(add);
        add.setBounds(100,35,200,30);
        add.setFont(new Font("Calibri", Font.PLAIN, 15));
        add.setBackground(Color.decode("#5F727A"));
        add.setForeground(Color.white);
        add.setUI(new StyledButtonUI());
        add.addActionListener(this);

        panel.add(service);
        service.setBounds(100,130,200,30);
        service.setFont(new Font("Calibri", Font.PLAIN, 15));
        service.setBackground(Color.decode("#5F727A"));
        service.setForeground(Color.white);
        service.setUI(new StyledButtonUI());
        service.addActionListener(this);

        panel.add(view1);
        view1.setBounds(100,230,200,30);
        view1.setFont(new Font("Calibri", Font.PLAIN, 15));
        view1.setBackground(Color.decode("#5F727A"));
        view1.setForeground(Color.white);
        view1.setUI(new StyledButtonUI());
        view1.addActionListener(this);

        panel.add(view2);
        view2.setBounds(100,330,200,30);
        view2.setFont(new Font("Calibri", Font.PLAIN, 15));
        view2.setBackground(Color.decode("#5F727A"));
        view2.setForeground(Color.white);
        view2.setUI(new StyledButtonUI());
        view2.addActionListener(this);

        header.add(logout);
        logout.setBounds(1350,50,100,28);
        logout.setFont(new Font("Calibri", Font.PLAIN, 15));
        logout.setBackground(Color.decode("#5F727A"));
        logout.setForeground(Color.white);
        logout.setUI(new StyledButtonUI());
        logout.addActionListener(this);

        background.add(car);
        car.setSize(200,500);
        car.setBounds(0,0,140,90);

        background.add(picLabel1);
        picLabel1.setSize(1600,900);
        picLabel1.setBounds(0,100,600,750);

        setSize(1600,1000);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == logout){
            try {
                setVisible(false);
                new HomePageWindow().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if (source == add){
            try {
                setVisible(false);
                new VehicleFrame().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if (source == view1){
            try {
                setVisible(false);
                new UserTable().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if (source == view2){
            try {
                setVisible(false);
                new VehicleList().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
