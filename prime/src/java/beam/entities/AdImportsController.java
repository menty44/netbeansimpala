package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AdImports;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "adImportsController")
@ViewScoped
public class AdImportsController extends AbstractController<AdImports> {

    @Inject
    private MembersController byIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AdImportsController() {
        // Inform the Abstract parent controller of the concrete AdImports Entity
        super(AdImports.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        currencyIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ImportedAds entities that
     * are retrieved from AdImports?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Currencies controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCurrencyId(ActionEvent event) {
        if (this.getSelected() != null && currencyIdController.getSelected() == null) {
            currencyIdController.setSelected(this.getSelected().getCurrencyId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of ImportedAdCategories
     * entities that are retrieved from AdImports?cap_first and returns the
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
