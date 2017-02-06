package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AmountReservations;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "amountReservationsController")
@ViewScoped
public class AmountReservationsController extends AbstractController<AmountReservations> {

    @Inject
    private TransferAuthorizationsController transferAuthorizationIdController;
    @Inject
    private TransfersController transferIdController;
    @Inject
    private AccountsController accountIdController;
    @Inject
    private ScheduledPaymentsController scheduledPaymentIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AmountReservationsController() {
        // Inform the Abstract parent controller of the concrete AmountReservations Entity
        super(AmountReservations.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferAuthorizationIdController.setSelected(null);
        transferIdController.setSelected(null);
        accountIdController.setSelected(null);
        scheduledPaymentIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TransferAuthorizations controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferAuthorizationId(ActionEvent event) {
        if (this.getSelected() != null && transferAuthorizationIdController.getSelected() == null) {
            transferAuthorizationIdController.setSelected(this.getSelected().getTransferAuthorizationId());
        }
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
     * Sets the "selected" attribute of the Accounts controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountId(ActionEvent event) {
        if (this.getSelected() != null && accountIdController.getSelected() == null) {
            accountIdController.setSelected(this.getSelected().getAccountId());
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
