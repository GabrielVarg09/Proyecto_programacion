/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srg_hotel.Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author XPC
 */
public class MenuPrincipal {

    private GestorReserva gestor;

    public MenuPrincipal() {
        gestor = new GestorReserva(50, 50);
    }

    public void mostrarMenu() {
        
        int opcion = 0;

        do {
            String[] opciones = {"Registrar clientes","Registrar habitaciones","Reservas","Salir"};
            opcion = JOptionPane.showOptionDialog(null, 
                    "Seleccione una opcion del sistema del hotel", 
                    "Sistema de Hotel", JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            
            switch (opcion) {
                
                case 0:
                    menuClientes();
                    break;
                case 1:
                    menuHabitaciones();
                    break;
                case 2:
                    menuReservas();
                    break;
                case 3:
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }

        } while (opcion != 3);
    }

    private void menuClientes() {
        Cliente cliente = new Cliente();
        cliente.registrarCliente();
        JOptionPane.showMessageDialog(null, cliente.mostrarCliente());
     }

    private void menuHabitaciones() {
        
        gestor.registrarHabitacion();
    }
           
    private void menuReservas() {
        int opcion;

        do {
            String[] opcionreserva = {"Crear reserva","Listar reservas","Buscar reserva","Cancelar reserva","Volver al menú"};
            opcion = JOptionPane.showOptionDialog(null, 
                    "Seleccione una opcion del sistema de reservas del hotel", 
                    "Sistema de Hotel", JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, null, opcionreserva, opcionreserva[0]);

            switch (opcion) {
                case 0: 
                    gestor.crearReserva();
                    break;
                case 1:
                    gestor.listarReservas();
                    break;

                case 2:
                    gestor.buscarReserva();
                    break;

                case 3:
                    gestor.cancelarReserva();
                    break;

                case 4:   
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }

        } while (opcion != 4);
    }
}
