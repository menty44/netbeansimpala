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
@Table(name = "sms_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmsLogs.findAll", query = "SELECT s FROM SmsLogs s"),
    @NamedQuery(name = "SmsLogs.findById", query = "SELECT s FROM SmsLogs s WHERE s.id = :id"),
    @NamedQuery(name = "SmsLogs.findByDate", query = "SELECT s FROM SmsLogs s WHERE s.date = :date"),
    @NamedQuery(name = "SmsLogs.findByFreeBaseUsed", query = "SELECT s FROM SmsLogs s WHERE s.freeBaseUsed = :freeBaseUsed"),
    @NamedQuery(name = "SmsLogs.findByMessageType", query = "SELECT s FROM SmsLogs s WHERE s.messageType = :messageType"),
    @NamedQuery(name = "SmsLogs.findByErrorType", query = "SELECT s FROM SmsLogs s WHERE s.errorType = :errorType"),
    @NamedQuery(name = "SmsLogs.findByArg0", query = "SELECT s FROM SmsLogs s WHERE s.arg0 = :arg0"),
    @NamedQuery(name = "SmsLogs.findByArg1", query = "SELECT s FROM SmsLogs s WHERE s.arg1 = :arg1"),
    @NamedQuery(name = "SmsLogs.findByArg2", query = "SELECT s FROM SmsLogs s WHERE s.arg2 = :arg2"),
    @NamedQuery(name = "SmsLogs.findByArg3", query = "SELECT s FROM SmsLogs s WHERE s.arg3 = :arg3"),
    @NamedQuery(name = "SmsLogs.findByArg4", query = "SELECT s FROM SmsLogs s WHERE s.arg4 = :arg4")})
public class SmsLogs implements Serializable {

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
    @Column(name = "free_base_used")
    private boolean freeBaseUsed;
    @Size(max = 3)
    @Column(name = "message_type")
    private String messageType;
    @Size(max = 3)
    @Column(name = "error_type")
    private String errorType;
    @Size(max = 150)
    @Column(name = "arg0")
    private String arg0;
    @Size(max = 150)
    @Column(name = "arg1")
    private String arg1;
    @Size(max = 150)
    @Column(name = "arg2")
    private String arg2;
    @Size(max = 150)
    @Column(name = "arg3")
    private String arg3;
    @Size(max = 150)
    @Column(name = "arg4")
    private String arg4;
    @JoinColumn(name = "charged_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members chargedMemberId;
    @JoinColumn(name = "sms_mailing_id", referencedColumnName = "id")
    @ManyToOne
    private SmsMailings smsMailingId;
    @JoinColumn(name = "sms_type_id", referencedColumnName = "id")
    @ManyToOne
    private SmsTypes smsTypeId;
    @JoinColumn(name = "target_member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members targetMemberId;

    public SmsLogs() {
    }

    public SmsLogs(Integer id) {
        this.id = id;
    }

    public SmsLogs(Integer id, Date date, boolean freeBaseUsed) {
        this.id = id;
        this.date = date;
        this.freeBaseUsed = freeBaseUsed;
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

    public boolean getFreeBaseUsed() {
        return freeBaseUsed;
    }

    public void setFreeBaseUsed(boolean freeBaseUsed) {
        this.freeBaseUsed = freeBaseUsed;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getArg4() {
        return arg4;
    }

    public void setArg4(String arg4) {
        this.arg4 = arg4;
    }

    public Members getChargedMemberId() {
        return chargedMemberId;
    }

    public void setChargedMemberId(Members chargedMemberId) {
        this.chargedMemberId = chargedMemberId;
    }

    public SmsMailings getSmsMailingId() {
        return smsMailingId;
    }

    public void setSmsMailingId(SmsMailings smsMailingId) {
        this.smsMailingId = smsMailingId;
    }

    public SmsTypes getSmsTypeId() {
        return smsTypeId;
    }

    public void setSmsTypeId(SmsTypes smsTypeId) {
        this.smsTypeId = smsTypeId;
    }

    public Members getTargetMemberId() {
        return targetMemberId;
    }

    public void setTargetMemberId(Members targetMemberId) {
        this.targetMemberId = targetMemberId;
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
        if (!(object instanceof SmsLogs)) {
            return false;
        }
        SmsLogs other = (SmsLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SmsLogs[ id=" + id + " ]";
    }
    
}
