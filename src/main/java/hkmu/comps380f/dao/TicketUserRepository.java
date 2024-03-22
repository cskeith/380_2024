package hkmu.comps380f.dao;

import hkmu.comps380f.model.TicketUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketUserRepository extends JpaRepository<TicketUser, String> {
}
