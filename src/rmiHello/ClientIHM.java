package rmiHello;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.rmi.Naming;

public class ClientIHM  extends Frame {

    protected Hello remoteHello;

    protected TextField serverName;
    protected TextField entry;
    protected TextField answer;

    public ClientIHM(String title, String urlHello) {

        super(title);
        this.setLayout (new GridLayout(6,1));

        this.add(new Label("Hello object URL: "));
        this.serverName = new TextField(40);
        this.add(serverName);
        this.add(new Label("Text to send to the Hello object: "));
        this.entry = new TextField(40);
        this.add(entry);
        this.add(new Label("Answer: "));
        this.answer = new TextField(40);
        this.add(answer);

        this.addWindowListener (new QuitAdapter());
        this.serverName.addActionListener (new ServerNameListener());
        this.entry.addActionListener (new EntryListener());

        this.serverName.setText(urlHello);
        this.connectServer(urlHello);
    }

    public void connectServer(String serverName) {
        try {
            this.remoteHello = (Hello) Naming.lookup(serverName);
            this.answer.setText(null);
        } catch(Exception e) {
            this.answer.setText (e.toString());
        }
    }

    protected class QuitAdapter extends WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent e){
            System.exit (0);
        }

    }

    protected class ServerNameListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            connectServer(serverName.getText());
        }

    }

    protected class EntryListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                remoteHello.show( entry.getText() );
                entry.setText("");
                Message lastMessage = remoteHello.getLastMessage();
                answer.setText( lastMessage.toString() );
            } catch(Exception ex) {
                answer.setText ( ex.toString() );
            }
        }
    }

    public static void main (String[] args) {

        ClientIHM ihm = new ClientIHM("IHM sur un serveur Hello", (args.length > 0)?args[0]:"//localhost/Hello");

        ihm.pack ();
        ihm.show ();
    }
}
