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
        @NamedQuery(name = "Student.findByRegistration", query = "SELECT s FROM Student s WHERE s.registrationNumber = :registrationNumber"),
})
@Table(name = "students")
public class Student extends Person implements Serializable {
    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "group_id")
    int group;

    @Column(name = "grade")
    private float grade;

    @Column(name = "year")
    private int year;

    public Student(Integer id, String firstName, String lastName, int group, String registrationNumber, float grade, int year) {
        super(id, firstName, lastName);
        this.group = group;
        this.registrationNumber = registrationNumber;
        this.grade = grade;
        this.year = year;
    }

    public Student(String firstName, String lastName, int group, String registrationNumber, float grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.registrationNumber = registrationNumber;
        this.grade = grade;
        this.year = year;
    }
}