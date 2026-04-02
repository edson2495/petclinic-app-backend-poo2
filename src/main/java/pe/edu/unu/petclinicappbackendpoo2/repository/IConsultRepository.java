package pe.edu.unu.petclinicappbackendpoo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unu.petclinicappbackendpoo2.entity.Consult;

public interface IConsultRepository extends JpaRepository<Consult, Integer> {
}
