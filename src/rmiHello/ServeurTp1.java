package rmiHello;

import java.rmi.Naming;

public class ServeurTp1 {

    public static void main(String args[]) throws Exception {

        Naming.rebind("aHello", new HelloImpl());

        System.out.println("Launching server Hello.");
    }

}