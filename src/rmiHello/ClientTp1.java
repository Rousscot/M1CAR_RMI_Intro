package rmiHello;

import rmiHello.Hello;

/**
 * Created by sylvie on 26/05/16.
 */
public class ClientTp1 {
    public static void main (String[] args) throws Exception {
// Obtenir la souche sur l’objet distant via l’annuaire Java RMI.
        Hello helloDistant = (Hello) java.rmi.Naming.lookup("//localhost/UnHello");
// Invoquer des methodes distantes comme si l’objet etait local.
        helloDistant.afficher("rmiHello.Hello world !");
        Message message = helloDistant.getDernierMessage();
        System.out.println("Le dernier message affiche est " + message);
    }
}
