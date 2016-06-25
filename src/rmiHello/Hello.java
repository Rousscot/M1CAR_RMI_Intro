package rmiHello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    void show(String chaine) throws RemoteException;

    Message getLastMessage() throws RemoteException;
}
