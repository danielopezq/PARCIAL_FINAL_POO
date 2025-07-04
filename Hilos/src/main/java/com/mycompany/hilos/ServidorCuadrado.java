package com.mycompany.hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuadrado {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor conectado en el puerto 5000");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                Thread hilo = new Thread(new ManejadorCliente(socketCliente));
                hilo.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
