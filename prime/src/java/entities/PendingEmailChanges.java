/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "pending_email_changes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PendingEmailChanges.findAll", query = "SELECT p FROM PendingEmailChanges p"),
    @NamedQuery(name = "PendingEmailChanges.findById", query = "SELECT p FROM PendingEmailChanges p WHERE p.id = :id"),
    @NamedQuery(name = "PendingEmailChanges.findByCreationDate", query = "SELECT p FROM PendingEmailChanges p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "PendingEmailChanges.findByNewEmail", query = "SELECT p FROM PendingEmailChanges p WHERE p.newEmail = :newEmail"),
    @NamedQuery(name = "PendingEmailChanges.findByValidationKey", query = "SELECT p FROM PendingEmailChanges p WHERE p.validationKey = :validationKey"),
    @NamedQuery(name = "PendingEmailChanges.findByLastEmailDate", query = "SELECT p FROM PendingEmailChanges p WHERE p.lastEmailDate = :lastEmailDate"),
    @NamedQuery(name = "PendingEmailChanges.findByRemoteAddress", query = "SELECT p FROM PendingEmailChanges p WHERE p.remoteAddress = :remoteAddress")})
public class PendingEmailChanges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "new_email")
    private String newEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "validation_key")
    private String validationKey;
    @Column(name = "last_email_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEmailDate;
    @Size(max = 100)
    @Column(name = "remote_address")
    private String remoteAddress;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members memberId;

    public PendingEmailChanges() {
    }

    public PendingEmailChanges(Integer id) {
        this.id = id;
    }

    public PendingEmailChanges(Integer id, Date creationDate, String newEmail, String validationKey) {
        this.id = id;
        this.creationDate = creationDate;
        this.newEmail = newEmail;
        this.validationKey = validationKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getValidationKey() {
        return validationKey;
    }

    public void setValidationKey(String validationKey) {
        this.validationKey = validationKey;
    }

    public Date getLastEmailDate() {
        return lastEmailDate;
    }

    public void setLastEmailDate(Date lastEmailDate) {
        this.lastEmailDate = lastEmailDate;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
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
        if (!(object instanceof PendingEmailChanges)) {
            return false;
        }
        PendingEmailChanges other = (PendingEmailChanges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PendingEmailChanges[ id=" + id + " ]";
    }
    
}
