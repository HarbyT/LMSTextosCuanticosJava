/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.dao;

/**
 *
 * @author harby
 */

import com.mycompany.textoscuanticoslms.model.Actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActividadesDAO {
    private final Connection connection;

    public ActividadesDAO(Connection connection) {
        this.connection = connection;
    }

    public void addActividad(Actividades actividad) throws SQLException {
        String sql = "INSERT INTO actividad (nombre, descripcion, fecha_limite) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, actividad.getNombre());
            ps.setString(2, actividad.getDescripcion());
            ps.setDate(3, actividad.getFechaLimite());
            ps.executeUpdate();
        }
    }

    public Actividades findActividadById(int id) throws SQLException {
        String sql = "SELECT * FROM actividad WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Actividades(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDate("fecha_limite"));
            }
        }
        return null;
    }

    public List<Actividades> getAllActividades() throws SQLException {
        List<Actividades> actividades = new ArrayList<>();
        String sql = "SELECT * FROM actividad";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                actividades.add(new Actividades(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDate("fecha_limite")));
            }
        }
        return actividades;
    }

    public void updateActividad(Actividades actividad) throws SQLException {
        String sql = "UPDATE actividad SET nombre = ?, descripcion = ?, fecha_limite = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, actividad.getNombre());
            ps.setString(2, actividad.getDescripcion());
            ps.setDate(3, actividad.getFechaLimite());
            ps.setInt(4, actividad.getId());
            ps.executeUpdate();
        }
    }

    public void deleteActividad(int id) throws SQLException {
        String sql = "DELETE FROM actividad WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
