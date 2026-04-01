package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OwnerRequest {

    private PersonRequest person;

}
