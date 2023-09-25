/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.controller;

/**
 *
 * @author harby
 */

import com.mycompany.textoscuanticoslms.dao.CursoDAO;
import com.mycompany.textoscuanticoslms.model.Curso;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CursoController {
    private final CursoDAO cursoDAO;

    public CursoController(Connection connection) {
        this.cursoDAO = new CursoDAO(connection);
    }

    public void addCurso(Curso curso) {
        try {
            cursoDAO.addCurso(curso);
        } catch (SQLException e) {
            // Aquí manejas la excepción, podrías emitir un mensaje al usuario.
        }
    }

    public Curso findCursoById(int id) {
        try {
            return cursoDAO.findCursoById(id);
        } catch (SQLException e) {
            // Maneja la excepción
            return null;
        }
    }

    public List<Curso> getAllCursos() {
        try {
            return cursoDAO.getAllCursos();
        } catch (SQLException e) {
            // Maneja la excepción
            return null;
        }
    }

    public void updateCurso(Curso curso) {
        try {
            cursoDAO.updateCurso(curso);
        } catch (SQLException e) {
            // Maneja la excepción
        }
    }

    public void deleteCurso(int id) {
        try {
            cursoDAO.deleteCurso(id);
        } catch (SQLException e) {
            // Maneja la excepción
        }
    }
}

