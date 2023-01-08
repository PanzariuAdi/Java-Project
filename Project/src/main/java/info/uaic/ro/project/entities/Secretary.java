package info.uaic.ro.project.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Secretary.findAll", query = "SELECT s FROM Secretary s"),
})
@Table(name = "secretaries")
public class Secretary extends Person implements Serializable {
    public Secretary(Integer id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Column(name = "role")
    private String role;

    public Secretary(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = "secretary";
    }
}
