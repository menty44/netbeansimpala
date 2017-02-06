package beam.entities;

import beam.entities.util.MobilePageController;
import entities.BrokeringCommissionStatus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "brokeringCommissionStatusController")
@ViewScoped
public class BrokeringCommissionStatusController extends AbstractController<BrokeringCommissionStatus> {

    @Inject
    private BrokeringsController brokeringIdController;
    @Inject
    private TransactionFeesController brokerCommissionIdController;
    @Inject
    private MobilePageController mobilePageController;

    public BrokeringCommissionStatusController() {
        // Inform the Abstract parent controller of the concrete BrokeringCommissionStatus Entity
        super(BrokeringCommissionStatus.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        brokeringIdController.setSelected(null);
        brokerCommissionIdController.setSelected(null);
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
}
