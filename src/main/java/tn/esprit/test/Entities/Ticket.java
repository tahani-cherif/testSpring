package tn.esprit.test.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name="Ticket")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idTicket;
    String codeTicket;
    Double prixTicket;
    @Enumerated(EnumType.STRING)
    TypeTicket typeTicket;
    @ManyToOne
    Internaute internaute;
    @ManyToOne
    Evenement evenement;
}
