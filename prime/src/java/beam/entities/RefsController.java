package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Refs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "refsController")
@ViewScoped
public class RefsController extends AbstractController<Refs> {

    @Inject
    private TransfersController transferIdController;
    @Inject
    private MembersController fromMemberIdController;
    @Inject
    private MembersController toMemberIdController;
    @Inject
    private ScheduledPaymentsController scheduledPaymentIdController;
    @Inject
    private MobilePageController mobilePageController;

    public RefsController() {
        // Inform the Abstract parent controller of the concrete Refs Entity
        super(Refs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferIdController.setSelected(null);
        fromMemberIdController.setSelected(null);
        toMemberIdController.setSelected(null);
        scheduledPaymentIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Transfers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferId(ActionEvent event) {
        if (this.getSelected() != null && transferIdController.getSelected() == null) {
            transferIdController.setSelected(this.getSelected().getTransferId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFromMemberId(ActionEvent event) {
        if (this.getSelected() != null && fromMemberIdController.getSelected() == null) {
            fromMemberIdController.setSelected(this.getSelected().getFromMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToMemberId(ActionEvent event) {
        if (this.getSelected() != null && toMemberIdController.getSelected() == null) {
            toMemberIdController.setSelected(this.getSelected().getToMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the ScheduledPayments controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareScheduledPaymentId(ActionEvent event) {
        if (this.getSelected() != null && scheduledPaymentIdController.getSelected() == null) {
            scheduledPaymentIdController.setSelected(this.getSelected().getScheduledPaymentId());
        }
    }
}
