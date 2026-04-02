package pe.edu.unu.petclinicappbackendpoo2.DTO.request;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.VetResponse;
import pe.edu.unu.petclinicappbackendpoo2.entity.Pet;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;

@Data
@Builder
@AllArgsConstructor
public class ConsultRequest {

    @NotNull
    @NotEmpty
    private String diagnostic;
    @NotNull
    private Pet pet;
    @NotNull
    private Vet vet;

}
