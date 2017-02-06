package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Loans;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "loansController")
@ViewScoped
public class LoansController extends AbstractController<Loans> {

    @Inject
    private GuaranteesController guaranteesController;
    @Inject
    private TransfersController transferIdController;
    @Inject
    private LoanGroupsController loanGroupIdController;
    @Inject
    private MobilePageController mobilePageController;

    public LoansController() {
        // Inform the Abstract parent controller of the concrete Loans Entity
        super(Loans.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        guaranteesController.setSelected(null);
        transferIdController.setSelected(null);
        loanGroupIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from Loans?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Members page
     */
    public String navigateMembersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Members_items", this.getSelected().getMembersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/members/index";
    }

    /**
     * Sets the "selected" attribute of the Guarantees controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGuarantees(ActionEvent event) {
        if (this.getSelected() != null && guaranteesController.getSelected() == null) {
            guaranteesController.setSelected(this.getSelected().getGuarantees());
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
     * Sets the "selected" attribute of the LoanGroups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanGroupId(ActionEvent event) {
        if (this.getSelected() != null && loanGroupIdController.getSelected() == null) {
            loanGroupIdController.setSelected(this.getSelected().getLoanGroupId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of LoanPayments entities
     * that are retrieved from Loans?cap_first and returns the navigation
     * outcome.
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
