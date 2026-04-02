package pe.edu.unu.petclinicappbackendpoo2.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unu.petclinicappbackendpoo2.entity.Consult;
import pe.edu.unu.petclinicappbackendpoo2.repository.IConsultRepository;
import pe.edu.unu.petclinicappbackendpoo2.repository.IOwnerRepository;
import pe.edu.unu.petclinicappbackendpoo2.repository.IPersonRepository;
import pe.edu.unu.petclinicappbackendpoo2.repository.IPetRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IConsultService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl implements IConsultService {

    private final IConsultRepository repository;

    private final IPetRepository petRepository;
    private final IOwnerRepository ownerRepository;
    private final IPersonRepository personRepository;

    @Override
    public List<Consult> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Consult savetransactional(Consult consult) {
        consult.getPet().getOwner().setPerson( personRepository.save(consult.getPet().getOwner().getPerson()) );
        //int a = 9/0;
        consult.getPet().setOwner( ownerRepository.save(consult.getPet().getOwner()) );
        consult.setPet( petRepository.save(consult.getPet()) );

        repository.save(consult);
        return consult;
    }

    @Override
    public Consult save(Consult consult) {
        return repository.save(consult);
    }

    @Override
    public Consult update(Consult consult) {
        return repository.save(consult);
    }

    @Override
    public Consult findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
