/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Habitacion;
import entidades.Huesped;
import entidades.TipoDeHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabrizzio
 */
public class HabitacionData {
  
    private Connection con = null;

    public HabitacionData() {
        
        con=Conexion.getConexion();
        
    }
  
  public void agregarHabitacion(Habitacion habitacion){
        String sql = "INSERT INTO habitacion(idTipo, estado,piso) VALUES (?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, habitacion.getIdTipo());
            
            ps.setBoolean(2, habitacion.isEstado());
           
            ps.setInt(3, habitacion.getPiso());
          
            
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                habitacion.setIdHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Habitacion añadido con exito");
                
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion " + ex.getMessage());
        }
    }
    
    
    public void modificarHabitacion(Habitacion habitacion){
        
        
            String sql = "UPDATE habitacion SET idTipo = ?  WHERE idHabitacion = ?";
            PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, habitacion.getIdTipo());
            
            ps.setInt(2, habitacion.getIdHabitacion());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La Habitacion no existe");
            }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion "+ex.getMessage());
            }

    }
    
    
    
    
    public void deshabilitarHabitacion(int id) {

        try {
            String sql = "UPDATE habitacion SET estado = 0 WHERE idHabitacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();

            if(fila==1){
                JOptionPane.showMessageDialog(null, "Hbaitacion Suspendida.");
            }
            ps.close();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion");
            }  
    }
  
  
  
}
