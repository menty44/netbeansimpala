package beam.entities;

import beam.entities.util.MobilePageController;
import entities.NotificationPreferences;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "notificationPreferencesController")
@ViewScoped
public class NotificationPreferencesController extends AbstractController<NotificationPreferences> {

    @Inject
    private MembersController member1Controller;
    @Inject
    private MobilePageController mobilePageController;

    public NotificationPreferencesController() {
        // Inform the Abstract parent controller of the concrete NotificationPreferences Entity
        super(NotificationPreferences.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        member1Controller.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMember1(ActionEvent event) {
        if (this.getSelected() != null && member1Controller.getSelected() == null) {
            member1Controller.setSelected(this.getSelected().getMember1());
        }
    }
}
