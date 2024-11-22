package tn.esprit.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.test.Entities.Categorie;
@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Long> {
}
