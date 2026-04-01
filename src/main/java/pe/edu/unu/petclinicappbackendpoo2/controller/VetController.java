package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.VetRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.OwnerResponse;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.VetResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;
import pe.edu.unu.petclinicappbackendpoo2.service.IVetService;

import java.util.List;

@RestController
@RequestMapping("api/v1/vets")
@RequiredArgsConstructor
public class VetController {

    private final IVetService service;

    @GetMapping
    public ResponseEntity<List<VetResponse>> findall(){
        List<Vet> vets = service.findAll();
        List<VetResponse> vetsReponses = vets.stream()
                .map(vet -> ModelMapperUtil.convertTo(vet, VetResponse.class))
                .toList();
        return ResponseEntity.ok(vetsReponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VetResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(ModelMapperUtil.convertTo(service.findById(id), VetResponse.class));
    }

    @PostMapping
    public ResponseEntity<VetResponse> save(@RequestBody VetRequest vetRequest){
        //como yo recibo un dto, para trabajarlo, debo convertir el DTO a entidad
        Vet vet = service.save(
                ModelMapperUtil.convertTo(vetRequest, Vet.class)
        );
        //convertir de entidad a DTO
        return new ResponseEntity<>(ModelMapperUtil.convertTo(vet, VetResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VetResponse> update(@PathVariable Integer id, @RequestBody VetRequest vetRequest){
        Vet vet = service.update(
                ModelMapperUtil.convertTo(vetRequest, Vet.class)
        );
        vet.setId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(vet, VetResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
