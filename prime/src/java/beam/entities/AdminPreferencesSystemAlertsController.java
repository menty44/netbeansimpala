package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AdminPreferencesSystemAlerts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "adminPreferencesSystemAlertsController")
@ViewScoped
public class AdminPreferencesSystemAlertsController extends AbstractController<AdminPreferencesSystemAlerts> {

    @Inject
    private AdminNotificationPreferencesController adminNotificationPreferencesController;
    @Inject
    private MobilePageController mobilePageController;

    public AdminPreferencesSystemAlertsController() {
        // Inform the Abstract parent controller of the concrete AdminPreferencesSystemAlerts Entity
        super(AdminPreferencesSystemAlerts.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getAdminPreferencesSystemAlertsPK().setPreferenceId(this.getSelected().getAdminNotificationPreferences().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setAdminPreferencesSystemAlertsPK(new entities.AdminPreferencesSystemAlertsPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        adminNotificationPreferencesController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the AdminNotificationPreferences
     * controller in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAdminNotificationPreferences(ActionEvent event) {
        if (this.getSelected() != null && adminNotificationPreferencesController.getSelected() == null) {
            adminNotificationPreferencesController.setSelected(this.getSelected().getAdminNotificationPreferences());
        }
    }
}
