package beam.entities;

import beam.entities.util.MobilePageController;
import entities.RegistrationAgreements;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "registrationAgreementsController")
@ViewScoped
public class RegistrationAgreementsController extends AbstractController<RegistrationAgreements> {

    @Inject
    private MobilePageController mobilePageController;

    public RegistrationAgreementsController() {
        // Inform the Abstract parent controller of the concrete RegistrationAgreements Entity
        super(RegistrationAgreements.class);
    }

    /**
     * Sets the "items" attribute with a collection of PendingMembers entities
     * that are retrieved from RegistrationAgreements?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PendingMembers page
     */
    public String navigatePendingMembersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PendingMembers_items", this.getSelected().getPendingMembersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pendingMembers/index";
    }

    /**
     * Sets the "items" attribute with a collection of RegistrationAgreementLogs
     * entities that are retrieved from RegistrationAgreements?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for RegistrationAgreementLogs page
     */
    public String navigateRegistrationAgreementLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistrationAgreementLogs_items", this.getSelected().getRegistrationAgreementLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/registrationAgreementLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from RegistrationAgreements?cap_first and returns the
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

}
