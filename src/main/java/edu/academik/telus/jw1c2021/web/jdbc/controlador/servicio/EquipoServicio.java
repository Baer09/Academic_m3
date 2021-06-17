
package edu.academik.telus.jw1c2021.web.jdbc.controlador.servicio;

import edu.academik.telus.jw1c2021.web.jdbc.controlador.modelo.Equipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braya
 */
public class EquipoServicio {
    
    public List<Equipo> buscarEquipos() throws SQLException{
        
        String queryString = "select * from equipo";
        
        List<Equipo> equipoList = new ArrayList<>();
        
        try(PreparedStatement stmt = ConexionDBSingleton.getConnection().prepareStatement(queryString)){
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    
                    Equipo equipo = new Equipo();
                    equipo.setId(rs.getInt("id"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setDirecction(rs.getString("direcction"));
                    
                    equipoList.add(equipo);
                            
                    
                }
            }
        }
        
        return equipoList;
        
    }
    
}
