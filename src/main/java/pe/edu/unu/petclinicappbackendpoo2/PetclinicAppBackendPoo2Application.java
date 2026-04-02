package pe.edu.unu.petclinicappbackendpoo2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.unu.petclinicappbackendpoo2.entity.*;
import pe.edu.unu.petclinicappbackendpoo2.repository.*;
import pe.edu.unu.petclinicappbackendpoo2.service.IPersonService;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class PetclinicAppBackendPoo2Application implements CommandLineRunner {

    private final IPersonRepository personRepository;
    private final IVetRepository vetRepository;
    private final IOwnerRepository ownerRepository;
    private final IPetTypeRepository petTypeRepository;
    private final IPetRepository petRepository;
    private final IConsultRepository consultRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetclinicAppBackendPoo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Limpiando todo
        personRepository.deleteAll();
        vetRepository.deleteAll();
        ownerRepository.deleteAll();
        petTypeRepository.deleteAll();
        petRepository.deleteAll();
        consultRepository.deleteAll();

        //agregando data de prueba de personas

        personRepository.save(
                Person.builder()
                .name("Roberto")
                .lastname("Sanchez")
                .birthday(LocalDate.of(1900,4,22))
                .cellphone("987654321")
                .build()
        );
        personRepository.save(
                Person.builder()
                .name("Joao")
                .lastname("Cajas")
                .birthday(LocalDate.of(2000,5,20))
                .cellphone("123456789")
                .build()
        );

        //agregando data de prueba de veterinarios
        vetRepository.save(
                Vet.builder()
                .person(Person.builder().id(1).build())
                .build()
        );

        ownerRepository.save(
                Owner.builder()
                .person(Person.builder().id(2).build())
                .build()
        );

        petTypeRepository.save(
                PetType.builder()
                .name("Can")
                .build()
        );
        petTypeRepository.save(
                PetType.builder()
                .name("Felino")
                .build()
        );

        petRepository.save(
                Pet.builder()
                .name("Gris")
                .owner(Owner.builder().id(1).build())
                .petType(PetType.builder().id(2).build())
                .build()
        );

        consultRepository.save(
                Consult.builder()
                .diagnostic("Everything is fine!")
                .pet(Pet.builder().id(1).build())
                .vet(Vet.builder().id(1).build())
                .build()
        );

    }
}
