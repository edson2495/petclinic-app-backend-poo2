package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;
import pe.edu.unu.petclinicappbackendpoo2.entity.PetType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetSaveRequest {

    private Integer id;
    private String name;
    private Owner owner;
    private PetType petType;

}
