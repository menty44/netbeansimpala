package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Settings;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "settingsController")
@ViewScoped
public class SettingsController extends AbstractController<Settings> {

    @Inject
    private MobilePageController mobilePageController;

    public SettingsController() {
        // Inform the Abstract parent controller of the concrete Settings Entity
        super(Settings.class);
    }

}
