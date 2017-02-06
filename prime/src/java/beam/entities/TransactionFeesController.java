package beam.entities;

import beam.entities.util.MobilePageController;
import entities.TransactionFees;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transactionFeesController")
@ViewScoped
public class TransactionFeesController extends AbstractController<TransactionFees> {

    @Inject
    private TransferTypesController generatedTypeIdController;
    @Inject
    private MembersController fromMemberIdController;
    @Inject
    private MembersController toMemberIdController;
    @Inject
    private TransferTypesController originalTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public TransactionFeesController() {
        // Inform the Abstract parent controller of the concrete TransactionFees Entity
        super(TransactionFees.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        generatedTypeIdController.setSelected(null);
        fromMemberIdController.setSelected(null);
        toMemberIdController.setSelected(null);
        originalTypeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransactionFees?cap_first and returns the navigation
     * outcome.
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
     * retrieved from TransactionFees?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from TransactionFees?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of DefaultBrokerCommissions
     * entities that are retrieved from TransactionFees?cap_first and returns
     * the navigation outcome.
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
     * Sets the "items" attribute with a collection of BrokerCommissionContracts
     * entities that are retrieved from TransactionFees?cap_first and returns
     * the navigation outcome.
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
     * entities that are retrieved from TransactionFees?cap_first and returns
     * the navigation outcome.
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
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGeneratedTypeId(ActionEvent event) {
        if (this.getSelected() != null && generatedTypeIdController.getSelected() == null) {
            generatedTypeIdController.setSelected(this.getSelected().getGeneratedTypeId());
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
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOriginalTypeId(ActionEvent event) {
        if (this.getSelected() != null && originalTypeIdController.getSelected() == null) {
            originalTypeIdController.setSelected(this.getSelected().getOriginalTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from TransactionFees?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from TransactionFees?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transfers page
     */
    public String navigateTransfersCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transfers_items", this.getSelected().getTransfersCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transfers/index";
    }

}
