package tn.esprit.test.Service;

import org.springframework.data.jpa.repository.Query;
import tn.esprit.test.Entities.*;

import java.time.LocalDate;
import java.util.List;

public interface ServiceInterface {
    Internaute ajouterInternaute(Internaute internaute);
    Evenement ajouterEvenement(Evenement evenement);
    List<Ticket> ajouterTicketsEtAffecterenementEtInternaute(List<Ticket> tickets,long idEvenement,long idInternaute);
    String internauteLePlusActif();
    void affichelog();
    Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);
    Double montantRecupereParEvtEtTypeTickets(String nomEvt, TypeTicket typeTicket);
}
