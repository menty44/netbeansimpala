package beam.entities;

import beam.entities.util.MobilePageController;
import entities.GuaranteeLogs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "guaranteeLogsController")
@ViewScoped
public class GuaranteeLogsController extends AbstractController<GuaranteeLogs> {

    @Inject
    private GuaranteesController guaranteeIdController;
    @Inject
    private MembersController byIdController;
    @Inject
    private MobilePageController mobilePageController;

    public GuaranteeLogsController() {
        // Inform the Abstract parent controller of the concrete GuaranteeLogs Entity
        super(GuaranteeLogs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        guaranteeIdController.setSelected(null);
        byIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Guarantees controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGuaranteeId(ActionEvent event) {
        if (this.getSelected() != null && guaranteeIdController.getSelected() == null) {
            guaranteeIdController.setSelected(this.getSelected().getGuaranteeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareById(ActionEvent event) {
        if (this.getSelected() != null && byIdController.getSelected() == null) {
            byIdController.setSelected(this.getSelected().getById());
        }
    }
}
