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
        int opcion;

        do {
            String[] opciones = {"Registrar habitaciones","Crear reserva","Listar reservas","Buscar reserva","Cancelar reserva","Salir"};
            opcion = JOptionPane.showOptionDialog(null, 
                    "Seleccione una opcion del sistema del hotel", 
                    "Sistema de Hotel", JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0: 
                    gestor.registrarHabitacion();
                    break;
                case 1:
                    gestor.crearReserva();
                    break;

                case 2:
                     gestor.listarReservas(); 
                    break;

                case 3:
                    gestor.buscarReserva(); 
                    break;
                    
                case 4: 
                    gestor.cancelarReserva();
                    break;
                    
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }

        } while (opcion != 5);
    }
}
