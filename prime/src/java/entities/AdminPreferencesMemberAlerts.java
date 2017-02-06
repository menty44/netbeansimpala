/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "admin_preferences_member_alerts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminPreferencesMemberAlerts.findAll", query = "SELECT a FROM AdminPreferencesMemberAlerts a"),
    @NamedQuery(name = "AdminPreferencesMemberAlerts.findByPreferenceId", query = "SELECT a FROM AdminPreferencesMemberAlerts a WHERE a.adminPreferencesMemberAlertsPK.preferenceId = :preferenceId"),
    @NamedQuery(name = "AdminPreferencesMemberAlerts.findByType", query = "SELECT a FROM AdminPreferencesMemberAlerts a WHERE a.adminPreferencesMemberAlertsPK.type = :type")})
public class AdminPreferencesMemberAlerts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdminPreferencesMemberAlertsPK adminPreferencesMemberAlertsPK;
    @JoinColumn(name = "preference_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AdminNotificationPreferences adminNotificationPreferences;

    public AdminPreferencesMemberAlerts() {
    }

    public AdminPreferencesMemberAlerts(AdminPreferencesMemberAlertsPK adminPreferencesMemberAlertsPK) {
        this.adminPreferencesMemberAlertsPK = adminPreferencesMemberAlertsPK;
    }

    public AdminPreferencesMemberAlerts(int preferenceId, String type) {
        this.adminPreferencesMemberAlertsPK = new AdminPreferencesMemberAlertsPK(preferenceId, type);
    }

    public AdminPreferencesMemberAlertsPK getAdminPreferencesMemberAlertsPK() {
        return adminPreferencesMemberAlertsPK;
    }

    public void setAdminPreferencesMemberAlertsPK(AdminPreferencesMemberAlertsPK adminPreferencesMemberAlertsPK) {
        this.adminPreferencesMemberAlertsPK = adminPreferencesMemberAlertsPK;
    }

    public AdminNotificationPreferences getAdminNotificationPreferences() {
        return adminNotificationPreferences;
    }

    public void setAdminNotificationPreferences(AdminNotificationPreferences adminNotificationPreferences) {
        this.adminNotificationPreferences = adminNotificationPreferences;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminPreferencesMemberAlertsPK != null ? adminPreferencesMemberAlertsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminPreferencesMemberAlerts)) {
            return false;
        }
        AdminPreferencesMemberAlerts other = (AdminPreferencesMemberAlerts) object;
        if ((this.adminPreferencesMemberAlertsPK == null && other.adminPreferencesMemberAlertsPK != null) || (this.adminPreferencesMemberAlertsPK != null && !this.adminPreferencesMemberAlertsPK.equals(other.adminPreferencesMemberAlertsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdminPreferencesMemberAlerts[ adminPreferencesMemberAlertsPK=" + adminPreferencesMemberAlertsPK + " ]";
    }
    
}
