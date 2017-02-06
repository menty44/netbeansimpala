package beam.entities;

import beam.entities.util.MobilePageController;
import entities.GroupFilters;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "groupFiltersController")
@ViewScoped
public class GroupFiltersController extends AbstractController<GroupFilters> {

    @Inject
    private MobilePageController mobilePageController;

    public GroupFiltersController() {
        // Inform the Abstract parent controller of the concrete GroupFilters Entity
        super(GroupFilters.class);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from GroupFilters?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of AdInterests entities that
     * are retrieved from GroupFilters?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AdInterests page
     */
    public String navigateAdInterestsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdInterests_items", this.getSelected().getAdInterestsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adInterests/index";
    }

    /**
     * Sets the "items" attribute with a collection of Files entities that are
     * retrieved from GroupFilters?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Files page
     */
    public String navigateFilesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Files_items", this.getSelected().getFilesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/files/index";
    }

}
