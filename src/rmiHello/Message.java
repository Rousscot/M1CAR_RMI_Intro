package rmiHello;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    protected java.util.Date date;

    protected String text;

    public Message(String text) {
        this.date = new Date();
        this.text = text;
    }

    public String toString() {
        return "rmiHello.Message[date=" + date + ",text=" + text + "]";
    }
}
