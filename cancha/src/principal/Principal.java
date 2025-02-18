/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import modelos.Cancha;
import modelos.Reserva;
import modelos.Usuario;
import principal.Servicio;

/**
 *
 * @author golden
 */
public class Principal {

    Scanner sc = new Scanner(System.in);
    Servicio s = new Servicio();

    public static void main(String[] args) {
        Principal p = new Principal();
        p.menu();
    }

    public void menu() {
        System.out.println("BIENVENIDO ADMINISTRADOR, \n"
                + "no olvides recordarle al usuario que si se inscribe en el sistema por cada 10 horas de partido podra recibir una gratis");
        s.inicializaCanchas();
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("\nDigite una opcion: \n1) Generar una reserva \n 2)Ver reporte total de reservas \n"
                    + "3)Reporte de reservas basado en fecha\n 4)Ver usuarios registrados \n 5) Registrar usuario \n"
                    + "6) Usar bono de registro \n 7) Ver reservas por usuario \n 8) Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Digite fecha del partido en formato YYYY-MM-DD: ");
                    String fecha = sc.next();
                    System.out.println("Digite hora exacta formato (0-24 hora militar): ");
                    int hora = sc.nextInt();
                    LocalDateTime aDateTime;
                    ArrayList<Reserva> filtrado = new ArrayList<>();
                    aDateTime = LocalDateTime.of(Integer.parseInt(fecha.substring(0, 4)), Integer.parseInt(fecha.substring(5, 7)), Integer.parseInt(fecha.substring(8, 10)), hora, 0, 0);
                    ArrayList<Cancha> descartadas = new ArrayList<>();
                    ArrayList<Cancha> disponibles = new ArrayList<>();
                    if (s.getReservas().containsKey(LocalDateTime.of(Integer.parseInt(fecha.substring(0, 4)), Integer.parseInt(fecha.substring(5, 7)), Integer.parseInt(fecha.substring(8, 10)), 0, 0, 0))) {
                        filtrado = s.getReservas().get(LocalDateTime.of(Integer.parseInt(fecha.substring(0, 4)), Integer.parseInt(fecha.substring(5, 7)), Integer.parseInt(fecha.substring(8, 10)), 0, 0, 0));
                    } else {
                        disponibles = s.getCanchas();
                    }

                    for (Reserva r : filtrado) {
                        if (r.getFecha().getHour() == aDateTime.getHour()) {
                            descartadas.add(new Cancha(r.getTipoCancha()));
                        }
                    }
                    for (Cancha c : s.getCanchas()) {
                        for (Cancha des : descartadas) {
                            if (!c.getTipo().equals(des.getTipo())) {
                                disponibles.add(c);
                            }

                        }

                    }

                    System.out.println("Cual es su cedula? ");
                    String cedula = sc.next();
                    System.out.println("Que cancha le gustaria reservar? seleccione opcion: ");

                    for (int i = 0; i < disponibles.size(); i++) {
                        System.out.println((i + 1) + ")" + disponibles.get(i));
                    }
                    int opcionCancha = sc.nextInt();
                    while (opcionCancha > disponibles.size()) {
                        System.out.println("Escogio una cancha no disponible, Digite una que sea valida Porfavor ");
                        opcionCancha = sc.nextInt();
                    }
                    System.out.println("Por cuantas horas quiere reservar? ");
                    int duracion = sc.nextInt();
                    //sc.next();
                    System.out.println("La cancha escogida cuesta " + disponibles.get(opcionCancha - 1).getTotal() * duracion + " cuanto quieres abonar? ");
                    int abono = sc.nextInt();
                    s.crearReserva(LocalDateTime.of(aDateTime.getYear(), aDateTime.getMonth(), aDateTime.getDayOfMonth(), 0, 0, 0), new Reserva(cedula, aDateTime, duracion, disponibles.get(opcionCancha - 1).getTipo(), abono, disponibles.get(opcionCancha - 1).getTotal() * duracion));
                    if (duracion > 1) {
                        for (int i = 0; i < duracion - 1; i++) {
                            s.crearReserva(LocalDateTime.of(aDateTime.getYear(), aDateTime.getMonth(), aDateTime.getDayOfMonth(), 0, 0, 0), new Reserva(LocalDateTime.of(aDateTime.getYear(), aDateTime.getMonth(), aDateTime.getDayOfMonth(), aDateTime.getHour() + (i + 1), 0, 0), disponibles.get(opcionCancha - 1).getTipo()));
                        }
                    }
                    break;
                // crear reserva, ver reporte de reservas totales, reservas por fecha, (usuarios), reservas por usuario                 // crear reserva, ver reporte de reservas totales, reservas por fecha, (usuarios), reservas por usuario 
                case 2:
                    s.mostrarReservar();
                    break;
                case 3:
                    System.out.println("Digite fecha para mirar los reportes YYYY-MM-DD: ");
                    fecha = sc.next();
                    LocalDateTime fecha_interes;
                    fecha_interes = LocalDateTime.of(Integer.parseInt(fecha.substring(0, 4)), Integer.parseInt(fecha.substring(5, 7)), Integer.parseInt(fecha.substring(8, 10)), 0, 0, 0);

                    filtrado = s.getReservas().get(fecha_interes);
                    System.out.println("Las reservas del dia : " + fecha_interes + " son: ");
                    System.out.println(filtrado);
                    break;
                case 4:
                    //System.out.println("Los usuarios registrados son: " + s.getClientes());
                	verUsuarios();
                    break;
                case 5:
                	System.out.println("Digite su nombre");
                	String nombre = sc.next();
                	System.out.println("Digite su cedula");
                	cedula = sc.next();
                	registrarUsuarios(nombre, cedula);
                	break;
            }
        }

    }
    
    public void registrarUsuarios(String nombre, String cedula) {
    	int index = 0;
    	ArrayList<Reserva> reservas = new ArrayList<>();
    	for(ArrayList<Reserva> r: s.getReservas().values()){
    		if(r.get(index).getCedula().equals(cedula)) {
    			reservas.add(r.get(index));
    		}
    		index++;
        }
    	
    	if (!s.getClientes().isEmpty()) {
    		if(s.getClientes().stream().filter(p->p.getCedula().equals(cedula)).findFirst().isPresent()) {
	    		System.out.println("El usuario ya ha sido registrado");
	    	}else {
	    		Usuario user = new Usuario(nombre, cedula, reservas);
	    		s.registrarUsuario(user);
	    	}
    	}else {
    		Usuario user = new Usuario(nombre, cedula, reservas);
    		s.registrarUsuario(user);
    	}
    }
    
    public void verUsuarios() {
    	if (s.getClientes().isEmpty()) {
			System.out.println("No hay usuarios registrados");
		}else {
			System.out.println("Los usuarios registrados son: ");
			for (int i = 0; i < s.getClientes().size(); i++) {
				System.out.println(s.getClientes().get(i));
			}
		}
    }
}
