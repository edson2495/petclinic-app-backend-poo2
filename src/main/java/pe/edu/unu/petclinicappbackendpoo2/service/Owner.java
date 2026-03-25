package pe.edu.unu.petclinicappbackendpoo2.service;

import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;

import java.util.List;

public interface Owner {

    public List<Vet> findAll();
    public Owner save(Owner owner);
    public Owner update(Owner owner);
    public Owner findById(Integer id);
    public void delete(Integer id);

}
