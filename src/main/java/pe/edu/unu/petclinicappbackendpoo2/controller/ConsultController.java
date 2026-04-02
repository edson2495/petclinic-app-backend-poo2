package pe.edu.unu.petclinicappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.ConsultRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.ConsultResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Consult;
import pe.edu.unu.petclinicappbackendpoo2.service.IConsultService;

import java.util.List;

@RestController
@RequestMapping("api/v1/consults")
@RequiredArgsConstructor
public class ConsultController {
    
    private final IConsultService service;

    @GetMapping
    public ResponseEntity<List<ConsultResponse>> findall(){
        List<Consult> consults = service.findAll();
        List<ConsultResponse> consultsReponses = consults.stream()
                .map(consult -> ModelMapperUtil.convertTo(consult, ConsultResponse.class))
                .toList();
        return ResponseEntity.ok(consultsReponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(ModelMapperUtil.convertTo(service.findById(id), ConsultResponse.class));
    }

    @PostMapping("/transactional")
    public ResponseEntity<ConsultResponse> saveTransactional(@Valid @RequestBody ConsultRequest consultRequest){
        Consult consult = service.savetransactional(
                ModelMapperUtil.convertTo(consultRequest, Consult.class)
        );
        return new ResponseEntity<>(ModelMapperUtil.convertTo(consult, ConsultResponse.class), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ConsultResponse> save(@Valid @RequestBody ConsultRequest consultRequest){
        //como yo recibo un dto, para trabajarlo, debo convertir el DTO a entidad
        Consult consult = service.save(
                ModelMapperUtil.convertTo(consultRequest, Consult.class)
        );
        //convertir de entidad a DTO
        return new ResponseEntity<>(ModelMapperUtil.convertTo(consult, ConsultResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultResponse> update(@PathVariable Integer id, @RequestBody ConsultRequest consultRequest){
        Consult consult = service.update(
                ModelMapperUtil.convertTo(consultRequest, Consult.class)
        );
        consult.setId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(consult, ConsultResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
