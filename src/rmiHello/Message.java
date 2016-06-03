package rmiHello;

/**
 * Created by sylvie on 26/05/16.
 */
public class Message implements java.io.Serializable {
    //L’état interne du message.
    protected java.util.Date date;
    protected String texte;

    // Le constructeur avec un texte.
    public Message(String texte) {
        this.date = new java.util.Date();
        this.texte = texte;
    }

    // Pour afficher le message.
    public String toString() {
        return "rmiHello.Message[date=" + date + ",texte=" + texte + "]";
    }
}
