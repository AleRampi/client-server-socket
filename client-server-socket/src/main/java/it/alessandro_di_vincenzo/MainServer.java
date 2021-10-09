package it.alessandro_di_vincenzo;

public class MainServer {
    public static void main(String[] args) {
        MultiServer tcpServer = new MultiServer();
        tcpServer.start();
    }
}