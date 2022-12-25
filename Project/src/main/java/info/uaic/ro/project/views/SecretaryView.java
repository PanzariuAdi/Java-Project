package info.uaic.ro.project.views;

import info.uaic.ro.project.beans.DataViewBean;
import info.uaic.ro.project.entities.Secretary;
import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.SecretaryService;
import info.uaic.ro.project.services.StudentService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class SecretaryView extends DataViewBean<Secretary, Integer> {
    @Inject
    private SecretaryService secretaryService;

    @PostConstruct
    public void init() {
        entities = secretaryService.findAll();
    }

    public List<Secretary> getEntities() {
        entities = secretaryService.findAll();
        return entities;
    }
}
