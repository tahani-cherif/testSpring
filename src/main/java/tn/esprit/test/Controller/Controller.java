package tn.esprit.test.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test.Entities.*;
import tn.esprit.test.ServiceImplement.ServiceImplement;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class Controller {
    private ServiceImplement serviceImplement;
    @PostMapping("/internaute/")
    public Internaute ajouterInternaute(@RequestBody Internaute internaute) {
        return serviceImplement.ajouterInternaute(internaute);
    }
    @PostMapping("/evenement/")
    public Evenement ajouterEvenement(@RequestBody Evenement evenement) {
        return serviceImplement.ajouterEvenement(evenement);
    }
    @PostMapping("/ticket/{idEvenement}/{idInternaute}")
    public List<Ticket> ajouterTicketsEtAffecterenementEtInternaute(@RequestBody List<Ticket> tickets, @PathVariable long idEvenement,@PathVariable long idInternaute) {
        return serviceImplement.ajouterTicketsEtAffecterenementEtInternaute(tickets, idEvenement, idInternaute);
    }
    @GetMapping("/internauteLePlusActif")
    public String internauteLePlusActif() {
        return serviceImplement.internauteLePlusActif();
    }
    @GetMapping("/nbinternaute/{trancheAge}/{dateMin}/{dateMax}")
    public Long nbInternauteParTrancheAgeEtDateEvenement(@PathVariable TrancheAge trancheAge,@PathVariable  LocalDate dateMin,@PathVariable  LocalDate dateMax) {
        return serviceImplement.nbInternauteParTrancheAgeEtDateEvenement(trancheAge, dateMin, dateMax);
    }
    @GetMapping("/montant/{nomEvt}/{typeTicket}")
    public Double montantRecupereParEvtEtTypeTickets(@PathVariable String nomEvt,@PathVariable TypeTicket typeTicket) {
        return serviceImplement.montantRecupereParEvtEtTypeTickets(nomEvt, typeTicket);
    }
}
