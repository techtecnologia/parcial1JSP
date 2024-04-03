<%@page import="java.util.ArrayList"%>
<%@page import="com.miparcial.modelo.Calificacion"%>

<%
    if(session.getAttribute("listaca") == null){
        ArrayList<Calificacion> aux = new ArrayList<Calificacion>();
        session.setAttribute("listaca", aux);
    }
    ArrayList<Calificacion> lista = (ArrayList<Calificacion>) session.getAttribute("listaca");
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
        <a href="MainServlet?op=nuevo">Nueva calificacion</a>
        <hr>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>P1 (30)</th>
                <th>P2 (30)</th>
                <th>P3 (40)</th>
                <th>Nota</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <%
                if(lista != null){
                    for(Calificacion item:lista){
            %>
                <tr>
                    <td><%= item.getId()%></td>
                    <td><%= item.getNombres()%></td>
                    <td><%= item.getPrimero()%></td>
                    <td><%= item.getSegundo()%></td>
                    <td><%= item.getTercero()%></td>
                    <td><%= item.getNota()%></td>
                    <td>
                        <a href="MainServlet?op=editar&id=<%= item.getId()%>">Editar</a>        
                    </td>
                    <td>
                        <a onclick="return(confirm('Realmente desea eliminar?'))" href="MainServlet?op=eliminar&id=<%= item.getId()%>">Eliminar</a>                                
                    </td>
                </tr>
            
            <%
                    }
                }
            %>
            
        </table>
        
    </body>
</html>
