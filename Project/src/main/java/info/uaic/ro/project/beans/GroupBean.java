package info.uaic.ro.project.beans;

import info.uaic.ro.project.entities.FacultyGroup;
import info.uaic.ro.project.services.GroupService;
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
public class GroupBean implements Serializable {
    @Inject
    GroupService groupService;

    private String name;
    private int id;

    public void addGroup() {
        groupService.create(new FacultyGroup(name));
    }

    public void deleteGroup() {
        FacultyGroup group = groupService.findById(id);
        groupService.remove(group);
    }

}
