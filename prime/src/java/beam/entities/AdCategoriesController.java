package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AdCategories;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "adCategoriesController")
@ViewScoped
public class AdCategoriesController extends AbstractController<AdCategories> {

    @Inject
    private AdCategoriesController parentIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AdCategoriesController() {
        // Inform the Abstract parent controller of the concrete AdCategories Entity
        super(AdCategories.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        parentIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ImportedAds entities that
     * are retrieved from AdCategories?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ImportedAds page
     */
    public String navigateImportedAdsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ImportedAds_items", this.getSelected().getImportedAdsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/importedAds/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdCategories entities
     * that are retrieved from AdCategories?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AdCategories page
     */
    public String navigateAdCategoriesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdCategories_items", this.getSelected().getAdCategoriesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adCategories/index";
    }

    /**
     * Sets the "selected" attribute of the AdCategories controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParentId(ActionEvent event) {
        if (this.getSelected() != null && parentIdController.getSelected() == null) {
            parentIdController.setSelected(this.getSelected().getParentId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ads entities that are
     * retrieved from AdCategories?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Ads page
     */
    public String navigateAdsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ads_items", this.getSelected().getAdsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ads/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdInterests entities that
     * are retrieved from AdCategories?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of ImportedAdCategories
     * entities that are retrieved from AdCategories?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ImportedAdCategories page
     */
    public String navigateImportedAdCategoriesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ImportedAdCategories_items", this.getSelected().getImportedAdCategoriesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/importedAdCategories/index";
    }

}
