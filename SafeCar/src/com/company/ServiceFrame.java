package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ServiceFrame extends JFrame implements ActionListener {

    JPanel background = new JPanel();
    JLabel text = new JLabel("Add service");

    Gradient2 header =  new Gradient2();
    JLabel name = new JLabel("SafeCar");

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

    JPanel panel = new JPanel();

    JLabel service_type = new JLabel("Service Type");
    String typeString[]={"Air Condition","Air Filter","Battery","Belts","Body/Chassis","Brake Fluid","Brake Pad","Brake Pad","Brake Replacement","Cooling System", "Engine Repair", "Fuel Filter", "Fuel Pump", "Glass/Mirrors", "Heating System", "Horn", "Inspection","Lights","New Tires","Oil Change", "Oil Filter",  "Radiator", "Rotate Tires", "Seat Belts", "Spark Plug", "Steering System", "Suspension System","Technical Control", "Tire Pressure", "ransmission on Fluid", "Wheel alignment", "Windshield Wipers"};

    JComboBox typeInput=new JComboBox(typeString);

    JLabel service_date = new JLabel("Service Date");
    JTextField dateInput = new JTextField(20);

    JLabel vin = new JLabel("VIN Number");
    JTextField vinInput = new JTextField(20);

    JButton add = new JButton("Add");
    JButton viewService = new JButton("View Service");

    public ServiceFrame() throws IOException {

        setTitle("Service");
        add(background);
        background.setBackground(Color.white);
        background.setLayout(null);

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);

        header.add(name);
        name.setBounds(100,20,1000,50);
        name.setFont(new Font("Times New Roman", Font.BOLD, 38));

        header.add(logo);
        logo.setSize(500,500);
        logo.setBounds(0,0,140,90);

        background.add(panel);
        panel.setBackground(Color.decode("#CDD3DF"));
        panel.setBounds(445,130,600,640);
        panel.setLayout(null);

        panel.add(text);
        text.setBounds(200,10,190,50);
        text.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 30));

        panel.add(vin);
        panel.add(vinInput);
        vin.setBounds(20,80,120,40);
        vin.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        vinInput.setBounds(20,120,200,28);

        panel.add(service_type);
        panel.add(typeInput);
        service_type.setBounds(20,200,150,40);
        service_type.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        typeInput.setBounds(20,240,200,28);

        panel.add(service_date);
        panel.add(dateInput);
        service_date.setBounds(20,320,150,40);
        service_date.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        dateInput.setBounds(20,360,200,28);

        panel.add(add);
        add.setBounds(460,580,100,28);
        add.setFont(new Font("Calibri", Font.PLAIN, 14));
        add.setBackground(Color.decode("#5F727A"));
        add.setForeground(Color.white);
        add.setUI(new StyledButtonUI());
        add.addActionListener(this);

        background.add(viewService);
        viewService.setBounds(1200,710,200,28);
        viewService.setFont(new Font("Calibri", Font.PLAIN, 14));
        viewService.setBackground(Color.decode("#5F727A"));
        viewService.setForeground(Color.white);
        viewService.setUI(new StyledButtonUI());
        viewService.addActionListener(this);

        setSize(1600,1000);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if(source == add){
//            String vin = vinInput.getText().toString();
//            String service_date =dateInput.getText().toString();

            if( vin.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required fields");
            }
            else if( service_date.equals("")){
                JOptionPane.showMessageDialog(null, "You have unfilled required field(s)");
            }
            else {
                try {
                    Service service = new Service();
                    service.setVin(vinInput.getText());
                    service.setService_type(String.valueOf(typeInput.getSelectedItem()));
                    service.setServiceDateStringImpl(dateInput.getText());
                    ServiceDAO.insertServiceRow(service);
                    setVisible(false);
                    new ServiceFrame().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }

    }
}
