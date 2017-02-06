package beam.entities;

import beam.entities.util.MobilePageController;
import entities.TraceNumbers;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "traceNumbersController")
@ViewScoped
public class TraceNumbersController extends AbstractController<TraceNumbers> {

    @Inject
    private MobilePageController mobilePageController;

    public TraceNumbersController() {
        // Inform the Abstract parent controller of the concrete TraceNumbers Entity
        super(TraceNumbers.class);
    }

}
