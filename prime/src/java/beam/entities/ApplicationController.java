package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Application;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "applicationController")
@ViewScoped
public class ApplicationController extends AbstractController<Application> {

    @Inject
    private MobilePageController mobilePageController;

    public ApplicationController() {
        // Inform the Abstract parent controller of the concrete Application Entity
        super(Application.class);
    }

}
