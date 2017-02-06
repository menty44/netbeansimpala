package beam.entities;

import beam.entities.util.MobilePageController;
import entities.PaymentObligationLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "paymentObligationLogsController")
@ViewScoped
public class PaymentObligationLogsController extends AbstractController<PaymentObligationLogs> {

    @Inject
    private MembersController byIdController;
    @Inject
    private PaymentObligationsController paymentObligationIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PaymentObligationLogsController() {
        // Inform the Abstract parent controller of the concrete PaymentObligationLogs Entity
        super(PaymentObligationLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        paymentObligationIdController.setSelected(null);
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
     * Sets the "selected" attribute of the PaymentObligations controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePaymentObligationId(ActionEvent event) {
        if (this.getSelected() != null && paymentObligationIdController.getSelected() == null) {
            paymentObligationIdController.setSelected(this.getSelected().getPaymentObligationId());
        }
    }
}
