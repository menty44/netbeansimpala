package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AuthorizationLevels;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "authorizationLevelsController")
@ViewScoped
public class AuthorizationLevelsController extends AbstractController<AuthorizationLevels> {

    @Inject
    private TransferTypesController typeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AuthorizationLevelsController() {
        // Inform the Abstract parent controller of the concrete AuthorizationLevels Entity
        super(AuthorizationLevels.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        typeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from AuthorizationLevels?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Transfers entities that
     * are retrieved from AuthorizationLevels?cap_first and returns the
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
     * Sets the "items" attribute with a collection of TransferAuthorizations
     * entities that are retrieved from AuthorizationLevels?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for TransferAuthorizations page
     */
    public String navigateTransferAuthorizationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferAuthorizations_items", this.getSelected().getTransferAuthorizationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferAuthorizations/index";
    }

}
