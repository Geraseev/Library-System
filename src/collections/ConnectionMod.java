/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 *
 * @author lgera
 */
public class ConnectionMod {
    public Connection conecta() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcadastro", "root", "Larinha0+8");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
