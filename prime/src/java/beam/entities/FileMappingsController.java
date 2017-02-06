package beam.entities;

import beam.entities.util.MobilePageController;
import entities.FileMappings;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "fileMappingsController")
@ViewScoped
public class FileMappingsController extends AbstractController<FileMappings> {

    @Inject
    private ExternalAccountsController accountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public FileMappingsController() {
        // Inform the Abstract parent controller of the concrete FileMappings Entity
        super(FileMappings.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        accountIdController.setSelected(null);
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
     * Sets the "items" attribute with a collection of FieldMappings entities
     * that are retrieved from FileMappings?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for FieldMappings page
     */
    public String navigateFieldMappingsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FieldMappings_items", this.getSelected().getFieldMappingsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/fieldMappings/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExternalAccounts entities
     * that are retrieved from FileMappings?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ExternalAccounts page
     */
    public String navigateExternalAccountsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExternalAccounts_items", this.getSelected().getExternalAccountsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/externalAccounts/index";
    }

}
