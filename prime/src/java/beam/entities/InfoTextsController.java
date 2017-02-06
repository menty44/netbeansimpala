package beam.entities;

import beam.entities.util.MobilePageController;
import entities.InfoTexts;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "infoTextsController")
@ViewScoped
public class InfoTextsController extends AbstractController<InfoTexts> {

    @Inject
    private MobilePageController mobilePageController;

    public InfoTextsController() {
        // Inform the Abstract parent controller of the concrete InfoTexts Entity
        super(InfoTexts.class);
    }

}
