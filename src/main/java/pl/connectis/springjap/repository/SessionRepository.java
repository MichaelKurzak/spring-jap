package pl.connectis.springjap.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.connectis.springjap.domaine.Session;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query (value ="SELECT s FROM Session s WHERE function ('DATE_TRUNC', 'day', s.startTime)=?1")
    List<Session> findAllByStartData(Data data);

    @EntityGraph(value = "Session.ticket", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Session> readById(Long id);

}
