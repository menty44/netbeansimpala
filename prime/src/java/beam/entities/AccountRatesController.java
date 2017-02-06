package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountRates;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountRatesController")
@ViewScoped
public class AccountRatesController extends AbstractController<AccountRates> {

    @Inject
    private TransfersController transferIdController;
    @Inject
    private AccountsController accountIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountRatesController() {
        // Inform the Abstract parent controller of the concrete AccountRates Entity
        super(AccountRates.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferIdController.setSelected(null);
        accountIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Transfers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferId(ActionEvent event) {
        if (this.getSelected() != null && transferIdController.getSelected() == null) {
            transferIdController.setSelected(this.getSelected().getTransferId());
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
