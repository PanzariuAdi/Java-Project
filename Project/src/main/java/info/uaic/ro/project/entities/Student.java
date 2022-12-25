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
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
})
@Table(name = "students")
public class Student extends Person implements Serializable {
    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "group_id")
    int group; // This will be set after the secretary makes the distribution.

    @Column(name = "grade")
    private float grade; // From admission, to change to a better name

    @Column(name = "year")
    private int year;

    public Student(Integer id, String firstName, String lastName, String registrationNumber, float grade, int year) {
        super(id, firstName, lastName);
        this.registrationNumber = registrationNumber;
        this.grade = grade;
        this.year = year;
    }
}