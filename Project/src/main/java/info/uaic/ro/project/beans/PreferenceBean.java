package info.uaic.ro.project.beans;

import info.uaic.ro.project.entities.Preference;
import info.uaic.ro.project.services.PreferenceService;
import info.uaic.ro.project.services.StudentService;
import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@ApplicationScoped
public class PreferenceBean implements Serializable {
    @Inject
    PreferenceService preferenceService;
    @Inject
    StudentService studentService;

    private String student1;
    private String student2;
    private int id;

    public void addPreference() {
        if (isPreferenceInvalid(student1) || isPreferenceInvalid(student2))
            return;
        Preference preference = new Preference(id, student1, student2);
        preferenceService.create(preference);
    }

    private boolean isPreferenceInvalid(String registration) {
        if (studentService.isRegistrationValid(registration))
            return false;

        showErrorMessage(registration);
        return true;
    }

    private void showErrorMessage(String registration) {
        String student = registration.equals(student1) ? "Student 1" : "Student 2";
        String summary = "Registration for " + student + " is invalid !";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, "Verify the student's registration."));
    }

    public void deletePreference() {
        Preference preference = preferenceService.findById(id);
        preferenceService.remove(preference);
    }

    public void updatePreference() {
        Preference preference = new Preference(id, student1, student2);
        preferenceService.update(preference);
    }
}