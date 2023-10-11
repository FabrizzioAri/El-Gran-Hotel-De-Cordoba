/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabrizzio
 */
public class ReservaData {
    
    private Connection con = null;

    public ReservaData() {
        
        con=Conexion.getConexion();
        
    }
    
    public void guardarReserva(Reserva reserva){
        
    String sql = "INSERT INTO reserva(idHuesped, idHabitacion, fechaEntrada, fechaSalida, cantPersonas, precio, estado) VALUES (?,?,?,?,?,?,?)";
    
    
    
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getHuesped().getIdHuesped());
            ps.setInt(2, reserva.getHabitacion().getIdHabitacion());
            ps.setDate(3, Date.valueOf(reserva.getFechaEntrada()));
            ps.setDate(4, Date.valueOf(reserva.getFechaSalida()));
            ps.setInt(5, reserva.getCantPersonas());
            ps.setInt(6, reserva.getPrecio());
            ps.setBoolean(7, reserva.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                reserva.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Reserva añadida con exito");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva " + ex.getMessage());
        }
    }
    
    public void modificarReserva(Reserva reserva){
        
    String sql = "UPDATE reserva SET idHuesped= ? ,idHabitacion= ? ,fechaEntrada= ? ,fechaSalida= ? ,cantPersonas= ? ,precio = ?, estado = ? WHERE idReserva = ?";
    
    
    
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getHuesped().getIdHuesped());
            ps.setInt(2, reserva.getHabitacion().getIdHabitacion());
            ps.setDate(3, Date.valueOf(reserva.getFechaEntrada()));
            ps.setDate(4, Date.valueOf(reserva.getFechaSalida()));
            ps.setInt(5, reserva.getCantPersonas());
            ps.setInt(6, reserva.getPrecio());
            ps.setBoolean(7, reserva.isEstado());
            ps.setInt(8, reserva.getIdReserva());
            ps.executeUpdate();
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La Habitacion no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva " + ex.getMessage());
        }
    }
    
    
    public void eliminarReserva(int id){
        String sql = "DELETE FROM reserva WHERE idReserva =  ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            int fila=ps.executeUpdate();

            if(fila==1){
                JOptionPane.showMessageDialog(null, "Reserva Eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva");
        }
                
    }
    
    
    
}
