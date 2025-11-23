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
public class Cliente {
    private String nombre;
    private String documentoIdentidad;
    private String telefono;
    
    public Cliente(){
        
    }
    
    public Cliente(String nombre, String documentoIdentidad, String telefono){
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDocumentoIdentidad(){
        return documentoIdentidad;
    }
    
    public void setDocumentoIdentidad(String documentoIdentidad){
        this.documentoIdentidad = documentoIdentidad;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void registrarCliente(){
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
        documentoIdentidad = JOptionPane.showInputDialog("Ingrese el ID del cliente: ");
        telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente: ");
    }
    
    public String mostrarCliente(){
        return "Cliente:\n"
                + "Nombre: " + nombre + "\n"
                + "ID: " + documentoIdentidad + "\n"
                + "Telefono: " + telefono;
    }
    
    
}
