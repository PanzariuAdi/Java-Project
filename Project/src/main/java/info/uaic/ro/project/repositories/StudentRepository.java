package info.uaic.ro.project.repositories;
import info.uaic.ro.project.entities.Student;
import javax.ejb.Stateless;

@Stateless
public class StudentRepository extends DataRepository<Student> {
    public StudentRepository() {
        super(Student.class);
    }
}
