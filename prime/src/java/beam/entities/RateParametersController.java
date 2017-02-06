package beam.entities;

import beam.entities.util.MobilePageController;
import entities.RateParameters;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rateParametersController")
@ViewScoped
public class RateParametersController extends AbstractController<RateParameters> {

    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private MobilePageController mobilePageController;

    public RateParametersController() {
        // Inform the Abstract parent controller of the concrete RateParameters Entity
        super(RateParameters.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        currencyIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Currencies entities that
     * are retrieved from RateParameters?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Currencies page
     */
    public String navigateCurrenciesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Currencies_items", this.getSelected().getCurrenciesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/currencies/index";
    }

    /**
     * Sets the "items" attribute with a collection of Currencies entities that
     * are retrieved from RateParameters?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Currencies page
     */
    public String navigateCurrenciesCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Currencies_items", this.getSelected().getCurrenciesCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/currencies/index";
    }

    /**
     * Sets the "items" attribute with a collection of Currencies entities that
     * are retrieved from RateParameters?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Currencies page
     */
    public String navigateCurrenciesCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Currencies_items", this.getSelected().getCurrenciesCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/currencies/index";
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
}
