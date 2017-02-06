package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Tickets;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ticketsController")
@ViewScoped
public class TicketsController extends AbstractController<Tickets> {

    @Inject
    private TransfersController transferIdController;
    @Inject
    private ChannelsController toChannelIdController;
    @Inject
    private MembersController fromMemberIdController;
    @Inject
    private MembersController toMemberIdController;
    @Inject
    private TransferTypesController transferTypeIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private ChannelsController fromChannelIdController;
    @Inject
    private MobilePageController mobilePageController;

    public TicketsController() {
        // Inform the Abstract parent controller of the concrete Tickets Entity
        super(Tickets.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        transferIdController.setSelected(null);
        toChannelIdController.setSelected(null);
        fromMemberIdController.setSelected(null);
        toMemberIdController.setSelected(null);
        transferTypeIdController.setSelected(null);
        currencyIdController.setSelected(null);
        fromChannelIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Transfers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferId(ActionEvent event) {
        if (this.getSelected() != null && transferIdController.getSelected() == null) {
            transferIdController.setSelected(this.getSelected().getTransferId());
        }
    }

    /**
     * Sets the "selected" attribute of the Channels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToChannelId(ActionEvent event) {
        if (this.getSelected() != null && toChannelIdController.getSelected() == null) {
            toChannelIdController.setSelected(this.getSelected().getToChannelId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFromMemberId(ActionEvent event) {
        if (this.getSelected() != null && fromMemberIdController.getSelected() == null) {
            fromMemberIdController.setSelected(this.getSelected().getFromMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToMemberId(ActionEvent event) {
        if (this.getSelected() != null && toMemberIdController.getSelected() == null) {
            toMemberIdController.setSelected(this.getSelected().getToMemberId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && transferTypeIdController.getSelected() == null) {
            transferTypeIdController.setSelected(this.getSelected().getTransferTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Currencies controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCurrencyId(ActionEvent event) {
        if (this.getSelected() != null && currencyIdController.getSelected() == null) {
            currencyIdController.setSelected(this.getSelected().getCurrencyId());
        }
    }

    /**
     * Sets the "selected" attribute of the Channels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFromChannelId(ActionEvent event) {
        if (this.getSelected() != null && fromChannelIdController.getSelected() == null) {
            fromChannelIdController.setSelected(this.getSelected().getFromChannelId());
        }
    }
}
