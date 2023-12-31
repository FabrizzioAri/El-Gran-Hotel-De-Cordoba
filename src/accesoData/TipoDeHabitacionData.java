/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import accesoData.Conexion;
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
public class TipoDeHabitacionData {
    
    
    private Connection con = null;

    public TipoDeHabitacionData() {
        
        con=Conexion.getConexion();
        
    }
    
    public void agregarTipo(TipoDeHabitacion tipo){
        String sql = "INSERT INTO tipohabitacion(nombre ,cantPersonas, cantCamas, tipoCamas, precio) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    
            ps.setString(1, tipo.getNombre());
            ps.setInt(2, tipo.getCantPersonas());
            
            ps.setInt(3, tipo.getCantCamas());
           
            ps.setString(4, tipo.getTipoCamas());
          
            ps.setInt(5, tipo.getPrecio());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                tipo.setIdTipo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tipo añadido con exito");
                
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped" + ex.getMessage());
        }
    }
    
    
    public void modificarTipo(TipoDeHabitacion tipo){
        
        
            String sql = "UPDATE tipoHabitacion SET nombre= ? ,cantPersonas = ? ,cantCamas = ?, tipoCamas = ?, precio = ? WHERE idTipo = ?";
            PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, tipo.getNombre());
            ps.setInt(2, tipo.getCantPersonas());
            
            ps.setInt(3, tipo.getCantCamas());
           
            ps.setString(4, tipo.getTipoCamas());
          
            ps.setInt(5, tipo.getPrecio());
            ps.setInt(6, tipo.getIdTipo());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Tipo de Habitacion no existe");
            }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tipo de Habitacion "+ ex.getMessage());
            }

    }
    
    public void eliminarTipo(int id) {

        try {
            String sql = "UPDATE tipoHabitacion SET estado = 0 WHERE idTipo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();

            if(fila==1){
                JOptionPane.showMessageDialog(null, "Se Deshabilito el Tipo.");
            }
            ps.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla del Tipo de Habitacion" + ex.getMessage());
            }  
    }
    
    
    
    
    

}
