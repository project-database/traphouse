package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GastScherm extends JFrame implements ActionListener {
    private JTable tabel = new JTable();
    private JButton aanmelden = new JButton("Gast aanmelden");
    private JButton verwijderen = new JButton("Gast verwijderen/wijzigen");

    JTextField naamField = new JTextField();
    JTextField adresField = new JTextField();
    JTextField postcodeField = new JTextField();
    JTextField woonplaatsField = new JTextField();
    JTextField telefoonnummerField = new JTextField();
    JTextField emailadresField = new JTextField();
    JTextField geboortedatumField = new JTextField();
    JTextField geslachtField = new JTextField();
    JTextField ratingField = new JTextField();
    JButton registrerenButton;

    DBConnection database = new DBConnection();

    public GastScherm() throws HeadlessException {

        setTitle("FullHouse - gast");
        setResizable(false);
        setPreferredSize (new Dimension(1200, 500));
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

    public String DatumVeranderen(String oudeDatum){
        try{
            SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdfSource.parse(oudeDatum);
            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sdfDestination.format(date);
            return strDate;

        }catch (ParseException e) {
            e.printStackTrace();
            return "00-00-0000";
        }
    }

    public void GastAanmeldScherm(){
        JDialog aanmeldenDatabase = new JDialog();
        GridLayout aanmeldenGrid = new GridLayout(12, 2);

        aanmeldenDatabase.setLayout(aanmeldenGrid);

        //Naam
        JLabel naamLabel = new JLabel("Naam: ");
        aanmeldenDatabase.add(naamLabel);
        aanmeldenDatabase.add(naamField);

        //Adres
        JLabel adresLabel = new JLabel("Adres: ");
        aanmeldenDatabase.add(adresLabel);
        aanmeldenDatabase.add(adresField);

        //Poscode
        JLabel postcodeLabel = new JLabel("Postcode: ");
        aanmeldenDatabase.add(postcodeLabel);
        aanmeldenDatabase.add(postcodeField);

        //Woonplaats
        JLabel woonplaatsLabel = new JLabel("Woonplaats: ");
        aanmeldenDatabase.add(woonplaatsLabel);
        aanmeldenDatabase.add(woonplaatsField);

        //Telefoonnummer
        JLabel telefoonnummerLabel = new JLabel("Telefoonnummer: ");
        aanmeldenDatabase.add(telefoonnummerLabel);
        aanmeldenDatabase.add(telefoonnummerField);

        //E-mail adres
        JLabel emailadresLabel = new JLabel("E-mail adres: ");
        aanmeldenDatabase.add(emailadresLabel);
        aanmeldenDatabase.add(emailadresField);

        //Geboortedatum
        JLabel geboortedatumLabel = new JLabel("Geboortedatum: ");
        aanmeldenDatabase.add(geboortedatumLabel);
        aanmeldenDatabase.add(geboortedatumField);

        //Geslacht
        JLabel geslachtLabel = new JLabel("Geslacht: ");
        aanmeldenDatabase.add(geslachtLabel);
        aanmeldenDatabase.add(geslachtField);

        //Rating
        JLabel ratingLabel = new JLabel("Rating: ");
        aanmeldenDatabase.add(ratingLabel);
        aanmeldenDatabase.add(ratingField);

        //registreren knop
        registrerenButton = new JButton("Registreren");
        aanmeldenDatabase.add(registrerenButton);
        registrerenButton.addActionListener(this);

        aanmeldenDatabase.setSize(400, 600);
        aanmeldenDatabase.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aanmelden){
            GastAanmeldScherm();
        }
        if(e.getSource() == registrerenButton){
            String nieuweDatum = DatumVeranderen(geboortedatumField.getText());
            database.runQuery("INSERT INTO gast (naam, adres, postcode, woonplaats, telefoonnummer, emailadres, geboortedatum, geslacht, rating) VALUES ('" + naamField.getText() + "', '" + adresField.getText() + "', '" + postcodeField.getText() + "', '" + woonplaatsField.getText() + "', '" + telefoonnummerField.getText() + "', '" + emailadresField.getText() + "', '" + nieuweDatum + "', '" + geslachtField.getText() + "', '" + ratingField.getText() + "');");
        }
    }
}