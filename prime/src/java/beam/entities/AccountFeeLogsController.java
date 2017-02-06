package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountFeeLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountFeeLogsController")
@ViewScoped
public class AccountFeeLogsController extends AbstractController<AccountFeeLogs> {

    @Inject
    private AccountFeesController accountFeeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountFeeLogsController() {
        // Inform the Abstract parent controller of the concrete AccountFeeLogs Entity
        super(AccountFeeLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        accountFeeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from AccountFeeLogs?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from AccountFeeLogs?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Invoices page
     */
    public String navigateInvoicesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Invoices_items", this.getSelected().getInvoicesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/invoices/index";
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from AccountFeeLogs?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the AccountFees controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountFeeId(ActionEvent event) {
        if (this.getSelected() != null && accountFeeIdController.getSelected() == null) {
            accountFeeIdController.setSelected(this.getSelected().getAccountFeeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of MemberAccountFeeLogs
     * entities that are retrieved from AccountFeeLogs?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberAccountFeeLogs page
     */
    public String navigateMemberAccountFeeLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberAccountFeeLogs_items", this.getSelected().getMemberAccountFeeLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberAccountFeeLogs/index";
    }

}
