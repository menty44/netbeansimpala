package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberAccountFeeLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "memberAccountFeeLogsController")
@ViewScoped
public class MemberAccountFeeLogsController extends AbstractController<MemberAccountFeeLogs> {

    @Inject
    private TransfersController transferIdController;
    @Inject
    private AccountFeeLogsController accountFeeLogIdController;
    @Inject
    private InvoicesController invoiceIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public MemberAccountFeeLogsController() {
        // Inform the Abstract parent controller of the concrete MemberAccountFeeLogs Entity
        super(MemberAccountFeeLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferIdController.setSelected(null);
        accountFeeLogIdController.setSelected(null);
        invoiceIdController.setSelected(null);
        memberIdController.setSelected(null);
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
}
