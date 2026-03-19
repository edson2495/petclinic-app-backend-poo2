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
@Table(name = "PET_TYPE")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PET_TYPE_ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

}
