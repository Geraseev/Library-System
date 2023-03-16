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
import javabeans.User;
import javax.swing.JOptionPane;
import telas.Reserva;

/**
 *
 * @author lgera
 */
public class UsuarioDAO {
    private Connection conecta;
    
    public UsuarioDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public void cadastraUser(User obj){
        try {
            String cmdsql = "insert into usuario(cpf,nome,tel) values(?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getCpf());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTel());
            
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<User> listarUser(){
        try  {
            List<User> lista = new ArrayList<User>();
            
            String cmdsql = "select * from usuario";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                User v = new User();
                
                v.setIduser(rs.getInt("iduser"));
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setTel(rs.getString("tel"));
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void editarUser(User obj){
        try {
            String cmdsql = "update usuario set nome=?, cpf=?, tel=? where iduser=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getTel());
            stmt.setInt(4, obj.getIduser());
            
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirUser(User obj){
        try {
            String cmdsql = "delete from usuario where iduser = ?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getIduser());
           
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<User> listarUserNome(String nome){
        try  {
            List<User> lista = new ArrayList<User>();
            
            String cmdsql = "select * from usuario where nome like ?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                User v = new User();
                
                v.setIduser(rs.getInt("iduser"));
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setTel(rs.getString("tel"));
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void efetuarLogin(String nome, String cpf){
        try {
            String cmdsql = "select * from usuario where nome = ? and cpf = ?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1,nome);
            stmt.setString(2,cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                Reserva telaRes = new Reserva();
                telaRes.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Dados incorretos"); 
            }
            
        } catch (Exception e) {
            
        }
    }
}
