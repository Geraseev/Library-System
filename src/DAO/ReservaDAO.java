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
import javabeans.Reservas;

/**
 *
 * @author lgera
 */
public class ReservaDAO {
    private Connection conecta;
    
    public ReservaDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    
    public List<Reservas> listarReserva(){
        try  {
            List<Reservas> lista = new ArrayList<Reservas>();
            
            String cmdsql = "select * from reserva";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Reservas v = new Reservas();
                
                v.setIdreserva(rs.getInt("idreserva"));
                v.setIdliv(rs.getInt("idliv"));
                v.setTit(rs.getString("titulo"));
                v.setDataE(rs.getString("dataE"));
                v.setDataR(rs.getString("dataR"));
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void excluirReserva(Reservas obj){
        try {
            String cmdsql = "delete from reserva where idreserva = ?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getIdreserva());
           
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
