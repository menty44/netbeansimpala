package beam.entities;

import beam.entities.util.MobilePageController;
import entities.CardTypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "cardTypesController")
@ViewScoped
public class CardTypesController extends AbstractController<CardTypes> {

    @Inject
    private MobilePageController mobilePageController;

    public CardTypesController() {
        // Inform the Abstract parent controller of the concrete CardTypes Entity
        super(CardTypes.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cards entities that are
     * retrieved from CardTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cards page
     */
    public String navigateCardsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cards_items", this.getSelected().getCardsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cards/index";
    }

    /**
     * Sets the "items" attribute with a collection of Groups entities that are
     * retrieved from CardTypes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Groups page
     */
    public String navigateGroupsCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Groups_items", this.getSelected().getGroupsCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/groups/index";
    }

}
