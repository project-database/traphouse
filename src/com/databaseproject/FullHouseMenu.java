package com.databaseproject;

import javax.swing.*;
import java.awt.*;

public class FullHouseMenu extends JFrame {
    String data[][]={ {"101","Jan","100"},{"102","Piet","200"},{"101","Klaas","30"}};
    String column[]={"ID","Naam","Inleggeld"};

    private JTable tabel = new JTable(data, column);

    private JButton gastRegistreren = new JButton("Gast registreren");
    private JButton toernooiAanmaken = new JButton("Toernooi maken");


    public FullHouseMenu() throws HeadlessException {
        setTitle("FullHouse - menu");
        setDefaultCloseOperation(InlogScherm.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(new Dimension(800, 600));
        MenuComponent();
    }

    public void MenuComponent(){
        JPanel panel = new JPanel();

        add(new JScrollPane(tabel));
        panel.add(tabel.getTableHeader());
        panel.add(gastRegistreren);
        panel.add(toernooiAanmaken);
        GridLayout grid = new GridLayout(3, 4, 30, 20);
        Container content = this.getContentPane();
        content.setLayout(grid);
        add(panel);
        pack();
    }
}
