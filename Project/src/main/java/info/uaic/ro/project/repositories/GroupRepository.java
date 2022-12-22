package info.uaic.ro.project.repositories;

import info.uaic.ro.project.entities.FacultyGroup;

import javax.ejb.Stateless;

@Stateless
public class GroupRepository extends DataRepository<FacultyGroup>{

    public GroupRepository() {
        super(FacultyGroup.class);
    }
}
