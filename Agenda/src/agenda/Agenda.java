/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import agenda.Datos.DBContactos;
import agenda.logica.Contacto;

/**
 *
 * @author Estudiantes
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBContactos dbcontactos = new DBContactos();
        Contacto[] contactos = dbcontactos.getContactos();
        
        for (Contacto contacto : contactos){
            System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getApellido());
        }
    }
    
}
