/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el.gran.hotel.de.cordoba;

import accesoData.HuespedData;
import entidades.Huesped;

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
       Huesped hue4 = new Huesped(5,"prueba","Sas",41254548,"prueba@gmail.com",113235484,true);
       Huesped Hued4 = hue4;
       HuespedData huespedData = new HuespedData();
       //huespedData.modificarHuesped(Hued4);
       huespedData.eliminarHuesped(5);
     
        
    }
    
}
