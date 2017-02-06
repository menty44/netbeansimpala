package beam.entities;

import beam.entities.util.MobilePageController;
import entities.LoanGroups;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "loanGroupsController")
@ViewScoped
public class LoanGroupsController extends AbstractController<LoanGroups> {

    @Inject
    private MobilePageController mobilePageController;

    public LoanGroupsController() {
        // Inform the Abstract parent controller of the concrete LoanGroups Entity
        super(LoanGroups.class);
    }

    /**
     * Sets the "items" attribute with a collection of Members entities that are
     * retrieved from LoanGroups?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Loans entities that are
     * retrieved from LoanGroups?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Loans page
     */
    public String navigateLoansCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Loans_items", this.getSelected().getLoansCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/loans/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from LoanGroups?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

}
