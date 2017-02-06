package beam.entities;

import beam.entities.util.MobilePageController;
import entities.SmsLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "smsLogsController")
@ViewScoped
public class SmsLogsController extends AbstractController<SmsLogs> {

    @Inject
    private MembersController chargedMemberIdController;
    @Inject
    private SmsMailingsController smsMailingIdController;
    @Inject
    private SmsTypesController smsTypeIdController;
    @Inject
    private MembersController targetMemberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public SmsLogsController() {
        // Inform the Abstract parent controller of the concrete SmsLogs Entity
        super(SmsLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        chargedMemberIdController.setSelected(null);
        smsMailingIdController.setSelected(null);
        smsTypeIdController.setSelected(null);
        targetMemberIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareChargedMemberId(ActionEvent event) {
        if (this.getSelected() != null && chargedMemberIdController.getSelected() == null) {
            chargedMemberIdController.setSelected(this.getSelected().getChargedMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the SmsMailings controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSmsMailingId(ActionEvent event) {
        if (this.getSelected() != null && smsMailingIdController.getSelected() == null) {
            smsMailingIdController.setSelected(this.getSelected().getSmsMailingId());
        }
    }

    /**
     * Sets the "selected" attribute of the SmsTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSmsTypeId(ActionEvent event) {
        if (this.getSelected() != null && smsTypeIdController.getSelected() == null) {
            smsTypeIdController.setSelected(this.getSelected().getSmsTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTargetMemberId(ActionEvent event) {
        if (this.getSelected() != null && targetMemberIdController.getSelected() == null) {
            targetMemberIdController.setSelected(this.getSelected().getTargetMemberId());
        }
    }
}
