/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "admin_notification_preferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminNotificationPreferences.findAll", query = "SELECT a FROM AdminNotificationPreferences a"),
    @NamedQuery(name = "AdminNotificationPreferences.findById", query = "SELECT a FROM AdminNotificationPreferences a WHERE a.id = :id"),
    @NamedQuery(name = "AdminNotificationPreferences.findByApplicationErrors", query = "SELECT a FROM AdminNotificationPreferences a WHERE a.applicationErrors = :applicationErrors"),
    @NamedQuery(name = "AdminNotificationPreferences.findBySystemInvoices", query = "SELECT a FROM AdminNotificationPreferences a WHERE a.systemInvoices = :systemInvoices")})
public class AdminNotificationPreferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "application_errors")
    private boolean applicationErrors;
    @Basic(optional = false)
    @NotNull
    @Column(name = "system_invoices")
    private boolean systemInvoices;
    @ManyToMany(mappedBy = "adminNotificationPreferencesCollection")
    private Collection<TransferTypes> transferTypesCollection;
    @ManyToMany(mappedBy = "adminNotificationPreferencesCollection1")
    private Collection<TransferTypes> transferTypesCollection1;
    @ManyToMany(mappedBy = "adminNotificationPreferencesCollection")
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "adminNotificationPreferencesCollection")
    private Collection<MessageCategories> messageCategoriesCollection;
    @ManyToMany(mappedBy = "adminNotificationPreferencesCollection")
    private Collection<GuaranteeTypes> guaranteeTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminNotificationPreferences")
    private Collection<AdminPreferencesMemberAlerts> adminPreferencesMemberAlertsCollection;
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @ManyToOne
    private Members adminId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminNotificationPreferences")
    private Collection<AdminPreferencesSystemAlerts> adminPreferencesSystemAlertsCollection;

    public AdminNotificationPreferences() {
    }

    public AdminNotificationPreferences(Integer id) {
        this.id = id;
    }

    public AdminNotificationPreferences(Integer id, boolean applicationErrors, boolean systemInvoices) {
        this.id = id;
        this.applicationErrors = applicationErrors;
        this.systemInvoices = systemInvoices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getApplicationErrors() {
        return applicationErrors;
    }

    public void setApplicationErrors(boolean applicationErrors) {
        this.applicationErrors = applicationErrors;
    }

    public boolean getSystemInvoices() {
        return systemInvoices;
    }

    public void setSystemInvoices(boolean systemInvoices) {
        this.systemInvoices = systemInvoices;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection1() {
        return transferTypesCollection1;
    }

    public void setTransferTypesCollection1(Collection<TransferTypes> transferTypesCollection1) {
        this.transferTypesCollection1 = transferTypesCollection1;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<MessageCategories> getMessageCategoriesCollection() {
        return messageCategoriesCollection;
    }

    public void setMessageCategoriesCollection(Collection<MessageCategories> messageCategoriesCollection) {
        this.messageCategoriesCollection = messageCategoriesCollection;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection() {
        return guaranteeTypesCollection;
    }

    public void setGuaranteeTypesCollection(Collection<GuaranteeTypes> guaranteeTypesCollection) {
        this.guaranteeTypesCollection = guaranteeTypesCollection;
    }

    @XmlTransient
    public Collection<AdminPreferencesMemberAlerts> getAdminPreferencesMemberAlertsCollection() {
        return adminPreferencesMemberAlertsCollection;
    }

    public void setAdminPreferencesMemberAlertsCollection(Collection<AdminPreferencesMemberAlerts> adminPreferencesMemberAlertsCollection) {
        this.adminPreferencesMemberAlertsCollection = adminPreferencesMemberAlertsCollection;
    }

    public Members getAdminId() {
        return adminId;
    }

    public void setAdminId(Members adminId) {
        this.adminId = adminId;
    }

    @XmlTransient
    public Collection<AdminPreferencesSystemAlerts> getAdminPreferencesSystemAlertsCollection() {
        return adminPreferencesSystemAlertsCollection;
    }

    public void setAdminPreferencesSystemAlertsCollection(Collection<AdminPreferencesSystemAlerts> adminPreferencesSystemAlertsCollection) {
        this.adminPreferencesSystemAlertsCollection = adminPreferencesSystemAlertsCollection;
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
        if (!(object instanceof AdminNotificationPreferences)) {
            return false;
        }
        AdminNotificationPreferences other = (AdminNotificationPreferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdminNotificationPreferences[ id=" + id + " ]";
    }
    
}
