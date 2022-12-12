package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame implements ActionListener {

    private final UserDAO userDAO = new UserDAO();

    Gradient1 background = new Gradient1();
    JLabel text = new JLabel("Please Enter Your Car VIN Number");

    Gradient1 header =  new Gradient1();
    JLabel label = new JLabel("SafeCar");

    JTextField vinSearch =  new JTextField();
    JButton vinSearchButton = new JButton("Submit");

    Object[][] data = userDAO.getAllSameVin();
    JTable table = new JTable(data, new Object[]{"VIN","Name","Surname","Type", "Manufacturer", "Series", "Car Number", "Service Type", "Service Date"});
    JScrollPane scrollPane = new JScrollPane(table);
    JTableHeader Theader = table.getTableHeader();

    JTable tableSearch;
    JScrollPane scrollPaneSearch;
    JTableHeader Theader1;


    public UserPage(){

        background.add(header);
        header.setLayout(null);
        header.setSize(1600,100);
        header.add(label);
        label.setBounds(20,20,1000,50);
        label.setFont(new Font("Times New Roman", Font.BOLD, 38));

        add(background);
        background.setLayout(null);
        background.add(text);
        text.setBounds(480,100,600,100);
        text.setFont(new Font("Times New Roman", Font.BOLD, 38));

        background.add(vinSearch);
        vinSearch.setBounds(600,200,250,28);

        background.add(vinSearchButton);
        vinSearchButton.setBounds(900,200,100,28);
        vinSearchButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        vinSearchButton.setBackground(Color.decode("#5F727A"));
        vinSearchButton.setForeground(Color.white);
        vinSearchButton.setUI(new StyledButtonUI());
        vinSearchButton.addActionListener(this);

        setSize(1600,1000);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if( source == vinSearchButton){
            try{
                Object[][] searchData = userDAO.searchVin(vinSearch.getText());

                tableSearch = new JTable(searchData, new Object[]{"VIN","Name","Surname","Type", "Manufacturer", "Series", "Car Number", "Service Type", "Service Date"});
                scrollPaneSearch = new JScrollPane(tableSearch);
                Theader1 = tableSearch.getTableHeader();
                scrollPane.setVisible(false);

                background.add(scrollPaneSearch, BorderLayout.CENTER);
                scrollPaneSearch.setSize(1500,1000);
                scrollPaneSearch.setBounds(20,500,1500,1000);

                Theader1.setForeground(Color.WHITE);
                Theader1.setBackground(Color.decode("#5F727A"));
                Theader1.setFont(new Font("Calibri", Font.PLAIN,20));
                ((DefaultTableCellRenderer)Theader1.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

                tableSearch.setFont(new Font("Tahome", Font.BOLD, 15));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
