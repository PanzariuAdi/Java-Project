package info.uaic.ro.project.services;

import info.uaic.ro.project.entities.FacultyGroup;
import info.uaic.ro.project.repositories.GroupRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupService implements Service<FacultyGroup> {
    @Inject
    GroupRepository groupRepository;

    public FacultyGroup findById(int id) {
        return groupRepository.findById(id);
    }

    public List<FacultyGroup> findAll() {
        return groupRepository.findAll();
    }

    public void create(FacultyGroup facultyGroup) {
        groupRepository.persist(facultyGroup);
    }

    public void update(FacultyGroup facultyGroup) {
        groupRepository.update(facultyGroup);
    }

    public void remove(FacultyGroup facultyGroup) {
        groupRepository.remove(facultyGroup);
    }
}
