package pe.edu.unu.petclinicappbackendpoo2.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VetResponse {

    private Integer id;
    private PersonResponse person;

}
