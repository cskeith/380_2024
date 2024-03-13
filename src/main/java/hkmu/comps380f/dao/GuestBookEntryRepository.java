package hkmu.comps380f.dao;

import hkmu.comps380f.model.GuestBookEntry;

import java.util.List;

public interface GuestBookEntryRepository {
    void addEntry(GuestBookEntry entry);

    void updateEntry(GuestBookEntry entry);

    List<GuestBookEntry> listEntries();

    GuestBookEntry getEntryById(long id);

    void removeEntryById(long id);
}