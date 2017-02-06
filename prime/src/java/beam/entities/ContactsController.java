package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Contacts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contactsController")
@ViewScoped
public class ContactsController extends AbstractController<Contacts> {

    @Inject
    private MembersController contactIdController;
    @Inject
    private MembersController ownerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ContactsController() {
        // Inform the Abstract parent controller of the concrete Contacts Entity
        super(Contacts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        contactIdController.setSelected(null);
        ownerIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareContactId(ActionEvent event) {
        if (this.getSelected() != null && contactIdController.getSelected() == null) {
            contactIdController.setSelected(this.getSelected().getContactId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOwnerId(ActionEvent event) {
        if (this.getSelected() != null && ownerIdController.getSelected() == null) {
            ownerIdController.setSelected(this.getSelected().getOwnerId());
        }
    }
}
