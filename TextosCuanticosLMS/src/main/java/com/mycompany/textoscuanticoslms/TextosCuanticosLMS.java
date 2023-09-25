package com.mycompany.textoscuanticoslms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import com.mycompany.textoscuanticoslms.views.UsuarioView;
import com.mycompany.textoscuanticoslms.controller.UsuarioController;
import com.mycompany.textoscuanticoslms.views.MainMenuPanel;
import java.awt.BorderLayout;

public class TextosCuanticosLMS {

    public static void main(String[] args) {
        try {
            // Configurar y establecer la conexión a la base de datos.
            Connection connection = setupDatabaseConnection();

            // Iniciar la aplicación con la conexión a la base de datos.
            startApplication(connection);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos.");
        }
    }

    /**
     * Configura y devuelve una conexión a la base de datos.
     *
     * @return Connection - La conexión a la base de datos.
     * @throws SQLException - Si hay un error al establecer la conexión.
     */
    private static Connection setupDatabaseConnection() throws SQLException {
        // Reemplaza con tus detalles de conexión a la base de datos.
        String url = "jdbc:mysql://localhost:3306/textoscuanticos";
        String username = "root";
        String password = "";

        // Conexión a la base de datos.
        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    /**
     * Inicia la aplicación con la conexión a la base de datos.
     *
     * @param connection - La conexión a la base de datos.
     */
    private static void startApplication(Connection connection) {
        // Instancia del controlador de usuario con la conexión a la base de datos.
        UsuarioController usuarioController = new UsuarioController(connection);

        // Instancia de la vista del usuario.
        UsuarioView usuarioView = new UsuarioView(connection);

        // Crear un panel y agregar la vista del usuario a ese panel.
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear el panel del menú lateral
        MainMenuPanel menuPanel = new MainMenuPanel();

        // Agregar el panel del menú en el lado izquierdo y la vista del usuario en el centro
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(usuarioView, BorderLayout.CENTER);

        // Configuración del JFrame para mostrar la vista del usuario.
        JFrame frame = new JFrame("Textos Cuánticos - LMS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Establecer el tamaño de la ventana
        frame.add(mainPanel); // Agregar el panel principal al marco
        frame.setVisible(true); // Hacer que el marco sea visible
    }
}
