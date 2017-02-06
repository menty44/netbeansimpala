/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "message_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageCategories.findAll", query = "SELECT m FROM MessageCategories m"),
    @NamedQuery(name = "MessageCategories.findById", query = "SELECT m FROM MessageCategories m WHERE m.id = :id"),
    @NamedQuery(name = "MessageCategories.findByName", query = "SELECT m FROM MessageCategories m WHERE m.name = :name")})
public class MessageCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "can_view_message_categories", joinColumns = {
        @JoinColumn(name = "category_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @JoinTable(name = "admin_preferences_message_categories", joinColumns = {
        @JoinColumn(name = "message_category_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "preference_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection;
    @OneToMany(mappedBy = "categoryId")
    private Collection<Messages> messagesCollection;

    public MessageCategories() {
    }

    public MessageCategories(Integer id) {
        this.id = id;
    }

    public MessageCategories(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<AdminNotificationPreferences> getAdminNotificationPreferencesCollection() {
        return adminNotificationPreferencesCollection;
    }

    public void setAdminNotificationPreferencesCollection(Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection) {
        this.adminNotificationPreferencesCollection = adminNotificationPreferencesCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
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
        if (!(object instanceof MessageCategories)) {
            return false;
        }
        MessageCategories other = (MessageCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessageCategories[ id=" + id + " ]";
    }
    
}
