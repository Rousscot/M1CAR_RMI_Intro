package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by aurelien on 26/05/2016.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected Message leDernierMessage;

    public HelloImpl() throws RemoteException{
        super();
        leDernierMessage = new Message("");
    }

    @Override
    public void afficher(String chaine) throws RemoteException {
        System.out.println("Invocation de HelloImpl.afficher(chaine=" + chaine+")");
        leDernierMessage = new Message(chaine);
    }

    @Override
    public Message getDernierMessage() throws RemoteException {
        System.out.println("Invocation de HelloImpl.getDernierMessage()");
        return leDernierMessage ;
    }
}
