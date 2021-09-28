package it.alessandro_di_vincenzo;

import java.io.BufferedReader;
import java.io.*;
import java.net.*;

public class ClientStream {

    String nomeServer = "localhost"; //indirizzo del server locale
    int portaServer = 5500;
    Socket mioSocket;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti(){

        //fare la roba

        return mioSocket;
    }

    public void comunica(){
        
    }
}
