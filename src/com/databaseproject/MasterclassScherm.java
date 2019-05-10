package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterclassScherm extends JFrame implements ActionListener {

    public MasterclassScherm() throws HeadlessException {
        setTitle("FullHouse - Toernooi");
        setResizable(true);
        setSize(new Dimension(800, 600));
        MasterclassComponent();
    }

    private void MasterclassComponent() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
