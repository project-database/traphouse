package com.databaseproject;

import java.sql.*;

public class DBConnection {
    public static boolean LoginCheck(String username, String password){
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://meru.hhs.nl/18120970", "18120970", "iecooH9sia");
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM account WHERE username = ? AND password = ?");

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultset = statement.executeQuery();

            if(resultset.next()){
                connect.close();
                return true;
            }else{
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
