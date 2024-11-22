package tn.esprit.test.ServiceImplement;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.test.Entities.*;
import tn.esprit.test.Repositories.CategorieRepo;
import tn.esprit.test.Repositories.EvenementRepo;
import tn.esprit.test.Repositories.InternauteRepo;
import tn.esprit.test.Repositories.TicketRepo;
import tn.esprit.test.Service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class ServiceImplement implements ServiceInterface {
    InternauteRepo internauteRepo;
    EvenementRepo   evenementRepo;
    TicketRepo  ticketRepo;
    CategorieRepo categorieRepo;
    @Override
    public Internaute ajouterInternaute(Internaute internaute) {
        return internauteRepo.save(internaute);
    }

    @Override
    public Evenement ajouterEvenement(Evenement evenement) {
        return evenementRepo.save(evenement);
    }

    @Override
    public List<Ticket> ajouterTicketsEtAffecterenementEtInternaute(List<Ticket> tickets, long idEvenement, long idInternaute) {
       Evenement evenement=evenementRepo.findById(idEvenement).orElse(null);
       Internaute internaute=internauteRepo.findById(idInternaute).orElse(null);
       assert evenement!=null;
       assert internaute!=null;
       if(evenement.getNbPlacesRestants()>=tickets.size()){
           for(Ticket ticket : tickets){
               ticket.setEvenement(evenement);
               ticket.setInternaute(internaute);
               ticketRepo.save(ticket);

           }
           evenement.setNbPlacesRestants(evenement.getNbPlacesRestants() - tickets.size());
        evenementRepo.save(evenement);

       }
       else{
           throw new java.lang.UnsupportedOperationException("nombre de places demandees indisponible");
       }

        return tickets;
    }


    @Override
    public String internauteLePlusActif() {
            List<Internaute> internautes = internauteRepo.findInternautesByTicketCountDesc();
            Internaute inter = internautes.get(0);
            return  "nom: "+inter.getIdentifiant();
    }

    @Override
    @Scheduled(cron = "*/15 * * * * *")
    @Transactional
    public void affichelog() {
         for(Categorie cat:categorieRepo.findAll()){
             log.info("categorie :"+cat.getNomCategorie());
             for(Evenement event :cat.getEvenement()){
                 log.info("evenement :"+event.getNomEvenement());
             }
         }
    }

    @Override
    public Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax) {
        return (long) internauteRepo.findByTrancheAgeAndTicketsEvenementDateEvenementBetween(trancheAge,dateMin,dateMax).size();
    }

    @Override
    public Double montantRecupereParEvtEtTypeTickets(String nomEvt, TypeTicket typeTicket) {
        return ticketRepo.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }
}
