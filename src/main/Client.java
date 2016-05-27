package main;

import java.rmi.Naming;

/**
 * Created by aurelien on 26/05/2016.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Hello helloDistant = (Hello) Naming.lookup("//localhost/UnHello");
        helloDistant.afficher("Hello world !");
        Message message = helloDistant.getDernierMessage();
        System.out.println("Le dernier message est: " + message);
    }
}
