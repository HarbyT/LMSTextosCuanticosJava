/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.controller;

/**
 *
 * @author harby
 */

import com.mycompany.textoscuanticoslms.dao.ActividadesDAO;
import com.mycompany.textoscuanticoslms.model.Actividades;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ActividadesController {
    private final ActividadesDAO actividadDAO;

    public ActividadesController(Connection connection) {
        this.actividadDAO = new ActividadesDAO(connection);
    }

    public void addActividad(Actividades actividad) {
        try {
            actividadDAO.addActividad(actividad);
        } catch (SQLException e) {
            e.printStackTrace();
            // Aquí podrías agregar más manejo de errores.
        }
    }

    public Actividades findActividadById(int id) {
        try {
            return actividadDAO.findActividadById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
            return null;
        }
    }

    public List<Actividades> getAllActividades() {
        try {
            return actividadDAO.getAllActividades();
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
            return null;
        }
    }

    public void updateActividad(Actividades actividad) {
        try {
            actividadDAO.updateActividad(actividad);
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
        }
    }

    public void deleteActividad(int id) {
        try {
            actividadDAO.deleteActividad(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Más manejo de errores
        }
    }
}
