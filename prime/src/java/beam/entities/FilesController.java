package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Files;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "filesController")
@ViewScoped
public class FilesController extends AbstractController<Files> {

    @Inject
    private GroupsController groupIdController;
    @Inject
    private GroupFiltersController groupFilterIdController;
    @Inject
    private DocumentsController documentIdController;
    @Inject
    private MobilePageController mobilePageController;

    public FilesController() {
        // Inform the Abstract parent controller of the concrete Files Entity
        super(Files.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        groupIdController.setSelected(null);
        groupFilterIdController.setSelected(null);
        documentIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Documents entities that
     * are retrieved from Files?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Documents page
     */
    public String navigateDocumentsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Documents_items", this.getSelected().getDocumentsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/documents/index";
    }

    /**
     * Sets the "items" attribute with a collection of Documents entities that
     * are retrieved from Files?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Documents page
     */
    public String navigateDocumentsCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Documents_items", this.getSelected().getDocumentsCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/documents/index";
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
     * Sets the "selected" attribute of the Documents controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocumentId(ActionEvent event) {
        if (this.getSelected() != null && documentIdController.getSelected() == null) {
            documentIdController.setSelected(this.getSelected().getDocumentId());
        }
    }
}
