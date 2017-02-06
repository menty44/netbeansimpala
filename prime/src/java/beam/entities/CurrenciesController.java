package beam.entities;

import beam.entities.util.MobilePageController;
import entities.Currencies;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "currenciesController")
@ViewScoped
public class CurrenciesController extends AbstractController<Currencies> {

    @Inject
    private RateParametersController aRateParamsIdController;
    @Inject
    private RateParametersController dRateParamsIdController;
    @Inject
    private RateParametersController iRateParamsIdController;
    @Inject
    private MobilePageController mobilePageController;

    public CurrenciesController() {
        // Inform the Abstract parent controller of the concrete Currencies Entity
        super(Currencies.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        aRateParamsIdController.setSelected(null);
        dRateParamsIdController.setSelected(null);
        iRateParamsIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of GuaranteeTypes entities
     * that are retrieved from Currencies?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GuaranteeTypes page
     */
    public String navigateGuaranteeTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuaranteeTypes_items", this.getSelected().getGuaranteeTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guaranteeTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of AccountTypes entities
     * that are retrieved from Currencies?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AccountTypes page
     */
    public String navigateAccountTypesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AccountTypes_items", this.getSelected().getAccountTypesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/accountTypes/index";
    }

    /**
     * Sets the "items" attribute with a collection of PaymentObligations
     * entities that are retrieved from Currencies?cap_first and returns the
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
     * Sets the "selected" attribute of the RateParameters controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareARateParamsId(ActionEvent event) {
        if (this.getSelected() != null && aRateParamsIdController.getSelected() == null) {
            aRateParamsIdController.setSelected(this.getSelected().getARateParamsId());
        }
    }

    /**
     * Sets the "selected" attribute of the RateParameters controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDRateParamsId(ActionEvent event) {
        if (this.getSelected() != null && dRateParamsIdController.getSelected() == null) {
            dRateParamsIdController.setSelected(this.getSelected().getDRateParamsId());
        }
    }

    /**
     * Sets the "selected" attribute of the RateParameters controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIRateParamsId(ActionEvent event) {
        if (this.getSelected() != null && iRateParamsIdController.getSelected() == null) {
            iRateParamsIdController.setSelected(this.getSelected().getIRateParamsId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ads entities that are
     * retrieved from Currencies?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Ads page
     */
    public String navigateAdsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ads_items", this.getSelected().getAdsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ads/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdInterests entities that
     * are retrieved from Currencies?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AdInterests page
     */
    public String navigateAdInterestsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdInterests_items", this.getSelected().getAdInterestsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adInterests/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdImports entities that
     * are retrieved from Currencies?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AdImports page
     */
    public String navigateAdImportsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdImports_items", this.getSelected().getAdImportsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/adImports/index";
    }

    /**
     * Sets the "items" attribute with a collection of RateParameters entities
     * that are retrieved from Currencies?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RateParameters page
     */
    public String navigateRateParametersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RateParameters_items", this.getSelected().getRateParametersCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/rateParameters/index";
    }

    /**
     * Sets the "items" attribute with a collection of Tickets entities that are
     * retrieved from Currencies?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Tickets page
     */
    public String navigateTicketsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tickets_items", this.getSelected().getTicketsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tickets/index";
    }

}
