/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srg_hotel.Clases;

/**
 *
 * @author XPC
 */
public class Reserva {

    private Cliente cliente;
    private Habitacion habitacion;
    private String fechaEntrada;
    private String fechaSalida;
    private int noches;
    private double total;

    public Reserva() {
        cliente = null;
        habitacion = null;
        fechaEntrada = "";
        fechaSalida = "";
        noches = 0;
        total = 0.0;
    }

    public Reserva(Cliente cliente, Habitacion habitacion,
                   String fechaEntrada, String fechaSalida,
                   int noches) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.noches = noches;
        this.total = 0.0;
    }

    public double calcularTotal() {
        if (habitacion != null) {
            total = noches * habitacion.getPrecioPorNoche();
        } else {
            total = 0.0;
        }
        return total;
    }

    public String mostrarReserva() {
        String texto = "";
        texto += "===== RESERVA =====\n\n";

        if (cliente != null) {
            texto += ">> Datos del cliente:\n";
            texto += cliente.mostrarCliente() + "\n";
        }

        if (habitacion != null) {
            texto += ">> Datos de la habitacion:\n";
            texto += habitacion.mostrarHabitacion() + "\n";
        }

        texto += "Fecha de entrada: " + fechaEntrada + "\n";
        texto += "Fecha de salida: " + fechaSalida + "\n";
        texto += "Noches: " + noches + "\n";
        texto += "Total: " + total + "\n";

        return texto;
    }

    // Getters y setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
