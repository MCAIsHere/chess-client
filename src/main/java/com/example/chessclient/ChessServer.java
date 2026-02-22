package com.example.chessclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChessServer{
    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        Socket p1;
        Socket p2;
        int turn = 0;

        System.out.println("Port:");
        Scanner sc = new Scanner(System.in);
        int port = sc.nextInt();
        ss = new ServerSocket(port);

        System.out.println("Waiting for players...");
        p1 = ss.accept();
        System.out.println("Player 1 connected");

        p2 = ss.accept();
        System.out.println("Player 2 connected");

        //server-ul preia fluxurile de la/către client
        DataInputStream p1_dis = new DataInputStream(p1.getInputStream());
        DataInputStream p2_dis = new DataInputStream(p2.getInputStream());
        DataOutputStream p1_dos = new DataOutputStream(p1.getOutputStream());
        DataOutputStream p2_dos = new DataOutputStream(p2.getOutputStream());

        p1_dos.writeUTF("Start");
        while(true)
        {
            // White - p1
            if (turn == 0){
                String message = p1_dis.readUTF();
                if (message.equals("Game over"))
                    break;
                System.out.println("Mesaj receptionat: " + message);
                p2_dos.writeUTF(message);
            }else if (turn == 1){
                String message = p2_dis.readUTF();
                if (message.equals("Game over"))
                    break;
                System.out.println("Mesaj receptionat: " + message);
                p1_dos.writeUTF(message);
            }
            turn ^= 1;
        }
        p1_dis.close();
        p1_dos.close();
        p2_dis.close();
        p2_dos.close();
        p1.close();
        p2.close();
        ss.close();
    }
}
