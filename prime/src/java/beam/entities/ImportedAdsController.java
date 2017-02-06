package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ImportedAds;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "importedAdsController")
@ViewScoped
public class ImportedAdsController extends AbstractController<ImportedAds> {

    @Inject
    private ImportedAdCategoriesController importedCategoryIdController;
    @Inject
    private AdCategoriesController existingCategoryIdController;
    @Inject
    private AdImportsController importIdController;
    @Inject
    private MembersController ownerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ImportedAdsController() {
        // Inform the Abstract parent controller of the concrete ImportedAds Entity
        super(ImportedAds.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        importedCategoryIdController.setSelected(null);
        existingCategoryIdController.setSelected(null);
        importIdController.setSelected(null);
        ownerIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ImportedAdCategories controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportedCategoryId(ActionEvent event) {
        if (this.getSelected() != null && importedCategoryIdController.getSelected() == null) {
            importedCategoryIdController.setSelected(this.getSelected().getImportedCategoryId());
        }
    }

    /**
     * Sets the "selected" attribute of the AdCategories controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareExistingCategoryId(ActionEvent event) {
        if (this.getSelected() != null && existingCategoryIdController.getSelected() == null) {
            existingCategoryIdController.setSelected(this.getSelected().getExistingCategoryId());
        }
    }

    /**
     * Sets the "selected" attribute of the AdImports controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportId(ActionEvent event) {
        if (this.getSelected() != null && importIdController.getSelected() == null) {
            importIdController.setSelected(this.getSelected().getImportId());
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
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from ImportedAds?cap_first and returns the
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
