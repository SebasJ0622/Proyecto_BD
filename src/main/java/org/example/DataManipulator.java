package org.example;
import java.sql.*;

public class DataManipulator {
    private Connection connection;

    public DataManipulator(Connection connection) {
        this.connection = connection;
    }
    // Método para obtener datos de la base de datos
    public String fetchData() throws SQLException {
        StringBuilder data = new StringBuilder();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

        while (resultSet.next()) {
            data.append("ID: ").append(resultSet.getInt("id"))
                    .append(", Dato: ").append(resultSet.getString("dato"))
                    .append("\n");
        }
        // Cerrar recursos
        resultSet.close();
        statement.close();
        return data.toString();
    }

    // Método para insertar datos en la base de datos
    public void insertData(String newData) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO products (dato) VALUES (?)");
        statement.setString(1, newData);
        statement.executeUpdate();
        statement.close();
    }
    // Método para actualizar datos en la base de datos
    public void updateData(int id, String newData) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("UPDATE products SET dato=? WHERE ID=?");
    statement.setString(1,newData);
    statement.setInt(2, id);
    statement.close();
    }
    // Método para eliminar datos de la base de datos
    public void deleteData(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE ID=?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }
}


