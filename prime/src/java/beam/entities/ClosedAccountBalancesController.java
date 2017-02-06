package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ClosedAccountBalances;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "closedAccountBalancesController")
@ViewScoped
public class ClosedAccountBalancesController extends AbstractController<ClosedAccountBalances> {

    @Inject
    private AccountsController accountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ClosedAccountBalancesController() {
        // Inform the Abstract parent controller of the concrete ClosedAccountBalances Entity
        super(ClosedAccountBalances.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        accountIdController.setSelected(null);
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
