package it.alessandro_di_vincenzo;

import java.io.*;
import java.net.*;


public class ServerStream extends Thread{
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public ServerStream(Socket socket){
        this.client = socket;
    }

    public void run(){
        try {
            comunica();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Socket attendi() {
        try {
            System.out.println("Server in esecuzione");
            server = new ServerSocket(5050); // creazione server su porta 5050

            client = server.accept(); // accept() indica al server di rimanere in attesa di un client

            server.close(); // chiusura del server

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());

        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la creazione del server");
            System.exit(1); // il codice diverso da 0 indica che qualcosa è andato storto
        }
        return client;
    }

    public void comunica() throws Exception{
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());

        for(;;){
            stringaRicevuta = inDalClient.readLine();
            if(stringaRicevuta == null || stringaRicevuta.equals("FINE")){
                outVersoClient.writeBytes(stringaRicevuta + "(=> server in chiusura...)" + '\n');
                System.out.println("Echo sul server in chiusura :" + stringaRicevuta);
                break;
            } else {
                outVersoClient.writeBytes(stringaRicevuta + "(ricevuta e trasmessa)" + '\n');
                System.out.println("Echo sul server :" + stringaRicevuta);
            }
        }
        outVersoClient.close();
        inDalClient.close();
        System.out.println("Chiusura socket" + client);
        client.close();
    }
}
