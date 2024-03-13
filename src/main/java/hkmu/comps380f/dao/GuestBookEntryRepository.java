package hkmu.comps380f.dao;

import hkmu.comps380f.model.GuestBookEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookEntryRepository extends JpaRepository<GuestBookEntry, Long> {
}
