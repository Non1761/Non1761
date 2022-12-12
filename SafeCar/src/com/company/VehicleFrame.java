package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VehicleFrame extends JFrame implements ActionListener {

    JPanel background = new JPanel();
    JLabel text = new JLabel("Add vehicle");

    Gradient2 header =  new Gradient2();
    JLabel name = new JLabel("SafeCar");

    JPanel panel = new JPanel();

    JLabel type = new JLabel("Type");
    String typeString[]={"Hatchback","Sedan","SUV (Sports Utility Vehicle)","MUV (Multi-Utility Vehicle)","Coupe","Convertible","Pickup Trucks","Wagon","Micro"};
    JComboBox typeInput=new JComboBox(typeString);

    JLabel manufacturer = new JLabel("Manufacturer");
    String manufacturerString[]={"Abarth","Alfa Romeo","Aston Martin","Audi","Bentley","BMW","Bugatti","Cadillac","Chevrolet","Chrysler","Citroën","Dacia","Daewoo","Daihatsu","Dodge","Donkervoort","DS","Ferrari","Fiat","Fisker","Ford","Honda","Hummer","Hyundai","Infiniti","Iveco","Jaguar","Jeep","Kia","KTM","Lada","Lamborghini","Lancia","Land Rover","Landwind","Lexus","Lotus","Maserati","Maybach","Mazda","McLaren","Mercedes-Benz","MG","Mini","Mitsubishi","Morgan","Nissan","Opel","Peugeot","Porsche","Renault","Rolls-Royce","Rover","Saab","Seat","Skoda","Smart","SsangYong","Subaru","Suzuki","Tesla","Toyota","Volkswagen","Volvo"};
    JComboBox manufacturerInput=new JComboBox(manufacturerString);

    JLabel series = new JLabel("Series");
    JTextField seriesInput = new JTextField(20);

    JLabel carNumber = new JLabel("Car Number");
    JTextField carNumberInput = new JTextField(20);

    JLabel vin = new JLabel("VIN Number");
    JTextField vinInput = new JTextField(20);

    JLabel ownerName = new JLabel("Owner Name");
    JTextField ownerNameInput = new JTextField(20);

    JLabel ownerSurname = new JLabel("Owner Surname");
    JTextField ownerSurnameInput = new JTextField(20);

    JButton add = new JButton("Add");
    JButton viewVehicles = new JButton("View Vehicles");

    public VehicleFrame() throws IOException{
        setTitle("Vehicle");
        add(background);
        background.setBackground(Color.white);
        background.setLayout(null);

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);
        header.add(name);
        name.setBounds(20,20,1000,50);
        name.setFont(new Font("Times New Roman", Font.BOLD, 38));

        background.add(panel);
        panel.setBackground(Color.decode("#CDD3DF"));
        panel.setBounds(445,130,600,640);
        panel.setLayout(null);

        panel.add(text);
        text.setBounds(200,10,190,50);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        panel.add(type);
        panel.add(typeInput);
        type.setBounds(20,80,100,40);
        type.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        typeInput.setBounds(20,120,200,28);

        panel.add(manufacturer);
        panel.add(manufacturerInput);
        manufacturer.setBounds(20,165,150,40);
        manufacturer.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        manufacturerInput.setBounds(20,205,200,28);

        panel.add(series);
        panel.add(seriesInput);
        series.setBounds(20,250,150,40);
        series.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        seriesInput.setBounds(20,290,200,28);

        panel.add(carNumber);
        panel.add(carNumberInput);
        carNumber.setBounds(20,335,150,40);
        carNumber.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        carNumberInput.setBounds(20,375,200,28);

        panel.add(vin);
        panel.add(vinInput);
        vin.setBounds(300,80,150,40);
        vin.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        vinInput.setBounds(300,120,200,28);

        panel.add(ownerName);
        panel.add(ownerNameInput);
        ownerName.setBounds(20,420,150,40);
        ownerName.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        ownerNameInput.setBounds(20,460,200,28);

        panel.add(ownerSurname);
        panel.add(ownerSurnameInput);
        ownerSurname.setBounds(20,505,150,40);
        ownerSurname.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        ownerSurnameInput.setBounds(20,545,200,28);

        panel.add(add);
        add.setBounds(460,580,100,28);
        add.setFont(new Font("Calibri", Font.PLAIN, 14));
        add.setBackground(Color.decode("#5F727A"));
        add.setForeground(Color.white);
        add.setUI(new StyledButtonUI());
        add.addActionListener(this);

        background.add(viewVehicles);
        viewVehicles.setBounds(1200,710,200,28);
        viewVehicles.setFont(new Font("Calibri", Font.PLAIN, 14));
        viewVehicles.setBackground(Color.decode("#5F727A"));
        viewVehicles.setForeground(Color.white);
        viewVehicles.setUI(new StyledButtonUI());
        viewVehicles.addActionListener(this);

        setSize(1600,1000);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if(source == add){
                String series = seriesInput.getText().toString();
                String carNumber = carNumberInput.getText().toString();
                String vin = vinInput.getText().toString();
                String ownerName = ownerNameInput.getText().toString();
                String ownerSurname = ownerSurnameInput.getText().toString();

                if( series.equals("")){
                    JOptionPane.showMessageDialog(null, "You have unfilled required fields");
                }
                else if( carNumber.equals("")){
                    JOptionPane.showMessageDialog(null, "You have unfilled required field(s)");
                }
                else if( vin.equals("")){
                    JOptionPane.showMessageDialog(null, "You have unfilled required field(s)");
                }
                else if( ownerName.equals("")){
                    JOptionPane.showMessageDialog(null, "You have unfilled required fields");
                }
                else if( ownerSurname.equals("")){
                    JOptionPane.showMessageDialog(null, "You have unfilled required fields");
                }
                else {
                    try {
                        Vehicle vehicle = new Vehicle();
                        vehicle.setType(String.valueOf(typeInput.getSelectedItem()));
                        vehicle.setManufacturer(String.valueOf(manufacturerInput.getSelectedItem()));
                        vehicle.setSeries(seriesInput.getText());
                        vehicle.setCar_number(carNumberInput.getText());
                        vehicle.setVin(vinInput.getText());
                        vehicle.setOwner_name(ownerNameInput.getText());
                        vehicle.setOwner_surname(ownerSurnameInput.getText());
                        VehicleDAO.insertVehicleRow(vehicle);
                        setVisible(false);
                        new VehicleFrame().setVisible(true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
        }

        else if (source == viewVehicles){
            try {
                setVisible(false);
                new VehicleList().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
