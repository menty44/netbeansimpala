package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Groups;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "groupsController")
@ViewScoped
public class GroupsController extends AbstractController<Groups> {

    @Inject
    private RegistrationAgreementsController registrationAgreementIdController;
    @Inject
    private GroupsController memberExpireGroupIdController;
    @Inject
    private CardTypesController cardTypeIdController;
    @Inject
    private TransferTypesController smsChargeTransferTypeIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public GroupsController() {
        // Inform the Abstract parent controller of the concrete Groups Entity
        super(Groups.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        registrationAgreementIdController.setSelected(null);
        memberExpireGroupIdController.setSelected(null);
        cardTypeIdController.setSelected(null);
        smsChargeTransferTypeIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountFees entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Channels entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of TransactionFees entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of GroupFilters entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GroupFilters page
     */
    public String navigateGroupFiltersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GroupFilters_items", this.getSelected().getGroupFiltersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groupFilters/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
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

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Channels entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Channels page
     */
    public String navigateChannelsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Channels_items", this.getSelected().getChannelsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/channels/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountTypes page
     */
    public String navigateAccountTypesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountTypes_items", this.getSelected().getAccountTypesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection4() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection4());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection5() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection5());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of TransactionFees entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of AccountTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountTypes page
     */
    public String navigateAccountTypesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountTypes_items", this.getSelected().getAccountTypesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountTypes page
     */
    public String navigateAccountTypesCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountTypes_items", this.getSelected().getAccountTypesCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Documents entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of PaymentFilters entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of MessageCategories
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MessageCategories page
     */
    public String navigateMessageCategoriesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MessageCategories_items", this.getSelected().getMessageCategoriesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/messageCategories/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection6() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection6());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Messages entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection7() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection7());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection8() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection8());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection5() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection5());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of AuthorizationLevels
     * entities that are retrieved from Groups?cap_first and returns the
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
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection9() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection9());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of ServiceClients entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection6() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection6());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection7() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection7());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransactionFees entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TransactionFees page
     */
    public String navigateTransactionFeesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransactionFees_items", this.getSelected().getTransactionFeesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transactionFees/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection8() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection8());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection9() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection9());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Documents entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Documents page
     */
    public String navigateDocumentsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Documents_items", this.getSelected().getDocumentsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/documents/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection10() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection10());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection11() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection11());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Channels entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Channels page
     */
    public String navigateChannelsCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Channels_items", this.getSelected().getChannelsCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/channels/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection10() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection10());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection11() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection11());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from Groups?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of MemberRecordTypes
     * entities that are retrieved from Groups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MemberRecordTypes page
     */
    public String navigateMemberRecordTypesCollection12() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberRecordTypes_items", this.getSelected().getMemberRecordTypesCollection12());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberRecordTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection12() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection12());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection13() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection13());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFields entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of
     * AdminNotificationPreferences entities that are retrieved from
     * Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of SmsMailings entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Permissions entities that
     * are retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Permissions page
     */
    public String navigatePermissionsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Permissions_items", this.getSelected().getPermissionsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/permissions/index";
    }

    /**
     * Sets the "items" attribute with a collection of PendingMembers entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of
     * MemberGroupAccountSettings entities that are retrieved from
     * Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of
     * MemberGroupsEmailValidation entities that are retrieved from
     * Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MemberGroupsEmailValidation page
     */
    public String navigateMemberGroupsEmailValidationCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberGroupsEmailValidation_items", this.getSelected().getMemberGroupsEmailValidationCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberGroupsEmailValidation/index";
    }

    /**
     * Sets the "items" attribute with a collection of GroupHistoryLogs entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Files entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Files page
     */
    public String navigateFilesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Files_items", this.getSelected().getFilesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/files/index";
    }

    /**
     * Sets the "items" attribute with a collection of MemberImports entities
     * that are retrieved from Groups?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the RegistrationAgreements controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRegistrationAgreementId(ActionEvent event) {
        if (this.getSelected() != null && registrationAgreementIdController.getSelected() == null) {
            registrationAgreementIdController.setSelected(this.getSelected().getRegistrationAgreementId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection14() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection14());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberExpireGroupId(ActionEvent event) {
        if (this.getSelected() != null && memberExpireGroupIdController.getSelected() == null) {
            memberExpireGroupIdController.setSelected(this.getSelected().getMemberExpireGroupId());
        }
    }

    /**
     * Sets the "selected" attribute of the CardTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCardTypeId(ActionEvent event) {
        if (this.getSelected() != null && cardTypeIdController.getSelected() == null) {
            cardTypeIdController.setSelected(this.getSelected().getCardTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSmsChargeTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && smsChargeTransferTypeIdController.getSelected() == null) {
            smsChargeTransferTypeIdController.setSelected(this.getSelected().getSmsChargeTransferTypeId());
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
     * Sets the "items" attribute with a collection of OperatorGroupsMaxAmount
     * entities that are retrieved from Groups?cap_first and returns the
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

    /**
     * Sets the "items" attribute with a collection of Remarks entities that are
     * retrieved from Groups?cap_first and returns the navigation outcome.
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
     * retrieved from Groups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Remarks page
     */
    public String navigateRemarksCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Remarks_items", this.getSelected().getRemarksCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/remarks/index";
    }

}
