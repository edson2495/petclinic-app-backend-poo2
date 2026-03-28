package pe.edu.unu.petclinicappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unu.petclinicappbackendpoo2.entity.Pet;
import pe.edu.unu.petclinicappbackendpoo2.repository.IPetRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IPetService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements IPetService {

    private final IPetRepository repository;

    @Override
    public List<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    @Override
    public Pet update(Pet pet) {
        //logica pertinente
        return repository.save(pet);
    }

    @Override
    public Pet findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
