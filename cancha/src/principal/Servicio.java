/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import modelos.Cancha;
import modelos.Reserva;
import modelos.Usuario;

/**
 *
 * @author golden
 */
public class Servicio {
    private HashMap<LocalDateTime, ArrayList<Reserva>> reservas  = new HashMap<>();
    private ArrayList<Usuario> clientes  = new ArrayList<>();
    private ArrayList<Cancha> canchas  = new ArrayList<>();
    
    public void inicializaCanchas(){
        canchas.add(new Cancha( "Cancha 1",50000.0));
        canchas.add(new Cancha("Cancha 2",60000.0));
        canchas.add(new Cancha("Cancha 3",70000.0));
        canchas.add(new Cancha("Cancha 4",45000.0));
        canchas.add(new Cancha("Cancha 5", 30000.0));
        canchas.add(new Cancha("Cancha 6",80000.0));
    }
    
    public void crearReserva(LocalDateTime fecha, Reserva r){
        ArrayList<Reserva> actual = new ArrayList<>();
        if(reservas.get(fecha) != null){
            actual = reservas.get(fecha);
            actual.add(r);
            reservas.put(fecha,actual);
        }else{
            actual.add(r);
            reservas.put(fecha,actual);
        }
    }
    
    public void registrarUsuario(Usuario u){
        clientes.add(u);
    }
    
    public void verificarDisponibilidad(LocalDateTime myDateObj){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(reservas.get(formattedDate.substring(0, 9)));
    }
    
    public void mostrarReservar(){
        for(ArrayList<Reserva> r: reservas.values()){
            System.out.println(r);
        }
    }

    public HashMap<LocalDateTime, ArrayList<Reserva>> getReservas() {
        return reservas;
    }

    public ArrayList<Usuario> getClientes() {
        return clientes;
    }

    public ArrayList<Cancha> getCanchas() {
        return canchas;
    }
    
    
}
