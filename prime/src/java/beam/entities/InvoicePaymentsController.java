package beam.entities;

import beam.entities.util.MobilePageController;
import entities.InvoicePayments;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "invoicePaymentsController")
@ViewScoped
public class InvoicePaymentsController extends AbstractController<InvoicePayments> {

    @Inject
    private TransfersController transferIdController;
    @Inject
    private InvoicesController invoiceIdController;
    @Inject
    private MobilePageController mobilePageController;

    public InvoicePaymentsController() {
        // Inform the Abstract parent controller of the concrete InvoicePayments Entity
        super(InvoicePayments.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferIdController.setSelected(null);
        invoiceIdController.setSelected(null);
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
     * Sets the "selected" attribute of the Invoices controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInvoiceId(ActionEvent event) {
        if (this.getSelected() != null && invoiceIdController.getSelected() == null) {
            invoiceIdController.setSelected(this.getSelected().getInvoiceId());
        }
    }
}
