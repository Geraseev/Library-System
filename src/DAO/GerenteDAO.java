/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import telas.AreaG;


/**
 *
 * @author lgera
 */
public class GerenteDAO {
    private Connection conecta;
    
    public GerenteDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public void efetuarLogin(String nome, String senha){
        try {
            String cmdsql = "select * from gerente where nome=? and senha=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1,nome);
            stmt.setString(2,senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                AreaG tela = new AreaG();
                tela.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Dados incorretos"); 
            }
            
        } catch (Exception e) {
            
        }
    }
}
