/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/DatabaseServlet"})
public class DatabaseServlet extends HttpServlet {
      private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        GameDAO gameDAO = new GameDAO();

        try {
            List<Game> games = gameDAO.getAllGames();
            out.println("<html><body>");
            out.println("<h2>Lista de Videojuegos desde la Base de Datos</h2>");
            out.println("<ul>");
            for (Game game : games) {
                out.println("<li>" + game.getNombre() + "</li>");
            }
            out.println("</ul>");
            out.println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime la traza de la excepción en el servidor
            out.println("<html><body>");
            out.println("<h2>Error al obtener la lista de juegos</h2>");
            out.println("<p>Ocurrió un error al intentar obtener los juegos desde la base de datos.</p>");
            out.println("<p>Detalles del error: " + e.getMessage() + "</p>");
            out.println("</body></html>");
        }
    }
}
