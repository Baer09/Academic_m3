/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.academik.telus.jw1c2021.web.jdbc.controlador;

import edu.academik.telus.jw1c2021.web.jdbc.controlador.modelo.Equipo;
import edu.academik.telus.jw1c2021.web.jdbc.controlador.servicio.EquipoServicio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author braya
 */
@WebServlet(name = "EquipoListadoServlet", urlPatterns = {"/equipos.html"})
public class EquipoListadoServlet extends HttpServlet {

  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        EquipoServicio equipoServicio = new EquipoServicio();
        
        List<Equipo> equipoList = equipoServicio.buscarEquipos();
        
        request.setAttribute("equipoList", equipoList);
        
        request.getRequestDispatcher("equipos/equipos-listado.jsp").forward(request, response);
        
        }catch(SQLException ex){
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

 
  
}
