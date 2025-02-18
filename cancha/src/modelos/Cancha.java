/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author golden
 */
public class Cancha {
    private String tipo;
    private double total;

    public Cancha(String tipo, double total) {
        this.tipo = tipo;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public Cancha(String tipo) {
        this.tipo = tipo;
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Cancha{" + "tipo=" + tipo + ", precio hora=" + total + "}\n";
    }

    
    
    
}
