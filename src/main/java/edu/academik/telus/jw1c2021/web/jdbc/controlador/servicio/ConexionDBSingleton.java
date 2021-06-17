
package edu.academik.telus.jw1c2021.web.jdbc.controlador.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author braya
 */
public class ConexionDBSingleton {
    
    private static final String URL = "jdbc:mariadb://localhost:3307/db1c2021";
    private static final String USER = "root";
    private static final String PASSWORD = "escobar09";
    
    private static Connection connection = null;
    
    public static Connection getConnection(){
        try{
        if(connection == null){
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            connection.setAutoCommit(false);
        }
        return connection;
        }catch(SQLException ex ){
            System.err.println(ex.getMessage());
        }
        
        return null;
    }
}
