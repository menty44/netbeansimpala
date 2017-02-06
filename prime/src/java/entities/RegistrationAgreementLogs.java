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
@Table(name = "registration_agreement_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrationAgreementLogs.findAll", query = "SELECT r FROM RegistrationAgreementLogs r"),
    @NamedQuery(name = "RegistrationAgreementLogs.findById", query = "SELECT r FROM RegistrationAgreementLogs r WHERE r.id = :id"),
    @NamedQuery(name = "RegistrationAgreementLogs.findByDate", query = "SELECT r FROM RegistrationAgreementLogs r WHERE r.date = :date"),
    @NamedQuery(name = "RegistrationAgreementLogs.findByRemoteAddress", query = "SELECT r FROM RegistrationAgreementLogs r WHERE r.remoteAddress = :remoteAddress")})
public class RegistrationAgreementLogs implements Serializable {

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
    @Size(max = 100)
    @Column(name = "remote_address")
    private String remoteAddress;
    @JoinColumn(name = "registration_agreement_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RegistrationAgreements registrationAgreementId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members memberId;

    public RegistrationAgreementLogs() {
    }

    public RegistrationAgreementLogs(Integer id) {
        this.id = id;
    }

    public RegistrationAgreementLogs(Integer id, Date date) {
        this.id = id;
        this.date = date;
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

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public RegistrationAgreements getRegistrationAgreementId() {
        return registrationAgreementId;
    }

    public void setRegistrationAgreementId(RegistrationAgreements registrationAgreementId) {
        this.registrationAgreementId = registrationAgreementId;
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
        if (!(object instanceof RegistrationAgreementLogs)) {
            return false;
        }
        RegistrationAgreementLogs other = (RegistrationAgreementLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RegistrationAgreementLogs[ id=" + id + " ]";
    }
    
}
