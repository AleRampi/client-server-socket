package it.alessandro_di_vincenzo;

import java.io.*;
import java.net.*;

public class ServerStream {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

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

    public void comunica(){
        try{
            System.out.println("Scrivi la frase che verrà tradotta in maiuscolo");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("Stringa ricevuta: " + stringaRicevuta);

            stringaModificata = stringaRicevuta.toUpperCase();
            System.out.println("Invio della stringa modificata al client");
            outVersoClient.writeBytes(stringaModificata + '\n');

            System.out.println("chiusura della connessione del client");
            client.close();
        } catch(Exception e){
            System.out.println("Errore");
            System.out.println(e.getMessage());
        }
    }
}
