/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srg_hotel.Clases;

/**
 *
 * @author XPC
 */
public class Habitacion {
    
    private int numeroHabitacion;
    private String tipo;
    private boolean disponible;
    private double precioPorNoche;
    
    
    public Habitacion(){
        numeroHabitacion = 0;
        tipo = "";
        disponible = true;
        precioPorNoche = 0.0;
    }
    public Habitacion(int numeroHabitacion, String tipo, double precioPorNoche) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
    }
    
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void cambiarDisponibilidad(boolean estado) {
        disponible = estado;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    
    public String mostrarHabitacion() {
        return "Habitacion:\n"
                + "Numero: " + numeroHabitacion + "\n"
                + "Tipo: " + tipo + "\n"
                + "Disponible: " + (disponible ? "Si" : "No") + "\n"
                + "Precio por noche: " + precioPorNoche;
    }
}
