package beam.entities;

import beam.entities.util.MobilePageController;
import entities.ErrorLogEntryParameters;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "errorLogEntryParametersController")
@ViewScoped
public class ErrorLogEntryParametersController extends AbstractController<ErrorLogEntryParameters> {

    @Inject
    private ErrorLogEntriesController errorLogEntriesController;
    @Inject
    private MobilePageController mobilePageController;

    public ErrorLogEntryParametersController() {
        // Inform the Abstract parent controller of the concrete ErrorLogEntryParameters Entity
        super(ErrorLogEntryParameters.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getErrorLogEntryParametersPK().setErrorLogEntryId(this.getSelected().getErrorLogEntries().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setErrorLogEntryParametersPK(new entities.ErrorLogEntryParametersPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        errorLogEntriesController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ErrorLogEntries controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareErrorLogEntries(ActionEvent event) {
        if (this.getSelected() != null && errorLogEntriesController.getSelected() == null) {
            errorLogEntriesController.setSelected(this.getSelected().getErrorLogEntries());
        }
    }
}
