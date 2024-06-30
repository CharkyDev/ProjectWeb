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

/**
 *
 * @author tibur
 */
@WebServlet(urlPatterns = {"/ContactServlet"})
public class ContactServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        
        // Aquí puedes agregar la lógica para procesar el formulario, como enviar un correo electrónico o almacenar el mensaje en la base de datos.
        
        out.println("<html><body>");
        out.println("<h2>Gracias por contactarnos, " + name + "!</h2>");
        out.println("<p>Hemos recibido tu mensaje:</p>");
        out.println("<p>" + message + "</p>");
        out.println("</body></html>");
    }

}
