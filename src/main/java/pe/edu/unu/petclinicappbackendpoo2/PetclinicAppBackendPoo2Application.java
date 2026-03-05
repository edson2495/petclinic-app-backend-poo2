package pe.edu.unu.petclinicappbackendpoo2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;

@SpringBootApplication
public class PetclinicAppBackendPoo2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PetclinicAppBackendPoo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Person person = new Person(1, "Pepito","Sanchez");
        Person person = Person.builder().
                id(1).
                name("Carlos").
                lastname("Sanchez").
                build();

        System.out.println(person.toString());



    }
}
