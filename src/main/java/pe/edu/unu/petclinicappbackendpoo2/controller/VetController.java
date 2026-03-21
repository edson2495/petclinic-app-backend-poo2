package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;
import pe.edu.unu.petclinicappbackendpoo2.service.IVetService;

import java.util.List;

@RestController
@RequestMapping("api/v1/vets")
@RequiredArgsConstructor
public class VetController {

    private final IVetService service;

    @GetMapping
    public ResponseEntity<List<Vet>> findall(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vet> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Vet> save(@RequestBody Vet vetToSave){
        Vet vet = service.save(vetToSave);
        return new ResponseEntity<>(vet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vet> update(@PathVariable Integer id, @RequestBody Vet vetToSave){
        System.out.println(vetToSave);
        Vet vet = service.update(vetToSave);
        return ResponseEntity.ok(vet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
