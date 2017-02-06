package converter.entities;

import entities.ServiceClientPermissions;
import session.entities.ServiceClientPermissionsFacade;
import beam.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "serviceClientPermissionsConverter")
public class ServiceClientPermissionsConverter implements Converter {

    @Inject
    private ServiceClientPermissionsFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.ServiceClientPermissionsPK getKey(String value) {
        entities.ServiceClientPermissionsPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.ServiceClientPermissionsPK();
        key.setServiceClientId(Integer.parseInt(values[0]));
        key.setOperation(values[1]);
        return key;
    }

    String getStringKey(entities.ServiceClientPermissionsPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getServiceClientId());
        sb.append(SEPARATOR);
        sb.append(value.getOperation());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof ServiceClientPermissions) {
            ServiceClientPermissions o = (ServiceClientPermissions) object;
            return getStringKey(o.getServiceClientPermissionsPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServiceClientPermissions.class.getName()});
            return null;
        }
    }

}
