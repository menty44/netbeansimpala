package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Invoices;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "invoicesController")
@ViewScoped
public class InvoicesController extends AbstractController<Invoices> {

    @Inject
    private TransfersController transferIdController;
    @Inject
    private AccountFeeLogsController accountFeeLogIdController;
    @Inject
    private MembersController fromMemberIdController;
    @Inject
    private MembersController toMemberIdController;
    @Inject
    private MembersController performedByIdController;
    @Inject
    private MembersController sentByIdController;
    @Inject
    private TransferTypesController transferTypeIdController;
    @Inject
    private ScheduledPaymentsController scheduledPaymentIdController;
    @Inject
    private AccountTypesController destTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public InvoicesController() {
        // Inform the Abstract parent controller of the concrete Invoices Entity
        super(Invoices.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferIdController.setSelected(null);
        accountFeeLogIdController.setSelected(null);
        fromMemberIdController.setSelected(null);
        toMemberIdController.setSelected(null);
        performedByIdController.setSelected(null);
        sentByIdController.setSelected(null);
        transferTypeIdController.setSelected(null);
        scheduledPaymentIdController.setSelected(null);
        destTypeIdController.setSelected(null);
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
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFromMemberId(ActionEvent event) {
        if (this.getSelected() != null && fromMemberIdController.getSelected() == null) {
            fromMemberIdController.setSelected(this.getSelected().getFromMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToMemberId(ActionEvent event) {
        if (this.getSelected() != null && toMemberIdController.getSelected() == null) {
            toMemberIdController.setSelected(this.getSelected().getToMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePerformedById(ActionEvent event) {
        if (this.getSelected() != null && performedByIdController.getSelected() == null) {
            performedByIdController.setSelected(this.getSelected().getPerformedById());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSentById(ActionEvent event) {
        if (this.getSelected() != null && sentByIdController.getSelected() == null) {
            sentByIdController.setSelected(this.getSelected().getSentById());
        }
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
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDestTypeId(ActionEvent event) {
        if (this.getSelected() != null && destTypeIdController.getSelected() == null) {
            destTypeIdController.setSelected(this.getSelected().getDestTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of InvoicePayments entities
     * that are retrieved from Invoices?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of MemberAccountFeeLogs
     * entities that are retrieved from Invoices?cap_first and returns the
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
     * entities that are retrieved from Invoices?cap_first and returns the
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
