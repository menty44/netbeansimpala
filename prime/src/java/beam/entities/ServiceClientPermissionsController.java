package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ServiceClientPermissions;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "serviceClientPermissionsController")
@ViewScoped
public class ServiceClientPermissionsController extends AbstractController<ServiceClientPermissions> {

    @Inject
    private ServiceClientsController serviceClientsController;
    @Inject
    private MobilePageController mobilePageController;

    public ServiceClientPermissionsController() {
        // Inform the Abstract parent controller of the concrete ServiceClientPermissions Entity
        super(ServiceClientPermissions.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getServiceClientPermissionsPK().setServiceClientId(this.getSelected().getServiceClients().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setServiceClientPermissionsPK(new entities.ServiceClientPermissionsPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        serviceClientsController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ServiceClients controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareServiceClients(ActionEvent event) {
        if (this.getSelected() != null && serviceClientsController.getSelected() == null) {
            serviceClientsController.setSelected(this.getSelected().getServiceClients());
        }
    }
}
