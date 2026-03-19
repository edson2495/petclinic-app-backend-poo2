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
@Table(name = "CONSULT")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSULT_ID", nullable = false)
    private Integer id;

    @Column(name = "DIAGNOSTIC", nullable = false, length = 200)
    private String diagnostic;

    @ManyToOne
    @JoinColumn(name = "PET_ID", nullable = false, foreignKey = @ForeignKey(name = "CONSULT_PET_FK"))
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "VET_ID", nullable = false, foreignKey = @ForeignKey(name = "CONSULT_VET_FK"))
    private Vet vet;

}
