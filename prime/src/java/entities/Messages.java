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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id"),
    @NamedQuery(name = "Messages.findByDate", query = "SELECT m FROM Messages m WHERE m.date = :date"),
    @NamedQuery(name = "Messages.findBySubject", query = "SELECT m FROM Messages m WHERE m.subject = :subject"),
    @NamedQuery(name = "Messages.findByType", query = "SELECT m FROM Messages m WHERE m.type = :type"),
    @NamedQuery(name = "Messages.findByDirection", query = "SELECT m FROM Messages m WHERE m.direction = :direction"),
    @NamedQuery(name = "Messages.findByIsRead", query = "SELECT m FROM Messages m WHERE m.isRead = :isRead"),
    @NamedQuery(name = "Messages.findByIsReplied", query = "SELECT m FROM Messages m WHERE m.isReplied = :isReplied"),
    @NamedQuery(name = "Messages.findByIsHtml", query = "SELECT m FROM Messages m WHERE m.isHtml = :isHtml"),
    @NamedQuery(name = "Messages.findByRemovedAt", query = "SELECT m FROM Messages m WHERE m.removedAt = :removedAt"),
    @NamedQuery(name = "Messages.findByEmailSent", query = "SELECT m FROM Messages m WHERE m.emailSent = :emailSent")})
public class Messages implements Serializable {

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
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "direction")
    private String direction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_read")
    private boolean isRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_replied")
    private boolean isReplied;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_html")
    private boolean isHtml;
    @Column(name = "removed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date removedAt;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email_sent")
    private boolean emailSent;
    @JoinTable(name = "messages_to_groups", joinColumns = {
        @JoinColumn(name = "message_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private MessageCategories categoryId;
    @JoinColumn(name = "from_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members fromMemberId;
    @JoinColumn(name = "to_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members toMemberId;

    public Messages() {
    }

    public Messages(Integer id) {
        this.id = id;
    }

    public Messages(Integer id, Date date, String subject, String type, String direction, boolean isRead, boolean isReplied, boolean isHtml, boolean emailSent) {
        this.id = id;
        this.date = date;
        this.subject = subject;
        this.type = type;
        this.direction = direction;
        this.isRead = isRead;
        this.isReplied = isReplied;
        this.isHtml = isHtml;
        this.emailSent = emailSent;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(boolean isReplied) {
        this.isReplied = isReplied;
    }

    public boolean getIsHtml() {
        return isHtml;
    }

    public void setIsHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    public Date getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(Date removedAt) {
        this.removedAt = removedAt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    public MessageCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(MessageCategories categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Messages[ id=" + id + " ]";
    }
    
}
