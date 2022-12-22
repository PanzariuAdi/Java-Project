package info.uaic.ro.project.repositories;

import info.uaic.ro.project.entities.Secretary;
import javax.ejb.Stateless;

@Stateless
public class SecretaryRepository extends DataRepository<Secretary> {
    public SecretaryRepository() {
        super(Secretary.class);
    }
}
