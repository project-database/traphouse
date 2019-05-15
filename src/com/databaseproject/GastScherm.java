package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GastScherm extends JFrame implements ActionListener {
    String data[][] = {{"101", "Jan", "100"}, {"102", "Piet", "200"}, {"101", " ", " "}};
    String column[] = {"ID", "Naam", "Inleggeld"};

    private JTable tabel = new JTable(data, column);

    private JButton aanmelden = new JButton("Gast aanmelden");
    private JButton verwijderen = new JButton("Gast verwijderen/wijzigen");
    private JDialog aanmeldenDatabase = new JDialog();

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
        panel.add(tabel.getTableHeader());
        GridLayout grid = new GridLayout(3, 4, 30, 20);
        Container content = this.getContentPane();
        content.setLayout(grid);
        add(panel);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aanmeldenDatabase = new JDialog();
        aanmeldenDatabase.setSize(100, 100);
        aanmeldenDatabase.setVisible(true);
    }
}
