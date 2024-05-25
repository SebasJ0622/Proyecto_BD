package org.example;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class MainUI extends JFrame {
    private JButton fetchButton;
    private JButton insertButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextArea dataTextArea;

    private Connection connection;
    private DataManipulator dataManipulator;

    public MainUI(Connection connection) {
        this.connection = connection;
        this.dataManipulator = new DataManipulator(connection);
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

        pack();
        setLocationRelativeTo(null);

        // Asignamos acciones a los botones
        fetchButton.addActionListener(e -> fetchData());
        insertButton.addActionListener(e -> insertData());
        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> deleteData());
    }

    private void fetchData() {
        // Implementaremos esta lógica más adelante
    }

    private void insertData() {
        // Implementaremos esta lógica más adelante
    }

    private void updateData() {
        // Implementaremos esta lógica más adelante
    }

    private void deleteData() {
        // Implementaremos esta lógica más adelante
    }
}


