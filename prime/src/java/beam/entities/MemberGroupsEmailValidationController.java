package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberGroupsEmailValidation;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "memberGroupsEmailValidationController")
@ViewScoped
public class MemberGroupsEmailValidationController extends AbstractController<MemberGroupsEmailValidation> {

    @Inject
    private GroupsController groupsController;
    @Inject
    private MobilePageController mobilePageController;

    public MemberGroupsEmailValidationController() {
        // Inform the Abstract parent controller of the concrete MemberGroupsEmailValidation Entity
        super(MemberGroupsEmailValidation.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getMemberGroupsEmailValidationPK().setGroupId(this.getSelected().getGroups().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setMemberGroupsEmailValidationPK(new entities.MemberGroupsEmailValidationPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        groupsController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGroups(ActionEvent event) {
        if (this.getSelected() != null && groupsController.getSelected() == null) {
            groupsController.setSelected(this.getSelected().getGroups());
        }
    }
}
