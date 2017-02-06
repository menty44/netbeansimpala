package beam.entities;

import beam.entities.util.MobilePageController;
import entities.OperatorGroupsMaxAmount;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "operatorGroupsMaxAmountController")
@ViewScoped
public class OperatorGroupsMaxAmountController extends AbstractController<OperatorGroupsMaxAmount> {

    @Inject
    private GroupsController groupsController;
    @Inject
    private TransferTypesController transferTypesController;
    @Inject
    private MobilePageController mobilePageController;

    public OperatorGroupsMaxAmountController() {
        // Inform the Abstract parent controller of the concrete OperatorGroupsMaxAmount Entity
        super(OperatorGroupsMaxAmount.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getOperatorGroupsMaxAmountPK().setGroupId(this.getSelected().getGroups().getId());
        this.getSelected().getOperatorGroupsMaxAmountPK().setTransferTypeId(this.getSelected().getTransferTypes().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setOperatorGroupsMaxAmountPK(new entities.OperatorGroupsMaxAmountPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        groupsController.setSelected(null);
        transferTypesController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferTypes(ActionEvent event) {
        if (this.getSelected() != null && transferTypesController.getSelected() == null) {
            transferTypesController.setSelected(this.getSelected().getTransferTypes());
        }
    }
}
