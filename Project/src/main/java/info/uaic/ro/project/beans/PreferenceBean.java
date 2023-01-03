package info.uaic.ro.project.beans;

import info.uaic.ro.project.entities.Preference;
import info.uaic.ro.project.services.PreferenceService;
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
public class PreferenceBean implements Serializable {
    @Inject
    PreferenceService preferenceService;

    private String student1;
    private String student2;
    private int id;

    public void addPreference() {
        preferenceService.create(new Preference(student1, student2));
    }

    public void deletePreference() {
        Preference preference = preferenceService.findById(id);
        preferenceService.remove(preference);
    }
}
