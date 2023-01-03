package info.uaic.ro.project.repositories;

import info.uaic.ro.project.entities.Preference;

import javax.ejb.Stateless;

@Stateless
public class PreferenceRepository extends DataRepository<Preference> {
    public PreferenceRepository() {
        super(Preference.class);
    }
}
