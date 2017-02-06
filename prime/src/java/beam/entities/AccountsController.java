package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Accounts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountsController")
@ViewScoped
public class AccountsController extends AbstractController<Accounts> {

    @Inject
    private AccountTypesController typeIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountsController() {
        // Inform the Abstract parent controller of the concrete Accounts Entity
        super(Accounts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        typeIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of AccountLimitLogs entities
     * that are retrieved from Accounts?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountLimitLogs page
     */
    public String navigateAccountLimitLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountLimitLogs_items", this.getSelected().getAccountLimitLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountLimitLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of ScheduledPayments
     * entities that are retrieved from Accounts?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ScheduledPayments page
     */
    public String navigateScheduledPaymentsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ScheduledPayments_items", this.getSelected().getScheduledPaymentsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/scheduledPayments/index";
    }

    /**
     * Sets the "items" attribute with a collection of ScheduledPayments
     * entities that are retrieved from Accounts?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ScheduledPayments page
     */
    public String navigateScheduledPaymentsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ScheduledPayments_items", this.getSelected().getScheduledPaymentsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/scheduledPayments/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountFeeAmounts
     * entities that are retrieved from Accounts?cap_first and returns the
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
     * Sets the "items" attribute with a collection of AccountTypes entities
     * that are retrieved from Accounts?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountTypes page
     */
    public String navigateAccountTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountTypes_items", this.getSelected().getAccountTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from Accounts?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from Accounts?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Transfers page
     */
    public String navigateTransfersCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transfers_items", this.getSelected().getTransfersCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transfers/index";
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
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
     * Sets the "items" attribute with a collection of AccountRates entities
     * that are retrieved from Accounts?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountRates page
     */
    public String navigateAccountRatesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountRates_items", this.getSelected().getAccountRatesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountRates/index";
    }

    /**
     * Sets the "items" attribute with a collection of AmountReservations
     * entities that are retrieved from Accounts?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AmountReservations page
     */
    public String navigateAmountReservationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AmountReservations_items", this.getSelected().getAmountReservationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/amountReservations/index";
    }

    /**
     * Sets the "items" attribute with a collection of ClosedAccountBalances
     * entities that are retrieved from Accounts?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ClosedAccountBalances page
     */
    public String navigateClosedAccountBalancesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ClosedAccountBalances_items", this.getSelected().getClosedAccountBalancesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/closedAccountBalances/index";
    }

}
