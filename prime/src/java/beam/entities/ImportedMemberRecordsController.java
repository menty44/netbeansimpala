package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ImportedMemberRecords;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "importedMemberRecordsController")
@ViewScoped
public class ImportedMemberRecordsController extends AbstractController<ImportedMemberRecords> {

    @Inject
    private ImportedMembersController importedMemberIdController;
    @Inject
    private MemberRecordTypesController memberRecordTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ImportedMemberRecordsController() {
        // Inform the Abstract parent controller of the concrete ImportedMemberRecords Entity
        super(ImportedMemberRecords.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        importedMemberIdController.setSelected(null);
        memberRecordTypeIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ImportedMembers controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareImportedMemberId(ActionEvent event) {
        if (this.getSelected() != null && importedMemberIdController.getSelected() == null) {
            importedMemberIdController.setSelected(this.getSelected().getImportedMemberId());
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
     * entities that are retrieved from ImportedMemberRecords?cap_first and
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
