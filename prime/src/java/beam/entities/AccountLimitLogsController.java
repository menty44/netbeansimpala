package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountLimitLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountLimitLogsController")
@ViewScoped
public class AccountLimitLogsController extends AbstractController<AccountLimitLogs> {

    @Inject
    private MembersController byIdController;
    @Inject
    private AccountsController accountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountLimitLogsController() {
        // Inform the Abstract parent controller of the concrete AccountLimitLogs Entity
        super(AccountLimitLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        accountIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareById(ActionEvent event) {
        if (this.getSelected() != null && byIdController.getSelected() == null) {
            byIdController.setSelected(this.getSelected().getById());
        }
    }

    /**
     * Sets the "selected" attribute of the Accounts controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountId(ActionEvent event) {
        if (this.getSelected() != null && accountIdController.getSelected() == null) {
            accountIdController.setSelected(this.getSelected().getAccountId());
        }
    }
}
