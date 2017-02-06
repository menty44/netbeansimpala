package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Certifications;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "certificationsController")
@ViewScoped
public class CertificationsController extends AbstractController<Certifications> {

    @Inject
    private MembersController buyerIdController;
    @Inject
    private GuaranteeTypesController guaranteeTypeIdController;
    @Inject
    private MembersController issuerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CertificationsController() {
        // Inform the Abstract parent controller of the concrete Certifications Entity
        super(Certifications.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        buyerIdController.setSelected(null);
        guaranteeTypeIdController.setSelected(null);
        issuerIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CertificationLogs
     * entities that are retrieved from Certifications?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CertificationLogs page
     */
    public String navigateCertificationLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CertificationLogs_items", this.getSelected().getCertificationLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/certificationLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Guarantees entities that
     * are retrieved from Certifications?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Guarantees page
     */
    public String navigateGuaranteesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guarantees_items", this.getSelected().getGuaranteesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guarantees/index";
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBuyerId(ActionEvent event) {
        if (this.getSelected() != null && buyerIdController.getSelected() == null) {
            buyerIdController.setSelected(this.getSelected().getBuyerId());
        }
    }

    /**
     * Sets the "selected" attribute of the GuaranteeTypes controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGuaranteeTypeId(ActionEvent event) {
        if (this.getSelected() != null && guaranteeTypeIdController.getSelected() == null) {
            guaranteeTypeIdController.setSelected(this.getSelected().getGuaranteeTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIssuerId(ActionEvent event) {
        if (this.getSelected() != null && issuerIdController.getSelected() == null) {
            issuerIdController.setSelected(this.getSelected().getIssuerId());
        }
    }
}
