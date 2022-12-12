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


public class UserRegistration extends JFrame implements ActionListener, FocusListener{

    Gradient2 test = new Gradient2();

    Gradient1 background = new Gradient1();
    JLabel text = new JLabel("Registration");

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

    JTextField name = new JTextField(20);
    JLabel nameText = new JLabel("Enter your name");

    JTextField surname = new JTextField(20);
    JLabel surnameText = new JLabel("Enter your surname");

    JTextField birthdate = new JTextField(20);
    JLabel birthdateText = new JLabel("Enter your birthdate (yyyy-mm-dd)");

    JTextField mail = new JTextField(20);
    JLabel mailText = new JLabel("Enter your e-mail address");

    JPasswordField password = new JPasswordField(20);
    JLabel passwordText = new JLabel("Enter your password");

//    JPasswordField confirmPassword = new JPasswordField(20);
//    JLabel confirmPasswordText = new JLabel("Repeat your password");

    JButton submit = new JButton("Submit");
    JButton login = new JButton("Login");
    JButton reset = new JButton("Reset");
    JButton menu = new JButton("Main");

    public UserRegistration() throws IOException {

        add(background);
        background.setLayout(null);
        background.add(text);
        text.setBounds(640,130,400,100);
        text.setFont(new Font("Times New Roman", Font.BOLD, 38));

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);

        header.add(logo);
        logo.setSize(500,500);
        logo.setBounds(0,0,140,90);

        header.add(label);
        label.setBounds(100,20,1000,50);
        label.setFont(new Font("Times New Roman", Font.BOLD, 38));

        background.add(name);
        background.add(nameText);
        nameText.setBounds(540,270,200,40);
        nameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        name.setBounds(640,270,210,28);

        background.add(surname);
        background.add(surnameText);
        surnameText.setBounds(520,330,200,40);
        surnameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        surname.setBounds(640,330,210,28);

        background.add(birthdate);
        background.add(birthdateText);
        birthdateText.setBounds(425,390,250,40);
        birthdateText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        birthdate.setBounds(640,390,210,28);


        background.add(mail);
        background.add(mailText);
        mailText.setBounds(485,450,200,40);
        mailText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mail.setBounds(640,450,210,28);

        background.add(password);
        background.add(passwordText);
        passwordText.setBounds(510,510,200,40);
        passwordText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        password.setBounds(640,510,210,28);

//        background.add(confirmPassword);
//        background.add(confirmPasswordText);
//        confirmPasswordText.setBounds(500,570,200,40);
//        confirmPasswordText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//        confirmPassword.setBounds(640,570,210,28);
//        getContentPane().add(confirmPassword);

        header.add(menu);
        menu.setBounds(1400,50,100,28);
        menu.setFont(new Font("Calibri", Font.PLAIN, 15));
        menu.setBackground(Color.decode("#5F727A"));
        menu.setForeground(Color.white);
        menu.setUI(new StyledButtonUI());
        menu.addActionListener(this);

        header.add(login);
        login.setBounds(1260,50,100,28);
        login.setFont(new Font("Calibri", Font.PLAIN, 15));
        login.setBackground(Color.decode("#5F727A"));
        login.setForeground(Color.white);
        login.setUI(new StyledButtonUI());
        login.addActionListener(this);

        background.add(submit);
        submit.setBounds(750,630,100,28);
        submit.setFont(new Font("Calibri", Font.PLAIN, 15));
        submit.setBackground(Color.decode("#5F727A"));
        submit.setForeground(Color.white);
        submit.setUI(new StyledButtonUI());
        submit.addActionListener(this);

        background.add(reset);
        reset.setBounds(630,630,100,28);
        reset.setFont(new Font("Calibri", Font.PLAIN, 15));
        reset.setBackground(Color.decode("#5F727A"));
        reset.setForeground(Color.white);
        reset.setUI(new StyledButtonUI());
        reset.addActionListener(this);


        setSize(1600,1000);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        final var source = e.getSource();
        if (source == menu){
            try {
                setVisible(false);
                new HomePageWindow().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if (source == login){
            try {
                setVisible(false);
                new UserLogin().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if (source == reset){
            try {
                setVisible(false);
                new UserRegistration().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if(source == submit){


            if( name.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required fields");
            }
            else if( surname.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required fields");
            }
            else if( birthdate.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required fields");
            }
            else if( mail.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required fields");
            }
            else if( password.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required fields");
            }
            else {
                try {
                    User user = new User();
                    user.setFirst_name(name.getText());
                    user.setLast_name(surname.getText());
                    user.setBirthdateStringImpl(birthdate.getText());
                    user.setMail(mail.getText());
                    user.setPassword(String.valueOf(password.getPassword()));
                    UserDAO.insertUserRow(user);
                    setVisible(false);
                    new UserLogin().setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

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
        if(text.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,5}$"))
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
