package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Cards;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cardsController")
@ViewScoped
public class CardsController extends AbstractController<Cards> {

    @Inject
    private CardTypesController cardTypeIdController;
    @Inject
    private MembersController ownerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CardsController() {
        // Inform the Abstract parent controller of the concrete Cards Entity
        super(Cards.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cardTypeIdController.setSelected(null);
        ownerIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CardLogs entities that
     * are retrieved from Cards?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CardLogs page
     */
    public String navigateCardLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CardLogs_items", this.getSelected().getCardLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cardLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of WrongCredentialAttempts
     * entities that are retrieved from Cards?cap_first and returns the
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
     * Sets the "selected" attribute of the CardTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCardTypeId(ActionEvent event) {
        if (this.getSelected() != null && cardTypeIdController.getSelected() == null) {
            cardTypeIdController.setSelected(this.getSelected().getCardTypeId());
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
