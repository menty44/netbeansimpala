package converter.entities;

import entities.OperatorGroupsMaxAmount;
import session.entities.OperatorGroupsMaxAmountFacade;
import beam.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "operatorGroupsMaxAmountConverter")
public class OperatorGroupsMaxAmountConverter implements Converter {

    @Inject
    private OperatorGroupsMaxAmountFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.OperatorGroupsMaxAmountPK getKey(String value) {
        entities.OperatorGroupsMaxAmountPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.OperatorGroupsMaxAmountPK();
        key.setGroupId(Integer.parseInt(values[0]));
        key.setTransferTypeId(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.OperatorGroupsMaxAmountPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getGroupId());
        sb.append(SEPARATOR);
        sb.append(value.getTransferTypeId());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof OperatorGroupsMaxAmount) {
            OperatorGroupsMaxAmount o = (OperatorGroupsMaxAmount) object;
            return getStringKey(o.getOperatorGroupsMaxAmountPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OperatorGroupsMaxAmount.class.getName()});
            return null;
        }
    }

}
