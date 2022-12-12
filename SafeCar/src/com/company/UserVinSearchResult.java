package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserVinSearchResult extends JFrame implements ActionListener {

    private final ServiceDAO serviceDAO = new ServiceDAO();
    private final UserPage userPage = new UserPage();

    Object[][] searchData = serviceDAO.search(userPage.vinSearch.getText());
    JTable table = new JTable(searchData, new Object[]{"ID","VIN","Service Type","Service Date"});
    JScrollPane scrollPane = new JScrollPane(table);
    JTableHeader Theader = table.getTableHeader();

    public UserVinSearchResult(){

        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setSize(1500,1000);
        scrollPane.setBounds(20,100,1500,1000);

        Theader.setForeground(Color.WHITE);
        Theader.setBackground(Color.decode("#5F727A"));
        Theader.setFont(new Font("Calibri", Font.PLAIN,20));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        table.setFont(new Font("Tahome", Font.BOLD, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1600,1000);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
