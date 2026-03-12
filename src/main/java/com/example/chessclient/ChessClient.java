package com.example.chessclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChessClient {
    private ChessController client_controller;
    private Socket cs;
    private DataInputStream c_dis;
    private DataOutputStream c_dos;

    ChessClient(String host, int port, ChessController controller){
        try{
            this.client_controller = controller;
            this.cs = new Socket(host, port);
            this.c_dis = new DataInputStream(cs.getInputStream());
            this.c_dos = new DataOutputStream(cs.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void startListening(){
        new Thread(() -> {
            while (true){
                try {
                    String message = c_dis.readUTF();
                    if (message.equals("STOP")) {
                        break;
                    } else {
                        //
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            closeConnection();
        }).start();
    }
    public void sentMove(String moveset){
        try {
            c_dos.writeUTF(moveset);
            c_dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try{
            this.c_dis.close();
            this.c_dos.close();
            this.cs.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
