package com.utp.karaoke.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConexion {

    private static DbConexion instance;
    private Connection connection;

    // Parametros para la conexion
    private final String url = "jdbc:mysql://localhost:3306/karaoke";
    private final String user = "root";
    private final String password = "";

    private DbConexion() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbConexion getInstance() {
        if (instance == null) {
            instance = new DbConexion();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
