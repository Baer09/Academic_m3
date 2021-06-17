
package edu.academik.telus.jw1c2021.web.jdbc.controlador;

import edu.academik.telus.jw1c2021.web.jdbc.controlador.modelo.Equipo;
import edu.academik.telus.jw1c2021.web.jdbc.controlador.servicio.EquipoServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author braya
 */
@WebServlet(name = "EquipoCrearServlet", urlPatterns = {"/crear-equipo.html"})//name to enter from http
public class EquipoCrearServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("mensaje", "");
        
        request.getRequestDispatcher("equipos/crear-equipo.jsp").forward(request, response);// rendered jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Equipo equipo = new Equipo();
            equipo.setDirecction(request.getParameter("direccion"));
            equipo.setNombre(request.getParameter("nombre"));

            EquipoServicio equipoServicio = new EquipoServicio();
            equipoServicio.crear(equipo);
            
            request.setAttribute("mensaje", "Equipo con ID = " + equipo.getId() + " creado satifactoriamente.");
            
            request.getRequestDispatcher("equipos/crear-equipo.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    
    
}
