package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToernooiScherm extends JFrame implements ActionListener {

    public ToernooiScherm() throws HeadlessException {
        setTitle("FullHouse - Toernooi");
        setResizable(true);
        setSize(new Dimension(800, 600));
        ToernooiComponent();
    }

    private void ToernooiComponent() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
