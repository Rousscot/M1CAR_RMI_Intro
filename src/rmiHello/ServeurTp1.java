package rmiHello;

/**
 * Created by sylvie on 26/05/16.
 */
public class ServeurTp1 {
    public static void main(String args[]) throws Exception {
// Creer l’objet accessible par Java RMI.
        HelloImpl obj = new HelloImpl();
// Enregistrer cet objet dans l’annuaire Java RMI.
        java.rmi.Naming.rebind("UnHello", obj);
        System.out.println("Le serveur Java RMI est pret ...");
    }
}