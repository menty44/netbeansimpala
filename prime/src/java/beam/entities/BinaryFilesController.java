package beam.entities;

import beam.entities.util.MobilePageController;
import entities.BinaryFiles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "binaryFilesController")
@ViewScoped
public class BinaryFilesController extends AbstractController<BinaryFiles> {

    @Inject
    private MobilePageController mobilePageController;

    public BinaryFilesController() {
        // Inform the Abstract parent controller of the concrete BinaryFiles Entity
        super(BinaryFiles.class);
    }

    /**
     * Sets the "items" attribute with a collection of Documents entities that
     * are retrieved from BinaryFiles?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Documents page
     */
    public String navigateDocumentsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Documents_items", this.getSelected().getDocumentsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/documents/index";
    }

}
