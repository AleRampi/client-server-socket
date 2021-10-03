package it.alessandro_di_vincenzo;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClientStream cliente = new ClientStream();
        cliente.connetti();
        cliente.comunica();
        
        ServerStream servente = new ServerStream();
        servente.attendi();
        servente.comunica();
    }
}
