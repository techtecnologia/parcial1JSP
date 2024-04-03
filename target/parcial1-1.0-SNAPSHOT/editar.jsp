
<%@page import="com.miparcial.modelo.Calificacion"%>
<%
    Calificacion ca = (Calificacion) request.getAttribute("calif");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primer Parcial</title>
        <style>
            *{
            }
            .nombre{
                border:1px solid #000;
                padding:10px;
                width: 600px;
                margin:0 auto;
            }
            table{
                border:1px solid #000;
            }
            a{
                border:1px solid #999;
                background-color: #ccc;
                color:#444;
                padding:5px;
                margin:15px;
            }
        </style>
    </head>
    <body>
        <div class="nombre">
        <h1>PRIMER PARCIAL TEM - 742</h1>
        <h3>Nombre: RICHARD CHIPANA YUCRA</h3>    
        </div>
        <h1 style="text-align: center">Registro de calificaciones</h1>
        <hr>

        <div class="nombre">
            <form action="MainServlet" method="post">
                ID
                <input type="text" name="id" readonly value="<%= ca.getId()%>">
                Nombre del estudiante
                <input type="text" name="nombres" value="<%= ca.getNombres()%>">
                Primer parcial
                <input type="text" name="primero" value="<%= ca.getPrimero()%>">
                Segundo parcial
                <input type="text" name="segundo" value="<%= ca.getSegundo()%>">
                Tercer parcial
                <input type="text" name="tercero" value="<%= ca.getTercero()%>">
                
                <input type="submit" value="Enviar">
                
            </form>
        </div>

        
    </body>
</html>
