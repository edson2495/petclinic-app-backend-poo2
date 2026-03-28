package pe.edu.unu.petclinicappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;
import pe.edu.unu.petclinicappbackendpoo2.repository.IVetRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IVetService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetServiceImpl implements IVetService {

    private final IVetRepository repository;

    @Override
    public List<Vet> findAll() {
        return repository.findAll();
    }

    @Override
    public Vet save(Vet vet) {
        return repository.save(vet);
    }

    @Override
    public Vet update(Vet vet) {
        return repository.save(vet);
    }

    @Override
    public Vet findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
