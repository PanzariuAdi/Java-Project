package info.uaic.ro.project.entities;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Secretary.findAll", query = "SELECT s FROM Secretary s"),
})
public class Secretary extends Person implements Serializable {
    public Secretary(Integer id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
