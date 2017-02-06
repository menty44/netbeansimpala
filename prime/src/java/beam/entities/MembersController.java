package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Members;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "membersController")
@ViewScoped
public class MembersController extends AbstractController<Members> {

    @Inject
    private MemberSmsStatusController memberSmsStatusController;
    @Inject
    private GroupsController groupIdController;
    @Inject
    private MembersController memberBrokerIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private UsersController usersController;
    @Inject
    private MobilePageController mobilePageController;

    public MembersController() {
        // Inform the Abstract parent controller of the concrete Members Entity
        super(Members.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        memberSmsStatusController.setSelected(null);
        groupIdController.setSelected(null);
        memberBrokerIdController.setSelected(null);
        memberIdController.setSelected(null);
        usersController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of AccountFeeLogs entities
     * that are retrieved from Members?cap_first and returns the navigation
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

    /**
     * Sets the "items" attribute with a collection of SmsMailings entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsMailings page
     */
    public String navigateSmsMailingsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsMailings_items", this.getSelected().getSmsMailingsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsMailings/index";
    }

    /**
     * Sets the "items" attribute with a collection of Loans entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of LoanGroups entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for LoanGroups page
     */
    public String navigateLoanGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LoanGroups_items", this.getSelected().getLoanGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/loanGroups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Channels entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of PendingEmailChanges
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PendingEmailChanges page
     */
    public String navigatePendingEmailChangesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PendingEmailChanges_items", this.getSelected().getPendingEmailChangesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pendingEmailChanges/index";
    }

    /**
     * Sets the "items" attribute with a collection of PendingEmailChanges
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PendingEmailChanges page
     */
    public String navigatePendingEmailChangesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PendingEmailChanges_items", this.getSelected().getPendingEmailChangesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pendingEmailChanges/index";
    }

    /**
     * Sets the "items" attribute with a collection of UsernameChangeLogs
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for UsernameChangeLogs page
     */
    public String navigateUsernameChangeLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsernameChangeLogs_items", this.getSelected().getUsernameChangeLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/usernameChangeLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of DefaultBrokerCommissions
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DefaultBrokerCommissions page
     */
    public String navigateDefaultBrokerCommissionsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DefaultBrokerCommissions_items", this.getSelected().getDefaultBrokerCommissionsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/defaultBrokerCommissions/index";
    }

    /**
     * Sets the "items" attribute with a collection of SmsLogs entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsLogs page
     */
    public String navigateSmsLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsLogs_items", this.getSelected().getSmsLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of SmsLogs entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsLogs page
     */
    public String navigateSmsLogsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsLogs_items", this.getSelected().getSmsLogsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Invoices page
     */
    public String navigateInvoicesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Invoices_items", this.getSelected().getInvoicesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/invoices/index";
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Invoices page
     */
    public String navigateInvoicesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Invoices_items", this.getSelected().getInvoicesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/invoices/index";
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Invoices page
     */
    public String navigateInvoicesCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Invoices_items", this.getSelected().getInvoicesCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/invoices/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotificationPreferences
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotificationPreferences page
     */
    public String navigateNotificationPreferencesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotificationPreferences_items", this.getSelected().getNotificationPreferencesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/notificationPreferences/index";
    }

    /**
     * Sets the "items" attribute with a collection of BrokerCommissionContracts
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for BrokerCommissionContracts page
     */
    public String navigateBrokerCommissionContractsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("BrokerCommissionContracts_items", this.getSelected().getBrokerCommissionContractsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/brokerCommissionContracts/index";
    }

    /**
     * Sets the "items" attribute with a collection of CardLogs entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CardLogs page
     */
    public String navigateCardLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CardLogs_items", this.getSelected().getCardLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cardLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Images entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Images page
     */
    public String navigateImagesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Images_items", this.getSelected().getImagesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/images/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeLogs entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GuaranteeLogs page
     */
    public String navigateGuaranteeLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeLogs_items", this.getSelected().getGuaranteeLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of ServiceClients entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Alerts entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Alerts page
     */
    public String navigateAlertsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Alerts_items", this.getSelected().getAlertsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/alerts/index";
    }

    /**
     * Sets the "selected" attribute of the MemberSmsStatus controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberSmsStatus(ActionEvent event) {
        if (this.getSelected() != null && memberSmsStatusController.getSelected() == null) {
            memberSmsStatusController.setSelected(this.getSelected().getMemberSmsStatus());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Messages entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Messages page
     */
    public String navigateMessagesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Messages_items", this.getSelected().getMessagesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/messages/index";
    }

    /**
     * Sets the "items" attribute with a collection of Messages entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Messages page
     */
    public String navigateMessagesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Messages_items", this.getSelected().getMessagesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/messages/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberPos entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MemberPos page
     */
    public String navigateMemberPosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberPos_items", this.getSelected().getMemberPosCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberPos/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransactionFees entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
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
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of AccountLimitLogs entities
     * that are retrieved from Members?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of PendingMembers entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PendingMembers page
     */
    public String navigatePendingMembersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PendingMembers_items", this.getSelected().getPendingMembersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pendingMembers/index";
    }

    /**
     * Sets the "items" attribute with a collection of PendingMembers entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PendingMembers page
     */
    public String navigatePendingMembersCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PendingMembers_items", this.getSelected().getPendingMembersCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pendingMembers/index";
    }

    /**
     * Sets the "items" attribute with a collection of ScheduledPayments
     * entities that are retrieved from Members?cap_first and returns the
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
     * Sets the "items" attribute with a collection of MemberRecords entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for MemberRecords page
     */
    public String navigateMemberRecordsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecords_items", this.getSelected().getMemberRecordsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecords/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecords entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for MemberRecords page
     */
    public String navigateMemberRecordsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecords_items", this.getSelected().getMemberRecordsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecords/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecords entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for MemberRecords page
     */
    public String navigateMemberRecordsCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecords_items", this.getSelected().getMemberRecordsCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecords/index";
    }

    /**
     * Sets the "items" attribute with a collection of RegistrationAgreementLogs
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for RegistrationAgreementLogs page
     */
    public String navigateRegistrationAgreementLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistrationAgreementLogs_items", this.getSelected().getRegistrationAgreementLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/registrationAgreementLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
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
     * are retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of ImportedAds entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for ImportedAds page
     */
    public String navigateImportedAdsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ImportedAds_items", this.getSelected().getImportedAdsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/importedAds/index";
    }

    /**
     * Sets the "items" attribute with a collection of PaymentObligations
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PaymentObligations page
     */
    public String navigatePaymentObligationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaymentObligations_items", this.getSelected().getPaymentObligationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/paymentObligations/index";
    }

    /**
     * Sets the "items" attribute with a collection of PaymentObligations
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PaymentObligations page
     */
    public String navigatePaymentObligationsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaymentObligations_items", this.getSelected().getPaymentObligationsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/paymentObligations/index";
    }

    /**
     * Sets the "items" attribute with a collection of CertificationLogs
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CertificationLogs page
     */
    public String navigateCertificationLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CertificationLogs_items", this.getSelected().getCertificationLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/certificationLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Brokerings entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Brokerings page
     */
    public String navigateBrokeringsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Brokerings_items", this.getSelected().getBrokeringsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/brokerings/index";
    }

    /**
     * Sets the "items" attribute with a collection of Brokerings entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Brokerings page
     */
    public String navigateBrokeringsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Brokerings_items", this.getSelected().getBrokeringsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/brokerings/index";
    }

    /**
     * Sets the "items" attribute with a collection of Refs entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Refs entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Refs page
     */
    public String navigateRefsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Refs_items", this.getSelected().getRefsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/refs/index";
    }

    /**
     * Sets the "items" attribute with a collection of
     * AdminNotificationPreferences entities that are retrieved from
     * Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of PaymentObligationLogs
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PaymentObligationLogs page
     */
    public String navigatePaymentObligationLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaymentObligationLogs_items", this.getSelected().getPaymentObligationLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/paymentObligationLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Accounts entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Contacts entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Contacts page
     */
    public String navigateContactsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Contacts_items", this.getSelected().getContactsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/contacts/index";
    }

    /**
     * Sets the "items" attribute with a collection of Contacts entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Contacts page
     */
    public String navigateContactsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Contacts_items", this.getSelected().getContactsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/contacts/index";
    }

    /**
     * Sets the "items" attribute with a collection of Documents entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Documents page
     */
    public String navigateDocumentsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Documents_items", this.getSelected().getDocumentsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/documents/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransferAuthorizations
     * entities that are retrieved from Members?cap_first and returns the
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
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGroupId(ActionEvent event) {
        if (this.getSelected() != null && groupIdController.getSelected() == null) {
            groupIdController.setSelected(this.getSelected().getGroupId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberBrokerId(ActionEvent event) {
        if (this.getSelected() != null && memberBrokerIdController.getSelected() == null) {
            memberBrokerIdController.setSelected(this.getSelected().getMemberBrokerId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Members page
     */
    public String navigateMembersCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Members_items", this.getSelected().getMembersCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/members/index";
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
     * Sets the "items" attribute with a collection of Guarantees entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Guarantees page
     */
    public String navigateGuaranteesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guarantees_items", this.getSelected().getGuaranteesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guarantees/index";
    }

    /**
     * Sets the "items" attribute with a collection of Guarantees entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Guarantees page
     */
    public String navigateGuaranteesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guarantees_items", this.getSelected().getGuaranteesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guarantees/index";
    }

    /**
     * Sets the "items" attribute with a collection of Guarantees entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Guarantees page
     */
    public String navigateGuaranteesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guarantees_items", this.getSelected().getGuaranteesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guarantees/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFields entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of ReferenceHistory entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ReferenceHistory page
     */
    public String navigateReferenceHistoryCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ReferenceHistory_items", this.getSelected().getReferenceHistoryCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/referenceHistory/index";
    }

    /**
     * Sets the "items" attribute with a collection of ReferenceHistory entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ReferenceHistory page
     */
    public String navigateReferenceHistoryCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ReferenceHistory_items", this.getSelected().getReferenceHistoryCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/referenceHistory/index";
    }

    /**
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsers(ActionEvent event) {
        if (this.getSelected() != null && usersController.getSelected() == null) {
            usersController.setSelected(this.getSelected().getUsers());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ads entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Ads page
     */
    public String navigateAdsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ads_items", this.getSelected().getAdsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ads/index";
    }

    /**
     * Sets the "items" attribute with a collection of GroupHistoryLogs entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GroupHistoryLogs page
     */
    public String navigateGroupHistoryLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GroupHistoryLogs_items", this.getSelected().getGroupHistoryLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groupHistoryLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdInterests entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdInterests page
     */
    public String navigateAdInterestsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdInterests_items", this.getSelected().getAdInterestsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adInterests/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdInterests entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdInterests page
     */
    public String navigateAdInterestsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdInterests_items", this.getSelected().getAdInterestsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adInterests/index";
    }

    /**
     * Sets the "items" attribute with a collection of PosLogs entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for PosLogs page
     */
    public String navigatePosLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PosLogs_items", this.getSelected().getPosLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/posLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of PosLogs entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for PosLogs page
     */
    public String navigatePosLogsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PosLogs_items", this.getSelected().getPosLogsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/posLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdImports entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdImports page
     */
    public String navigateAdImportsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdImports_items", this.getSelected().getAdImportsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adImports/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExternalTransferImports
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ExternalTransferImports page
     */
    public String navigateExternalTransferImportsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalTransferImports_items", this.getSelected().getExternalTransferImportsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalTransferImports/index";
    }

    /**
     * Sets the "items" attribute with a collection of Cards entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cards page
     */
    public String navigateCardsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cards_items", this.getSelected().getCardsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cards/index";
    }

    /**
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Tickets page
     */
    public String navigateTicketsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tickets_items", this.getSelected().getTicketsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tickets/index";
    }

    /**
     * Sets the "items" attribute with a collection of PrintSettings entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PrintSettings page
     */
    public String navigatePrintSettingsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PrintSettings_items", this.getSelected().getPrintSettingsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/printSettings/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExternalTransfers
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ExternalTransfers page
     */
    public String navigateExternalTransfersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalTransfers_items", this.getSelected().getExternalTransfersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalTransfers/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberAccountFeeLogs
     * entities that are retrieved from Members?cap_first and returns the
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
     * Sets the "items" attribute with a collection of SmsMailings entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsMailings page
     */
    public String navigateSmsMailingsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsMailings_items", this.getSelected().getSmsMailingsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsMailings/index";
    }

    /**
     * Sets the "items" attribute with a collection of SmsMailings entities that
     * are retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsMailings page
     */
    public String navigateSmsMailingsCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsMailings_items", this.getSelected().getSmsMailingsCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsMailings/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberImports entities
     * that are retrieved from Members?cap_first and returns the navigation
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
     * that are retrieved from Members?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Certifications entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Certifications page
     */
    public String navigateCertificationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Certifications_items", this.getSelected().getCertificationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/certifications/index";
    }

    /**
     * Sets the "items" attribute with a collection of Certifications entities
     * that are retrieved from Members?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Certifications page
     */
    public String navigateCertificationsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Certifications_items", this.getSelected().getCertificationsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/certifications/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from Members?cap_first and returns the
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

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from Members?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

    /**
     * Sets the "items" attribute with a collection of Remarks entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Remarks page
     */
    public String navigateRemarksCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Remarks_items", this.getSelected().getRemarksCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/remarks/index";
    }

    /**
     * Sets the "items" attribute with a collection of Remarks entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Remarks page
     */
    public String navigateRemarksCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Remarks_items", this.getSelected().getRemarksCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/remarks/index";
    }

    /**
     * Sets the "items" attribute with a collection of Remarks entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Remarks page
     */
    public String navigateRemarksCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Remarks_items", this.getSelected().getRemarksCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/remarks/index";
    }

    /**
     * Sets the "items" attribute with a collection of Remarks entities that are
     * retrieved from Members?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Remarks page
     */
    public String navigateRemarksCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Remarks_items", this.getSelected().getRemarksCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/remarks/index";
    }

}
