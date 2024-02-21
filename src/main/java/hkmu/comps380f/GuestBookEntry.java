package hkmu.comps380f;

import java.io.Serializable;
import java.util.Date;

public class GuestBookEntry implements Serializable {
    String name;
    String message;
    Date date;

    public GuestBookEntry() {
        date = new Date();
    }

    public GuestBookEntry(String name, String message) {
        this.name = name;
        this.message = message;
        date = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
