package beam.entities;

import beam.entities.util.MobilePageController;
import entities.GuaranteeTypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "guaranteeTypesController")
@ViewScoped
public class GuaranteeTypesController extends AbstractController<GuaranteeTypes> {

    @Inject
    private TransferTypesController creditFeeTransferTypeIdController;
    @Inject
    private TransferTypesController issueFeeTransferTypeIdController;
    @Inject
    private TransferTypesController loanTransferTypeIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private TransferTypesController forwardTransferTypeIdController;
    @Inject
    private MobilePageController mobilePageController;

    public GuaranteeTypesController() {
        // Inform the Abstract parent controller of the concrete GuaranteeTypes Entity
        super(GuaranteeTypes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        creditFeeTransferTypeIdController.setSelected(null);
        issueFeeTransferTypeIdController.setSelected(null);
        loanTransferTypeIdController.setSelected(null);
        currencyIdController.setSelected(null);
        forwardTransferTypeIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from GuaranteeTypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

    /**
     * Sets the "items" attribute with a collection of
     * AdminNotificationPreferences entities that are retrieved from
     * GuaranteeTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AdminNotificationPreferences page
     */
    public String navigateAdminNotificationPreferencesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdminNotificationPreferences_items", this.getSelected().getAdminNotificationPreferencesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adminNotificationPreferences/index";
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCreditFeeTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && creditFeeTransferTypeIdController.getSelected() == null) {
            creditFeeTransferTypeIdController.setSelected(this.getSelected().getCreditFeeTransferTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIssueFeeTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && issueFeeTransferTypeIdController.getSelected() == null) {
            issueFeeTransferTypeIdController.setSelected(this.getSelected().getIssueFeeTransferTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLoanTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && loanTransferTypeIdController.getSelected() == null) {
            loanTransferTypeIdController.setSelected(this.getSelected().getLoanTransferTypeId());
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
     * Sets the "selected" attribute of the TransferTypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareForwardTransferTypeId(ActionEvent event) {
        if (this.getSelected() != null && forwardTransferTypeIdController.getSelected() == null) {
            forwardTransferTypeIdController.setSelected(this.getSelected().getForwardTransferTypeId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Guarantees entities that
     * are retrieved from GuaranteeTypes?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Certifications entities
     * that are retrieved from GuaranteeTypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Certifications page
     */
    public String navigateCertificationsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Certifications_items", this.getSelected().getCertificationsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/certifications/index";
    }

}
