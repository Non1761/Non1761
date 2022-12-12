package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.ClassNotFoundException;

public class UserLogin extends JFrame implements ActionListener, FocusListener {
    Gradient1 background = new Gradient1();
    JLabel text = new JLabel("Login");

    Gradient1 header =  new Gradient1();
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

    JTextField mail = new JTextField(20);
    JLabel mailText = new JLabel("E-mail address");

    JPasswordField password = new JPasswordField(20);
    JLabel passwordText = new JLabel("Password");

    JButton login = new JButton("Login");
    JButton register = new JButton("Register");
    JButton menu = new JButton("Main");

    public UserLogin() throws IOException {

        setTitle("User Login");

        add(background);
        background.setLayout(null);
        background.add(text);
        text.setBounds(700,230,400,100);
        text.setFont(new Font("Times New Roman", Font.BOLD, 38));

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);

        header.add(label);
        label.setBounds(100,20,1000,50);
        label.setFont(new Font("Times New Roman", Font.BOLD, 38));

        header.add(logo);
        logo.setSize(500,500);
        logo.setBounds(0,0,140,90);

        background.add(mail);
        mail.addFocusListener(this);
        background.add(mailText);
        mailText.setBounds(550,380,200,40);
        mailText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mail.setBounds(650,380,210,28);

        background.add(password);
        password.addFocusListener(this);
        background.add(passwordText);
        passwordText.setBounds(550,440,200,40);
        passwordText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        password.setBounds(650,440,210,28);

        background.add(login);
        login.setBounds(700,520,100,28);
        login.setFont(new Font("Calibri", Font.PLAIN, 14));
        login.setBackground(Color.decode("#5F727A"));
        login.setForeground(Color.white);
        login.setUI(new StyledButtonUI());
        login.addActionListener(this);

        header.add(menu);
        menu.setBounds(1260,50,100,28);
        menu.setFont(new Font("Calibri", Font.PLAIN, 15));
        menu.setBackground(Color.decode("#5F727A"));
        menu.setForeground(Color.white);
        menu.setUI(new StyledButtonUI());
        menu.addActionListener(this);

        header.add(register);
        register.setBounds(1400,50,100,28);
        register.setFont(new Font("Calibri", Font.PLAIN, 14));
        register.setBackground(Color.decode("#5F727A"));
        register.setForeground(Color.white);
        register.setUI(new StyledButtonUI());
        register.addActionListener(this);


        setSize(1600,1000);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
        String name = mail.getText();
        String pass = String.valueOf(password.getPassword());
        Statement statement = null;
        ResultSet resultSet = null;
        final var source = e.getSource();
        if (source == register){
            try {
                setVisible(false);
                new UserRegistration().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else if (source == login){
            String mailDB = "";
            String passwordDB = "";
            try
            {
                statement = ConnectionDB.connect().createStatement();
                resultSet = statement.executeQuery("select e_mail, password from userlogin");
                while(resultSet.next())
                {
                    mailDB = resultSet.getString("e_mail");
                    passwordDB = resultSet.getString("password");

                    if(name.equals(mailDB) && pass.equals(passwordDB))
                    {
                        setVisible(false);
                        new UserPage().setVisible(true);
                    } else {
                        setVisible(false);
                        new UserLogin().setVisible(true);
                    }
                }
            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
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
    }

    @Override
    public void focusGained(FocusEvent e) {
        ((JTextComponent) e.getSource()).setBackground(Color.WHITE);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource().equals(mail))
        {
            validationForEmail(mail);
        }
        else if(e.getSource().equals(password))
        {
            validationForPassword(password);
        }
    }

    public void validationForEmail(JTextComponent comp)
    {
        String text=comp.getText();
        if(text.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            comp.setBackground(Color.GREEN);
        else
            comp.setBackground(Color.RED);
    }
    public void validationForPassword(JTextComponent comp)
    {
        String temp=comp.getText();
        if (temp.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
            comp.setBackground(Color.GREEN);
        }
        else
            comp.setBackground(Color.RED);
    }


}
