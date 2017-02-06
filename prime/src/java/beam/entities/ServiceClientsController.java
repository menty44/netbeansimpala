package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ServiceClients;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "serviceClientsController")
@ViewScoped
public class ServiceClientsController extends AbstractController<ServiceClients> {

    @Inject
    private ChannelsController channelIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ServiceClientsController() {
        // Inform the Abstract parent controller of the concrete ServiceClients Entity
        super(ServiceClients.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        channelIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from ServiceClients?cap_first and returns the
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
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from ServiceClients?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from ServiceClients?cap_first and returns the navigation
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
     * that are retrieved from ServiceClients?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "selected" attribute of the Channels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareChannelId(ActionEvent event) {
        if (this.getSelected() != null && channelIdController.getSelected() == null) {
            channelIdController.setSelected(this.getSelected().getChannelId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberId(ActionEvent event) {
        if (this.getSelected() != null && memberIdController.getSelected() == null) {
            memberIdController.setSelected(this.getSelected().getMemberId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of ServiceClientPermissions
     * entities that are retrieved from ServiceClients?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ServiceClientPermissions page
     */
    public String navigateServiceClientPermissionsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ServiceClientPermissions_items", this.getSelected().getServiceClientPermissionsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/serviceClientPermissions/index";
    }

}
