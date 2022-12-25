package info.uaic.ro.project.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "FacultyGroup.findAll", query = "SELECT f FROM FacultyGroup f"),
})
@Table(name = "groups")
public class FacultyGroup extends AbstractEntity<Integer> {

    @Column(name = "name")
    private String name;

    public FacultyGroup(Integer id, String name) {
       super(id);
       this.name = name;
    }
}