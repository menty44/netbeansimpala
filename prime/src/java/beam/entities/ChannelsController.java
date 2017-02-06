package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Channels;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "channelsController")
@ViewScoped
public class ChannelsController extends AbstractController<Channels> {

    @Inject
    private MobilePageController mobilePageController;

    public ChannelsController() {
        // Inform the Abstract parent controller of the concrete Channels Entity
        super(Channels.class);
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from Channels?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Channels?cap_first and returns the navigation outcome.
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
     * retrieved from Channels?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from Channels?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Members page
     */
    public String navigateMembersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Members_items", this.getSelected().getMembersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/members/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Channels?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of ServiceClients entities
     * that are retrieved from Channels?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ServiceClients page
     */
    public String navigateServiceClientsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ServiceClients_items", this.getSelected().getServiceClientsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/serviceClients/index";
    }

    /**
     * Sets the "items" attribute with a collection of ChannelsPrincipals
     * entities that are retrieved from Channels?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ChannelsPrincipals page
     */
    public String navigateChannelsPrincipalsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ChannelsPrincipals_items", this.getSelected().getChannelsPrincipalsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/channelsPrincipals/index";
    }

    /**
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from Channels?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Tickets page
     */
    public String navigateTicketsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tickets_items", this.getSelected().getTicketsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tickets/index";
    }

    /**
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from Channels?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Tickets page
     */
    public String navigateTicketsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tickets_items", this.getSelected().getTicketsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tickets/index";
    }

}
