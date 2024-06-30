<%-- 
    Document   : Game
    Created on : 30 jun 2024, 12:30:00
    Author     : tibur
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Juegos - Página de Videojuegos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Mejores Juegos 2024</h1>
    </header>
    <nav>
        <ul>
            <li><a href="index.html">Inicio</a></li>
            <li><a href="Game.jsp">Juegos</a></li>
            <li><a href="contact.html">Contacto</a></li>
        </ul>
    </nav>
    <main>
        <h2>Mejores Juegos 2024</h2>
        <ul>
            <c:forEach var="game" items="${games}">
                <li>${game.nombre}</li>
            </c:forEach>
        </ul>
    </main>
    <footer>
        <p>&copy; Mejores Juegos 2024</p>
    </footer>
</body>
</html>
