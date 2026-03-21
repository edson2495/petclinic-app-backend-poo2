package pe.edu.unu.petclinicappbackendpoo2.service;

import pe.edu.unu.petclinicappbackendpoo2.entity.Person;

import java.util.List;

public interface IPersonService {

    public List<Person> findAll();
    public Person save(Person person);
    public Person update(Person person);
    public Person findById(Integer id);
    public void delete(Integer id);

}
