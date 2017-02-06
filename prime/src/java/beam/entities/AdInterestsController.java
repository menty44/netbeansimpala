package beam.entities;

import beam.entities.util.MobilePageController;
import entities.AdInterests;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "adInterestsController")
@ViewScoped
public class AdInterestsController extends AbstractController<AdInterests> {

    @Inject
    private AdCategoriesController categoryIdController;
    @Inject
    private GroupFiltersController groupFilterIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MembersController ownerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public AdInterestsController() {
        // Inform the Abstract parent controller of the concrete AdInterests Entity
        super(AdInterests.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        categoryIdController.setSelected(null);
        groupFilterIdController.setSelected(null);
        currencyIdController.setSelected(null);
        memberIdController.setSelected(null);
        ownerIdController.setSelected(null);
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
     * Sets the "selected" attribute of the GroupFilters controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGroupFilterId(ActionEvent event) {
        if (this.getSelected() != null && groupFilterIdController.getSelected() == null) {
            groupFilterIdController.setSelected(this.getSelected().getGroupFilterId());
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
    public void prepareMemberId(ActionEvent event) {
        if (this.getSelected() != null && memberIdController.getSelected() == null) {
            memberIdController.setSelected(this.getSelected().getMemberId());
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
}
