package info.uaic.ro.project.views;
import info.uaic.ro.project.beans.DataViewBean;
import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.StudentService;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class StudentView extends DataViewBean<Student, Integer> {
    @Inject
    private StudentService studentService;

    @PostConstruct
    public void init() {
        entities = studentService.findAll();
    }

    public List<Student> getEntities() {
        entities = studentService.findAll();
        return entities;
    }
}
