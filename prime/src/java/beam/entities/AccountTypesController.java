package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountTypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountTypesController")
@ViewScoped
public class AccountTypesController extends AbstractController<AccountTypes> {

    @Inject
    private AccountsController systemAccountIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountTypesController() {
        // Inform the Abstract parent controller of the concrete AccountTypes Entity
        super(AccountTypes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        systemAccountIdController.setSelected(null);
        currencyIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from AccountTypes?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from AccountTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from AccountTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from AccountTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from AccountTypes?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Accounts controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSystemAccountId(ActionEvent event) {
        if (this.getSelected() != null && systemAccountIdController.getSelected() == null) {
            systemAccountIdController.setSelected(this.getSelected().getSystemAccountId());
        }
    }

    /**
     * Sets the "selected" attribute of the Currencies controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCurrencyId(ActionEvent event) {
        if (this.getSelected() != null && currencyIdController.getSelected() == null) {
            currencyIdController.setSelected(this.getSelected().getCurrencyId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of AccountFees entities that
     * are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountFees page
     */
    public String navigateAccountFeesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountFees_items", this.getSelected().getAccountFeesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountFees/index";
    }

    /**
     * Sets the "items" attribute with a collection of Accounts entities that
     * are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Accounts page
     */
    public String navigateAccountsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Accounts_items", this.getSelected().getAccountsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accounts/index";
    }

    /**
     * Sets the "items" attribute with a collection of
     * MemberGroupAccountSettings entities that are retrieved from
     * AccountTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MemberGroupAccountSettings page
     */
    public String navigateMemberGroupAccountSettingsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberGroupAccountSettings_items", this.getSelected().getMemberGroupAccountSettingsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberGroupAccountSettings/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExternalAccounts entities
     * that are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ExternalAccounts page
     */
    public String navigateExternalAccountsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalAccounts_items", this.getSelected().getExternalAccountsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalAccounts/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExternalAccounts entities
     * that are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ExternalAccounts page
     */
    public String navigateExternalAccountsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalAccounts_items", this.getSelected().getExternalAccountsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalAccounts/index";
    }

    /**
     * Sets the "items" attribute with a collection of PaymentFilters entities
     * that are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PaymentFilters page
     */
    public String navigatePaymentFiltersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaymentFilters_items", this.getSelected().getPaymentFiltersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/paymentFilters/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberImports entities
     * that are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for MemberImports page
     */
    public String navigateMemberImportsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberImports_items", this.getSelected().getMemberImportsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberImports/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from AccountTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

}
