package beam.entities;

import beam.entities.util.MobilePageController;
import entities.GroupHistoryLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "groupHistoryLogsController")
@ViewScoped
public class GroupHistoryLogsController extends AbstractController<GroupHistoryLogs> {

    @Inject
    private GroupsController groupIdController;
    @Inject
    private MembersController elementIdController;
    @Inject
    private MobilePageController mobilePageController;

    public GroupHistoryLogsController() {
        // Inform the Abstract parent controller of the concrete GroupHistoryLogs Entity
        super(GroupHistoryLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        groupIdController.setSelected(null);
        elementIdController.setSelected(null);
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
    public void prepareElementId(ActionEvent event) {
        if (this.getSelected() != null && elementIdController.getSelected() == null) {
            elementIdController.setSelected(this.getSelected().getElementId());
        }
    }
}
