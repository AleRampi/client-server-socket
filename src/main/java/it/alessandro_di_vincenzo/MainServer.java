package it.alessandro_di_vincenzo;

public class MainServer {
    public static void main( String[] args ){
        ServerStream servente = new ServerStream();
        servente.attendi();
        servente.comunica();
    }
}
