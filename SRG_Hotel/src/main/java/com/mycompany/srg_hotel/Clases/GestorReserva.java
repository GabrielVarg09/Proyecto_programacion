/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srg_hotel.Clases;

import com.mycompany.srg_hotel.Enumeradores.TipoHabitacion;
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

    public GestorReserva(int tamanoHabitaciones, int tamanoReservas) {
        habitaciones = new Habitacion[tamanoHabitaciones];
        reservas = new Reserva[tamanoReservas];
        contadorHabitaciones = 0;
        contadorReservas = 0;
    }

    public void registrarHabitacion() {
        if (contadorHabitaciones >= habitaciones.length) {
            JOptionPane.showMessageDialog(null, "No hay espacio para mas habitaciones");
        } else {
            int numero;

            while (true) {
                String lectura = JOptionPane.showInputDialog("Digite el numero de la habitacion:");
                numero = Integer.parseInt(lectura);
                boolean repeticion = false;

                for (int i = 0; i < contadorHabitaciones; i++) {
                    if (habitaciones[i].getNumeroHabitacion() == numero) {
                        repeticion = true;
                        break;
                    }
                }

                if (repeticion) {
                    JOptionPane.showMessageDialog(null, "La habitacion #" + numero + " ya esta definida");
                } else {
                    break;
                }
            }

            String tipo = "";
            boolean valido = false;

            while (!valido) {

                tipo = JOptionPane.showInputDialog(
                        "Digite el tipo de habitacion (simple, doble, suite):");

                if (tipo.equalsIgnoreCase(TipoHabitacion.SIMPLE.name())
                        || tipo.equalsIgnoreCase(TipoHabitacion.DOBLE.name())
                        || tipo.equalsIgnoreCase(TipoHabitacion.SUITE.name())) {

                    valido = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Tipo incorrecto. Solo puede ser: simple, doble o suite");
                }
            }
            String lecturaPrecio = JOptionPane.showInputDialog("Digite el precio por noche:");
            double precio = Double.parseDouble(lecturaPrecio);

            Habitacion nueva = new Habitacion(numero, tipo, precio);
            habitaciones[contadorHabitaciones] = nueva;
            contadorHabitaciones++;
        }
    }

    public void crearReserva() {
        if (contadorReservas >= reservas.length) {
            JOptionPane.showMessageDialog(null,
                    "No hay espacio para mas reservas");
            return;
        }

        String lista = "Habitaciones disponibles:\n";
        for (int i = 0; i < contadorHabitaciones; i++) {
            if (habitaciones[i] != null && habitaciones[i].isDisponible()) {
                lista += (i + 1) + ". Habitacion #" + habitaciones[i].getNumeroHabitacion()
                        + " (" + habitaciones[i].getTipo() + ") " + "₡"
                        + habitaciones[i].getPrecioPorNoche() + "\n";
            }
        }

        if (lista.equals("Habitaciones disponibles:\n")) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles");
            return;
        }

        int seleccion = Integer.parseInt(
                JOptionPane.showInputDialog(lista + "\nSeleccione una habitacion:"));

        while (true) {

            if (seleccion < 1 || seleccion > contadorHabitaciones) {
                JOptionPane.showMessageDialog(null, "La habitacion no existe.");
            } else {
                Habitacion habitacion = habitaciones[seleccion - 1];

                if (habitacion.isDisponible()) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "La habitacion esta ocupada.");
                }
            }
            seleccion = Integer.parseInt(
                    JOptionPane.showInputDialog("Seleccione otra habitacion: " + "\n" + lista + "\n"));

        }

        Habitacion habitacionDisponible = habitaciones[seleccion - 1];

        Cliente cliente = new Cliente();
        cliente.registrarCliente();
        String fechaEntrada = "";
        boolean fechaEntradaValida = false;

        while (!fechaEntradaValida) {
            fechaEntrada = JOptionPane.showInputDialog(
                    "Digite la fecha de entrada (formato AAAA-MM-DD):");

            if (esFechaValida(fechaEntrada)) {
                fechaEntradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Fecha de entrada invalida. Debe tener el formato AAAA-MM-DD.");
            }
        }

        int noches = 0;
        boolean nochesValidas = false;
        while (!nochesValidas) {
            String lecturaNoches = JOptionPane.showInputDialog(
                    "Digite la cantidad de noches de la reserva (maximo 30):");
            noches = Integer.parseInt(lecturaNoches);
            if (noches < 1) {
                JOptionPane.showMessageDialog(null,
                        "La cantidad de noches debe ser al menos 1.");
            } else if (noches > 30) {
                JOptionPane.showMessageDialog(null,
                        "Mas de 30 noches no es posible");
            } else {
                nochesValidas = true;
            }
        }

        Reserva nueva = new Reserva(cliente, habitacionDisponible,fechaEntrada,noches);
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
            if (reservas[i] != null) {
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
                "Digite el numero de identificacion del cliente a buscar:");

        for (int i = 0; i < contadorReservas; i++) {
            if (reservas[i] != null) {
                Cliente cliente = reservas[i].getCliente();
                if (cliente != null && cliente.getDocumentoIdentidad().equals(documento)) {
                    JOptionPane.showMessageDialog(null,
                            "Reserva encontrada:\n\n" + reservas[i].mostrarReserva());
                    return reservas[i];
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                "No se encontro ninguna reserva activa para ese numero de identificacion");
        return null;
    }

    public void cancelarReserva() {
        if (contadorReservas == 0) {
            JOptionPane.showMessageDialog(null, "No hay ningun registro");
            return;
        }

        String documento = JOptionPane.showInputDialog(
                "Digite numero de identificacion del cliente para cancelar:");

        for (int i = 0; i < contadorReservas; i++) {
            Cliente cliente = reservas[i].getCliente();
            if (cliente != null && cliente.getDocumentoIdentidad().equals(documento)) {

                Habitacion habitacion = reservas[i].getHabitacion();
                if (habitacion != null) {
                    habitacion.cambiarDisponibilidad(true);
                }
                for (int j = i; j < contadorReservas - 1; j++) {
                    reservas[j] = reservas[j + 1];
                }

                reservas[contadorReservas - 1] = null;
                contadorReservas--;

                JOptionPane.showMessageDialog(null, "Reserva cancelada correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontro reserva para ese numero de identificacion");
    }

    private Habitacion obtenerHabitacionDisponible() {
        for (int i = 0; i < contadorHabitaciones; i++) {
            if (habitaciones[i].isDisponible()) {
                return habitaciones[i];
            }
        }
        return null;
    }

    private boolean esFechaValida(String fecha) {
        if (fecha == null){
            return false;
        }
        if (fecha.length() != 10) {
            return false;
        }
        if (fecha.charAt(4) != '-' || fecha.charAt(7) != '-') {
            return false;
        }

        for (int i = 0; i < fecha.length(); i++) {
            if (i == 4 || i == 7) {
                continue;
            }
            char c = fecha.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        String anioStr = fecha.substring(0, 4);
        String mesStr = fecha.substring(5, 7);
        String diaStr = fecha.substring(8, 10);

        int anio = Integer.parseInt(anioStr);
        int mes = Integer.parseInt(mesStr);
        int dia = Integer.parseInt(diaStr);

        if (anio < 1900) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > 31) {
            return false;
        }
        return true;
    }
}
