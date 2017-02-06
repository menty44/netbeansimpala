package beam.entities;

import beam.entities.util.MobilePageController;
import entities.PosLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "posLogsController")
@ViewScoped
public class PosLogsController extends AbstractController<PosLogs> {

    @Inject
    private MembersController byIdController;
    @Inject
    private MembersController assignedToController;
    @Inject
    private PosController posIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PosLogsController() {
        // Inform the Abstract parent controller of the concrete PosLogs Entity
        super(PosLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        assignedToController.setSelected(null);
        posIdController.setSelected(null);
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
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAssignedTo(ActionEvent event) {
        if (this.getSelected() != null && assignedToController.getSelected() == null) {
            assignedToController.setSelected(this.getSelected().getAssignedTo());
        }
    }

    /**
     * Sets the "selected" attribute of the Pos controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePosId(ActionEvent event) {
        if (this.getSelected() != null && posIdController.getSelected() == null) {
            posIdController.setSelected(this.getSelected().getPosId());
        }
    }
}
