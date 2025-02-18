/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author golden
 */
public class Reserva {
    
    private int idReserva;
    private String cedula;
    private LocalDateTime fecha;
    private int duracion;
    private String tipoCancha;
    private double abono;
    private double pago;
     

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }


    public Reserva(String cedula, LocalDateTime fecha, int duracion, String tipoCancha, double abono, double pago) {
        int idR =1000000 + (int)(Math.random() * ((9999999 - 1000000) + 1));
        this.idReserva = idR;
        this.cedula = cedula;
        this.fecha = fecha;
        this.duracion = duracion;
        this.tipoCancha = tipoCancha;
        this.abono = abono;
        this.pago = pago;
    }

    public Reserva(LocalDateTime fecha, String tipoCancha) {
        this.fecha = fecha;
        this.tipoCancha = tipoCancha;
    }

    
    
    

    @Override
    public String toString() {
        return "{" + "Id reserva = " + idReserva + ", Cedula = " + cedula + ", Fecha = " + fecha + ", Num horas = " + duracion + ", Cancha = " + tipoCancha + ", Abono = " + abono + ", Pago = " + pago + ", Saldo pendiente = "+(pago-abono)+"}\n";
    }
    

    
    
    
    
    
    
    
    
}
