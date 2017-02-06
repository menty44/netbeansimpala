package beam.entities;

import beam.entities.util.MobilePageController;
import entities.BrokerCommissionContracts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "brokerCommissionContractsController")
@ViewScoped
public class BrokerCommissionContractsController extends AbstractController<BrokerCommissionContracts> {

    @Inject
    private MembersController cancelledByIdController;
    @Inject
    private BrokeringsController brokeringIdController;
    @Inject
    private TransactionFeesController brokerCommissionIdController;
    @Inject
    private MobilePageController mobilePageController;

    public BrokerCommissionContractsController() {
        // Inform the Abstract parent controller of the concrete BrokerCommissionContracts Entity
        super(BrokerCommissionContracts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cancelledByIdController.setSelected(null);
        brokeringIdController.setSelected(null);
        brokerCommissionIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCancelledById(ActionEvent event) {
        if (this.getSelected() != null && cancelledByIdController.getSelected() == null) {
            cancelledByIdController.setSelected(this.getSelected().getCancelledById());
        }
    }

    /**
     * Sets the "selected" attribute of the Brokerings controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBrokeringId(ActionEvent event) {
        if (this.getSelected() != null && brokeringIdController.getSelected() == null) {
            brokeringIdController.setSelected(this.getSelected().getBrokeringId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransactionFees controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBrokerCommissionId(ActionEvent event) {
        if (this.getSelected() != null && brokerCommissionIdController.getSelected() == null) {
            brokerCommissionIdController.setSelected(this.getSelected().getBrokerCommissionId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from BrokerCommissionContracts?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Transfers page
     */
    public String navigateTransfersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transfers_items", this.getSelected().getTransfersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transfers/index";
    }

}
