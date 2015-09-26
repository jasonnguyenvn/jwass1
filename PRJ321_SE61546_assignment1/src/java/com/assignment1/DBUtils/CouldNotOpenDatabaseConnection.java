/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.DBUtils;

/**
 *
 * @author Hau
 */
public class CouldNotOpenDatabaseConnection extends Exception {

    public CouldNotOpenDatabaseConnection(String message) {
        super("Could not open db connection. Login fail." + message);
    }
    
    public CouldNotOpenDatabaseConnection() {
        super("Could not open db connection. Login fail." );
    }

}
