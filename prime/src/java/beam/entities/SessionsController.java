package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Sessions;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "sessionsController")
@ViewScoped
public class SessionsController extends AbstractController<Sessions> {

    @Inject
    private UsersController userIdController;
    @Inject
    private MobilePageController mobilePageController;

    public SessionsController() {
        // Inform the Abstract parent controller of the concrete Sessions Entity
        super(Sessions.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        userIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUserId(ActionEvent event) {
        if (this.getSelected() != null && userIdController.getSelected() == null) {
            userIdController.setSelected(this.getSelected().getUserId());
        }
    }
}
