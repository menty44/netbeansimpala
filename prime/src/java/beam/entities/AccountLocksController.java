package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AccountLocks;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "accountLocksController")
@ViewScoped
public class AccountLocksController extends AbstractController<AccountLocks> {

    @Inject
    private MobilePageController mobilePageController;

    public AccountLocksController() {
        // Inform the Abstract parent controller of the concrete AccountLocks Entity
        super(AccountLocks.class);
    }

}
