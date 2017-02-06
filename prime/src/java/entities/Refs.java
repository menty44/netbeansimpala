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
import javax.persistence.Lob;
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
@Table(name = "refs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refs.findAll", query = "SELECT r FROM Refs r"),
    @NamedQuery(name = "Refs.findById", query = "SELECT r FROM Refs r WHERE r.id = :id"),
    @NamedQuery(name = "Refs.findBySubclass", query = "SELECT r FROM Refs r WHERE r.subclass = :subclass"),
    @NamedQuery(name = "Refs.findByLevel", query = "SELECT r FROM Refs r WHERE r.level = :level"),
    @NamedQuery(name = "Refs.findByDate", query = "SELECT r FROM Refs r WHERE r.date = :date"),
    @NamedQuery(name = "Refs.findByReplyCommentsDate", query = "SELECT r FROM Refs r WHERE r.replyCommentsDate = :replyCommentsDate"),
    @NamedQuery(name = "Refs.findByAdminCommentsDate", query = "SELECT r FROM Refs r WHERE r.adminCommentsDate = :adminCommentsDate")})
public class Refs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private short level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "comments")
    private String comments;
    @Column(name = "reply_comments_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date replyCommentsDate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "reply_comments")
    private String replyComments;
    @Column(name = "admin_comments_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adminCommentsDate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "admin_comments")
    private String adminComments;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "from_member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members fromMemberId;
    @JoinColumn(name = "to_member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members toMemberId;
    @JoinColumn(name = "scheduled_payment_id", referencedColumnName = "id")
    @ManyToOne
    private ScheduledPayments scheduledPaymentId;

    public Refs() {
    }

    public Refs(Integer id) {
        this.id = id;
    }

    public Refs(Integer id, String subclass, short level, Date date, String comments) {
        this.id = id;
        this.subclass = subclass;
        this.level = level;
        this.date = date;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getReplyCommentsDate() {
        return replyCommentsDate;
    }

    public void setReplyCommentsDate(Date replyCommentsDate) {
        this.replyCommentsDate = replyCommentsDate;
    }

    public String getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(String replyComments) {
        this.replyComments = replyComments;
    }

    public Date getAdminCommentsDate() {
        return adminCommentsDate;
    }

    public void setAdminCommentsDate(Date adminCommentsDate) {
        this.adminCommentsDate = adminCommentsDate;
    }

    public String getAdminComments() {
        return adminComments;
    }

    public void setAdminComments(String adminComments) {
        this.adminComments = adminComments;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public Members getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(Members fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public Members getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(Members toMemberId) {
        this.toMemberId = toMemberId;
    }

    public ScheduledPayments getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(ScheduledPayments scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
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
        if (!(object instanceof Refs)) {
            return false;
        }
        Refs other = (Refs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Refs[ id=" + id + " ]";
    }
    
}
