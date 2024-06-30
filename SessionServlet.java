/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tibur
 */
@WebServlet(urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (username == null) {
            username = "usuario";
            session.setAttribute("username", username);
            out.println("<p>Bienvenido, " + username + "!</p>");
        } else {
            out.println("<p>Bienvenido de nuevo, " + username + "!</p>");
        }
    }

}
