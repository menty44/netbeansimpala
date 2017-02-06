package beam.entities;

import beam.entities.util.MobilePageController;
import entities.PendingMembers;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pendingMembersController")
@ViewScoped
public class PendingMembersController extends AbstractController<PendingMembers> {

    @Inject
    private RegistrationAgreementsController registrationAgreementIdController;
    @Inject
    private MembersController brokerIdController;
    @Inject
    private GroupsController groupIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PendingMembersController() {
        // Inform the Abstract parent controller of the concrete PendingMembers Entity
        super(PendingMembers.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        registrationAgreementIdController.setSelected(null);
        brokerIdController.setSelected(null);
        groupIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the RegistrationAgreements controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRegistrationAgreementId(ActionEvent event) {
        if (this.getSelected() != null && registrationAgreementIdController.getSelected() == null) {
            registrationAgreementIdController.setSelected(this.getSelected().getRegistrationAgreementId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBrokerId(ActionEvent event) {
        if (this.getSelected() != null && brokerIdController.getSelected() == null) {
            brokerIdController.setSelected(this.getSelected().getBrokerId());
        }
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGroupId(ActionEvent event) {
        if (this.getSelected() != null && groupIdController.getSelected() == null) {
            groupIdController.setSelected(this.getSelected().getGroupId());
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
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from PendingMembers?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

}
