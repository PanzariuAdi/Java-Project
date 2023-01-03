package info.uaic.ro.project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Preference.findAll", query = "SELECT f FROM Preference f"),
})
@Table(name = "preferences")
public class Preference extends AbstractEntity<Integer> implements Serializable {
    @Column(name = "student1")
    private String student1;

    @Column(name = "student2")
    private String student2;

    public Preference(int id, String student1, String student2) {
        super(id);
        this.student1 = student1;
        this.student2 = student2;
    }
}
