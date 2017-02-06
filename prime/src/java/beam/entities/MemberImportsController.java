package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberImports;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "memberImportsController")
@ViewScoped
public class MemberImportsController extends AbstractController<MemberImports> {

    @Inject
    private MembersController byIdController;
    @Inject
    private TransferTypesController initialCreditTransferTypeIdController;
    @Inject
    private TransferTypesController initialDebitTransferTypeIdController;
    @Inject
    private GroupsController groupIdController;
    @Inject
    private AccountTypesController accountTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public MemberImportsController() {
        // Inform the Abstract parent controller of the concrete MemberImports Entity
        super(MemberImports.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        byIdController.setSelected(null);
        initialCreditTransferTypeIdController.setSelected(null);
        initialDebitTransferTypeIdController.setSelected(null);
        groupIdController.setSelected(null);
        accountTypeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ImportedMembers entities
     * that are retrieved from MemberImports?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ImportedMembers page
     */
    public String navigateImportedMembersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ImportedMembers_items", this.getSelected().getImportedMembersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/importedMembers/index";
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
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInitialCreditTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && initialCreditTransferTypeIdController.getSelected() == null) {
            initialCreditTransferTypeIdController.setSelected(this.getSelected().getInitialCreditTransferTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInitialDebitTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && initialDebitTransferTypeIdController.getSelected() == null) {
            initialDebitTransferTypeIdController.setSelected(this.getSelected().getInitialDebitTransferTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Groups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGroupId(ActionEvent event) {
        if (this.getSelected() != null && groupIdController.getSelected() == null) {
            groupIdController.setSelected(this.getSelected().getGroupId());
        }
    }

    /**
     * Sets the "selected" attribute of the AccountTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccountTypeId(ActionEvent event) {
        if (this.getSelected() != null && accountTypeIdController.getSelected() == null) {
            accountTypeIdController.setSelected(this.getSelected().getAccountTypeId());
        }
    }
}
