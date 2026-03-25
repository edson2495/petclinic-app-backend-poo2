package pe.edu.unu.petclinicappbackendpoo2.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.PersonRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PersonResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;
import pe.edu.unu.petclinicappbackendpoo2.service.IPersonService;

import java.util.List;

@RestController
//@Controller
@RequestMapping("api/v1/people")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> findall(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponse> save(@RequestBody PersonRequest personRequest){

////        Person personToSave = Person.builder()
////        .name(personRequest.getName())
////        .lastname(personRequest.getLastname())
////        .birthday(personRequest.getBirthday())
////        .cellphone(personRequest.getCellphone())
////        .build();
//        Person personToSave = convertToEntity(personRequest);
//
//        Person person = service.save(personToSave);
//
////        PersonResponse personResponse = PersonResponse.builder()
////        .id(person.getId())
////        .name(personRequest.getName())
////        .lastname(personRequest.getLastname())
////        .birthday(personRequest.getBirthday())
////        .cellphone(personRequest.getCellphone())
////        .build();
//        PersonResponse personResponse = convertToResponse(person);

        Person personToSave = ModelMapperUtil.convertToEntity(personRequest);
        Person person = service.save(personToSave);
        PersonResponse personResponse = ModelMapperUtil.convertToResponse(person);

        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Integer id, @RequestBody PersonRequest personRequest){

        Person personToUpdate = ModelMapperUtil.convertToEntity(personRequest);
        personToUpdate.setId(id);
        Person person = service.save(personToUpdate);
        PersonResponse personResponse = ModelMapperUtil.convertToResponse(person);

        return ResponseEntity.ok(personResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


//    private final ModelMapper mapper;
//
//    //entity -> DTO
//    private PersonResponse convertToResponse(Person person){
//        return mapper.map(person, PersonResponse.class);
//    }
//
//    //DTO -> entity
//    private Person convertToEntity(PersonRequest personRequest){
//        return mapper.map(personRequest, Person.class);
//    }

}
