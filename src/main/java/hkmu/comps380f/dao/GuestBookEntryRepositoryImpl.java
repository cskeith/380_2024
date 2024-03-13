package hkmu.comps380f.dao;

import hkmu.comps380f.model.GuestBookEntry;
import jakarta.persistence.EntityManager;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GuestBookEntryRepositoryImpl implements GuestBookEntryRepository {

    private final Session session;

    @Autowired
    public GuestBookEntryRepositoryImpl(EntityManager entityManager) {
        this.session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void addEntry(GuestBookEntry e) {
        this.session.persist(e);
    }

    @Override
    @Transactional
    public List<GuestBookEntry> listEntries() {
        String hql = "FROM GuestBookEntry";
        Query<GuestBookEntry> query = this.session.createQuery(hql, GuestBookEntry.class);
        List<GuestBookEntry> entriesList = query.list();
        return entriesList;
    }

    @Override
    @Transactional
    public GuestBookEntry getEntryById(long id) {
        GuestBookEntry e = this.session.getReference(GuestBookEntry.class, id);
        Hibernate.initialize(e);
        return e;
    }

    @Override
    @Transactional
    public void updateEntry(GuestBookEntry e) {
        this.session.merge(e);
    }

    @Override
    @Transactional
    public void removeEntryById(long id) {
        GuestBookEntry e = this.session.getReference(GuestBookEntry.class, id);
        if (e != null) {
            this.session.remove(e);
        }
    }
}