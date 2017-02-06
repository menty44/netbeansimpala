package converter.entities;

import entities.Permissions;
import session.entities.PermissionsFacade;
import beam.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "permissionsConverter")
public class PermissionsConverter implements Converter {

    @Inject
    private PermissionsFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.PermissionsPK getKey(String value) {
        entities.PermissionsPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.PermissionsPK();
        key.setGroupId(Integer.parseInt(values[0]));
        key.setPermission(values[1]);
        return key;
    }

    String getStringKey(entities.PermissionsPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getGroupId());
        sb.append(SEPARATOR);
        sb.append(value.getPermission());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Permissions) {
            Permissions o = (Permissions) object;
            return getStringKey(o.getPermissionsPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Permissions.class.getName()});
            return null;
        }
    }

}
