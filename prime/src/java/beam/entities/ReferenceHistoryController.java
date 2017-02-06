package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ReferenceHistory;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "referenceHistoryController")
@ViewScoped
public class ReferenceHistoryController extends AbstractController<ReferenceHistory> {

    @Inject
    private MembersController fromMemberIdController;
    @Inject
    private MembersController toMemberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ReferenceHistoryController() {
        // Inform the Abstract parent controller of the concrete ReferenceHistory Entity
        super(ReferenceHistory.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        fromMemberIdController.setSelected(null);
        toMemberIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFromMemberId(ActionEvent event) {
        if (this.getSelected() != null && fromMemberIdController.getSelected() == null) {
            fromMemberIdController.setSelected(this.getSelected().getFromMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToMemberId(ActionEvent event) {
        if (this.getSelected() != null && toMemberIdController.getSelected() == null) {
            toMemberIdController.setSelected(this.getSelected().getToMemberId());
        }
    }
}
