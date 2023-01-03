package info.uaic.ro.project.beans;

import info.uaic.ro.project.entities.Secretary;
import info.uaic.ro.project.services.SecretaryService;
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
public class SecretaryBean implements Serializable {
    @Inject
    SecretaryService secretaryService;

    private String firstName;
    private String lastName;
    private int id;

    public void addSecretary() {
        secretaryService.create(new Secretary(firstName, lastName));
    }

    public void deleteSecretary() {
       Secretary secretary = secretaryService.findById(id);
       secretaryService.remove(secretary);
    }

}
