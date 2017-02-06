package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ScheduledPayments;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "scheduledPaymentsController")
@ViewScoped
public class ScheduledPaymentsController extends AbstractController<ScheduledPayments> {

    @Inject
    private MembersController byIdController;
    @Inject
    private AccountsController fromAccountIdController;
    @Inject
    private TransferTypesController typeIdController;
    @Inject
    private AccountsController toAccountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ScheduledPaymentsController() {
        // Inform the Abstract parent controller of the concrete ScheduledPayments Entity
        super(ScheduledPayments.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        fromAccountIdController.setSelected(null);
        typeIdController.setSelected(null);
        toAccountIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Invoices entities that
     * are retrieved from ScheduledPayments?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from ScheduledPayments?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Refs entities that are
     * retrieved from ScheduledPayments?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of AmountReservations
     * entities that are retrieved from ScheduledPayments?cap_first and returns
     * the navigation outcome.
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
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from ScheduledPayments?cap_first and returns
     * the navigation outcome.
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
