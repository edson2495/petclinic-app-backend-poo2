package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;
import pe.edu.unu.petclinicappbackendpoo2.service.IOwnerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final IOwnerService service;

    @GetMapping
    public ResponseEntity<List<Owner>> findall(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Owner> save(@RequestBody Owner ownerToSave){
        Owner owner = service.save(ownerToSave);
        return new ResponseEntity<>(owner, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@PathVariable Integer id, @RequestBody Owner ownerToSave){
        Owner owner = service.update(ownerToSave);
        return ResponseEntity.ok(owner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
