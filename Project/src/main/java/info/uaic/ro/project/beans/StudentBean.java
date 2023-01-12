package info.uaic.ro.project.beans;

import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.StudentService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named
@ApplicationScoped
public class StudentBean implements Serializable {
    @Inject
    StudentService studentService;

    private int id;
    private String firstName;
    private String lastName;
    private String registrationNumber;
    private int group = 1;
    private float grade = 10;
    private int year = 1;

    public void addStudent() {
        Student student = new Student(
                firstName,
                lastName,
                group,
                registrationNumber,
                grade,
                year
        );
        studentService.create(student);
    }

    public void deleteStudent() {
        Student student = studentService.findById(id);
        studentService.remove(student);
    }

    public void updateStudent() {
        Student student = new Student(
                id,
                firstName,
                lastName,
                group,
                registrationNumber,
                grade,
                year
        );
        studentService.update(student);
    }
}
