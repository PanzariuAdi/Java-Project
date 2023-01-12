package info.uaic.ro.project.services;

import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.repositories.StudentRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class StudentService implements Service<Student> {
    @Inject
    StudentRepository studentRepository;

    public void create(Student student) {
        studentRepository.persist(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public void remove(Student student) {
        studentRepository.remove(student);
    }

    public boolean isRegistrationValid(String registration) {
        return findAll()
                .stream()
                .anyMatch(s -> s.getRegistrationNumber().equals(registration));
    }

}
