package beam.entities;

import beam.entities.util.MobilePageController;
import entities.DefaultBrokerCommissions;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "defaultBrokerCommissionsController")
@ViewScoped
public class DefaultBrokerCommissionsController extends AbstractController<DefaultBrokerCommissions> {

    @Inject
    private MembersController brokerIdController;
    @Inject
    private TransactionFeesController brokerCommissionIdController;
    @Inject
    private MobilePageController mobilePageController;

    public DefaultBrokerCommissionsController() {
        // Inform the Abstract parent controller of the concrete DefaultBrokerCommissions Entity
        super(DefaultBrokerCommissions.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        brokerIdController.setSelected(null);
        brokerCommissionIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBrokerId(ActionEvent event) {
        if (this.getSelected() != null && brokerIdController.getSelected() == null) {
            brokerIdController.setSelected(this.getSelected().getBrokerId());
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
