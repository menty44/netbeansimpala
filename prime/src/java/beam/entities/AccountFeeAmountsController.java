package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountFeeAmounts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "accountFeeAmountsController")
@ViewScoped
public class AccountFeeAmountsController extends AbstractController<AccountFeeAmounts> {

    @Inject
    private AccountsController accountIdController;
    @Inject
    private AccountFeesController accountFeeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AccountFeeAmountsController() {
        // Inform the Abstract parent controller of the concrete AccountFeeAmounts Entity
        super(AccountFeeAmounts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        accountIdController.setSelected(null);
        accountFeeIdController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the AccountFees controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountFeeId(ActionEvent event) {
        if (this.getSelected() != null && accountFeeIdController.getSelected() == null) {
            accountFeeIdController.setSelected(this.getSelected().getAccountFeeId());
        }
    }
}
