package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ExternalAccounts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "externalAccountsController")
@ViewScoped
public class ExternalAccountsController extends AbstractController<ExternalAccounts> {

    @Inject
    private AccountTypesController systemAccountIdController;
    @Inject
    private AccountTypesController memberAccountIdController;
    @Inject
    private FileMappingsController fileMappingIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ExternalAccountsController() {
        // Inform the Abstract parent controller of the concrete ExternalAccounts Entity
        super(ExternalAccounts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        systemAccountIdController.setSelected(null);
        memberAccountIdController.setSelected(null);
        fileMappingIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ExternalTransferTypes
     * entities that are retrieved from ExternalAccounts?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for ExternalTransferTypes page
     */
    public String navigateExternalTransferTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalTransferTypes_items", this.getSelected().getExternalTransferTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalTransferTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of FileMappings entities
     * that are retrieved from ExternalAccounts?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for FileMappings page
     */
    public String navigateFileMappingsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FileMappings_items", this.getSelected().getFileMappingsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/fileMappings/index";
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSystemAccountId(ActionEvent event) {
        if (this.getSelected() != null && systemAccountIdController.getSelected() == null) {
            systemAccountIdController.setSelected(this.getSelected().getSystemAccountId());
        }
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberAccountId(ActionEvent event) {
        if (this.getSelected() != null && memberAccountIdController.getSelected() == null) {
            memberAccountIdController.setSelected(this.getSelected().getMemberAccountId());
        }
    }

    /**
     * Sets the "selected" attribute of the FileMappings controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFileMappingId(ActionEvent event) {
        if (this.getSelected() != null && fileMappingIdController.getSelected() == null) {
            fileMappingIdController.setSelected(this.getSelected().getFileMappingId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of ExternalTransferImports
     * entities that are retrieved from ExternalAccounts?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for ExternalTransferImports page
     */
    public String navigateExternalTransferImportsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalTransferImports_items", this.getSelected().getExternalTransferImportsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalTransferImports/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExternalTransfers
     * entities that are retrieved from ExternalAccounts?cap_first and returns
     * the navigation outcome.
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
