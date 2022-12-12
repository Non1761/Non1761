package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserTable extends JFrame implements ActionListener {

    private  final UserDAO userDAO = new UserDAO();
    private JTextField users = new JTextField();

    Object[][] data = userDAO.getAllData();
    JTable table = new JTable(data, new Object[]{"ID","Name","Surname","Birthdate", "E-mail address"});
    JScrollPane scrollPane = new JScrollPane(table);
    JTableHeader Theader = table.getTableHeader();

    JTable tableSearch;
    JScrollPane scrollPaneSearch;
    JTableHeader Theader1;

    JTable tableDeleted;
    JScrollPane scrollPaneDeleted;
    JTableHeader Theader2;

    JTextField search = new JTextField();
    JButton searchButton = new JButton("Search");

    JButton update = new JButton("Update");

    JTextField delete = new JTextField();
    JButton deleteButton = new JButton("Delete");


    public UserTable(){

        setTitle("Users List");
        setLayout(null);

        userDAO.fillUser();
        users.setText(userDAO.getAllUser());

        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setSize(1500,1000);
        scrollPane.setBounds(20,100,1500,1000);

        Theader.setForeground(Color.WHITE);
        Theader.setBackground(Color.decode("#5F727A"));
        Theader.setFont(new Font("Calibri", Font.PLAIN,20));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        table.setFont(new Font("Tahome", Font.BOLD, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

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

        add(delete);
        delete.setBounds(780,44,200,28);

        add(deleteButton);
        deleteButton.setBounds(1000,50,100,20);
        deleteButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        deleteButton.setBackground(Color.decode("#5F727A"));
        deleteButton.setForeground(Color.white);
        deleteButton.setUI(new StyledButtonUI());
        getContentPane().add(delete);
        deleteButton.addActionListener(this);

        add(update);
        update.setBounds(50,50,100,20);
        update.setFont(new Font("Calibri", Font.PLAIN, 15));
        update.setBackground(Color.decode("#5F727A"));
        update.setForeground(Color.white);
        update.setUI(new StyledButtonUI());
        update.addActionListener(this);


        setSize(1600,1000);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if( source == searchButton){
            try{
                Object[][] searchData = userDAO.search(search.getText());

                tableSearch = new JTable(searchData, new Object[]{"ID","Name","Surname","Birthdate", "E-mail address"});
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



            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if( source == deleteButton){
            try{
                userDAO.deleteById(Integer.parseInt(delete.getText()));
                data = userDAO.getAllData();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        else if (e.getSource() == update) {
            setVisible(false);
            new UserTable();
        }

    }
}
