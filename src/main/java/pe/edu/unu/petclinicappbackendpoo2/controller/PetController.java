package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PetResponse;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.VetResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Pet;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;
import pe.edu.unu.petclinicappbackendpoo2.service.IPetService;

import java.util.List;

@RestController
@RequestMapping("api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final IPetService service;

    @GetMapping
    public ResponseEntity<List<PetResponse>> findall(){
        List<Pet> pets = service.findAll();
        List<PetResponse> petsReponses = pets.stream()
                .map(pet -> ModelMapperUtil.convertTo(pet, PetResponse.class))
                .toList();
        return ResponseEntity.ok(petsReponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet petToSave){
        Pet pet = service.save(petToSave);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable Integer id, @RequestBody Pet petToSave){
        Pet pet = service.update(petToSave);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
