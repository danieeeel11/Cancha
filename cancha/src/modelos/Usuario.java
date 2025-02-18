/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;



/**
 *
 * @author golden
 */
public class Usuario {
    private String nombre;
    private String cedula;
    ArrayList<Reserva> reservasP;

    public Usuario(String nombre, String cedula, ArrayList<Reserva> reservasP) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.reservasP = reservasP;
    }

    public ArrayList<Reserva> getReservasP() {
        return reservasP;
    }

    public void setReservasP(ArrayList<Reserva> reservasP) {
        this.reservasP = reservasP;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" + "\n  Nombre = " + nombre + "\n  Cedula = " + cedula + "\n  Reservas = " + reservasP + '}';
    }
    
    
    
}
