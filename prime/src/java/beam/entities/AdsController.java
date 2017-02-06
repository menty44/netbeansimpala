package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Ads;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "adsController")
@ViewScoped
public class AdsController extends AbstractController<Ads> {

    @Inject
    private AdCategoriesController categoryIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private MembersController ownerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AdsController() {
        // Inform the Abstract parent controller of the concrete Ads Entity
        super(Ads.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        categoryIdController.setSelected(null);
        currencyIdController.setSelected(null);
        ownerIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Images entities that are
     * retrieved from Ads?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Images page
     */
    public String navigateImagesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Images_items", this.getSelected().getImagesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/images/index";
    }

    /**
     * Sets the "selected" attribute of the AdCategories controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCategoryId(ActionEvent event) {
        if (this.getSelected() != null && categoryIdController.getSelected() == null) {
            categoryIdController.setSelected(this.getSelected().getCategoryId());
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
     * entities that are retrieved from Ads?cap_first and returns the navigation
     * outcome.
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
