package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberPos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "memberPosController")
@ViewScoped
public class MemberPosController extends AbstractController<MemberPos> {

    @Inject
    private PosController posIdController;
    @Inject
    private MembersController ownerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public MemberPosController() {
        // Inform the Abstract parent controller of the concrete MemberPos Entity
        super(MemberPos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        posIdController.setSelected(null);
        ownerIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Pos controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePosId(ActionEvent event) {
        if (this.getSelected() != null && posIdController.getSelected() == null) {
            posIdController.setSelected(this.getSelected().getPosId());
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

    /**
     * Sets the "items" attribute with a collection of Pos entities that are
     * retrieved from MemberPos?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Pos page
     */
    public String navigatePosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pos_items", this.getSelected().getPosCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pos/index";
    }

    /**
     * Sets the "items" attribute with a collection of WrongCredentialAttempts
     * entities that are retrieved from MemberPos?cap_first and returns the
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

}
