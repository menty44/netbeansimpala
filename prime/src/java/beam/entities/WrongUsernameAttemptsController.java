package beam.entities;

import beam.entities.util.MobilePageController;
import entities.WrongUsernameAttempts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "wrongUsernameAttemptsController")
@ViewScoped
public class WrongUsernameAttemptsController extends AbstractController<WrongUsernameAttempts> {

    @Inject
    private MobilePageController mobilePageController;

    public WrongUsernameAttemptsController() {
        // Inform the Abstract parent controller of the concrete WrongUsernameAttempts Entity
        super(WrongUsernameAttempts.class);
    }

}
