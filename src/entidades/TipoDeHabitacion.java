/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Fabrizzio
 */
public class TipoDeHabitacion {
    private int idTipo;
    private String nombre;
    private int cantPersonas;
    private int cantCamas;
    private String tipoCamas;
    private int precio;

    public TipoDeHabitacion() {
    }

    public TipoDeHabitacion(String nombre ,int cantPersonas, int cantCamas, String tipoCamas, int precio) {
        this.nombre = nombre;
        this.cantPersonas = cantPersonas;
        this.cantCamas = cantCamas;
        this.tipoCamas = tipoCamas;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDeHabitacion(int idTipo,String nombre, int cantPersonas, int cantidadCamas, String tipoCamas, int precio) {
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.cantPersonas = cantPersonas;
        this.cantCamas = cantidadCamas;
        this.tipoCamas = tipoCamas;
        this.precio = precio;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantidadCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "TipoDeHabitacion{" + "idTipo=" + idTipo + ", nombre=" + nombre + ", cantPersonas=" + cantPersonas + ", cantCamas=" + cantCamas + ", tipoCamas=" + tipoCamas + ", precio=" + precio + '}';
    }

    

    public int cantPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
