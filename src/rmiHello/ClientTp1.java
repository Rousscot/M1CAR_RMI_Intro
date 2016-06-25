package rmiHello;

import java.rmi.Naming;

public class ClientTp1 {

    public static void main (String[] args) throws Exception {

        Hello remoteHello = (Hello) Naming.lookup("//localhost/aHello");
        remoteHello.show("rmiHello.Hello world !");
        Message message = remoteHello.getLastMessage();

        System.out.println("Last message: " + message);
    }

}
