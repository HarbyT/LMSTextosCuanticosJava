/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.dao;

/**
 *
 * @author harby
 */
import com.mycompany.textoscuanticoslms.model.Contenido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContenidoDAO {
    private final Connection connection;

    public ContenidoDAO(Connection connection) {
        this.connection = connection;
    }

    public void addContenido(Contenido contenido) throws SQLException {
        String sql = "INSERT INTO contenido (titulo, descripcion, cursoId) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, contenido.getTitulo());
            stmt.setString(2, contenido.getDescripcion());
            stmt.setInt(3, contenido.getCursoId());
            stmt.executeUpdate();
        }
    }

    public Contenido findContenidoById(int id) throws SQLException {
        String sql = "SELECT * FROM contenido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Contenido(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getInt("cursoId")
                    );
                }
            }
        }
        return null;
    }

    public List<Contenido> getAllContenidos() throws SQLException {
        List<Contenido> contenidos = new ArrayList<>();
        String sql = "SELECT * FROM contenido";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                contenidos.add(new Contenido(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("cursoId")
                ));
            }
        }
        return contenidos;
    }

    public void updateContenido(Contenido contenido) throws SQLException {
        String sql = "UPDATE contenido SET titulo = ?, descripcion = ?, cursoId = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, contenido.getTitulo());
            stmt.setString(2, contenido.getDescripcion());
            stmt.setInt(3, contenido.getCursoId());
            stmt.setInt(4, contenido.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteContenido(int id) throws SQLException {
        String sql = "DELETE FROM contenido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }}



