package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by aurelien on 26/05/2016.
 */
public interface Hello extends Remote {

    public void afficher(String chaine) throws RemoteException;

    public Message getDernierMessage() throws RemoteException;
}
