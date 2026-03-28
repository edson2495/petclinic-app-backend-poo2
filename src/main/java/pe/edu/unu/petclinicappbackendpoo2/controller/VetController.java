package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.VetRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.VetResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;
import pe.edu.unu.petclinicappbackendpoo2.service.IVetService;

import java.util.List;

@RestController
@RequestMapping("api/v1/vets")
@RequiredArgsConstructor
public class VetController {

    private final IVetService service;

//    @GetMapping
//    public ResponseEntity<List<Vet>> findall(){
//        return ResponseEntity.ok(service.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Vet> findById(@PathVariable Integer id){
//        return ResponseEntity.ok(service.findById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<VetResponse> save(@RequestBody VetRequest vetRequest){
//        //como yo recibo un dto, para trabajarlo, debo convertir el DTO a entidad
//        Vet vet = service.save(
//                ModelMapperUtil.convertToEntity(vetRequest)
//        );
//        //convertir de entidad a DTO
//        return new ResponseEntity<>(ModelMapperUtil.convertToResponse(vet), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<VetResponse> update(@PathVariable Integer id, @RequestBody VetRequest vetRequest){
//        Vet vet = service.update(
//                ModelMapperUtil.convertToEntity(vetRequest)
//        );
//        return ResponseEntity.ok(ModelMapperUtil.convertToResponse(vet));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id){
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
    
}
