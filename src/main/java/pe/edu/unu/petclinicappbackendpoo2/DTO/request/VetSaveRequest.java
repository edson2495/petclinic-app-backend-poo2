package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VetSaveRequest {

    private Integer id;
    private PersonRequest person;

}