/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServidorCuadrado {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server esperando conexiones...");
            
            while(true){
                Socket socketCliente = serverSocket.accept();
                System.out.println("Direccion del cliente: " 
                        + socketCliente.getInetAddress());
                new Thread(new ManejadorCliente(socketCliente)).start();
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
}
