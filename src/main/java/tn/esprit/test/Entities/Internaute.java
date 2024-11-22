package tn.esprit.test.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name="Internaute")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idInternaute;
    String identifiant;
    @Enumerated(EnumType.STRING)
    TrancheAge trancheAge;
    @OneToMany(mappedBy = "internaute")
    List<Ticket> tickets;
}
