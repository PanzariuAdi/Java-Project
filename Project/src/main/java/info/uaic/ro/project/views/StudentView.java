package info.uaic.ro.project.views;
import info.uaic.ro.project.beans.DataViewBean;
import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.StudentService;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class StudentView extends DataViewBean<Student, Integer> implements Serializable {
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
