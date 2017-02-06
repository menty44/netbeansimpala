package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountFees;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountFeesController")
@ViewScoped
public class AccountFeesController extends AbstractController<AccountFees> {

    @Inject
    private TransferTypesController transferTypeIdController;
    @Inject
    private AccountTypesController accountTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountFeesController() {
        // Inform the Abstract parent controller of the concrete AccountFees Entity
        super(AccountFees.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferTypeIdController.setSelected(null);
        accountTypeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from AccountFees?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountFeeAmounts
     * entities that are retrieved from AccountFees?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AccountFeeAmounts page
     */
    public String navigateAccountFeeAmountsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountFeeAmounts_items", this.getSelected().getAccountFeeAmountsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountFeeAmounts/index";
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && transferTypeIdController.getSelected() == null) {
            transferTypeIdController.setSelected(this.getSelected().getTransferTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountTypeId(ActionEvent event) {
        if (this.getSelected() != null && accountTypeIdController.getSelected() == null) {
            accountTypeIdController.setSelected(this.getSelected().getAccountTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of AccountFeeLogs entities
     * that are retrieved from AccountFees?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountFeeLogs page
     */
    public String navigateAccountFeeLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountFeeLogs_items", this.getSelected().getAccountFeeLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountFeeLogs/index";
    }

}
