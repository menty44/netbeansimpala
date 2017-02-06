/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "error_log_entries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErrorLogEntries.findAll", query = "SELECT e FROM ErrorLogEntries e"),
    @NamedQuery(name = "ErrorLogEntries.findById", query = "SELECT e FROM ErrorLogEntries e WHERE e.id = :id"),
    @NamedQuery(name = "ErrorLogEntries.findByDate", query = "SELECT e FROM ErrorLogEntries e WHERE e.date = :date"),
    @NamedQuery(name = "ErrorLogEntries.findByPath", query = "SELECT e FROM ErrorLogEntries e WHERE e.path = :path"),
    @NamedQuery(name = "ErrorLogEntries.findByRemoved", query = "SELECT e FROM ErrorLogEntries e WHERE e.removed = :removed")})
public class ErrorLogEntries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removed")
    private boolean removed;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "stack_trace")
    private String stackTrace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "errorLogEntries")
    private Collection<ErrorLogEntryParameters> errorLogEntryParametersCollection;
    @JoinColumn(name = "logged_user_id", referencedColumnName = "id")
    @ManyToOne
    private Users loggedUserId;

    public ErrorLogEntries() {
    }

    public ErrorLogEntries(Integer id) {
        this.id = id;
    }

    public ErrorLogEntries(Integer id, Date date, String path, boolean removed) {
        this.id = id;
        this.date = date;
        this.path = path;
        this.removed = removed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean getRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @XmlTransient
    public Collection<ErrorLogEntryParameters> getErrorLogEntryParametersCollection() {
        return errorLogEntryParametersCollection;
    }

    public void setErrorLogEntryParametersCollection(Collection<ErrorLogEntryParameters> errorLogEntryParametersCollection) {
        this.errorLogEntryParametersCollection = errorLogEntryParametersCollection;
    }

    public Users getLoggedUserId() {
        return loggedUserId;
    }

    public void setLoggedUserId(Users loggedUserId) {
        this.loggedUserId = loggedUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorLogEntries)) {
            return false;
        }
        ErrorLogEntries other = (ErrorLogEntries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ErrorLogEntries[ id=" + id + " ]";
    }
    
}
