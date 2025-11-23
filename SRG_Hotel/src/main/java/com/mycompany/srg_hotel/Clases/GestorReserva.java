/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srg_hotel.Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author surys
 */
public class GestorReserva {

    private Reserva[] reservas;
    private Habitacion[] habitaciones;
    private int contadorReservas;
    private int contadorHabitaciones;

    public GestorReservas(int tamanoHabitaciones, int tamanoReservas) {
        habitaciones = new Habitacion[tamanoHabitaciones];
        reservas = new Reserva[tamanoReservas];
        contadorHabitaciones = 0;
        contadorReservas = 0;
    }

    public void registrarHabitacion() {
        if (contadorHabitaciones >= habitaciones.length) {
            JOptionPane.showMessageDialog(null,
                    "No hay espacio para mas habitaciones");
        } else {
            String lectura;

            lectura = JOptionPane.showInputDialog("Digite el numero de la habitacion:");
            int numero = Integer.parseInt(lectura);

            String tipo = JOptionPane.showInputDialog(
                    "Digite el tipo de habitacion (simple, doble, suite):");

            lectura = JOptionPane.showInputDialog("Digite el precio por noche:");
            double precio = Double.parseDouble(lectura);

            Habitacion nueva = new Habitacion(numero, tipo, precio);
            habitaciones[contadorHabitaciones] = nueva;
            contadorHabitaciones++;

            JOptionPane.showMessageDialog(null,
                    "Habitacion registrada correctamente");
        }
    }

    public void crearReserva() {
        if (contadorReservas >= reservas.length) {
            JOptionPane.showMessageDialog(null,
                    "No hay espacio para mas reservas");
            return;
        }

        Habitacion habitacionDisponible = obtenerHabitacionDisponible();

        if (habitacionDisponible == null) {
            JOptionPane.showMessageDialog(null,
                    "No hay habitaciones disponibles");
            return;
        }

        // Registrar datos del cliente
        Cliente cliente = new Cliente();
        cliente.registrarCliente();

        String fechaEntrada = JOptionPane.showInputDialog(
                "Digite la fecha de entrada (ej: 2025-11-20):");

        String fechaSalida = JOptionPane.showInputDialog(
                "Digite la fecha de salida (ej: 2025-11-22):");

        String lecturaNoches = JOptionPane.showInputDialog(
                "Digite la cantidad de noches de la reserva:");
        int noches = Integer.parseInt(lecturaNoches);

        // Crear la reserva
        Reserva nueva = new Reserva(cliente, habitacionDisponible,
                fechaEntrada, fechaSalida, noches);

        nueva.calcularTotal();

        reservas[contadorReservas] = nueva;
        contadorReservas++;

        habitacionDisponible.cambiarDisponibilidad(false);

        JOptionPane.showMessageDialog(null,
                "Reserva creada correctamente");
    }

    public void listarReservas() {
        if (contadorReservas == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay reservas registradas");
            return;
        }

        String texto = "";

        for (int i = 0; i < contadorReservas; i++) {
            if (reservas[i] != null && reservas[i].getTotal() >= 0) {
                texto += reservas[i].mostrarReserva() + "\n";
            }
        }

        if (texto.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "No hay reservas activas");
        } else {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public Reserva buscarReserva() {
        if (contadorReservas == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay reservas registradas");
            return null;
        }

        String documento = JOptionPane.showInputDialog(
                "Digite el documento del cliente a buscar:");

        for (int i = 0; i < contadorReservas; i++) {
            Cliente c = reservas[i].getCliente();
            if (c != null && c.getDocumentoIdentidad().equals(documento)) {
                JOptionPane.showMessageDialog(null,
                        "Reserva encontrada:\n\n" + reservas[i].mostrarReserva());
                return reservas[i];
            }
        }

        JOptionPane.showMessageDialog(null,
                "No se encontro una reserva activa para ese documento");
        return null;
    }

    public void cancelarReserva() {
        if (contadorReservas == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay ningun registro");
            return;
        }

        String documento = JOptionPane.showInputDialog(
                "Digite el documento del cliente para cancelar:");

        for (int i = 0; i < contadorReservas; i++) {
            Cliente c = reservas[i].getCliente();
            if (c != null && c.getDocumentoIdentidad().equals(documento)) {

                Habitacion h = reservas[i].getHabitacion();
                if (h != null) {
                    h.cambiarDisponibilidad(true);
                }

                reservas[i].setTotal(0);
                JOptionPane.showMessageDialog(null,
                        "Reserva cancelada correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "No se encontro reserva para ese documento");
    }

    private Habitacion obtenerHabitacionDisponible() {
        for (int i = 0; i < contadorHabitaciones; i++) {
            if (habitaciones[i].isDisponible()) {
                return habitaciones[i];
            }
        }
        return null;
    }
}
