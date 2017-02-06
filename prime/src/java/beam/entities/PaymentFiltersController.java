package beam.entities;

import beam.entities.util.MobilePageController;
import entities.PaymentFilters;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "paymentFiltersController")
@ViewScoped
public class PaymentFiltersController extends AbstractController<PaymentFilters> {

    @Inject
    private AccountTypesController accountTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PaymentFiltersController() {
        // Inform the Abstract parent controller of the concrete PaymentFilters Entity
        super(PaymentFilters.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        accountTypeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from PaymentFilters?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from PaymentFilters?cap_first and returns the
     * navigation outcome.
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
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountTypeId(ActionEvent event) {
        if (this.getSelected() != null && accountTypeIdController.getSelected() == null) {
            accountTypeIdController.setSelected(this.getSelected().getAccountTypeId());
        }
    }
}
