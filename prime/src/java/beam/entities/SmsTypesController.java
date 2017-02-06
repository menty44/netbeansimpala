package beam.entities;

import beam.entities.util.MobilePageController;
import entities.SmsTypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "smsTypesController")
@ViewScoped
public class SmsTypesController extends AbstractController<SmsTypes> {

    @Inject
    private MobilePageController mobilePageController;

    public SmsTypesController() {
        // Inform the Abstract parent controller of the concrete SmsTypes Entity
        super(SmsTypes.class);
    }

    /**
     * Sets the "items" attribute with a collection of SmsLogs entities that are
     * retrieved from SmsTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for SmsLogs page
     */
    public String navigateSmsLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SmsLogs_items", this.getSelected().getSmsLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/smsLogs/index";
    }

}
