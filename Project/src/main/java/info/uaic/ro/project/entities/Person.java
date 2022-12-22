package info.uaic.ro.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Person extends AbstractEntity<Integer> {
    @Column(name = "firstname")
    protected String firstName;

    @Column(name = "lastname")
    protected String lastName;

    public Person(Integer id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
