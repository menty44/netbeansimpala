package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Images;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "imagesController")
@ViewScoped
public class ImagesController extends AbstractController<Images> {

    @Inject
    private AdsController adIdController;
    @Inject
    private MembersController memberIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ImagesController() {
        // Inform the Abstract parent controller of the concrete Images Entity
        super(Images.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        adIdController.setSelected(null);
        memberIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ads controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAdId(ActionEvent event) {
        if (this.getSelected() != null && adIdController.getSelected() == null) {
            adIdController.setSelected(this.getSelected().getAdId());
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
}
