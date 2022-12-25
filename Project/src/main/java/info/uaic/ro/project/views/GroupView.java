package info.uaic.ro.project.views;

import info.uaic.ro.project.beans.DataViewBean;
import info.uaic.ro.project.entities.FacultyGroup;
import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.GroupService;
import info.uaic.ro.project.services.StudentService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class GroupView extends DataViewBean<FacultyGroup, Integer> {
    @Inject
    private GroupService groupService;

    @PostConstruct
    public void init() {
        entities = groupService.findAll();
    }

    public List<FacultyGroup> getEntities() {
        entities = groupService.findAll();
        return entities;
    }
}
