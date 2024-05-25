package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/inventario";
        String user = "root";
        String password = "my-secret-pw";

        try {
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(url, user, password);

            // Crear y mostrar la interfaz de usuario
            MainUI mainUI = new MainUI(connection);
            mainUI.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}