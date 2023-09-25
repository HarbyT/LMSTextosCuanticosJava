/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.controller;

/**
 *
 * @author harby
 */

import com.mycompany.textoscuanticoslms.dao.ContenidoDAO;
import com.mycompany.textoscuanticoslms.model.Contenido;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ContenidoController {
    private final ContenidoDAO contenidoDAO;

    public ContenidoController(Connection connection) {
        this.contenidoDAO = new ContenidoDAO(connection);
    }

    public void addContenido(Contenido contenido) {
        try {
            contenidoDAO.addContenido(contenido);
        } catch (SQLException e) {
            e.printStackTrace();
            // Aquí podrías agregar más manejo de errores.
        }
    }

    public Contenido findContenidoById(int id) {
        try {
            return contenidoDAO.findContenidoById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
            return null;
        }
    }

    public List<Contenido> getAllContenidos() {
        try {
            return contenidoDAO.getAllContenidos();
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
            return null;
        }
    }

    public void updateContenido(Contenido contenido) {
        try {
            contenidoDAO.updateContenido(contenido);
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
        }
    }

    public void deleteContenido(int id) {
        try {
            contenidoDAO.deleteContenido(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
        }
    }
}

