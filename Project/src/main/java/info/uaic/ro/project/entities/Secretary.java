package info.uaic.ro.project.entities;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
}
