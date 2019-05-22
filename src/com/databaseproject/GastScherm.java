package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GastScherm extends JFrame implements ActionListener {
    private JTable tabel = new JTable();
    private JButton aanmelden = new JButton("Gast aanmelden");
    private JButton verwijderen = new JButton("Gast verwijderen/wijzigen");
    private JDialog aanmeldenDatabase = new JDialog();

    DBConnection database = new DBConnection();

    public GastScherm() throws HeadlessException {
        setTitle("FullHouse - gast");
        setResizable(true);
        setSize(new Dimension(800, 600));
        GastComponent();
    }

    public void GastComponent() {
        JPanel panel = new JPanel();

        aanmelden.addActionListener(this);
        panel.add(aanmelden);
        panel.add(verwijderen);
        add(new JScrollPane(tabel));
        GridLayout grid = new GridLayout(3, 4, 30, 20);
        Container content = this.getContentPane();
        content.setLayout(grid);
        add(panel);
        tabel.setModel(database.gastLijst());
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aanmeldenDatabase = new JDialog();
        aanmeldenDatabase.setSize(100, 100);
        aanmeldenDatabase.setVisible(true);
    }
}