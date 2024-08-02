package org.example.apk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection connect() {
        String url = "jdbc:mysql://localhost:3306/parcvehicule?";

        try {
            Connection connection = DriverManager.getConnection(url,"root","");
            return connection;
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    return null;}
}