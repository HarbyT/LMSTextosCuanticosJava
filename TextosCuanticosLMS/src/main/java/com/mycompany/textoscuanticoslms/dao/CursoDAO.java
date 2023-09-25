/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.dao;

/**
 *
 * @author harby
 */
import com.mycompany.textoscuanticoslms.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private final Connection connection;

    public CursoDAO(Connection connection) {
        this.connection = connection;
    }

    public void addCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO cursos (nombre, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.executeUpdate();
        }
    }

    public Curso findCursoById(int id) throws SQLException {
        String sql = "SELECT * FROM cursos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Curso(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
                }
            }
        }
        return null;
    }

    public List<Curso> getAllCursos() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM cursos";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cursos.add(new Curso(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion")));
                }
            }
        }
        return cursos;
    }

    public void updateCurso(Curso curso) throws SQLException {
        String sql = "UPDATE cursos SET nombre = ?, descripcion = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getId());
            ps.executeUpdate();
        }
    }

    public void deleteCurso(int id) throws SQLException {
        String sql = "DELETE FROM cursos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

