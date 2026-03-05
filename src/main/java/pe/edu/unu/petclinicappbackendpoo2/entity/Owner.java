package pe.edu.unu.petclinicappbackendpoo2.entity;

public class Owner {

    private Integer id;

    private Person person;

    public Owner() {
    }

    public Owner(Integer id, Person person) {
        this.id = id;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", person=" + person +
                '}';
    }
}
