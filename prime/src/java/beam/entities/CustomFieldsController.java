package beam.entities;

import beam.entities.util.MobilePageController;
import entities.CustomFields;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "customFieldsController")
@ViewScoped
public class CustomFieldsController extends AbstractController<CustomFields> {

    @Inject
    private CustomFieldsController parentIdController;
    @Inject
    private TransferTypesController transferTypeIdController;
    @Inject
    private MemberRecordTypesController memberRecordTypeIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CustomFieldsController() {
        // Inform the Abstract parent controller of the concrete CustomFields Entity
        super(CustomFields.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        parentIdController.setSelected(null);
        transferTypeIdController.setSelected(null);
        memberRecordTypeIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TransferTypes entities
     * that are retrieved from CustomFields?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TransferTypes page
     */
    public String navigateTransferTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TransferTypes_items", this.getSelected().getTransferTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/transferTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from CustomFields?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldPossibleValues
     * entities that are retrieved from CustomFields?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of FieldMappings entities
     * that are retrieved from CustomFields?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for FieldMappings page
     */
    public String navigateFieldMappingsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FieldMappings_items", this.getSelected().getFieldMappingsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/fieldMappings/index";
    }

    /**
     * Sets the "items" attribute with a collection of ChannelsPrincipals
     * entities that are retrieved from CustomFields?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ChannelsPrincipals page
     */
    public String navigateChannelsPrincipalsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ChannelsPrincipals_items", this.getSelected().getChannelsPrincipalsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/channelsPrincipals/index";
    }

    /**
     * Sets the "items" attribute with a collection of CustomFields entities
     * that are retrieved from CustomFields?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CustomFields page
     */
    public String navigateCustomFieldsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFields_items", this.getSelected().getCustomFieldsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFields/index";
    }

    /**
     * Sets the "selected" attribute of the CustomFields controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParentId(ActionEvent event) {
        if (this.getSelected() != null && parentIdController.getSelected() == null) {
            parentIdController.setSelected(this.getSelected().getParentId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && transferTypeIdController.getSelected() == null) {
            transferTypeIdController.setSelected(this.getSelected().getTransferTypeId());
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
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from CustomFields?cap_first and returns the
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
