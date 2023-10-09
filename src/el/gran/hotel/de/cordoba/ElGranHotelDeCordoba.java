/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el.gran.hotel.de.cordoba;

import accesoData.HabitacionData;
import accesoData.HuespedData;
import accesoData.TipoDeHabitacionData;
import entidades.Habitacion;
import entidades.Huesped;
import entidades.TipoDeHabitacion;

/**
 *
 * @author Fabrizzio
 */
public class ElGranHotelDeCordoba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //Huesped hue1 = new Huesped("Carlos","Montiel",45794166,"elpity@gmail.com",351479865,true);
       //Huesped hue2 = new Huesped("Octavio","Calles",45845666,"octavio@gmail.com",355566135,true);
       //Huesped hue3 = new Huesped("Jazmin","Saavedra",41215448,"jaz@gmail.com",116465484,true);
       //Huesped hue4 = new Huesped(5,"prueba","Sas",41254548,"prueba@gmail.com",113235484,true);
       //Huesped Hued4 = hue4;
       //HuespedData huespedData = new HuespedData();
       //huespedData.modificarHuesped(Hued4);
       //huespedData.eliminarHuesped(5);
       
       TipoDeHabitacion t1 = new TipoDeHabitacion(1,3,3,"Simple",250);
       TipoDeHabitacion t2 = new TipoDeHabitacion(2,1,"Queen",300);
       TipoDeHabitacion t3 = new TipoDeHabitacion(4,2,"King",350);
      
       TipoDeHabitacionData th = new TipoDeHabitacionData();/*
       th.agregarTipo(t1);
       th.agregarTipo(t2);
       th.agregarTipo(t3);
       
       TipoDeHabitacion th1 = t1;
       th.modificarTipo(th1);
       */
       Habitacion habi1 = new Habitacion(2,true,1);
       Habitacion habi2 = new Habitacion(3,true,1);
       Habitacion habi3 = new Habitacion(3,3,true,1);
       
       HabitacionData hD= new HabitacionData();
       Habitacion Habi3 = habi3;
       
       //hD.agregarHabitacion(habi2);
       //hD.agregarHabitacion(habi3);
       
      // hD.modificarHabitacion(Habi3);
       
      hD.deshabilitarHabitacion(1);
    }
    
}
