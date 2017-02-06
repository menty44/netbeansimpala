package beam.entities;

import beam.entities.util.MobilePageController;
import entities.FieldMappings;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "fieldMappingsController")
@ViewScoped
public class FieldMappingsController extends AbstractController<FieldMappings> {

    @Inject
    private FileMappingsController fileMappingIdController;
    @Inject
    private CustomFieldsController memberFieldIdController;
    @Inject
    private MobilePageController mobilePageController;

    public FieldMappingsController() {
        // Inform the Abstract parent controller of the concrete FieldMappings Entity
        super(FieldMappings.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        fileMappingIdController.setSelected(null);
        memberFieldIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the FileMappings controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFileMappingId(ActionEvent event) {
        if (this.getSelected() != null && fileMappingIdController.getSelected() == null) {
            fileMappingIdController.setSelected(this.getSelected().getFileMappingId());
        }
    }

    /**
     * Sets the "selected" attribute of the CustomFields controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberFieldId(ActionEvent event) {
        if (this.getSelected() != null && memberFieldIdController.getSelected() == null) {
            memberFieldIdController.setSelected(this.getSelected().getMemberFieldId());
        }
    }
}
