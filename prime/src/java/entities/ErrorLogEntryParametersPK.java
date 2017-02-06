/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fred
 */
@Embeddable
public class ErrorLogEntryParametersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "error_log_entry_id")
    private int errorLogEntryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    public ErrorLogEntryParametersPK() {
    }

    public ErrorLogEntryParametersPK(int errorLogEntryId, String name) {
        this.errorLogEntryId = errorLogEntryId;
        this.name = name;
    }

    public int getErrorLogEntryId() {
        return errorLogEntryId;
    }

    public void setErrorLogEntryId(int errorLogEntryId) {
        this.errorLogEntryId = errorLogEntryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) errorLogEntryId;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorLogEntryParametersPK)) {
            return false;
        }
        ErrorLogEntryParametersPK other = (ErrorLogEntryParametersPK) object;
        if (this.errorLogEntryId != other.errorLogEntryId) {
            return false;
        }
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ErrorLogEntryParametersPK[ errorLogEntryId=" + errorLogEntryId + ", name=" + name + " ]";
    }
    
}
