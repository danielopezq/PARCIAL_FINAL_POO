/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Socket1 {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Se ha conectado al servidor");
            
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream,true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));            
     
            writer.println("Cliente B");
            String res = reader.readLine();
           
            System.out.println("Respuesta del servidor: " + res);
            socket.close();
        }catch(IOException e){
        System.out.println(e);}
    }
}
