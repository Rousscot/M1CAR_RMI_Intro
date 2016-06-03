package rmiHello;

/**
 * Created by sylvie on 26/05/16.
 */
public class HelloImpl extends java.rmi.server.UnicastRemoteObject
        implements Hello
{
    // Attribut stockant le dernier message affiche.
    protected Message leDernierMessage;
    // Le constructeur.
    public HelloImpl() throws java.rmi.RemoteException {
// Appel du constructeur java.rmi.server.UnicastRemoteObject.
// Peut soulever l’exception java.rmi.RemoteException.
        super();
        leDernierMessage = new Message("");
    }
    // Afficher une chaine de caracteres.
    public void afficher(String chaine) throws java.rmi.RemoteException {
        System.out.println("Invocation de rmiHello.HelloImpl.afficher(chaine=" + chaine + ")");
        leDernierMessage = new Message(chaine);
    }
    // Obtenir le dernier message affiche.
    public Message getDernierMessage() throws java.rmi.RemoteException {
        System.out.println("Invocation de rmiHello.HelloImpl.getDernierMessage()");
        return leDernierMessage;
    }
}