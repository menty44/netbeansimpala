package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ExternalTransferImports;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "externalTransferImportsController")
@ViewScoped
public class ExternalTransferImportsController extends AbstractController<ExternalTransferImports> {

    @Inject
    private MembersController byIdController;
    @Inject
    private ExternalAccountsController accountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ExternalTransferImportsController() {
        // Inform the Abstract parent controller of the concrete ExternalTransferImports Entity
        super(ExternalTransferImports.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        accountIdController.setSelected(null);
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
     * Sets the "selected" attribute of the ExternalAccounts controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountId(ActionEvent event) {
        if (this.getSelected() != null && accountIdController.getSelected() == null) {
            accountIdController.setSelected(this.getSelected().getAccountId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of ExternalTransfers
     * entities that are retrieved from ExternalTransferImports?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for ExternalTransfers page
     */
    public String navigateExternalTransfersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalTransfers_items", this.getSelected().getExternalTransfersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalTransfers/index";
    }

}
