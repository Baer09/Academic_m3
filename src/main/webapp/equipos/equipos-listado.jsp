<%-- 
    Document   : equipos-listado
    Created on : 14 jun. 2021, 18:46:59
    Author     : braya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="edu.academik.telus.jw1c2021.web.jdbc.controlador.modelo.Equipo"%>


<%
    List<Equipo> equipoList = (List<Equipo>) request.getAttribute("equipoList");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebJDBC: Listado de Equipos</title>
    </head>
    <body>
        <h1>Listado de Equipos</h1>
        
        <div>            
            <table>

                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                    for (Equipo equipo : equipoList) {%>
                    <tr>
                        <td><%=equipo.getId()%></td>
                        <td><%=equipo.getNombre()%></td>
                        <td><%=equipo.getDirecction()%></td>
                    </tr>
                    <%}%>
                </tbody>                
            </table>            
        </div>
        
    </body>
</html>
