package com.mycompany.textoscuanticoslms.controller;

import com.mycompany.textoscuanticoslms.dao.UsuarioDAO;
import com.mycompany.textoscuanticoslms.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    
    private final UsuarioDAO usuarioDAO;

    public UsuarioController(Connection connection) {
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public void addUser(Usuario usuario) {
        try {
            usuarioDAO.addUser(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsuarios() {
        try {
            return usuarioDAO.getAllUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Usuario findUserById(int id) {
        try {
            return usuarioDAO.findUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateUser(Usuario usuario) {
        try {
            usuarioDAO.updateUser(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            usuarioDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
