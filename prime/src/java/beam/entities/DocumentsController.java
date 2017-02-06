package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Documents;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "documentsController")
@ViewScoped
public class DocumentsController extends AbstractController<Documents> {

    @Inject
    private FilesController documentPageIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private FilesController formPageIdController;
    @Inject
    private BinaryFilesController binaryFileIdController;
    @Inject
    private MobilePageController mobilePageController;

    public DocumentsController() {
        // Inform the Abstract parent controller of the concrete Documents Entity
        super(Documents.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        documentPageIdController.setSelected(null);
        memberIdController.setSelected(null);
        formPageIdController.setSelected(null);
        binaryFileIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Documents?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from Documents?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "selected" attribute of the Files controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocumentPageId(ActionEvent event) {
        if (this.getSelected() != null && documentPageIdController.getSelected() == null) {
            documentPageIdController.setSelected(this.getSelected().getDocumentPageId());
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
     * Sets the "selected" attribute of the Files controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFormPageId(ActionEvent event) {
        if (this.getSelected() != null && formPageIdController.getSelected() == null) {
            formPageIdController.setSelected(this.getSelected().getFormPageId());
        }
    }

    /**
     * Sets the "selected" attribute of the BinaryFiles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBinaryFileId(ActionEvent event) {
        if (this.getSelected() != null && binaryFileIdController.getSelected() == null) {
            binaryFileIdController.setSelected(this.getSelected().getBinaryFileId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Files entities that are
     * retrieved from Documents?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Files page
     */
    public String navigateFilesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Files_items", this.getSelected().getFilesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/files/index";
    }

}
