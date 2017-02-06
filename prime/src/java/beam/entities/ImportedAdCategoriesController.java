package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ImportedAdCategories;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "importedAdCategoriesController")
@ViewScoped
public class ImportedAdCategoriesController extends AbstractController<ImportedAdCategories> {

    @Inject
    private AdCategoriesController existingParentIdController;
    @Inject
    private ImportedAdCategoriesController importedParentIdController;
    @Inject
    private AdImportsController adImportIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ImportedAdCategoriesController() {
        // Inform the Abstract parent controller of the concrete ImportedAdCategories Entity
        super(ImportedAdCategories.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        existingParentIdController.setSelected(null);
        importedParentIdController.setSelected(null);
        adImportIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ImportedAds entities that
     * are retrieved from ImportedAdCategories?cap_first and returns the
     * navigation outcome.
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
     * Sets the "selected" attribute of the AdCategories controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareExistingParentId(ActionEvent event) {
        if (this.getSelected() != null && existingParentIdController.getSelected() == null) {
            existingParentIdController.setSelected(this.getSelected().getExistingParentId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of ImportedAdCategories
     * entities that are retrieved from ImportedAdCategories?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for ImportedAdCategories page
     */
    public String navigateImportedAdCategoriesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ImportedAdCategories_items", this.getSelected().getImportedAdCategoriesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/importedAdCategories/index";
    }

    /**
     * Sets the "selected" attribute of the ImportedAdCategories controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportedParentId(ActionEvent event) {
        if (this.getSelected() != null && importedParentIdController.getSelected() == null) {
            importedParentIdController.setSelected(this.getSelected().getImportedParentId());
        }
    }

    /**
     * Sets the "selected" attribute of the AdImports controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAdImportId(ActionEvent event) {
        if (this.getSelected() != null && adImportIdController.getSelected() == null) {
            adImportIdController.setSelected(this.getSelected().getAdImportId());
        }
    }
}
