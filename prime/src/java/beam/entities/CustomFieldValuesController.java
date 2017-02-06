package beam.entities;

import beam.entities.util.MobilePageController;
import entities.CustomFieldValues;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "customFieldValuesController")
@ViewScoped
public class CustomFieldValuesController extends AbstractController<CustomFieldValues> {

    @Inject
    private LoanGroupsController loanGroupIdController;
    @Inject
    private GuaranteesController guaranteeIdController;
    @Inject
    private TransfersController transferIdController;
    @Inject
    private PendingMembersController pendingMemberIdController;
    @Inject
    private MemberRecordsController memberRecordIdController;
    @Inject
    private ImportedMemberRecordsController importedMemberRecordIdController;
    @Inject
    private MembersController adminIdController;
    @Inject
    private MembersController operatorIdController;
    @Inject
    private ImportedMembersController importedMemberIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private InvoicesController invoiceIdController;
    @Inject
    private ImportedAdsController importedAdIdController;
    @Inject
    private CustomFieldsController fieldIdController;
    @Inject
    private MembersController memberValueIdController;
    @Inject
    private ScheduledPaymentsController scheduledPaymentIdController;
    @Inject
    private AdsController adIdController;
    @Inject
    private CustomFieldPossibleValuesController possibleValueIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CustomFieldValuesController() {
        // Inform the Abstract parent controller of the concrete CustomFieldValues Entity
        super(CustomFieldValues.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        loanGroupIdController.setSelected(null);
        guaranteeIdController.setSelected(null);
        transferIdController.setSelected(null);
        pendingMemberIdController.setSelected(null);
        memberRecordIdController.setSelected(null);
        importedMemberRecordIdController.setSelected(null);
        adminIdController.setSelected(null);
        operatorIdController.setSelected(null);
        importedMemberIdController.setSelected(null);
        memberIdController.setSelected(null);
        invoiceIdController.setSelected(null);
        importedAdIdController.setSelected(null);
        fieldIdController.setSelected(null);
        memberValueIdController.setSelected(null);
        scheduledPaymentIdController.setSelected(null);
        adIdController.setSelected(null);
        possibleValueIdController.setSelected(null);
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
     * Sets the "selected" attribute of the Guarantees controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGuaranteeId(ActionEvent event) {
        if (this.getSelected() != null && guaranteeIdController.getSelected() == null) {
            guaranteeIdController.setSelected(this.getSelected().getGuaranteeId());
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
     * Sets the "selected" attribute of the PendingMembers controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePendingMemberId(ActionEvent event) {
        if (this.getSelected() != null && pendingMemberIdController.getSelected() == null) {
            pendingMemberIdController.setSelected(this.getSelected().getPendingMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the MemberRecords controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberRecordId(ActionEvent event) {
        if (this.getSelected() != null && memberRecordIdController.getSelected() == null) {
            memberRecordIdController.setSelected(this.getSelected().getMemberRecordId());
        }
    }

    /**
     * Sets the "selected" attribute of the ImportedMemberRecords controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportedMemberRecordId(ActionEvent event) {
        if (this.getSelected() != null && importedMemberRecordIdController.getSelected() == null) {
            importedMemberRecordIdController.setSelected(this.getSelected().getImportedMemberRecordId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAdminId(ActionEvent event) {
        if (this.getSelected() != null && adminIdController.getSelected() == null) {
            adminIdController.setSelected(this.getSelected().getAdminId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOperatorId(ActionEvent event) {
        if (this.getSelected() != null && operatorIdController.getSelected() == null) {
            operatorIdController.setSelected(this.getSelected().getOperatorId());
        }
    }

    /**
     * Sets the "selected" attribute of the ImportedMembers controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportedMemberId(ActionEvent event) {
        if (this.getSelected() != null && importedMemberIdController.getSelected() == null) {
            importedMemberIdController.setSelected(this.getSelected().getImportedMemberId());
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
     * Sets the "selected" attribute of the Invoices controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInvoiceId(ActionEvent event) {
        if (this.getSelected() != null && invoiceIdController.getSelected() == null) {
            invoiceIdController.setSelected(this.getSelected().getInvoiceId());
        }
    }

    /**
     * Sets the "selected" attribute of the ImportedAds controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportedAdId(ActionEvent event) {
        if (this.getSelected() != null && importedAdIdController.getSelected() == null) {
            importedAdIdController.setSelected(this.getSelected().getImportedAdId());
        }
    }

    /**
     * Sets the "selected" attribute of the CustomFields controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFieldId(ActionEvent event) {
        if (this.getSelected() != null && fieldIdController.getSelected() == null) {
            fieldIdController.setSelected(this.getSelected().getFieldId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberValueId(ActionEvent event) {
        if (this.getSelected() != null && memberValueIdController.getSelected() == null) {
            memberValueIdController.setSelected(this.getSelected().getMemberValueId());
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
     * Sets the "selected" attribute of the Ads controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAdId(ActionEvent event) {
        if (this.getSelected() != null && adIdController.getSelected() == null) {
            adIdController.setSelected(this.getSelected().getAdId());
        }
    }

    /**
     * Sets the "selected" attribute of the CustomFieldPossibleValues controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePossibleValueId(ActionEvent event) {
        if (this.getSelected() != null && possibleValueIdController.getSelected() == null) {
            possibleValueIdController.setSelected(this.getSelected().getPossibleValueId());
        }
    }
}
