package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Server extends Observable  implements Runnable {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;

        try {
            server = new ServerSocket(port);
            
            while (true) {
              
                sc = server.accept();
                in = new DataInputStream(sc.getInputStream());           
                String mensaje = in.readUTF();             
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                sc.close();
                

            }

        } catch (IOException e) {
        	e.printStackTrace();
        }

    }
}
