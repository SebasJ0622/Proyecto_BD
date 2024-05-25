package org.example;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManipulator {
    private Connection connection;
    private JTextArea dataTextArea;

    public DataManipulator(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener datos de la base de datos
    public void fetchData() throws SQLException {
        try {
        // Preparar la consulta SQL
        String query = "SELECT * FROM products";
        PreparedStatement statement = connection.prepareStatement(query);

        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();

        // Limpiar el área de texto antes de mostrar los nuevos datos
        dataTextArea.setText("");

        // Mostrar los datos en el área de texto
        while (resultSet.next()) {
            // Leer los valores de cada fila y mostrarlos en el área de texto
            int id = resultSet.getInt("id");
            String data = resultSet.getString("dato");
            dataTextArea.append("ID: " + id + ", Dato: " + data + "\n");
        }

        // Cerrar recursos
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }



    // Método para insertar datos en la base de datos
    public void insertData(String newData) {
        try {
            // Preparar la consulta SQL para insertar nuevos datos
            String query = "INSERT INTO products (dato) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newData);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar recursos
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar datos en la base de datos
    public void updateData(int id, String updatedData) {
            try {
                // Preparar la consulta SQL para actualizar datos
                String query = "UPDATE products SET dato = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, updatedData);
                statement.setInt(2, id);

                // Ejecutar la consulta
                statement.executeUpdate();

                // Cerrar recursos
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // Método para eliminar datos de la base de datos
    public void deleteData(int id) {
        try {
            // Preparar la consulta SQL para eliminar datos
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar recursos
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }


