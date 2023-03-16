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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Emprestimos;
import javabeans.Reservas;

/**
 *
 * @author lgera
 */
public class EmprestimoDAO {
    private Connection conecta;
    
    public EmprestimoDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public List<Emprestimos> listarEmprestimo(){
        try  {
            List<Emprestimos> lista = new ArrayList<Emprestimos>();
            
            String cmdsql = "select * from emprestimo";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Emprestimos v = new Emprestimos();
                
                v.setIdemp(rs.getInt("idemp"));
                v.setUser(rs.getString("user"));
                v.setCpf(rs.getString("cpf"));
                v.setTit(rs.getString("titulo"));
                v.setIdliv(rs.getInt("idliv"));
                v.setDataEm(rs.getString("dataEm"));
                v.setDataRet(rs.getString("dataRet"));
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirEmprestimo(Emprestimos obj){
        try {
            String cmdsql = "delete from emprestimo where idemp = ?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getIdemp());
           
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
