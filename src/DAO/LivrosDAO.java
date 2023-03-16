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
import javabeans.Livros;

/**
 *
 * @author lgera
 */
public class LivrosDAO {
    private Connection conecta;
    
    public LivrosDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public void cadastraLivro(Livros obj){
        try {
            String cmdsql = "insert into livro(titulo,autor,editora) values(?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getTitulo());
            stmt.setString(2, obj.getAutor());
            stmt.setString(3, obj.getEditora());
            
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Livros> listarLivros(){
        try  {
            List<Livros> lista = new ArrayList<Livros>();
            
            String cmdsql = "select* from livro";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Livros v = new Livros();
                
                v.setIdlivro(rs.getInt("idlivro"));
                v.setTitulo(rs.getString("titulo"));
                v.setAutor(rs.getString("autor"));
                v.setEditora(rs.getString("editora"));
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void editarLiv(Livros obj){
        try {
            String cmdsql = "update livro set titulo=?, autor=?, editora=? where idlivro=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getTitulo());
            stmt.setString(2, obj.getAutor());
            stmt.setString(3, obj.getEditora());
            stmt.setInt(4, obj.getIdlivro());
            
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirLiv(Livros obj){
        try {
            String cmdsql = "delete from livro where idlivro = ?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getIdlivro());
           
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Livros> listarLivrosPorTit(String titulo){
        try  {
            List<Livros> lista = new ArrayList<Livros>();
            
            String cmdsql = "select* from livro where titulo like ?";
            
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, titulo);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Livros v = new Livros();
                
                v.setIdlivro(rs.getInt("idlivro"));
                v.setTitulo(rs.getString("titulo"));
                v.setAutor(rs.getString("autor"));
                v.setEditora(rs.getString("editora"));
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

    
}
