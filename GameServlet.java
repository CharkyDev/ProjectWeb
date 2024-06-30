/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tibur
 */
@WebServlet(urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Establecer conexión y preparar la consulta SQL
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        conn = DBConnection.getConnection(); // Obtener conexión (de tu clase DBConnection)
        
        // Consulta SQL para recuperar los juegos
        String sql = "SELECT nombre FROM juegos";
        stmt = conn.prepareStatement(sql);
        
        // Ejecutar la consulta y obtener resultados
        rs = stmt.executeQuery();
        
        // Imprimir los resultados de la consulta
        while (rs.next()) {
            String nombreJuego = rs.getString("nombre");
            System.out.println("Juego encontrado: " + nombreJuego); // Imprimir en la consola del servidor
        }
        
        // Ejemplo de cómo pasar los resultados al JSP (importante para tu implementación real)
        List<String> juegos = new ArrayList<>();
        while (rs.next()) {
            juegos.add(rs.getString("nombre"));
        }
        request.setAttribute("juegos", juegos);
        request.getRequestDispatcher("Game.jsp").forward(request, response); // Forward al JSP con los resultados
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar recursos
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}
}
