package info.uaic.ro.project.entities;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Group.findAll", query = "SELECT f FROM FacultyGroup f"),
})
public class FacultyGroup extends AbstractEntity<Integer> {
    private String name;

    public FacultyGroup(Integer id, String name) {
       super(id);
       this.name = name;
    }
}
