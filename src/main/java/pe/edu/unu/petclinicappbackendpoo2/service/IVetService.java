package pe.edu.unu.petclinicappbackendpoo2.service;

import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;

import java.util.List;

public interface IVetService {

    public List<Vet> findAll();
    public Vet save(Vet vet);
    public Vet update(Vet vet);
    public Vet findById(Integer id);
    public void delete(Integer id);
    
}
