package com.example.haasi.tp_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ChatActivity extends AppCompatActivity {

    private TextView text;
    private String chat;
    private String nome;
    private Socket socket;
    private OutputStream ou ;
    private Writer ouw;
    private BufferedWriter bfw;
    private boolean get;

    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Button button = findViewById(R.id.button_chatbox_send);

        text = findViewById(R.id.chat);
        chat = "";
        text.setText(chat);
        get = false;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText texto = findViewById(R.id.edittext_chatbox);
                try {
                    enviarMensagem(texto.getText().toString());
                    texto.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        nome = getIntent().getExtras().getString("name");
        final int port = getIntent().getExtras().getInt("port");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conectar(port);
                    escutar();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

    }

    public void conectar(int port) throws IOException {
        socket = new Socket("192.168.0.5", port);
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.write(nome + "\r\n");
        bfw.flush();

        in = socket.getInputStream();
        inr = new InputStreamReader(in);
        bfr = new BufferedReader(inr);
    }

    public void enviarMensagem(String msg) throws IOException{
        final String txt = msg;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(txt.equals("Sair")){
                        bfw.write("Sair\r\n");
                    }else{
                        bfw.write(txt + "\n");
                    }
                    bfw.flush();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

    public void escutar() throws IOException {
        String msg = "";
        while (!"Sair".equalsIgnoreCase(msg)) {
            msg = bfr.readLine();
            chat += msg + "\r\n";
        }
    }

    /*public void sair() throws IOException{
        enviarMensagem("Sair\r\n");
        bfw.close();
        ouw.close();
        ou.close();
        socket.close();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*try {
            sair();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
