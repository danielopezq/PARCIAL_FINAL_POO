package com.mycompany.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Socket1 {

    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 5000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Conectado al servidor.");
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese un numero entero: ");
            int numero = scanner.nextInt();
            writer.println(nombre);
            writer.println(numero);
            String respuesta1 = reader.readLine();
            String respuesta2 = reader.readLine();
            String respuesta3 = reader.readLine();
            System.out.println(respuesta1);
            System.out.println(respuesta2);
            System.out.println(respuesta3);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}