package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.OwnerRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.OwnerResponse;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PersonResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;
import pe.edu.unu.petclinicappbackendpoo2.service.IOwnerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final IOwnerService service;

    @GetMapping
    public ResponseEntity<List<OwnerResponse>> findall(){
        List<Owner> owners = service.findAll();
        List<OwnerResponse> ownersReponses = owners.stream()
                .map(owner -> ModelMapperUtil.convertTo(owner, OwnerResponse.class))
                .toList();
        return ResponseEntity.ok(ownersReponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(ModelMapperUtil.convertTo(service.findById(id),OwnerResponse.class));
    }

    @PostMapping
    public ResponseEntity<OwnerResponse> save(@RequestBody OwnerRequest ownerRequest){
        Owner ownerToSave = ModelMapperUtil.convertTo(ownerRequest, Owner.class);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(service.save(ownerToSave),OwnerResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerResponse> update(@PathVariable Integer id, @RequestBody OwnerRequest ownerRequest){
        Owner ownerToUpdate = ModelMapperUtil.convertTo(ownerRequest, Owner.class);
        ownerToUpdate.setId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(service.update(ownerToUpdate), OwnerResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
