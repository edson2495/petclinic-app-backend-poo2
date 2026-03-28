package pe.edu.unu.petclinicappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;
import pe.edu.unu.petclinicappbackendpoo2.repository.IOwnerRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IOwnerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements IOwnerService {

    private final IOwnerRepository repository;

    @Override
    public List<Owner> findAll() {
        return repository.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        return repository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return repository.save(owner);
    }

    @Override
    public Owner findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
