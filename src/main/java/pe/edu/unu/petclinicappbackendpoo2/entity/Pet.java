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
@Table(name = "PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PET_ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID", nullable = false, foreignKey = @ForeignKey(name = "PET_OWNER_FK"))
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "PET_TYPE_ID", nullable = false, foreignKey = @ForeignKey(name = "PET_PET_TYPE_FK"))
    private PetType petType;

}
