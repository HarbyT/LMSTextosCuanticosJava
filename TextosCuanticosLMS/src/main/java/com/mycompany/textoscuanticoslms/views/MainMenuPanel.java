/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.views;

/**
 *
 * @author harby
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private JList<String> menuList;
    private DefaultListModel<String> menuListModel;

    public MainMenuPanel() {
        setLayout(new BorderLayout());
        menuListModel = new DefaultListModel<>();
        menuList = new JList<>(menuListModel);

        // Agrega elementos al menú
        menuListModel.addElement("Actividades");
        menuListModel.addElement("Contenidos");
        menuListModel.addElement("Cursos");
        menuListModel.addElement("Evaluación");
        menuListModel.addElement("Cerrar Sesión");

        // Agrega un ActionListener para manejar las selecciones del menú
        menuList.addListSelectionListener(e -> {
            String selectedOption = menuList.getSelectedValue();
            handleMenuSelection(selectedOption);
        });

        JScrollPane scrollPane = new JScrollPane(menuList);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para manejar las selecciones del menú
    private void handleMenuSelection(String selectedOption) {
        if (selectedOption != null) {
            if (selectedOption.equals("Actividades")) {
                // Aquí puedes mostrar la vista de Actividades
            } else if (selectedOption.equals("Contenidos")) {
                // Aquí puedes mostrar la vista de Contenidos
            } else if (selectedOption.equals("Cursos")) {
                // Aquí puedes mostrar la vista de Cursos
            } else if (selectedOption.equals("Evaluación")) {
                // Aquí puedes mostrar la vista de Evaluación
            } else if (selectedOption.equals("Cerrar Sesión")) {
                // Aquí puedes implementar la lógica para cerrar sesión
            }
        }
    }
}
