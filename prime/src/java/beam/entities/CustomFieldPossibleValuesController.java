package beam.entities;

import beam.entities.util.MobilePageController;
import entities.CustomFieldPossibleValues;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "customFieldPossibleValuesController")
@ViewScoped
public class CustomFieldPossibleValuesController extends AbstractController<CustomFieldPossibleValues> {

    @Inject
    private CustomFieldPossibleValuesController parentIdController;
    @Inject
    private CustomFieldsController fieldIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CustomFieldPossibleValuesController() {
        // Inform the Abstract parent controller of the concrete CustomFieldPossibleValues Entity
        super(CustomFieldPossibleValues.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        parentIdController.setSelected(null);
        fieldIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldPossibleValues
     * entities that are retrieved from CustomFieldPossibleValues?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for CustomFieldPossibleValues page
     */
    public String navigateCustomFieldPossibleValuesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldPossibleValues_items", this.getSelected().getCustomFieldPossibleValuesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldPossibleValues/index";
    }

    /**
     * Sets the "selected" attribute of the CustomFieldPossibleValues controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParentId(ActionEvent event) {
        if (this.getSelected() != null && parentIdController.getSelected() == null) {
            parentIdController.setSelected(this.getSelected().getParentId());
        }
    }

    /**
     * Sets the "selected" attribute of the CustomFields controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFieldId(ActionEvent event) {
        if (this.getSelected() != null && fieldIdController.getSelected() == null) {
            fieldIdController.setSelected(this.getSelected().getFieldId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from CustomFieldPossibleValues?cap_first and
     * returns the navigation outcome.
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
