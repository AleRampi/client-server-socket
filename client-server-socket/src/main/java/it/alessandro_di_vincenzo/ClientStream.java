package it.alessandro_di_vincenzo;

import java.io.*;
import java.net.*;


public class ClientStream {

    String nomeServer = "localhost"; //indirizzo del server locale
    int portaServer = 5050;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti(){

        System.out.println("Client partito in esecuzione...");

        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in)); //input da tastiera

            mioSocket = new Socket(nomeServer, portaServer); //creazione del socket

            outVersoServer = new DataOutputStream(mioSocket.getOutputStream()); //per effettuare la lettura

            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream())); //per effettuare la lettura
        } catch (UnknownHostException e){ 
            //se viene generata un eccezione a causa di un host sconosciuto
            System.out.println("Host sconosciuto");  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1); //il codice diverso da 0 indica che qualcosa è andato storto
            
        }

        return mioSocket;
    }

    public void comunica(){
        for(;;){
            try{
                System.out.println("Utente, inserisci una stringa da trasmettere al server!");
                stringaUtente = tastiera.readLine();

                System.out.println("invio la stringa al server e attendo...");
                outVersoServer.writeBytes(stringaUtente + '\n');

                stringaRicevutaDalServer = inDalServer.readLine();
                System.out.println("risposta dal server " + '\n' + stringaRicevutaDalServer);
                if(stringaUtente.equals("FINE")){
                    System.out.println("CLIENT: termina elaborazione e chiude connessione");
                    mioSocket.close();
                    break;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Errore durante la comunicazione col server");
                System.exit(1);
            }
        } 
    }
}
