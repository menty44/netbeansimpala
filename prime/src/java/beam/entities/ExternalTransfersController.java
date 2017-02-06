package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ExternalTransfers;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "externalTransfersController")
@ViewScoped
public class ExternalTransfersController extends AbstractController<ExternalTransfers> {

    @Inject
    private ExternalTransferImportsController importIdController;
    @Inject
    private ExternalTransferTypesController typeIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private ExternalAccountsController accountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ExternalTransfersController() {
        // Inform the Abstract parent controller of the concrete ExternalTransfers Entity
        super(ExternalTransfers.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        importIdController.setSelected(null);
        typeIdController.setSelected(null);
        memberIdController.setSelected(null);
        accountIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from ExternalTransfers?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the ExternalTransferImports controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportId(ActionEvent event) {
        if (this.getSelected() != null && importIdController.getSelected() == null) {
            importIdController.setSelected(this.getSelected().getImportId());
        }
    }

    /**
     * Sets the "selected" attribute of the ExternalTransferTypes controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTypeId(ActionEvent event) {
        if (this.getSelected() != null && typeIdController.getSelected() == null) {
            typeIdController.setSelected(this.getSelected().getTypeId());
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

    /**
     * Sets the "selected" attribute of the ExternalAccounts controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountId(ActionEvent event) {
        if (this.getSelected() != null && accountIdController.getSelected() == null) {
            accountIdController.setSelected(this.getSelected().getAccountId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of LoanPayments entities
     * that are retrieved from ExternalTransfers?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for LoanPayments page
     */
    public String navigateLoanPaymentsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LoanPayments_items", this.getSelected().getLoanPaymentsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/loanPayments/index";
    }

}
