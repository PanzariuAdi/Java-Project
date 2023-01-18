package info.uaic.ro.project.beans;

import com.google.common.hash.Hashing;
import info.uaic.ro.project.entities.Secretary;
import info.uaic.ro.project.services.SecretaryService;
import lombok.Getter;
import lombok.Setter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@Getter @Setter
@Named
@ApplicationScoped
public class SecretaryBean implements Serializable {
    @Inject
    SecretaryService secretaryService;

    private String firstName;
    private String lastName;
    private int id;

    public void addSecretary() {
        lastName = Hashing.sha256()
                                .hashString(lastName, StandardCharsets.UTF_8)
                                .toString();
        secretaryService.create(new Secretary(firstName, lastName));
    }

    public void deleteSecretary() {
       Secretary secretary = new Secretary(id, firstName, lastName);
       secretaryService.remove(secretary);
    }

    public void updateSecretary() {
        Secretary secretary = new Secretary(id, firstName, lastName);
        secretaryService.update(secretary);
    }
}