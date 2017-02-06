package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ImportedMembers;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "importedMembersController")
@ViewScoped
public class ImportedMembersController extends AbstractController<ImportedMembers> {

    @Inject
    private MemberImportsController importIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ImportedMembersController() {
        // Inform the Abstract parent controller of the concrete ImportedMembers Entity
        super(ImportedMembers.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        importIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the MemberImports controller in order to
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
     * Sets the "items" attribute with a collection of ImportedMemberRecords
     * entities that are retrieved from ImportedMembers?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for ImportedMemberRecords page
     */
    public String navigateImportedMemberRecordsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ImportedMemberRecords_items", this.getSelected().getImportedMemberRecordsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/importedMemberRecords/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from ImportedMembers?cap_first and returns
     * the navigation outcome.
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
