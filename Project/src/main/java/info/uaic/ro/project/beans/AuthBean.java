package info.uaic.ro.project.beans;

import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named
@Dependent
public class AuthBean implements Serializable {
    String HOME_URL = "http://localhost:8080/Project/";

    public void logout() {
        try {
            logoutAndRedirect();
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void logoutAndRedirect() throws IOException, ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.logout();
        context.getExternalContext().redirect(HOME_URL);
    }
}
