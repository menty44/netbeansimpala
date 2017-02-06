package beam.entities;

import beam.entities.util.MobilePageController;
import entities.IndexOperations;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "indexOperationsController")
@ViewScoped
public class IndexOperationsController extends AbstractController<IndexOperations> {

    @Inject
    private MobilePageController mobilePageController;

    public IndexOperationsController() {
        // Inform the Abstract parent controller of the concrete IndexOperations Entity
        super(IndexOperations.class);
    }

}
