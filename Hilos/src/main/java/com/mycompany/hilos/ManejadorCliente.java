package com.mycompany.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManejadorCliente implements Runnable {
    private Socket socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter writer = new PrintWriter(socketCliente.getOutputStream(), true)
        ) {
            String nombre = reader.readLine();
            int numero = Integer.parseInt(reader.readLine());

            System.out.println("Cliente " + nombre + " conectado.");

            int cuadrado = numero * numero;
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            writer.println("Bienvenido " + nombre + "!");
            writer.println("El cuadrado de " + numero + " es: " + cuadrado);
            writer.println("Fecha y hora: " + fechaHora);

            System.out.println("Cliente " + nombre + " desconectado.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}