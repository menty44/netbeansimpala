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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "sms_mailings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmsMailings.findAll", query = "SELECT s FROM SmsMailings s"),
    @NamedQuery(name = "SmsMailings.findById", query = "SELECT s FROM SmsMailings s WHERE s.id = :id"),
    @NamedQuery(name = "SmsMailings.findByDate", query = "SELECT s FROM SmsMailings s WHERE s.date = :date"),
    @NamedQuery(name = "SmsMailings.findByText", query = "SELECT s FROM SmsMailings s WHERE s.text = :text"),
    @NamedQuery(name = "SmsMailings.findByFree", query = "SELECT s FROM SmsMailings s WHERE s.free = :free"),
    @NamedQuery(name = "SmsMailings.findBySentSms", query = "SELECT s FROM SmsMailings s WHERE s.sentSms = :sentSms"),
    @NamedQuery(name = "SmsMailings.findByFinished", query = "SELECT s FROM SmsMailings s WHERE s.finished = :finished")})
public class SmsMailings implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "free")
    private boolean free;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sent_sms")
    private int sentSms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finished")
    private boolean finished;
    @JoinTable(name = "sms_mailings_pending_to_send", joinColumns = {
        @JoinColumn(name = "sms_mailing_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Members> membersCollection;
    @JoinTable(name = "sms_mailings_groups", joinColumns = {
        @JoinColumn(name = "sms_mailing_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @OneToMany(mappedBy = "smsMailingId")
    private Collection<SmsLogs> smsLogsCollection;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members byId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;

    public SmsMailings() {
    }

    public SmsMailings(Integer id) {
        this.id = id;
    }

    public SmsMailings(Integer id, Date date, String text, boolean free, int sentSms, boolean finished) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.free = free;
        this.sentSms = sentSms;
        this.finished = finished;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getSentSms() {
        return sentSms;
    }

    public void setSentSms(int sentSms) {
        this.sentSms = sentSms;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @XmlTransient
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<SmsLogs> getSmsLogsCollection() {
        return smsLogsCollection;
    }

    public void setSmsLogsCollection(Collection<SmsLogs> smsLogsCollection) {
        this.smsLogsCollection = smsLogsCollection;
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
        if (!(object instanceof SmsMailings)) {
            return false;
        }
        SmsMailings other = (SmsMailings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SmsMailings[ id=" + id + " ]";
    }
    
}
