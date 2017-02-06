package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AdminNotificationPreferences;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "adminNotificationPreferencesController")
@ViewScoped
public class AdminNotificationPreferencesController extends AbstractController<AdminNotificationPreferences> {

    @Inject
    private MembersController adminIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AdminNotificationPreferencesController() {
        // Inform the Abstract parent controller of the concrete AdminNotificationPreferences Entity
        super(AdminNotificationPreferences.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        adminIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from AdminNotificationPreferences?cap_first and
     * returns the navigation outcome.
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
     * that are retrieved from AdminNotificationPreferences?cap_first and
     * returns the navigation outcome.
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
     * retrieved from AdminNotificationPreferences?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of MessageCategories
     * entities that are retrieved from AdminNotificationPreferences?cap_first
     * and returns the navigation outcome.
     *
     * @return navigation outcome for MessageCategories page
     */
    public String navigateMessageCategoriesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MessageCategories_items", this.getSelected().getMessageCategoriesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/messageCategories/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from AdminNotificationPreferences?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for GuaranteeTypes page
     */
    public String navigateGuaranteeTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeTypes_items", this.getSelected().getGuaranteeTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of
     * AdminPreferencesMemberAlerts entities that are retrieved from
     * AdminNotificationPreferences?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AdminPreferencesMemberAlerts page
     */
    public String navigateAdminPreferencesMemberAlertsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdminPreferencesMemberAlerts_items", this.getSelected().getAdminPreferencesMemberAlertsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adminPreferencesMemberAlerts/index";
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAdminId(ActionEvent event) {
        if (this.getSelected() != null && adminIdController.getSelected() == null) {
            adminIdController.setSelected(this.getSelected().getAdminId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of
     * AdminPreferencesSystemAlerts entities that are retrieved from
     * AdminNotificationPreferences?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AdminPreferencesSystemAlerts page
     */
    public String navigateAdminPreferencesSystemAlertsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdminPreferencesSystemAlerts_items", this.getSelected().getAdminPreferencesSystemAlertsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adminPreferencesSystemAlerts/index";
    }

}
