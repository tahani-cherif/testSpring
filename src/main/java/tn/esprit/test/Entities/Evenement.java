package tn.esprit.test.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Evenement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idEvenement;
    String nomEvenement;
    long nbPlacesRestants;
    LocalDate dateEvenement;
    @OneToMany(mappedBy = "evenement",cascade = CascadeType.ALL)
    List<Ticket> ticket;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Categorie> categorie;
}
