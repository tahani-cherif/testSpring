package tn.esprit.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.test.Entities.Internaute;
import tn.esprit.test.Entities.Ticket;
import tn.esprit.test.Entities.TypeTicket;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

    @Query("SELECT SUM(i.prixTicket) FROM Ticket i JOIN i.evenement where i.typeTicket=:typeTicket  AND i.evenement.nomEvenement=:nomEvt")
    Double montantRecupereParEvtEtTypeTicket(@Param("nomEvt") String nomEvt,@Param("typeTicket") TypeTicket typeTicket);
}
