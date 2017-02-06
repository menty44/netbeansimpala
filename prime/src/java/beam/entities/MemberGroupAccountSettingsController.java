package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberGroupAccountSettings;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "memberGroupAccountSettingsController")
@ViewScoped
public class MemberGroupAccountSettingsController extends AbstractController<MemberGroupAccountSettings> {

    @Inject
    private TransferTypesController initialCreditTransferTypeIdController;
    @Inject
    private GroupsController groupIdController;
    @Inject
    private AccountTypesController typeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public MemberGroupAccountSettingsController() {
        // Inform the Abstract parent controller of the concrete MemberGroupAccountSettings Entity
        super(MemberGroupAccountSettings.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        initialCreditTransferTypeIdController.setSelected(null);
        groupIdController.setSelected(null);
        typeIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInitialCreditTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && initialCreditTransferTypeIdController.getSelected() == null) {
            initialCreditTransferTypeIdController.setSelected(this.getSelected().getInitialCreditTransferTypeId());
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
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTypeId(ActionEvent event) {
        if (this.getSelected() != null && typeIdController.getSelected() == null) {
            typeIdController.setSelected(this.getSelected().getTypeId());
        }
    }
}
