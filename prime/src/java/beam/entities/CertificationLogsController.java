package beam.entities;

import beam.entities.util.MobilePageController;
import entities.CertificationLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "certificationLogsController")
@ViewScoped
public class CertificationLogsController extends AbstractController<CertificationLogs> {

    @Inject
    private CertificationsController certificationIdController;
    @Inject
    private MembersController byIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CertificationLogsController() {
        // Inform the Abstract parent controller of the concrete CertificationLogs Entity
        super(CertificationLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        certificationIdController.setSelected(null);
        byIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Certifications controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCertificationId(ActionEvent event) {
        if (this.getSelected() != null && certificationIdController.getSelected() == null) {
            certificationIdController.setSelected(this.getSelected().getCertificationId());
        }
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
}
