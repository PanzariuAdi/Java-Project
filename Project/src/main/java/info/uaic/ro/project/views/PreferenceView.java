package info.uaic.ro.project.views;

import info.uaic.ro.project.beans.DataViewBean;
import info.uaic.ro.project.entities.Preference;
import info.uaic.ro.project.services.PreferenceService;
import lombok.Getter;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Getter
@Setter
@Named
@ApplicationScoped
public class PreferenceView extends DataViewBean<Preference, Integer> {
    @Inject
    private PreferenceService preferenceService;

    @PostConstruct
    public void init() {
        entities = preferenceService.findAll();
    }

    public List<Preference> getEntities() {
        entities = preferenceService.findAll();
        return entities;
    }
}
