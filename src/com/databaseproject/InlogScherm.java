package com.databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InlogScherm extends JFrame implements ActionListener {

    private JLabel gebruikersnaamTekst;
    private JTextField gebruikersnaam;

    private JLabel wachtwoordTekst;
    private JPasswordField wachtwoord;

    private JButton inlogknop;


    public InlogScherm() throws HeadlessException {
        setTitle("FullHouse - inloggen");
        setDefaultCloseOperation(InlogScherm.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(300, 300));
        InlogComponent();
    }

    public void InlogComponent(){
        JPanel panel = new JPanel();
        //Gebruikersnaam
        gebruikersnaamTekst = new JLabel("Gebruikersnaam: ");
        gebruikersnaamTekst.setBounds(20,15, 150, 10);
        gebruikersnaam = new JTextField();
        gebruikersnaam.setBounds(20,40, 150, 20);
        panel.add(gebruikersnaamTekst);
        panel.add(gebruikersnaam);

        //Wachtwoord
        wachtwoordTekst = new JLabel("Wachtwoord: ");
        wachtwoordTekst.setBounds(20,70,150,10);
        wachtwoord = new JPasswordField();
        wachtwoord.setBounds(20,95, 150, 20);
        panel.add(wachtwoordTekst);
        panel.add(wachtwoord);

        //Inlogknop
        inlogknop = new JButton("Inloggen");
        inlogknop.setBounds(45,125, 100, 20);
        inlogknop.addActionListener(this);
        panel.add(inlogknop);
        panel.setLayout(null);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ingevuldWachtwoord = String.valueOf(wachtwoord.getPassword());
        if(DBConnection.LoginCheck(gebruikersnaam.getText(), ingevuldWachtwoord)){
            this.dispose();
            FullHouseMenu menu = new FullHouseMenu();
            menu.setLocationRelativeTo(menu);
            menu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Uw heeft een ongeldige naam of wachtwoord ingevuld.");
        }
    }
}
