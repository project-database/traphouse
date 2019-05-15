package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToernooiScherm extends JFrame implements ActionListener {

    private JButton toernooiAanmaken = new JButton("Toernooi aanmaken");
    private JButton gastInscrhijven = new JButton("Gast inscrhijven");
    private JButton ratingBijwerken = new JButton("Rating bijwerken");
    private JButton winnaarRegistreren = new JButton("Winnaar regsitreren");
    private JButton inleggeldBijwerken = new JButton("Inleggeld bijwerken");
    private JButton tafelIndelen = new JButton("Tafel indelen");

    String data[][] = {{"101", "Jan", "100", ""}, {"102", "Piet", "200", ""}, {"101", " ", " ", ""}};
    String column[] = {"Datum", "Naam", "Inleggeld", "Rating"};

    private JTable tabel = new JTable(data, column);

    public ToernooiScherm() throws HeadlessException {
        setTitle("FullHouse - Toernooi");
        setResizable(true);
        setSize(new Dimension(800, 800));
        ToernooiComponent();
    }


    private void ToernooiComponent() {
        JPanel panel = new JPanel();
        panel.add(toernooiAanmaken);
        toernooiAanmaken.addActionListener(this);
        panel.add(gastInscrhijven);
        gastInscrhijven.addActionListener(this);
        panel.add(ratingBijwerken);
        ratingBijwerken.addActionListener(this);
        panel.add(winnaarRegistreren);
        winnaarRegistreren.addActionListener(this);
        panel.add(inleggeldBijwerken);
        inleggeldBijwerken.addActionListener(this);
        panel.add(tafelIndelen);
        tafelIndelen.addActionListener(this);
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
        if (e.getSource() == toernooiAanmaken) {
            ToernooiScherm scherm = new ToernooiScherm();
            scherm.setLocationRelativeTo(scherm);
            scherm.setVisible(true);
        }
        if (e.getSource() == gastInscrhijven) {
            JDialog gastInschrijvenPopup = new JDialog();
            gastInschrijvenPopup.setSize(500, 500);
            gastInschrijvenPopup.setVisible(true);
        }
        if (e.getSource() == ratingBijwerken) {
            JDialog ratingbijwerkenPopup = new JDialog();
            ratingbijwerkenPopup.setSize(500, 500);
            ratingbijwerkenPopup.setVisible(true);
        }
        if (e.getSource() == winnaarRegistreren) {
            JDialog winnaarRegistrerenPopup = new JDialog();
            winnaarRegistrerenPopup.setSize(500, 500);
            winnaarRegistrerenPopup.setVisible(true);
        }
        if (e.getSource() == inleggeldBijwerken) {
            JDialog inleggeldBijwerkenPopup = new JDialog();
            inleggeldBijwerkenPopup.setSize(500, 500);
            inleggeldBijwerkenPopup.setVisible(true);

        }
        if (e.getSource() == tafelIndelen) {
            JDialog tafelIndelenPopup = new JDialog();
            tafelIndelenPopup.setSize(500, 500);
            tafelIndelenPopup.setVisible(true);

        }


    }


}

