package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Pos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "posController")
@ViewScoped
public class PosController extends AbstractController<Pos> {

    @Inject
    private MemberPosController memberPosIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PosController() {
        // Inform the Abstract parent controller of the concrete Pos Entity
        super(Pos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        memberPosIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of MemberPos entities that
     * are retrieved from Pos?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MemberPos page
     */
    public String navigateMemberPosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MemberPos_items", this.getSelected().getMemberPosCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/memberPos/index";
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
     * Sets the "items" attribute with a collection of PosLogs entities that are
     * retrieved from Pos?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for PosLogs page
     */
    public String navigatePosLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PosLogs_items", this.getSelected().getPosLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/posLogs/index";
    }

}
