package converter.entities;

import entities.ErrorLogEntryParameters;
import session.entities.ErrorLogEntryParametersFacade;
import beam.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "errorLogEntryParametersConverter")
public class ErrorLogEntryParametersConverter implements Converter {

    @Inject
    private ErrorLogEntryParametersFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.ErrorLogEntryParametersPK getKey(String value) {
        entities.ErrorLogEntryParametersPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.ErrorLogEntryParametersPK();
        key.setErrorLogEntryId(Integer.parseInt(values[0]));
        key.setName(values[1]);
        return key;
    }

    String getStringKey(entities.ErrorLogEntryParametersPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getErrorLogEntryId());
        sb.append(SEPARATOR);
        sb.append(value.getName());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof ErrorLogEntryParameters) {
            ErrorLogEntryParameters o = (ErrorLogEntryParameters) object;
            return getStringKey(o.getErrorLogEntryParametersPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ErrorLogEntryParameters.class.getName()});
            return null;
        }
    }

}
