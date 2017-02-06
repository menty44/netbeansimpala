package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Brokerings;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "brokeringsController")
@ViewScoped
public class BrokeringsController extends AbstractController<Brokerings> {

    @Inject
    private MembersController brokerIdController;
    @Inject
    private MembersController brokeredIdController;
    @Inject
    private MobilePageController mobilePageController;

    public BrokeringsController() {
        // Inform the Abstract parent controller of the concrete Brokerings Entity
        super(Brokerings.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        brokerIdController.setSelected(null);
        brokeredIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of BrokerCommissionContracts
     * entities that are retrieved from Brokerings?cap_first and returns the
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
     * Sets the "items" attribute with a collection of BrokeringCommissionStatus
     * entities that are retrieved from Brokerings?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for BrokeringCommissionStatus page
     */
    public String navigateBrokeringCommissionStatusCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("BrokeringCommissionStatus_items", this.getSelected().getBrokeringCommissionStatusCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/brokeringCommissionStatus/index";
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
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBrokeredId(ActionEvent event) {
        if (this.getSelected() != null && brokeredIdController.getSelected() == null) {
            brokeredIdController.setSelected(this.getSelected().getBrokeredId());
        }
    }
}
