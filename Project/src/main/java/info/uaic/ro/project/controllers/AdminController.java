package info.uaic.ro.project.controllers;

import info.uaic.ro.project.entities.Secretary;
import info.uaic.ro.project.services.SecretaryService;

import javax.inject.Inject;
import java.util.List;

public class AdminController {
    @Inject
    SecretaryService secretaryService;

    public void addSecretary(Secretary secretary) {
        secretaryService.create(secretary);
    }

    public void updateSecretary(Secretary secretary) {
        secretaryService.update(secretary);
    }

    public void removeSecretary(Secretary secretary) {
        secretaryService.remove(secretary);
    }

    public Secretary findSecretary(int id) {
        return secretaryService.findById(id);
    }

    public List<Secretary> getSecretaries() {
        return secretaryService.findAll();
    }
}
