/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.controller;

/**
 *
 * @author harby
 */

import com.mycompany.textoscuanticoslms.dao.EvaluacionDAO;
import com.mycompany.textoscuanticoslms.model.Evaluacion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvaluacionController {
    private final EvaluacionDAO evaluacionDAO;

    public EvaluacionController(Connection connection) {
        this.evaluacionDAO = new EvaluacionDAO(connection);
    }

    public void addEvaluacion(Evaluacion evaluacion) {
        try {
            evaluacionDAO.addEvaluacion(evaluacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Evaluacion> getAllEvaluaciones() {
        try {
            return evaluacionDAO.getAllEvaluaciones();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateEvaluacion(Evaluacion evaluacion) {
        try {
            evaluacionDAO.updateEvaluacion(evaluacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvaluacion(int id) {
        try {
            evaluacionDAO.deleteEvaluacion(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

