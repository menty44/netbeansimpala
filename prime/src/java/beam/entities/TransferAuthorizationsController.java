package beam.entities;

import beam.entities.util.MobilePageController;
import entities.TransferAuthorizations;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transferAuthorizationsController")
@ViewScoped
public class TransferAuthorizationsController extends AbstractController<TransferAuthorizations> {

    @Inject
    private AuthorizationLevelsController levelIdController;
    @Inject
    private MembersController byIdController;
    @Inject
    private TransfersController transferIdController;
    @Inject
    private MobilePageController mobilePageController;

    public TransferAuthorizationsController() {
        // Inform the Abstract parent controller of the concrete TransferAuthorizations Entity
        super(TransferAuthorizations.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        levelIdController.setSelected(null);
        byIdController.setSelected(null);
        transferIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the AuthorizationLevels controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLevelId(ActionEvent event) {
        if (this.getSelected() != null && levelIdController.getSelected() == null) {
            levelIdController.setSelected(this.getSelected().getLevelId());
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
     * Sets the "items" attribute with a collection of AmountReservations
     * entities that are retrieved from TransferAuthorizations?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for AmountReservations page
     */
    public String navigateAmountReservationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AmountReservations_items", this.getSelected().getAmountReservationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/amountReservations/index";
    }

}
