package tn.esprit.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.test.Entities.Internaute;
import tn.esprit.test.Entities.TrancheAge;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InternauteRepo extends JpaRepository<Internaute, Long> {
    @Query("SELECT i FROM Internaute i JOIN i.tickets t GROUP BY i.idInternaute ORDER BY COUNT(t) DESC")
    List<Internaute> findInternautesByTicketCountDesc();
    List<Internaute> findByTrancheAgeAndTicketsEvenementDateEvenementBetween(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);
}
