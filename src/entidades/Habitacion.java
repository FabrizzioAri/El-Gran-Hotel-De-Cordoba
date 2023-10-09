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
public class Habitacion {
    private int idHabitacion;
    private int idTipo;
    private boolean estado;
    private int piso;

    public Habitacion() {
    }

    public Habitacion( int idTipo, boolean estado,int piso) {
        this.idTipo = idTipo;
        this.piso = piso;
        this.estado = estado;
    }

    public Habitacion(int idHabitacion, int idTipo, boolean estado, int piso) {
        this.idHabitacion = idHabitacion;
        this.idTipo = idTipo;
        this.estado = estado;
        this.piso = piso;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", IdTipo=" + idTipo + ", Estado=" + estado + ", Piso=" + piso + '}';
    }
    
    
    
    
    
    
}
