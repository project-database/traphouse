package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FullHouseMenu extends JFrame implements ActionListener {

    private JButton gastBeheren = new JButton("Gast beheren");
    private JButton toernooiBeheren = new JButton("Toernooi beheren");
    private JButton masterclassBeheren = new JButton("Masterclass beheren");

    public FullHouseMenu() throws HeadlessException {
        setTitle("FullHouse - menu");
        setDefaultCloseOperation(InlogScherm.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(new Dimension(800, 600));
        MenuComponent();
    }

    public void MenuComponent(){
        JPanel panel = new JPanel();
        panel.add(gastBeheren);
        gastBeheren.addActionListener(this);
        panel.add(toernooiBeheren);
        toernooiBeheren.addActionListener(this);
        panel.add(masterclassBeheren);
        masterclassBeheren.addActionListener(this);
        GridLayout grid = new GridLayout(3, 4, 30, 20);
        Container content = this.getContentPane();
        content.setLayout(grid);
        add(panel);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gastBeheren) {
            GastScherm gast = new GastScherm();
            gast.setLocationRelativeTo(gast);
            gast.setVisible(true);
        }
        if (e.getSource() == toernooiBeheren) {
            ToernooiScherm toernooi = new ToernooiScherm();
            toernooi.setLocationRelativeTo(toernooi);
            toernooi.setVisible(true);
        }
        if (e.getSource() == masterclassBeheren) {
            MasterclassScherm masterclass = new MasterclassScherm();
            masterclass.setLocationRelativeTo(masterclass);
            masterclass.setVisible(true);
        }
    }
}