package org.example;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class MainUI extends JFrame {
    private JButton fetchButton, insertButton, updateButton, deleteButton;
    private JTextArea dataTextArea;
    private DataManipulator dataManipulator;

    public MainUI(Connection connection) {
        dataManipulator = new DataManipulator(connection);
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Gestor de Datos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        fetchButton = new JButton("Fetch Data");
        insertButton = new JButton("Insert Data");
        updateButton = new JButton("Update Data");
        deleteButton = new JButton("Delete Data");
        dataTextArea = new JTextArea(20, 40);
        dataTextArea.setEditable(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(fetchButton);
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JScrollPane scrollPane = new JScrollPane(dataTextArea);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        fetchButton.addActionListener(e -> fetchData());
        insertButton.addActionListener(e -> insertData());
        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> deleteData());

        pack();
        setLocationRelativeTo(null);
    }

    private void fetchData() {
        try {
            dataTextArea.setText(dataManipulator.fetchData());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertData() {
        String newData = JOptionPane.showInputDialog(this, "Ingresa los datos");
        if (newData != null && !newData.isEmpty()) {
            try {
                dataManipulator.insertData(newData);
                fetchData();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void updateData() {
    String id = JOptionPane.showInputDialog(this, "Ingresa el id a modificar:");
    String newData = JOptionPane.showInputDialog(this, "Ingresa el dato nuevo:");
        if (id != null && !id.isEmpty() && newData != null && !newData.isEmpty()) {
        try {
            dataManipulator.updateData(Integer.parseInt(id), newData);
            fetchData();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    }

    private void deleteData() {
    String id = JOptionPane.showInputDialog(this, "Ingresa el id a borrar:");
        if (id != null && !id.isEmpty()) {
            try {
                dataManipulator.deleteData(Integer.parseInt(id));
                fetchData();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}


