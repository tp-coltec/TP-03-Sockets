package com.example.haasi.tp_03;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    public static String chat;
    private String nome;
    private Socket socket;
    private OutputStream ou ;
    private Writer ouw;
    private BufferedWriter bfw;

    public void conectar(int port) throws IOException{
        socket = new Socket("192.168.0.5", 5000);
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.write("nome"); // change nome
        bfw.flush();
    }

    public void enviarMensagem(String msg) throws IOException{
        if(msg.equals("Sair")){
            bfw.write("Desconectado \r\n");
            chat += "Desconectado\r\n";
        }else{
            bfw.write(nome + ": " + msg+"\r\n");
            chat += nome + ": " + msg;
        }
        bfw.flush();
    }

    public void escutar() throws IOException {

        InputStream in = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(inr);
        String msg = "";

        while(!"Sair".equalsIgnoreCase(msg))
            if(bfr.ready()){
                msg = bfr.readLine();
                if(msg.equals("Sair")) {
                    chat += "Servidor caiu";
                } else {
                    chat += msg;
                }
            }
    }

    public void sair() throws IOException{
        enviarMensagem("Sair");
        bfw.close();
        ouw.close();
        ou.close();
        socket.close();
    }

}
