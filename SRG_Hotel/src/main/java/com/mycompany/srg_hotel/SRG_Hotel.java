/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.srg_hotel;

import javax.swing.JOptionPane;
import com.mycompany.srg_hotel.Clases.GestorReserva;
import javax.swing.JOptionPane;
/**
 *
 * @author XPC
 */
public class SRG_Hotel {

    public static void main(String[] args) {          
        GestorReserva gestor = new GestorReserva(10, 20);  
        // 10 habitaciones, 20 reservas

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PRINCIPAL\n"
                    + "1. Registrar habitacion\n"
                    + "2. Crear reserva\n"
                    + "3. Listar reservas\n"
                    + "4. Buscar reserva\n"
                    + "5. Cancelar reserva\n"
                    + "6. Salir\n\n"
                    + "Digite una opcion:"));

            switch (opcion) {
                case 1:
                    gestor.registrarHabitacion();
                    break;
                case 2:
                    gestor.crearReserva();
                    break;
                case 3:
                    gestor.listarReservas();
                    break;
                case 4:
                    gestor.buscarReserva();
                    break;
                case 5:
                    gestor.cancelarReserva();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }

        } while (opcion != 6);
    }
   
}
