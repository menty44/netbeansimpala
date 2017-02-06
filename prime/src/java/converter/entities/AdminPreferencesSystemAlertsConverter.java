package converter.entities;

import entities.AdminPreferencesSystemAlerts;
import session.entities.AdminPreferencesSystemAlertsFacade;
import beam.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "adminPreferencesSystemAlertsConverter")
public class AdminPreferencesSystemAlertsConverter implements Converter {

    @Inject
    private AdminPreferencesSystemAlertsFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.AdminPreferencesSystemAlertsPK getKey(String value) {
        entities.AdminPreferencesSystemAlertsPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.AdminPreferencesSystemAlertsPK();
        key.setPreferenceId(Integer.parseInt(values[0]));
        key.setType(values[1]);
        return key;
    }

    String getStringKey(entities.AdminPreferencesSystemAlertsPK value) {
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
        if (object instanceof AdminPreferencesSystemAlerts) {
            AdminPreferencesSystemAlerts o = (AdminPreferencesSystemAlerts) object;
            return getStringKey(o.getAdminPreferencesSystemAlertsPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AdminPreferencesSystemAlerts.class.getName()});
            return null;
        }
    }

}
