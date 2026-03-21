package pe.edu.unu.petclinicappbackendpoo2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;
import pe.edu.unu.petclinicappbackendpoo2.repository.IPersonRepository;
import pe.edu.unu.petclinicappbackendpoo2.repository.IVetRepository;
import pe.edu.unu.petclinicappbackendpoo2.service.IPersonService;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class PetclinicAppBackendPoo2Application implements CommandLineRunner {

    private final IPersonRepository personRepository;
    private final IVetRepository vetRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetclinicAppBackendPoo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Limpiando todo
        personRepository.deleteAll();
        vetRepository.deleteAll();

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

    }
}
