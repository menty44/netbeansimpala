package beam.entities;

import beam.entities.util.MobilePageController;
import entities.CardLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cardLogsController")
@ViewScoped
public class CardLogsController extends AbstractController<CardLogs> {

    @Inject
    private CardsController cardIdController;
    @Inject
    private MembersController byIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CardLogsController() {
        // Inform the Abstract parent controller of the concrete CardLogs Entity
        super(CardLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cardIdController.setSelected(null);
        byIdController.setSelected(null);
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
}
