package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class PersonRequest {

    private String name;
    private String lastname;
    private LocalDate birthday;
    private String cellphone;

}
