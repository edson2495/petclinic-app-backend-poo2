package pe.edu.unu.petclinicappbackendpoo2.service;

import pe.edu.unu.petclinicappbackendpoo2.entity.Pet;

import java.util.List;

public interface IPetService {

    public List<Pet> findAll();
    public Pet save(Pet pet);
    public Pet update(Pet pet);
    public Pet findById(Integer id);
    public void delete(Integer id);

}
