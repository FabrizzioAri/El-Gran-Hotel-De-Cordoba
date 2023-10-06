/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Huesped;
import java.sql.Connection;
import java.sql.Date;
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
}
