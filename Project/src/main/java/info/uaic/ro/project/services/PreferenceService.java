package info.uaic.ro.project.services;

import info.uaic.ro.project.entities.Preference;
import info.uaic.ro.project.repositories.PreferenceRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PreferenceService implements Service<Preference> {
    @Inject
    PreferenceRepository preferenceRepository;

    public void create(Preference preference) {
        preferenceRepository.persist(preference);
    }

    public List<Preference> findAll() {
        return preferenceRepository.findAll();
    }

    public Preference findById(int id) {
        return preferenceRepository.findById(id);
    }

    public void update(Preference preference) {
        preferenceRepository.update(preference);
    }

    public void remove(Preference preference) {
        preferenceRepository.remove(preference);
    }

}
