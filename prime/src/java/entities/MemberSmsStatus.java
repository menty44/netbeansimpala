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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "member_sms_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberSmsStatus.findAll", query = "SELECT m FROM MemberSmsStatus m"),
    @NamedQuery(name = "MemberSmsStatus.findById", query = "SELECT m FROM MemberSmsStatus m WHERE m.id = :id"),
    @NamedQuery(name = "MemberSmsStatus.findByFreeSmsSent", query = "SELECT m FROM MemberSmsStatus m WHERE m.freeSmsSent = :freeSmsSent"),
    @NamedQuery(name = "MemberSmsStatus.findByFreeSmsExpiration", query = "SELECT m FROM MemberSmsStatus m WHERE m.freeSmsExpiration = :freeSmsExpiration"),
    @NamedQuery(name = "MemberSmsStatus.findByPaidSmsLeft", query = "SELECT m FROM MemberSmsStatus m WHERE m.paidSmsLeft = :paidSmsLeft"),
    @NamedQuery(name = "MemberSmsStatus.findByPaidSmsExpiration", query = "SELECT m FROM MemberSmsStatus m WHERE m.paidSmsExpiration = :paidSmsExpiration"),
    @NamedQuery(name = "MemberSmsStatus.findByAllowChargingSms", query = "SELECT m FROM MemberSmsStatus m WHERE m.allowChargingSms = :allowChargingSms"),
    @NamedQuery(name = "MemberSmsStatus.findByAcceptFreeMailing", query = "SELECT m FROM MemberSmsStatus m WHERE m.acceptFreeMailing = :acceptFreeMailing"),
    @NamedQuery(name = "MemberSmsStatus.findByAcceptPaidMailing", query = "SELECT m FROM MemberSmsStatus m WHERE m.acceptPaidMailing = :acceptPaidMailing")})
public class MemberSmsStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "free_sms_sent")
    private int freeSmsSent;
    @Column(name = "free_sms_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date freeSmsExpiration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paid_sms_left")
    private int paidSmsLeft;
    @Column(name = "paid_sms_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidSmsExpiration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allow_charging_sms")
    private boolean allowChargingSms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accept_free_mailing")
    private boolean acceptFreeMailing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accept_paid_mailing")
    private boolean acceptPaidMailing;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Members memberId;

    public MemberSmsStatus() {
    }

    public MemberSmsStatus(Integer id) {
        this.id = id;
    }

    public MemberSmsStatus(Integer id, int freeSmsSent, int paidSmsLeft, boolean allowChargingSms, boolean acceptFreeMailing, boolean acceptPaidMailing) {
        this.id = id;
        this.freeSmsSent = freeSmsSent;
        this.paidSmsLeft = paidSmsLeft;
        this.allowChargingSms = allowChargingSms;
        this.acceptFreeMailing = acceptFreeMailing;
        this.acceptPaidMailing = acceptPaidMailing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFreeSmsSent() {
        return freeSmsSent;
    }

    public void setFreeSmsSent(int freeSmsSent) {
        this.freeSmsSent = freeSmsSent;
    }

    public Date getFreeSmsExpiration() {
        return freeSmsExpiration;
    }

    public void setFreeSmsExpiration(Date freeSmsExpiration) {
        this.freeSmsExpiration = freeSmsExpiration;
    }

    public int getPaidSmsLeft() {
        return paidSmsLeft;
    }

    public void setPaidSmsLeft(int paidSmsLeft) {
        this.paidSmsLeft = paidSmsLeft;
    }

    public Date getPaidSmsExpiration() {
        return paidSmsExpiration;
    }

    public void setPaidSmsExpiration(Date paidSmsExpiration) {
        this.paidSmsExpiration = paidSmsExpiration;
    }

    public boolean getAllowChargingSms() {
        return allowChargingSms;
    }

    public void setAllowChargingSms(boolean allowChargingSms) {
        this.allowChargingSms = allowChargingSms;
    }

    public boolean getAcceptFreeMailing() {
        return acceptFreeMailing;
    }

    public void setAcceptFreeMailing(boolean acceptFreeMailing) {
        this.acceptFreeMailing = acceptFreeMailing;
    }

    public boolean getAcceptPaidMailing() {
        return acceptPaidMailing;
    }

    public void setAcceptPaidMailing(boolean acceptPaidMailing) {
        this.acceptPaidMailing = acceptPaidMailing;
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
        if (!(object instanceof MemberSmsStatus)) {
            return false;
        }
        MemberSmsStatus other = (MemberSmsStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberSmsStatus[ id=" + id + " ]";
    }
    
}
