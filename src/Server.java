import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private static ArrayList<BufferedWriter> clients;
    private static ServerSocket server;
    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;

    Server(Socket con){
        this.con = con;
        try {
            in  = con.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try{
            String msg;
            OutputStream ou =  this.con.getOutputStream();
            Writer ouw = new OutputStreamWriter(ou);
            BufferedWriter bfw = new BufferedWriter(ouw);
            clients.add(bfw);
            nome = msg = bfr.readLine();
            while(!"Sair".equalsIgnoreCase(msg) && msg != null)
            {
                msg = bfr.readLine();
                sendToAll(bfw, msg);
                System.out.println(msg);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(BufferedWriter bwSaida, String msg) throws  IOException
    {
        BufferedWriter bwS;
        for(BufferedWriter bw : clients){
            bwS = (BufferedWriter)bw;
            if(!(bwSaida == bwS)){
                bw.write(nome + ": " + msg+"\r\n");
                bw.flush();
            }
        }
    }

    public static void main(String []args) {
        try{
            int port = 5000; // change port
            server = new ServerSocket(port);
            clients = new ArrayList<BufferedWriter>();
            while(true){
                Socket con = server.accept();
                for(BufferedWriter bfw : clients) {
                    bfw.write("-- novo usuario conectado --\r\n" );
                    bfw.flush();
                }
                Thread t = new Server(con);
                t.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
