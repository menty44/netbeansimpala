/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "notification_preferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationPreferences.findAll", query = "SELECT n FROM NotificationPreferences n"),
    @NamedQuery(name = "NotificationPreferences.findById", query = "SELECT n FROM NotificationPreferences n WHERE n.id = :id"),
    @NamedQuery(name = "NotificationPreferences.findByType", query = "SELECT n FROM NotificationPreferences n WHERE n.type = :type"),
    @NamedQuery(name = "NotificationPreferences.findByIsMessage", query = "SELECT n FROM NotificationPreferences n WHERE n.isMessage = :isMessage"),
    @NamedQuery(name = "NotificationPreferences.findByIsEmail", query = "SELECT n FROM NotificationPreferences n WHERE n.isEmail = :isEmail"),
    @NamedQuery(name = "NotificationPreferences.findByIsSms", query = "SELECT n FROM NotificationPreferences n WHERE n.isSms = :isSms")})
public class NotificationPreferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_message")
    private boolean isMessage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_email")
    private boolean isEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_sms")
    private boolean isSms;
    @JoinColumn(name = "member", referencedColumnName = "id")
    @ManyToOne
    private Members member1;

    public NotificationPreferences() {
    }

    public NotificationPreferences(Integer id) {
        this.id = id;
    }

    public NotificationPreferences(Integer id, String type, boolean isMessage, boolean isEmail, boolean isSms) {
        this.id = id;
        this.type = type;
        this.isMessage = isMessage;
        this.isEmail = isEmail;
        this.isSms = isSms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsMessage() {
        return isMessage;
    }

    public void setIsMessage(boolean isMessage) {
        this.isMessage = isMessage;
    }

    public boolean getIsEmail() {
        return isEmail;
    }

    public void setIsEmail(boolean isEmail) {
        this.isEmail = isEmail;
    }

    public boolean getIsSms() {
        return isSms;
    }

    public void setIsSms(boolean isSms) {
        this.isSms = isSms;
    }

    public Members getMember1() {
        return member1;
    }

    public void setMember1(Members member1) {
        this.member1 = member1;
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
        if (!(object instanceof NotificationPreferences)) {
            return false;
        }
        NotificationPreferences other = (NotificationPreferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotificationPreferences[ id=" + id + " ]";
    }
    
}
