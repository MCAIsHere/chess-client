package com.example.chessclient;

import javafx.application.Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChessClient {
    public static void main(String[] sir) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresa serverului: ");
        String adresa = sc.next();
        System.out.print("Portul serverului: ");
        int port = sc.nextInt();
        sc.nextLine();

        //conectarea la server
        Socket cs = new Socket(adresa, port);
        System.out.println("Conectare reusita la server!");

        //preluăm fluxurile de intrare/ieșire de la/către server
        DataInputStream dis = new DataInputStream(cs.getInputStream());
        DataOutputStream dos = new DataOutputStream(cs.getOutputStream());

        while(true)
        {
            String linie = dis.readUTF();
            System.out.println("Mesaj receptionat: " + linie);

            if (!linie.equals("Stop")){
                linie = sc.nextLine();
                dos.writeUTF(linie);
                dos.flush();
            }else break;
        }
        cs.close();
        dis.close();
        dos.close();
    }
}
