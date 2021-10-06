package it.alessandro_di_vincenzo;

public class MainClient 
{
    public static void main( String[] args )
    {
        ClientStream cliente = new ClientStream();
        cliente.connetti();
        cliente.comunica();
    }
}
