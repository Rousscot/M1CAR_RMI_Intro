package rmiHello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected Message lastMessage;

    public HelloImpl() throws RemoteException {
        super();
        this.lastMessage = new Message("");
    }

    public void show(String chaine) throws RemoteException {
        this.log("show");
        this.lastMessage = new Message(chaine);
    }

    public Message getLastMessage() throws RemoteException {
        this.log("getLastMessage");
        return this.lastMessage;
    }

    public void log(String message){
        System.out.println("HelloImp: " + message);
    }
}