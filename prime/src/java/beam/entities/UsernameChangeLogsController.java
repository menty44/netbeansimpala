package beam.entities;

import beam.entities.util.MobilePageController;
import entities.UsernameChangeLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usernameChangeLogsController")
@ViewScoped
public class UsernameChangeLogsController extends AbstractController<UsernameChangeLogs> {

    @Inject
    private MembersController byIdController;
    @Inject
    private UsersController userIdController;
    @Inject
    private MobilePageController mobilePageController;

    public UsernameChangeLogsController() {
        // Inform the Abstract parent controller of the concrete UsernameChangeLogs Entity
        super(UsernameChangeLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        userIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareById(ActionEvent event) {
        if (this.getSelected() != null && byIdController.getSelected() == null) {
            byIdController.setSelected(this.getSelected().getById());
        }
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
