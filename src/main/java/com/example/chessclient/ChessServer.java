package com.example.chessclient;

import javafx.application.Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChessServer{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Waiting for players...");
        Socket p1 = ss.accept();
        System.out.println("Player 1 connected");

        Socket p2 = ss.accept();
        System.out.println("Player 2 connected");

        //server-ul preia fluxurile de la/către client
        DataInputStream p1_dis = new DataInputStream(p1.getInputStream());
        DataInputStream p2_dis = new DataInputStream(p2.getInputStream());
        DataOutputStream p1_dos = new DataOutputStream(p1.getOutputStream());
        DataOutputStream p2_dos = new DataOutputStream(p2.getOutputStream());

        int turn = 0;
        while(true)
        {
            // White - p1
            if (turn == 0){
                String message = p1_dis.readUTF();
                if (message.equals("GAMEOVER"))
                    break;
                System.out.println("Mesaj receptionat: " + message);
                p2_dos.writeUTF(message);
            }else if (turn == 1){
                String message = p2_dis.readUTF();
                if (message.equals("GAMEOVER"))
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
