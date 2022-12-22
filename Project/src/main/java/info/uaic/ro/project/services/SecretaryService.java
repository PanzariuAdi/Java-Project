package info.uaic.ro.project.services;

import info.uaic.ro.project.entities.Secretary;
import info.uaic.ro.project.repositories.SecretaryRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class SecretaryService implements Service<Secretary> {
    @Inject
    SecretaryRepository secretaryRepository;

    public Secretary findById(int id) {
        return secretaryRepository.findById(id);
    }

    public List<Secretary> findAll() {
        return secretaryRepository.findAll();
    }

    public void create(Secretary secretary) {
        secretaryRepository.persist(secretary);
    }

    public void update(Secretary secretary) {
        secretaryRepository.update(secretary);
    }

    public void remove(Secretary secretary) {
        secretaryRepository.remove(secretary);
    }
}
