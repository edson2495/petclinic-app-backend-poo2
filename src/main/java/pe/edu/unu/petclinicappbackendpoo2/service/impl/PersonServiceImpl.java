package pe.edu.unu.petclinicappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;
import pe.edu.unu.petclinicappbackendpoo2.repository.IPersonRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IPersonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository repository;

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
