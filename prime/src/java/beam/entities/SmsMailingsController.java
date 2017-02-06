package beam.entities;

import beam.entities.util.MobilePageController;
import entities.SmsMailings;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "smsMailingsController")
@ViewScoped
public class SmsMailingsController extends AbstractController<SmsMailings> {

    @Inject
    private MembersController byIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public SmsMailingsController() {
        // Inform the Abstract parent controller of the concrete SmsMailings Entity
        super(SmsMailings.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from SmsMailings?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Members page
     */
    public String navigateMembersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Members_items", this.getSelected().getMembersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/members/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from SmsMailings?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of SmsLogs entities that are
     * retrieved from SmsMailings?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsLogs page
     */
    public String navigateSmsLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsLogs_items", this.getSelected().getSmsLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsLogs/index";
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
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberId(ActionEvent event) {
        if (this.getSelected() != null && memberIdController.getSelected() == null) {
            memberIdController.setSelected(this.getSelected().getMemberId());
        }
    }
}
