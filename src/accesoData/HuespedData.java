/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Huesped;
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
public class HuespedData {
    
    private Connection con = null;

    public HuespedData() {
        
        con=Conexion.getConexion();
        
    }
    
    
    public void agregarHuesped(Huesped huesped){
        String sql = "INSERT INTO huesped(nombre, apellido,dni,correo,celular,estado) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, huesped.getNombre());
            
            ps.setString(2, huesped.getApellido());
           
            ps.setInt(3, huesped.getDni());
          
            ps.setString(4, (huesped.getCorreo()));
          
            ps.setInt(5, huesped.getCelular());
            
            ps.setBoolean(6, huesped.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Huesped añadido con exito");
                
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped" + ex.getMessage());
        }
    }
    
    
    public void modificarHuesped(Huesped huesped){
        
        
            String sql = "UPDATE huesped SET nombre = ? , apellido = ?, dni = ?, correo = ?, celular = ? WHERE idHuesped = ?";
            PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setInt(3, huesped.getDni());
            ps.setString(4, huesped.getCorreo());
            ps.setInt(5, huesped.getCelular() );
            ps.setInt(6, huesped.getIdHuesped());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Huesped no existe");
            }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped "+ex.getMessage());
            }

    }
    
    
    
    
    public void eliminarHuesped(int id) {

        try {
            String sql = "UPDATE huesped SET estado = 0 WHERE idHuesped = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();

            if(fila==1){
                JOptionPane.showMessageDialog(null, "Se eliminó el Huesped.");
            }
            ps.close();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped");
            }  
    }
}
