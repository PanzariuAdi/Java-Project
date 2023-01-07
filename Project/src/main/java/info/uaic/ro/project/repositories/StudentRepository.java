package info.uaic.ro.project.repositories;
import info.uaic.ro.project.entities.Student;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentRepository extends DataRepository<Student> {
    @Getter
    @Setter
    @PersistenceContext(unitName = "GPU")
    private EntityManager entityManager;

    public StudentRepository() {
        super(Student.class);
    }

    public Student findByRegistration(String registration) {
        return (Student) entityManager.createNamedQuery("Student.findByRegistration")
                .setParameter("registrationNumber", registration)
                .getSingleResult();
    }
}
