/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "error_log_entry_parameters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErrorLogEntryParameters.findAll", query = "SELECT e FROM ErrorLogEntryParameters e"),
    @NamedQuery(name = "ErrorLogEntryParameters.findByErrorLogEntryId", query = "SELECT e FROM ErrorLogEntryParameters e WHERE e.errorLogEntryParametersPK.errorLogEntryId = :errorLogEntryId"),
    @NamedQuery(name = "ErrorLogEntryParameters.findByName", query = "SELECT e FROM ErrorLogEntryParameters e WHERE e.errorLogEntryParametersPK.name = :name")})
public class ErrorLogEntryParameters implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErrorLogEntryParametersPK errorLogEntryParametersPK;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "error_log_entry_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ErrorLogEntries errorLogEntries;

    public ErrorLogEntryParameters() {
    }

    public ErrorLogEntryParameters(ErrorLogEntryParametersPK errorLogEntryParametersPK) {
        this.errorLogEntryParametersPK = errorLogEntryParametersPK;
    }

    public ErrorLogEntryParameters(int errorLogEntryId, String name) {
        this.errorLogEntryParametersPK = new ErrorLogEntryParametersPK(errorLogEntryId, name);
    }

    public ErrorLogEntryParametersPK getErrorLogEntryParametersPK() {
        return errorLogEntryParametersPK;
    }

    public void setErrorLogEntryParametersPK(ErrorLogEntryParametersPK errorLogEntryParametersPK) {
        this.errorLogEntryParametersPK = errorLogEntryParametersPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ErrorLogEntries getErrorLogEntries() {
        return errorLogEntries;
    }

    public void setErrorLogEntries(ErrorLogEntries errorLogEntries) {
        this.errorLogEntries = errorLogEntries;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorLogEntryParametersPK != null ? errorLogEntryParametersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorLogEntryParameters)) {
            return false;
        }
        ErrorLogEntryParameters other = (ErrorLogEntryParameters) object;
        if ((this.errorLogEntryParametersPK == null && other.errorLogEntryParametersPK != null) || (this.errorLogEntryParametersPK != null && !this.errorLogEntryParametersPK.equals(other.errorLogEntryParametersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ErrorLogEntryParameters[ errorLogEntryParametersPK=" + errorLogEntryParametersPK + " ]";
    }
    
}
