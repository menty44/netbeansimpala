package beam.entities;

import beam.entities.util.MobilePageController;
import entities.TranslationMessages;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "translationMessagesController")
@ViewScoped
public class TranslationMessagesController extends AbstractController<TranslationMessages> {

    @Inject
    private MobilePageController mobilePageController;

    public TranslationMessagesController() {
        // Inform the Abstract parent controller of the concrete TranslationMessages Entity
        super(TranslationMessages.class);
    }

}
