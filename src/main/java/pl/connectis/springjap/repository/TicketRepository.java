package pl.connectis.springjap.repository;

import org.springframework.data.repository.CrudRepository;
import pl.connectis.springjap.domaine.Session;
import pl.connectis.springjap.domaine.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Iterable<Ticket> findAllBySession(Session session);
    Long countBySession(Session session);

}
