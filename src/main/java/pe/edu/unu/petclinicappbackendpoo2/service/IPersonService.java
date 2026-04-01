package pe.edu.unu.petclinicappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PersonResponse;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;

import java.util.List;

public interface IPersonService {

    public Page<PersonResponse> page(Integer page, Integer size);
    public List<Person> findAll();
    public Person save(Person person);
    public Person update(Person person);
    public Person findById(Integer id);
    public void delete(Integer id);

}
