/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author tibur
 */
@WebServlet(urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        boolean found = false;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    found = true;
                    out.println("<p>Bienvenido de nuevo, " + cookie.getValue() + "!</p>");
                }
            }
        }

        if (!found) {
            Cookie newCookie = new Cookie("user", "usuario");
            newCookie.setMaxAge(60 * 60 * 24); // 1 día
            response.addCookie(newCookie);
            out.println("<p>Bienvenido, nuevo usuario!</p>");
        }
    }
}
