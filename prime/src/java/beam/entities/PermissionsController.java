package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Permissions;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "permissionsController")
@ViewScoped
public class PermissionsController extends AbstractController<Permissions> {

    @Inject
    private GroupsController groupsController;
    @Inject
    private MobilePageController mobilePageController;

    public PermissionsController() {
        // Inform the Abstract parent controller of the concrete Permissions Entity
        super(Permissions.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPermissionsPK().setGroupId(this.getSelected().getGroups().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPermissionsPK(new entities.PermissionsPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        groupsController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGroups(ActionEvent event) {
        if (this.getSelected() != null && groupsController.getSelected() == null) {
            groupsController.setSelected(this.getSelected().getGroups());
        }
    }
}
