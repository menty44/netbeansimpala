package beam.entities;

import beam.entities.util.MobilePageController;
import entities.PermissionDenieds;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "permissionDeniedsController")
@ViewScoped
public class PermissionDeniedsController extends AbstractController<PermissionDenieds> {

    @Inject
    private UsersController userIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PermissionDeniedsController() {
        // Inform the Abstract parent controller of the concrete PermissionDenieds Entity
        super(PermissionDenieds.class);
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
