package tn.esprit.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.test.Entities.Evenement;
import tn.esprit.test.Entities.Internaute;

import java.util.List;

@Repository
public interface EvenementRepo extends JpaRepository<Evenement, Long> {

}
