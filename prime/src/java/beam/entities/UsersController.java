package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Users;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usersController")
@ViewScoped
public class UsersController extends AbstractController<Users> {

    @Inject
    private MembersController membersController;
    @Inject
    private MobilePageController mobilePageController;

    public UsersController() {
        // Inform the Abstract parent controller of the concrete Users Entity
        super(Users.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        membersController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of UsernameChangeLogs
     * entities that are retrieved from Users?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for UsernameChangeLogs page
     */
    public String navigateUsernameChangeLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsernameChangeLogs_items", this.getSelected().getUsernameChangeLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/usernameChangeLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of LoginHistory entities
     * that are retrieved from Users?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for LoginHistory page
     */
    public String navigateLoginHistoryCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LoginHistory_items", this.getSelected().getLoginHistoryCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/loginHistory/index";
    }

    /**
     * Sets the "items" attribute with a collection of Sessions entities that
     * are retrieved from Users?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Sessions page
     */
    public String navigateSessionsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Sessions_items", this.getSelected().getSessionsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/sessions/index";
    }

    /**
     * Sets the "items" attribute with a collection of PermissionDenieds
     * entities that are retrieved from Users?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PermissionDenieds page
     */
    public String navigatePermissionDeniedsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PermissionDenieds_items", this.getSelected().getPermissionDeniedsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/permissionDenieds/index";
    }

    /**
     * Sets the "items" attribute with a collection of ErrorLogEntries entities
     * that are retrieved from Users?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ErrorLogEntries page
     */
    public String navigateErrorLogEntriesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ErrorLogEntries_items", this.getSelected().getErrorLogEntriesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/errorLogEntries/index";
    }

    /**
     * Sets the "items" attribute with a collection of WrongCredentialAttempts
     * entities that are retrieved from Users?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for WrongCredentialAttempts page
     */
    public String navigateWrongCredentialAttemptsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("WrongCredentialAttempts_items", this.getSelected().getWrongCredentialAttemptsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/wrongCredentialAttempts/index";
    }

    /**
     * Sets the "items" attribute with a collection of PasswordHistory entities
     * that are retrieved from Users?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PasswordHistory page
     */
    public String navigatePasswordHistoryCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PasswordHistory_items", this.getSelected().getPasswordHistoryCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/passwordHistory/index";
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMembers(ActionEvent event) {
        if (this.getSelected() != null && membersController.getSelected() == null) {
            membersController.setSelected(this.getSelected().getMembers());
        }
    }
}
