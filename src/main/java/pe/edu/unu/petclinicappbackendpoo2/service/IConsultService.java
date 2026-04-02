package pe.edu.unu.petclinicappbackendpoo2.service;

import pe.edu.unu.petclinicappbackendpoo2.entity.Consult;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;

import java.util.List;

public interface IConsultService {

    public List<Consult> findAll();
    public Consult savetransactional(Consult consult);
    public Consult save(Consult consult);
    public Consult update(Consult consult);
    public Consult findById(Integer id);
    public void delete(Integer id);

}
