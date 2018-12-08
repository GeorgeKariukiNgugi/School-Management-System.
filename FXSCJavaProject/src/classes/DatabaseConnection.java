/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class DatabaseConnection {
   public Connection co;
   public Statement state;
   public void Connect(){
        try {
             co = DriverManager.getConnection("jdbc:mysql://localhost:3308/JavaProject","root","7205");
            System.out.println("HELLO DATABASES;");
            state = co.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    
   }
}
