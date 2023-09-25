/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.dao;

/**
 *
 * @author harby
 */

import com.mycompany.textoscuanticoslms.model.Evaluacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvaluacionDAO {
    private final Connection connection;

    public EvaluacionDAO(Connection connection) {
        this.connection = connection;
    }

    // Crear
    public void addEvaluacion(Evaluacion evaluacion) throws SQLException {
        String sql = "INSERT INTO evaluaciones (nombre, descripcion, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, evaluacion.getNombre());
            ps.setString(2, evaluacion.getDescripcion());
            ps.setDate(3, evaluacion.getFecha());
            ps.executeUpdate();
        }
    }

    // Leer
    public List<Evaluacion> getAllEvaluaciones() throws SQLException {
        List<Evaluacion> evaluaciones = new ArrayList<>();
        String sql = "SELECT * FROM evaluaciones";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                evaluaciones.add(new Evaluacion(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDate("fecha")));
            }
        }
        return evaluaciones;
    }

    // Actualizar
    public void updateEvaluacion(Evaluacion evaluacion) throws SQLException {
        String sql = "UPDATE evaluaciones SET nombre=?, descripcion=?, fecha=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, evaluacion.getNombre());
            ps.setString(2, evaluacion.getDescripcion());
            ps.setDate(3, evaluacion.getFecha());
            ps.setInt(4, evaluacion.getId());
            ps.executeUpdate();
        }
    }

    // Eliminar
    public void deleteEvaluacion(int id) throws SQLException {
        String sql = "DELETE FROM evaluaciones WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

