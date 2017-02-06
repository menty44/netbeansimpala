package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberRecords;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "memberRecordsController")
@ViewScoped
public class MemberRecordsController extends AbstractController<MemberRecords> {

    @Inject
    private MembersController byIdController;
    @Inject
    private MembersController modifiedByIdController;
    @Inject
    private MembersController elementIdController;
    @Inject
    private MemberRecordTypesController memberRecordTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public MemberRecordsController() {
        // Inform the Abstract parent controller of the concrete MemberRecords Entity
        super(MemberRecords.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        modifiedByIdController.setSelected(null);
        elementIdController.setSelected(null);
        memberRecordTypeIdController.setSelected(null);
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
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareModifiedById(ActionEvent event) {
        if (this.getSelected() != null && modifiedByIdController.getSelected() == null) {
            modifiedByIdController.setSelected(this.getSelected().getModifiedById());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareElementId(ActionEvent event) {
        if (this.getSelected() != null && elementIdController.getSelected() == null) {
            elementIdController.setSelected(this.getSelected().getElementId());
        }
    }

    /**
     * Sets the "selected" attribute of the MemberRecordTypes controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMemberRecordTypeId(ActionEvent event) {
        if (this.getSelected() != null && memberRecordTypeIdController.getSelected() == null) {
            memberRecordTypeIdController.setSelected(this.getSelected().getMemberRecordTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from MemberRecords?cap_first and returns the
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
