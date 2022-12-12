package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceList extends JFrame implements ActionListener {

    private final ServiceDAO serviceDAO = new ServiceDAO();
    private JTextField services = new JTextField();

    Object[][] data = serviceDAO.getAllData();
    JTable table = new JTable(data, new Object[]{"ID","VIN","Service Type","Service Date"});
    JScrollPane scrollPane = new JScrollPane(table);
    JTableHeader Theader = table.getTableHeader();

    JTable tableSearch;
    JScrollPane scrollPaneSearch;
    JTableHeader Theader1;

    JButton addVehicle = new JButton("Add Vehicle");
    JButton addService = new JButton("Add Service");
    JButton viewVehicle = new JButton("View Vehicle");

    JTextField search = new JTextField();
    JButton searchButton = new JButton("Search");

    JButton update = new JButton("Update");

    JTextField delete = new JTextField();
    JButton deleteButton = new JButton("Delete");


    public ServiceList(){

        setTitle("Service List");
        setLayout(null);

        serviceDAO.fillService();
        services.setText(serviceDAO.getAllService());

        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setSize(1500,1000);
        scrollPane.setBounds(20,100,1500,1000);

        Theader.setForeground(Color.WHITE);
        Theader.setBackground(Color.decode("#5F727A"));
        Theader.setFont(new Font("Calibri", Font.CENTER_BASELINE,20));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        table.setFont(new Font("Tahome", Font.BOLD, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

        add(addVehicle);
        addVehicle.setBounds(50,50,150,28);
        addVehicle.setFont(new Font("Calibri", Font.PLAIN, 15));
        addVehicle.setBackground(Color.decode("#5F727A"));
        addVehicle.setForeground(Color.white);
        addVehicle.setUI(new StyledButtonUI());
        addVehicle.addActionListener(this);

        add(addService);
        addService.setBounds(220,50,150,28);
        addService.setFont(new Font("Calibri", Font.PLAIN, 15));
        addService.setBackground(Color.decode("#5F727A"));
        addService.setForeground(Color.white);
        addService.setUI(new StyledButtonUI());
        addService.addActionListener(this);

        add(viewVehicle);
        viewVehicle.setBounds(400,50,150,28);
        viewVehicle.setFont(new Font("Calibri", Font.PLAIN, 15));
        viewVehicle.setBackground(Color.decode("#5F727A"));
        viewVehicle.setForeground(Color.white);
        viewVehicle.setUI(new StyledButtonUI());
        viewVehicle.addActionListener(this);

        add(search);
        search.setBounds(1150,44,200,28);

        add(searchButton);
        searchButton.setBounds(1370,50,100,20);
        searchButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        searchButton.setBackground(Color.decode("#5F727A"));
        searchButton.setForeground(Color.white);
        searchButton.setUI(new StyledButtonUI());

        getContentPane().add(search);
        searchButton.addActionListener(this);

        add(update);
        update.setBounds(660,50,100,28);
        update.setFont(new Font("Calibri", Font.PLAIN, 15));
        update.setBackground(Color.decode("#5F727A"));
        update.setForeground(Color.white);
        update.setUI(new StyledButtonUI());
        update.addActionListener(this);

        add(delete);
        delete.setBounds(780,44,200,28);

        add(deleteButton);
        deleteButton.setBounds(1000,50,100,28);
        deleteButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        deleteButton.setBackground(Color.decode("#5F727A"));
        deleteButton.setForeground(Color.white);
        deleteButton.setUI(new StyledButtonUI());
        deleteButton.addActionListener(this);

        setSize(1600, 1000);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == addVehicle){
            try {
                setVisible(false);
                new VehicleFrame().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if( source == searchButton){
            try{
                Object[][] searchData = serviceDAO.search(search.getText());

                tableSearch = new JTable(searchData, new Object[]{"ID","VIN","Service Type","Service Date"});
                scrollPaneSearch = new JScrollPane(tableSearch);
                Theader1 = tableSearch.getTableHeader();
                scrollPane.setVisible(false);

                add(scrollPaneSearch, BorderLayout.CENTER);
                scrollPaneSearch.setSize(1500,1000);
                scrollPaneSearch.setBounds(20,100,1500,1000);

                Theader1.setForeground(Color.WHITE);
                Theader1.setBackground(Color.decode("#5F727A"));
                Theader1.setFont(new Font("Calibri", Font.CENTER_BASELINE,20));
                ((DefaultTableCellRenderer)Theader1.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

                tableSearch.setFont(new Font("Tahome", Font.BOLD, 15));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//                add(update);
//                update.setBounds(100,100,100,20);
//                update.addActionListener(this);


            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
