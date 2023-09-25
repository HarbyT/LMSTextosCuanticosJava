package com.mycompany.textoscuanticoslms.views;

import com.mycompany.textoscuanticoslms.controller.UsuarioController;
import com.mycompany.textoscuanticoslms.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.List;

public class UsuarioView extends JPanel {
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldId;
    private JTextArea textAreaUsuarios;
    private UsuarioController usuarioController;

    public UsuarioView(Connection connection) {
        usuarioController = new UsuarioController(connection);
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel lblNombre = new JLabel("Nombre");
        textFieldNombre = new JTextField(10);
        JLabel lblApellido = new JLabel("Apellido");
        textFieldApellido = new JTextField(10);
        JButton btnAdd = new JButton("Añadir");
        btnAdd.addActionListener(e -> addUser());

        inputPanel.add(lblNombre);
        inputPanel.add(textFieldNombre);
        inputPanel.add(lblApellido);
        inputPanel.add(textFieldApellido);
        inputPanel.add(btnAdd);

        add(inputPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        textAreaUsuarios = new JTextArea(10, 40);
        textAreaUsuarios.setEditable(false);

        centerPanel.add(new JScrollPane(textAreaUsuarios), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnMostrar = new JButton("Mostrar Todos");
        btnMostrar.addActionListener(e -> displayUsers());
        textFieldId = new JTextField(5);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> searchUser());
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> deleteUser());

        buttonPanel.add(btnMostrar);
        buttonPanel.add(new JLabel("ID:"));
        buttonPanel.add(textFieldId);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnEliminar);

        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void addUser() {
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        Usuario usuario = new Usuario(nombre, apellido);
        usuarioController.addUser(usuario);
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        displayUsers();
    }

    private void displayUsers() {
        List<Usuario> usuarios = usuarioController.getAllUsuarios();
        StringBuilder sb = new StringBuilder();
        for (Usuario u : usuarios) {
            sb.append(u.getId()).append(" - ").append(u.getNombre()).append(" ").append(u.getApellido()).append("\n");
        }
        textAreaUsuarios.setText(sb.toString());
    }

    private void searchUser() {
        int id;
        try {
            id = Integer.parseInt(textFieldId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Usuario usuario = usuarioController.findUserById(id);
        if (usuario != null) {
            textFieldNombre.setText(usuario.getNombre());
            textFieldApellido.setText(usuario.getApellido());
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser() {
        int id;
        try {
            id = Integer.parseInt(textFieldId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        usuarioController.deleteUser(id);
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldId.setText("");
        displayUsers();
    }
}
