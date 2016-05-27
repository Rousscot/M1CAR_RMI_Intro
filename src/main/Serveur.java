package main;

import java.rmi.Naming;

/**
 * Created by aurelien on 26/05/2016.
 */
public class Serveur {
    public static void main(String[] args) throws Exception {
        HelloImpl obj = new HelloImpl();
        Naming.rebind("UnHello", obj);
        System.out.println("Le serveur Java RMI est prêt");
    }
}
