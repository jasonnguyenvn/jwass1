/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.DBUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */



public class MSSQLUtil implements Serializable {
   
    
    
    public static Connection openConnection() 
            throws ClassNotFoundException, SQLException, CouldNotOpenDatabaseConnection {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ321_Assignment";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "sa", "123456");
        } catch (SQLException ex) {
            throw new CouldNotOpenDatabaseConnection(ex.getMessage());
        }
        
        if(con == null) {
            throw new CouldNotOpenDatabaseConnection();
        }
        
        return con;
    }
    
}
