import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private Socket socket;
    private OutputStream ou ;
    private Writer ouw;
    private BufferedWriter bfw;

    public Client(){ }

    public void conectar(int port) throws IOException{
        socket = new Socket("127.0.0.1", port);
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.write("nome"); // change nome
        bfw.flush();
    }

    public void enviarMensagem(String msg) throws IOException{
        if(msg.equals("Sair")){
            bfw.write("Desconectado \r\n");
            // texto.append("Desconectado \r\n");
        }else{
            bfw.write(msg+"\r\n");
            // texto.append( "nome" + ": " + "mensagem"); // change nome e mensagem
        }
        bfw.flush();
        // reseta mensagem
    }

    public void escutar() throws IOException{

        InputStream in = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(inr);
        String msg = "";

        while(!"Sair".equalsIgnoreCase(msg))

            if(bfr.ready()){
                msg = bfr.readLine();
                if(msg.equals("Sair")) {
                    // servidor caiu
                } else {
                    // adiciona mensagem
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

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if(/* clicar para enviar*/)
                enviarMensagem(/* mensagem */ "");
            else
            if(/* sair */)
                sair();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                enviarMensagem("" /* mensagem */);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    public static void main(String []args) throws IOException{
        Client app = new Client();
        app.conectar(5000); ///change
        app.escutar();
    }
}
