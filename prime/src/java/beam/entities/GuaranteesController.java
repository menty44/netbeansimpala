package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Guarantees;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "guaranteesController")
@ViewScoped
public class GuaranteesController extends AbstractController<Guarantees> {

    @Inject
    private CertificationsController certificationIdController;
    @Inject
    private MembersController sellerIdController;
    @Inject
    private MembersController buyerIdController;
    @Inject
    private GuaranteeTypesController guaranteeTypeIdController;
    @Inject
    private MembersController issuerIdController;
    @Inject
    private LoansController loanIdController;
    @Inject
    private MobilePageController mobilePageController;

    public GuaranteesController() {
        // Inform the Abstract parent controller of the concrete Guarantees Entity
        super(Guarantees.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        certificationIdController.setSelected(null);
        sellerIdController.setSelected(null);
        buyerIdController.setSelected(null);
        guaranteeTypeIdController.setSelected(null);
        issuerIdController.setSelected(null);
        loanIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeLogs entities
     * that are retrieved from Guarantees?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GuaranteeLogs page
     */
    public String navigateGuaranteeLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeLogs_items", this.getSelected().getGuaranteeLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeLogs/index";
    }

    /**
     * Sets the "items" attribute with a collection of PaymentObligations
     * entities that are retrieved from Guarantees?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PaymentObligations page
     */
    public String navigatePaymentObligationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaymentObligations_items", this.getSelected().getPaymentObligationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/paymentObligations/index";
    }

    /**
     * Sets the "selected" attribute of the Certifications controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCertificationId(ActionEvent event) {
        if (this.getSelected() != null && certificationIdController.getSelected() == null) {
            certificationIdController.setSelected(this.getSelected().getCertificationId());
        }
    }

    /**
     * Sets the "selected" attribute of the Members controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSellerId(ActionEvent event) {
        if (this.getSelected() != null && sellerIdController.getSelected() == null) {
            sellerIdController.setSelected(this.getSelected().getSellerId());
        }
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

    /**
     * Sets the "selected" attribute of the Loans controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanId(ActionEvent event) {
        if (this.getSelected() != null && loanIdController.getSelected() == null) {
            loanIdController.setSelected(this.getSelected().getLoanId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of CustomFieldValues
     * entities that are retrieved from Guarantees?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CustomFieldValues page
     */
    public String navigateCustomFieldValuesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CustomFieldValues_items", this.getSelected().getCustomFieldValuesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customFieldValues/index";
    }

}
