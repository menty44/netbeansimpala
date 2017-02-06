package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ErrorLogEntries;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "errorLogEntriesController")
@ViewScoped
public class ErrorLogEntriesController extends AbstractController<ErrorLogEntries> {

    @Inject
    private UsersController loggedUserIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ErrorLogEntriesController() {
        // Inform the Abstract parent controller of the concrete ErrorLogEntries Entity
        super(ErrorLogEntries.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        loggedUserIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ErrorLogEntryParameters
     * entities that are retrieved from ErrorLogEntries?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for ErrorLogEntryParameters page
     */
    public String navigateErrorLogEntryParametersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ErrorLogEntryParameters_items", this.getSelected().getErrorLogEntryParametersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/errorLogEntryParameters/index";
    }

    /**
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoggedUserId(ActionEvent event) {
        if (this.getSelected() != null && loggedUserIdController.getSelected() == null) {
            loggedUserIdController.setSelected(this.getSelected().getLoggedUserId());
        }
    }
}
