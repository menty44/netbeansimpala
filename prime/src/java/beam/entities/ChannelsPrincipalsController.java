package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ChannelsPrincipals;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "channelsPrincipalsController")
@ViewScoped
public class ChannelsPrincipalsController extends AbstractController<ChannelsPrincipals> {

    @Inject
    private CustomFieldsController customFieldIdController;
    @Inject
    private ChannelsController channelIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ChannelsPrincipalsController() {
        // Inform the Abstract parent controller of the concrete ChannelsPrincipals Entity
        super(ChannelsPrincipals.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        customFieldIdController.setSelected(null);
        channelIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CustomFields controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCustomFieldId(ActionEvent event) {
        if (this.getSelected() != null && customFieldIdController.getSelected() == null) {
            customFieldIdController.setSelected(this.getSelected().getCustomFieldId());
        }
    }

    /**
     * Sets the "selected" attribute of the Channels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareChannelId(ActionEvent event) {
        if (this.getSelected() != null && channelIdController.getSelected() == null) {
            channelIdController.setSelected(this.getSelected().getChannelId());
        }
    }
}
