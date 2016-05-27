package main;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by aurelien on 26/05/2016.
 */
public class Message implements Serializable {
    // l'état interne du message
    protected Date date;
    protected String texte;

    public Message(String texte) {
        this.date = new Date();
        this.texte = texte;
    }

    public String toString() {
        return "Message[date=" + date + ", texte=" + texte + "]";
    }
}
