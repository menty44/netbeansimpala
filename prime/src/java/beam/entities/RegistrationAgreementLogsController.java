package beam.entities;

import beam.entities.util.MobilePageController;
import entities.RegistrationAgreementLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registrationAgreementLogsController")
@ViewScoped
public class RegistrationAgreementLogsController extends AbstractController<RegistrationAgreementLogs> {

    @Inject
    private RegistrationAgreementsController registrationAgreementIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public RegistrationAgreementLogsController() {
        // Inform the Abstract parent controller of the concrete RegistrationAgreementLogs Entity
        super(RegistrationAgreementLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        registrationAgreementIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the RegistrationAgreements controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRegistrationAgreementId(ActionEvent event) {
        if (this.getSelected() != null && registrationAgreementIdController.getSelected() == null) {
            registrationAgreementIdController.setSelected(this.getSelected().getRegistrationAgreementId());
        }
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
