package pe.edu.unu.petclinicappbackendpoo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unu.petclinicappbackendpoo2.entity.Owner;

public interface IOwnerRepository extends JpaRepository<Owner, Integer> {
}
