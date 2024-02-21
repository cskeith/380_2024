package hkmu.comps380f;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GuestBookBean implements Serializable {
    List<GuestBookEntry> entries;

    public GuestBookBean() {
        entries = new CopyOnWriteArrayList<>();
    }

    public void setAddEntry(String dummy) {
        GuestBookEntry entry = new GuestBookEntry();
        entries.add(entry);
    }

    public GuestBookEntry getLastEntry() {
        return entries.get(entries.size() - 1);
    }

    public List<GuestBookEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<GuestBookEntry> entries) {
        this.entries = entries;
    }
}