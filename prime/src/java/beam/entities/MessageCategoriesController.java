package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MessageCategories;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "messageCategoriesController")
@ViewScoped
public class MessageCategoriesController extends AbstractController<MessageCategories> {

    @Inject
    private MobilePageController mobilePageController;

    public MessageCategoriesController() {
        // Inform the Abstract parent controller of the concrete MessageCategories Entity
        super(MessageCategories.class);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from MessageCategories?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of
     * AdminNotificationPreferences entities that are retrieved from
     * MessageCategories?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdminNotificationPreferences page
     */
    public String navigateAdminNotificationPreferencesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdminNotificationPreferences_items", this.getSelected().getAdminNotificationPreferencesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adminNotificationPreferences/index";
    }

    /**
     * Sets the "items" attribute with a collection of Messages entities that
     * are retrieved from MessageCategories?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Messages page
     */
    public String navigateMessagesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Messages_items", this.getSelected().getMessagesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/messages/index";
    }

}
