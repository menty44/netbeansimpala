package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Alerts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "alertsController")
@ViewScoped
public class AlertsController extends AbstractController<Alerts> {

    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AlertsController() {
        // Inform the Abstract parent controller of the concrete Alerts Entity
        super(Alerts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberId(ActionEvent event) {
        if (this.getSelected() != null && memberIdController.getSelected() == null) {
            memberIdController.setSelected(this.getSelected().getMemberId());
        }
    }
}
