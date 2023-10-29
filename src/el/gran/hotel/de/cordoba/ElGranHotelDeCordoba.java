/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el.gran.hotel.de.cordoba;

import accesoData.HabitacionData;
import accesoData.HuespedData;
import accesoData.ReservaData;
import accesoData.TipoDeHabitacionData;
import entidades.Habitacion;
import entidades.Huesped;
import entidades.Reserva;
import entidades.TipoDeHabitacion;
import java.sql.Date;
import java.time.LocalDate;

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
    HuespedData huespedData = new HuespedData();
    TipoDeHabitacionData th = new TipoDeHabitacionData();
    HabitacionData hD= new HabitacionData();
    ReservaData rev1 = new ReservaData();
    
    
    //-----------------------------------------------------------------------------------------------------------
    
    //Proceso de Crear una reserva con un huesped Exisitente
    
    
    Huesped hue = new Huesped(1,"Carlos","Montiel",45794166,"elpity@gmail.com",351479865,true);
    Habitacion habi = new Habitacion(1,3,true,1);
    Habitacion habitacion1 = habi;
    Huesped huesped1 = hue ;
    
    
    //Modificacion de fecha de String a LocalDate para poder usarlo en el constructor de Reserva
    
    Date fe = Date.valueOf("2023-12-1");
    Date fs = Date.valueOf("2023-12-9");
    LocalDate lcfe = fe.toLocalDate();
    LocalDate lcfs = fs.toLocalDate();
    
    //Constructor de la Reserva
    
    Reserva rev = new Reserva(huesped1,habitacion1, lcfe , lcfs ,2,500,true);
    
    //Se agrega la Reserva a la base de Datos
    
    
    
    rev1.guardarReserva(rev);
    
    
    //---------------------------------------------------------------------------------------------------------
    
    //Modificacion de Reserva
    
    
    Huesped huem = new Huesped(1,"Fabrizzio","Ariatello",42640944,"fabriariatello@gmail.com", 117341324 ,true);
    
    Date fsm = Date.valueOf("2023-12-15");
    LocalDate lcfsm = fs.toLocalDate();
    
    Reserva reservmodif = new Reserva(3, huem,habitacion1, lcfe , lcfsm ,2,300,true);
    
    rev1.modificarReserva(reservmodif);
    
    
    
    //-----------------------------------------------------------------------------------------------------------
    
    
    
    

    }
    
}
