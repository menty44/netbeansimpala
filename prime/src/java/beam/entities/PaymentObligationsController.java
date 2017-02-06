package beam.entities;

import beam.entities.util.MobilePageController;
import entities.PaymentObligations;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "paymentObligationsController")
@ViewScoped
public class PaymentObligationsController extends AbstractController<PaymentObligations> {

    @Inject
    private GuaranteesController guaranteeIdController;
    @Inject
    private MembersController sellerIdController;
    @Inject
    private MembersController buyerIdController;
    @Inject
    private CurrenciesController currencyIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PaymentObligationsController() {
        // Inform the Abstract parent controller of the concrete PaymentObligations Entity
        super(PaymentObligations.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        guaranteeIdController.setSelected(null);
        sellerIdController.setSelected(null);
        buyerIdController.setSelected(null);
        currencyIdController.setSelected(null);
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
     * Sets the "items" attribute with a collection of PaymentObligationLogs
     * entities that are retrieved from PaymentObligations?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for PaymentObligationLogs page
     */
    public String navigatePaymentObligationLogsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaymentObligationLogs_items", this.getSelected().getPaymentObligationLogsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/paymentObligationLogs/index";
    }

}
