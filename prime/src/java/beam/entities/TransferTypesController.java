package beam.entities;

import beam.entities.util.MobilePageController;
import entities.TransferTypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transferTypesController")
@ViewScoped
public class TransferTypesController extends AbstractController<TransferTypes> {

    @Inject
    private TransferTypesController loanRepaymentTypeIdController;
    @Inject
    private TransferTypesController loanExpirationFeeTypeIdController;
    @Inject
    private AccountTypesController fromAccountTypeIdController;
    @Inject
    private AccountTypesController toAccountTypeIdController;
    @Inject
    private TransferTypesController loanGrantFeeTypeIdController;
    @Inject
    private TransferTypesController loanExpDailyInterestTypeIdController;
    @Inject
    private MembersController fixedDestinationMemberIdController;
    @Inject
    private TransferTypesController loanMonthlyInterestTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public TransferTypesController() {
        // Inform the Abstract parent controller of the concrete TransferTypes Entity
        super(TransferTypes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        loanRepaymentTypeIdController.setSelected(null);
        loanExpirationFeeTypeIdController.setSelected(null);
        fromAccountTypeIdController.setSelected(null);
        toAccountTypeIdController.setSelected(null);
        loanGrantFeeTypeIdController.setSelected(null);
        loanExpDailyInterestTypeIdController.setSelected(null);
        fixedDestinationMemberIdController.setSelected(null);
        loanMonthlyInterestTypeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of ServiceClients entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ServiceClients page
     */
    public String navigateServiceClientsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ServiceClients_items", this.getSelected().getServiceClientsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/serviceClients/index";
    }

    /**
     * Sets the "items" attribute with a collection of Channels entities that
     * are retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Channels page
     */
    public String navigateChannelsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Channels_items", this.getSelected().getChannelsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/channels/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of
     * AdminNotificationPreferences entities that are retrieved from
     * TransferTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdminNotificationPreferences page
     */
    public String navigateAdminNotificationPreferencesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdminNotificationPreferences_items", this.getSelected().getAdminNotificationPreferencesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adminNotificationPreferences/index";
    }

    /**
     * Sets the "items" attribute with a collection of
     * AdminNotificationPreferences entities that are retrieved from
     * TransferTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdminNotificationPreferences page
     */
    public String navigateAdminNotificationPreferencesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdminNotificationPreferences_items", this.getSelected().getAdminNotificationPreferencesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adminNotificationPreferences/index";
    }

    /**
     * Sets the "items" attribute with a collection of ServiceClients entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ServiceClients page
     */
    public String navigateServiceClientsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ServiceClients_items", this.getSelected().getServiceClientsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/serviceClients/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of PaymentFilters entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of ServiceClients entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ServiceClients page
     */
    public String navigateServiceClientsCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ServiceClients_items", this.getSelected().getServiceClientsCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/serviceClients/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFields entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFields page
     */
    public String navigateCustomFieldsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFields_items", this.getSelected().getCustomFieldsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFields/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for GuaranteeTypes page
     */
    public String navigateGuaranteeTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeTypes_items", this.getSelected().getGuaranteeTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for GuaranteeTypes page
     */
    public String navigateGuaranteeTypesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeTypes_items", this.getSelected().getGuaranteeTypesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for GuaranteeTypes page
     */
    public String navigateGuaranteeTypesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeTypes_items", this.getSelected().getGuaranteeTypesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for GuaranteeTypes page
     */
    public String navigateGuaranteeTypesCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeTypes_items", this.getSelected().getGuaranteeTypesCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from TransferTypes?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of ExternalTransferTypes
     * entities that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ExternalTransferTypes page
     */
    public String navigateExternalTransferTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalTransferTypes_items", this.getSelected().getExternalTransferTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalTransferTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransactionFees entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransactionFees page
     */
    public String navigateTransactionFeesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransactionFees_items", this.getSelected().getTransactionFeesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transactionFees/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransactionFees entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransactionFees page
     */
    public String navigateTransactionFeesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransactionFees_items", this.getSelected().getTransactionFeesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transactionFees/index";
    }

    /**
     * Sets the "items" attribute with a collection of ScheduledPayments
     * entities that are retrieved from TransferTypes?cap_first and returns the
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
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from TransferTypes?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of AuthorizationLevels
     * entities that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AuthorizationLevels page
     */
    public String navigateAuthorizationLevelsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AuthorizationLevels_items", this.getSelected().getAuthorizationLevelsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/authorizationLevels/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountFees entities that
     * are retrieved from TransferTypes?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of
     * MemberGroupAccountSettings entities that are retrieved from
     * TransferTypes?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of CustomFields entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFields page
     */
    public String navigateCustomFieldsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFields_items", this.getSelected().getCustomFieldsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFields/index";
    }

    /**
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of MemberImports entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of MemberImports entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberImports page
     */
    public String navigateMemberImportsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberImports_items", this.getSelected().getMemberImportsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberImports/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
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
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanRepaymentTypeId(ActionEvent event) {
        if (this.getSelected() != null && loanRepaymentTypeIdController.getSelected() == null) {
            loanRepaymentTypeIdController.setSelected(this.getSelected().getLoanRepaymentTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanExpirationFeeTypeId(ActionEvent event) {
        if (this.getSelected() != null && loanExpirationFeeTypeIdController.getSelected() == null) {
            loanExpirationFeeTypeIdController.setSelected(this.getSelected().getLoanExpirationFeeTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFromAccountTypeId(ActionEvent event) {
        if (this.getSelected() != null && fromAccountTypeIdController.getSelected() == null) {
            fromAccountTypeIdController.setSelected(this.getSelected().getFromAccountTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToAccountTypeId(ActionEvent event) {
        if (this.getSelected() != null && toAccountTypeIdController.getSelected() == null) {
            toAccountTypeIdController.setSelected(this.getSelected().getToAccountTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanGrantFeeTypeId(ActionEvent event) {
        if (this.getSelected() != null && loanGrantFeeTypeIdController.getSelected() == null) {
            loanGrantFeeTypeIdController.setSelected(this.getSelected().getLoanGrantFeeTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanExpDailyInterestTypeId(ActionEvent event) {
        if (this.getSelected() != null && loanExpDailyInterestTypeIdController.getSelected() == null) {
            loanExpDailyInterestTypeIdController.setSelected(this.getSelected().getLoanExpDailyInterestTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFixedDestinationMemberId(ActionEvent event) {
        if (this.getSelected() != null && fixedDestinationMemberIdController.getSelected() == null) {
            fixedDestinationMemberIdController.setSelected(this.getSelected().getFixedDestinationMemberId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection4() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection4());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanMonthlyInterestTypeId(ActionEvent event) {
        if (this.getSelected() != null && loanMonthlyInterestTypeIdController.getSelected() == null) {
            loanMonthlyInterestTypeIdController.setSelected(this.getSelected().getLoanMonthlyInterestTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransferTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection4() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection4());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of OperatorGroupsMaxAmount
     * entities that are retrieved from TransferTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for OperatorGroupsMaxAmount page
     */
    public String navigateOperatorGroupsMaxAmountCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OperatorGroupsMaxAmount_items", this.getSelected().getOperatorGroupsMaxAmountCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/operatorGroupsMaxAmount/index";
    }

}
