package pe.edu.unu.petclinicappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PersonResponse;
import pe.edu.unu.petclinicappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;
import pe.edu.unu.petclinicappbackendpoo2.repository.IPersonRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IPersonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository repository;

    @Override
    public Page<PersonResponse> page(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(
                        new Sort.Order(Sort.Direction.ASC, "lastname"), //va el nombre del atributo de la clase
                        new Sort.Order(Sort.Direction.ASC, "name"),
                        new Sort.Order(Sort.Direction.ASC, "birthday")
                )
        );
        Page<Person> people = repository.findAll(pageable);
        return people.map(person ->{
            return ModelMapperUtil.convertTo(person, PersonResponse.class);
        });
        //return people.map(p -> ModelMapperUtil.convertTo(p, PersonResponse.class));
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    //CRUD : CREATE, READ, UPDATE, DELETE

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        //logica pertinente
        return repository.save(person);
    }

    @Override
    public Person findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
