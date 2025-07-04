/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ManejadorCliente implements Runnable {
    private Socket socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    @Override
    public void run(){
        try{
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            String nombre = reader.readLine();
            System.out.println("El cliente " + nombre + " realizo la accion");
            writer.println("Bienvenido " + nombre + "!");
            socketCliente.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
