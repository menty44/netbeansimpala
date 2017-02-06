package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Transfers;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transfersController")
@ViewScoped
public class TransfersController extends AbstractController<Transfers> {

    @Inject
    private AccountsController fromAccountIdController;
    @Inject
    private BrokerCommissionContractsController brokerCommissionContractIdController;
    @Inject
    private TransfersController chargedbackByIdController;
    @Inject
    private TransfersController parentIdController;
    @Inject
    private MembersController byIdController;
    @Inject
    private AuthorizationLevelsController nextAuthorizationLevelIdController;
    @Inject
    private LoanPaymentsController loanPaymentIdController;
    @Inject
    private TransactionFeesController transactionFeeIdController;
    @Inject
    private ExternalTransfersController externalTransferIdController;
    @Inject
    private AccountFeeLogsController accountFeeLogIdController;
    @Inject
    private TransferTypesController typeIdController;
    @Inject
    private MembersController receiverIdController;
    @Inject
    private TransfersController chargebackOfIdController;
    @Inject
    private ScheduledPaymentsController scheduledPaymentIdController;
    @Inject
    private TransactionFeesController feeIdController;
    @Inject
    private AccountsController toAccountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public TransfersController() {
        // Inform the Abstract parent controller of the concrete Transfers Entity
        super(Transfers.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        fromAccountIdController.setSelected(null);
        brokerCommissionContractIdController.setSelected(null);
        chargedbackByIdController.setSelected(null);
        parentIdController.setSelected(null);
        byIdController.setSelected(null);
        nextAuthorizationLevelIdController.setSelected(null);
        loanPaymentIdController.setSelected(null);
        transactionFeeIdController.setSelected(null);
        externalTransferIdController.setSelected(null);
        accountFeeLogIdController.setSelected(null);
        typeIdController.setSelected(null);
        receiverIdController.setSelected(null);
        chargebackOfIdController.setSelected(null);
        scheduledPaymentIdController.setSelected(null);
        feeIdController.setSelected(null);
        toAccountIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from Transfers?cap_first and returns the navigation
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
    public void prepareFromAccountId(ActionEvent event) {
        if (this.getSelected() != null && fromAccountIdController.getSelected() == null) {
            fromAccountIdController.setSelected(this.getSelected().getFromAccountId());
        }
    }

    /**
     * Sets the "selected" attribute of the BrokerCommissionContracts controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBrokerCommissionContractId(ActionEvent event) {
        if (this.getSelected() != null && brokerCommissionContractIdController.getSelected() == null) {
            brokerCommissionContractIdController.setSelected(this.getSelected().getBrokerCommissionContractId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from Transfers?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Transfers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareChargedbackById(ActionEvent event) {
        if (this.getSelected() != null && chargedbackByIdController.getSelected() == null) {
            chargedbackByIdController.setSelected(this.getSelected().getChargedbackById());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from Transfers?cap_first and returns the navigation
     * outcome.
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
     * Sets the "selected" attribute of the Transfers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParentId(ActionEvent event) {
        if (this.getSelected() != null && parentIdController.getSelected() == null) {
            parentIdController.setSelected(this.getSelected().getParentId());
        }
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
     * Sets the "selected" attribute of the AuthorizationLevels controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNextAuthorizationLevelId(ActionEvent event) {
        if (this.getSelected() != null && nextAuthorizationLevelIdController.getSelected() == null) {
            nextAuthorizationLevelIdController.setSelected(this.getSelected().getNextAuthorizationLevelId());
        }
    }

    /**
     * Sets the "selected" attribute of the LoanPayments controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanPaymentId(ActionEvent event) {
        if (this.getSelected() != null && loanPaymentIdController.getSelected() == null) {
            loanPaymentIdController.setSelected(this.getSelected().getLoanPaymentId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransactionFees controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransactionFeeId(ActionEvent event) {
        if (this.getSelected() != null && transactionFeeIdController.getSelected() == null) {
            transactionFeeIdController.setSelected(this.getSelected().getTransactionFeeId());
        }
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
     * Sets the "selected" attribute of the AccountFeeLogs controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountFeeLogId(ActionEvent event) {
        if (this.getSelected() != null && accountFeeLogIdController.getSelected() == null) {
            accountFeeLogIdController.setSelected(this.getSelected().getAccountFeeLogId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
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
    public void prepareReceiverId(ActionEvent event) {
        if (this.getSelected() != null && receiverIdController.getSelected() == null) {
            receiverIdController.setSelected(this.getSelected().getReceiverId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from Transfers?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transfers page
     */
    public String navigateTransfersCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transfers_items", this.getSelected().getTransfersCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transfers/index";
    }

    /**
     * Sets the "selected" attribute of the Transfers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareChargebackOfId(ActionEvent event) {
        if (this.getSelected() != null && chargebackOfIdController.getSelected() == null) {
            chargebackOfIdController.setSelected(this.getSelected().getChargebackOfId());
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

    /**
     * Sets the "selected" attribute of the TransactionFees controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFeeId(ActionEvent event) {
        if (this.getSelected() != null && feeIdController.getSelected() == null) {
            feeIdController.setSelected(this.getSelected().getFeeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Accounts controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToAccountId(ActionEvent event) {
        if (this.getSelected() != null && toAccountIdController.getSelected() == null) {
            toAccountIdController.setSelected(this.getSelected().getToAccountId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Refs entities that are
     * retrieved from Transfers?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Refs page
     */
    public String navigateRefsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Refs_items", this.getSelected().getRefsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/refs/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransferAuthorizations
     * entities that are retrieved from Transfers?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferAuthorizations page
     */
    public String navigateTransferAuthorizationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferAuthorizations_items", this.getSelected().getTransferAuthorizationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferAuthorizations/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountRates entities
     * that are retrieved from Transfers?cap_first and returns the navigation
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
     * entities that are retrieved from Transfers?cap_first and returns the
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
     * Sets the "items" attribute with a collection of Loans entities that are
     * retrieved from Transfers?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Loans page
     */
    public String navigateLoansCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Loans_items", this.getSelected().getLoansCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/loans/index";
    }

    /**
     * Sets the "items" attribute with a collection of InvoicePayments entities
     * that are retrieved from Transfers?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for InvoicePayments page
     */
    public String navigateInvoicePaymentsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InvoicePayments_items", this.getSelected().getInvoicePaymentsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/invoicePayments/index";
    }

    /**
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from Transfers?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Tickets page
     */
    public String navigateTicketsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tickets_items", this.getSelected().getTicketsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tickets/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberAccountFeeLogs
     * entities that are retrieved from Transfers?cap_first and returns the
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

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from Transfers?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

}
