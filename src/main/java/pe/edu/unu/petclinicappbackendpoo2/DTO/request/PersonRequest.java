package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class PersonRequest {

    @NotNull // no nullo
    @NotEmpty // no ""
    private String name;
    @NotNull
    @NotEmpty
    private String lastname;
    @NotNull
    @Past
    private LocalDate birthday;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[0-9]+$")
    private String cellphone;

}
