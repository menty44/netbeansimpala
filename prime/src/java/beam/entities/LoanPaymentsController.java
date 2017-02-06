package beam.entities;

import beam.entities.util.MobilePageController;
import entities.LoanPayments;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "loanPaymentsController")
@ViewScoped
public class LoanPaymentsController extends AbstractController<LoanPayments> {

    @Inject
    private ExternalTransfersController externalTransferIdController;
    @Inject
    private LoansController loanIdController;
    @Inject
    private MobilePageController mobilePageController;

    public LoanPaymentsController() {
        // Inform the Abstract parent controller of the concrete LoanPayments Entity
        super(LoanPayments.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        externalTransferIdController.setSelected(null);
        loanIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from LoanPayments?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transfers page
     */
    public String navigateTransfersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transfers_items", this.getSelected().getTransfersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transfers/index";
    }

    /**
     * Sets the "selected" attribute of the ExternalTransfers controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareExternalTransferId(ActionEvent event) {
        if (this.getSelected() != null && externalTransferIdController.getSelected() == null) {
            externalTransferIdController.setSelected(this.getSelected().getExternalTransferId());
        }
    }

    /**
     * Sets the "selected" attribute of the Loans controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanId(ActionEvent event) {
        if (this.getSelected() != null && loanIdController.getSelected() == null) {
            loanIdController.setSelected(this.getSelected().getLoanId());
        }
    }
}
