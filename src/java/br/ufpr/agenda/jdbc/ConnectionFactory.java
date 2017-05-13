package br.ufpr.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            //MUITO IMPORTANJTE ESSA LINHA ABAIXO!!!!
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
          "jdbc:mysql://localhost/agenda", "root", "root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}