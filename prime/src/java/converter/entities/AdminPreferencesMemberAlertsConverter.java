package converter.entities;

import entities.AdminPreferencesMemberAlerts;
import session.entities.AdminPreferencesMemberAlertsFacade;
import beam.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "adminPreferencesMemberAlertsConverter")
public class AdminPreferencesMemberAlertsConverter implements Converter {

    @Inject
    private AdminPreferencesMemberAlertsFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.AdminPreferencesMemberAlertsPK getKey(String value) {
        entities.AdminPreferencesMemberAlertsPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.AdminPreferencesMemberAlertsPK();
        key.setPreferenceId(Integer.parseInt(values[0]));
        key.setType(values[1]);
        return key;
    }

    String getStringKey(entities.AdminPreferencesMemberAlertsPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getPreferenceId());
        sb.append(SEPARATOR);
        sb.append(value.getType());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof AdminPreferencesMemberAlerts) {
            AdminPreferencesMemberAlerts o = (AdminPreferencesMemberAlerts) object;
            return getStringKey(o.getAdminPreferencesMemberAlertsPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AdminPreferencesMemberAlerts.class.getName()});
            return null;
        }
    }

}
