package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Remarks;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "remarksController")
@ViewScoped
public class RemarksController extends AbstractController<Remarks> {

    @Inject
    private MembersController subjectIdController;
    @Inject
    private MembersController newBrokerIdController;
    @Inject
    private GroupsController oldGroupIdController;
    @Inject
    private GroupsController newGroupIdController;
    @Inject
    private MembersController oldBrokerIdController;
    @Inject
    private MembersController writerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public RemarksController() {
        // Inform the Abstract parent controller of the concrete Remarks Entity
        super(Remarks.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        subjectIdController.setSelected(null);
        newBrokerIdController.setSelected(null);
        oldGroupIdController.setSelected(null);
        newGroupIdController.setSelected(null);
        oldBrokerIdController.setSelected(null);
        writerIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSubjectId(ActionEvent event) {
        if (this.getSelected() != null && subjectIdController.getSelected() == null) {
            subjectIdController.setSelected(this.getSelected().getSubjectId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNewBrokerId(ActionEvent event) {
        if (this.getSelected() != null && newBrokerIdController.getSelected() == null) {
            newBrokerIdController.setSelected(this.getSelected().getNewBrokerId());
        }
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOldGroupId(ActionEvent event) {
        if (this.getSelected() != null && oldGroupIdController.getSelected() == null) {
            oldGroupIdController.setSelected(this.getSelected().getOldGroupId());
        }
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNewGroupId(ActionEvent event) {
        if (this.getSelected() != null && newGroupIdController.getSelected() == null) {
            newGroupIdController.setSelected(this.getSelected().getNewGroupId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOldBrokerId(ActionEvent event) {
        if (this.getSelected() != null && oldBrokerIdController.getSelected() == null) {
            oldBrokerIdController.setSelected(this.getSelected().getOldBrokerId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareWriterId(ActionEvent event) {
        if (this.getSelected() != null && writerIdController.getSelected() == null) {
            writerIdController.setSelected(this.getSelected().getWriterId());
        }
    }
}
