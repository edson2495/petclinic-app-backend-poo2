package pe.edu.unu.petclinicappbackendpoo2.DTO.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    private Integer id;
    private String name;
    private String lastname;
    private LocalDate birthday;
    private String cellphone;

}
