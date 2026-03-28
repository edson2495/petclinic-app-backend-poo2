package pe.edu.unu.petclinicappbackendpoo2.service;

import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;

import java.util.List;

public interface IOwnerService {

    public List<Owner> findAll();
    public Owner save(Owner owner);
    public Owner update(Owner owner);
    public Owner findById(Integer id);
    public void delete(Integer id);

}
