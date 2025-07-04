/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manejadorcliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author sofis
 */
public class ManejadorCliente implements Runnable{
    private Socket socket;
    
    public ManejadorCliente(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
    try( BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter output = new PrintWriter(socket.getOutputStream(), true)){
        
        String nombre = input.readLine();
        System.out.println("Cliente" + nombre + "Conectado");
        int numero = Integer.parseInt(input.readLine());
        int cuadrado = numero  * numero;
        
        String fechaHora = new Date().toString();
        output.println("!Buenvenido" + nombre);
        output.println("EL cuadrado del numero es" + cuadrado);
        output.println("Fecha y hora del servidor" + fechaHora);
        
        System.out.println("Cliente" + nombre + "Desconectado");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}