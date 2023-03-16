/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;


/**
 *
 * @author lgera
 */
public class Livraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testando conecção
        try{
            JOptionPane.showMessageDialog(null, "Testando conecção");
            Connection con = new collections.ConnectionMod().conecta();
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
    
}
