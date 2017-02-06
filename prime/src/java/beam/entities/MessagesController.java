package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Messages;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "messagesController")
@ViewScoped
public class MessagesController extends AbstractController<Messages> {

    @Inject
    private MessageCategoriesController categoryIdController;
    @Inject
    private MembersController fromMemberIdController;
    @Inject
    private MembersController toMemberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public MessagesController() {
        // Inform the Abstract parent controller of the concrete Messages Entity
        super(Messages.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        categoryIdController.setSelected(null);
        fromMemberIdController.setSelected(null);
        toMemberIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Messages?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "selected" attribute of the MessageCategories controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCategoryId(ActionEvent event) {
        if (this.getSelected() != null && categoryIdController.getSelected() == null) {
            categoryIdController.setSelected(this.getSelected().getCategoryId());
        }
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
