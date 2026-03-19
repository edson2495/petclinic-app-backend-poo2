package pe.edu.unu.petclinicappbackendpoo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "VET",
        uniqueConstraints = {
            @UniqueConstraint(name = "VET_UK", columnNames = {"PERSON_ID"})
        }
)
public class Vet {//Vet : Veterinario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VET_ID", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PERSON_ID", nullable = false, foreignKey = @ForeignKey(name = "VET_PERSON_FK"))
    private Person person;

}
