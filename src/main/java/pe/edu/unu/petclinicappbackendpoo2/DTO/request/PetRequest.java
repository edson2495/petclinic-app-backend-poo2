package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;
import pe.edu.unu.petclinicappbackendpoo2.entity.PetType;

@Data
@Builder
@AllArgsConstructor
public class PetRequest {

    private String name;
    private Owner owner;
    private PetType petType;

}
