package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterclassScherm extends JFrame implements ActionListener {

    private JButton masterclassAanmaken = new JButton("Masterclass aanmaken");
    private JButton gastInscrhijvenMasterclass = new JButton("Gast inscrhijven");


    String data[][] = {{"101", "Jan", "100", ""}, {"102", "Piet", "200", ""}, {"101", " ", " ", ""}};
    String column[] = {"Datum", "Naam", "Inleggeld", "Rating"};

    private JTable tabel = new JTable(data, column);

    public MasterclassScherm() throws HeadlessException {
        setTitle("FullHouse - MasterClass");
        setResizable(true);
        setSize(new Dimension(800, 600));
        MasterclassComponent();
    }

    private void MasterclassComponent() {

        JPanel panel = new JPanel();
        panel.add(masterclassAanmaken);
        masterclassAanmaken.addActionListener(this);
        panel.add(gastInscrhijvenMasterclass);
        gastInscrhijvenMasterclass.addActionListener(this);
        add(new JScrollPane(tabel));
        panel.add(tabel.getTableHeader());
        GridLayout grid = new GridLayout(4, 4, 30, 20);
        Container content = this.getContentPane();
        content.setLayout(grid);
        add(panel);
        pack();



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == gastInscrhijvenMasterclass) {
            JDialog gastInschrijvenPopup = new JDialog();
            gastInschrijvenPopup.setSize(500, 500);
            gastInschrijvenPopup.setVisible(true);
        }
        if (e.getSource() == masterclassAanmaken) {
            JDialog masterclassAanmakenPopup = new JDialog();
            masterclassAanmakenPopup.setSize(500, 500);
            masterclassAanmakenPopup.setVisible(true);
        }

    }
}
