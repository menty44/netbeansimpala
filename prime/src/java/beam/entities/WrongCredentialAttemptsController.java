package beam.entities;

import beam.entities.util.MobilePageController;
import entities.WrongCredentialAttempts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "wrongCredentialAttemptsController")
@ViewScoped
public class WrongCredentialAttemptsController extends AbstractController<WrongCredentialAttempts> {

    @Inject
    private MemberPosController memberPosIdController;
    @Inject
    private CardsController cardIdController;
    @Inject
    private UsersController userIdController;
    @Inject
    private MobilePageController mobilePageController;

    public WrongCredentialAttemptsController() {
        // Inform the Abstract parent controller of the concrete WrongCredentialAttempts Entity
        super(WrongCredentialAttempts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        memberPosIdController.setSelected(null);
        cardIdController.setSelected(null);
        userIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the MemberPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberPosId(ActionEvent event) {
        if (this.getSelected() != null && memberPosIdController.getSelected() == null) {
            memberPosIdController.setSelected(this.getSelected().getMemberPosId());
        }
    }

    /**
     * Sets the "selected" attribute of the Cards controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCardId(ActionEvent event) {
        if (this.getSelected() != null && cardIdController.getSelected() == null) {
            cardIdController.setSelected(this.getSelected().getCardId());
        }
    }

    /**
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUserId(ActionEvent event) {
        if (this.getSelected() != null && userIdController.getSelected() == null) {
            userIdController.setSelected(this.getSelected().getUserId());
        }
    }
}
