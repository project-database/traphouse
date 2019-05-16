package com.databaseproject;

import java.sql.*;

public class DBConnection {
    public static boolean LoginCheck(String username, String password){
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://meru.hhs.nl/18120970", "asdfasdf", "sdafasdf");
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM account WHERE username = ? AND password = ?");

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultset = statement.executeQuery();

            if(resultset.next()){
                System.out.println("Login correct.");
                connect.close();
                return true;
            }else{
                System.out.println("Login failed.");
                connect.close();
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Fout met het verbinden!");
            e.printStackTrace();
            return false;
        }
    }

}
