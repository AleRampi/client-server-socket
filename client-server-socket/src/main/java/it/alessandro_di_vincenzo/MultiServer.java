package it.alessandro_di_vincenzo;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    
    public void start(){
        try{
            ServerSocket serverSocket = new ServerSocket(5050);
            for(;;){
                System.out.println("Server in attesa...");
                Socket socket = serverSocket.accept();
                System.out.println("Server socket " + socket);
                ServerStream serverStream = new ServerStream(socket);
                serverStream.start();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server!");
            System.exit(1);
        }
    }
    
}
