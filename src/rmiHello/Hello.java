package rmiHello;

/**
 * Created by sylvie on 26/05/16.
 */
public interface Hello extends java.rmi.Remote
{
    // Afficher une chaine de caracteres.
    public void afficher(String chaine) throws java.rmi.RemoteException;
    // Obtenir le dernier message affiche.
    public Message getDernierMessage() throws java.rmi.RemoteException;
}
