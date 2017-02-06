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
@Table(name = "admin_preferences_system_alerts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminPreferencesSystemAlerts.findAll", query = "SELECT a FROM AdminPreferencesSystemAlerts a"),
    @NamedQuery(name = "AdminPreferencesSystemAlerts.findByPreferenceId", query = "SELECT a FROM AdminPreferencesSystemAlerts a WHERE a.adminPreferencesSystemAlertsPK.preferenceId = :preferenceId"),
    @NamedQuery(name = "AdminPreferencesSystemAlerts.findByType", query = "SELECT a FROM AdminPreferencesSystemAlerts a WHERE a.adminPreferencesSystemAlertsPK.type = :type")})
public class AdminPreferencesSystemAlerts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdminPreferencesSystemAlertsPK adminPreferencesSystemAlertsPK;
    @JoinColumn(name = "preference_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AdminNotificationPreferences adminNotificationPreferences;

    public AdminPreferencesSystemAlerts() {
    }

    public AdminPreferencesSystemAlerts(AdminPreferencesSystemAlertsPK adminPreferencesSystemAlertsPK) {
        this.adminPreferencesSystemAlertsPK = adminPreferencesSystemAlertsPK;
    }

    public AdminPreferencesSystemAlerts(int preferenceId, String type) {
        this.adminPreferencesSystemAlertsPK = new AdminPreferencesSystemAlertsPK(preferenceId, type);
    }

    public AdminPreferencesSystemAlertsPK getAdminPreferencesSystemAlertsPK() {
        return adminPreferencesSystemAlertsPK;
    }

    public void setAdminPreferencesSystemAlertsPK(AdminPreferencesSystemAlertsPK adminPreferencesSystemAlertsPK) {
        this.adminPreferencesSystemAlertsPK = adminPreferencesSystemAlertsPK;
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
        hash += (adminPreferencesSystemAlertsPK != null ? adminPreferencesSystemAlertsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminPreferencesSystemAlerts)) {
            return false;
        }
        AdminPreferencesSystemAlerts other = (AdminPreferencesSystemAlerts) object;
        if ((this.adminPreferencesSystemAlertsPK == null && other.adminPreferencesSystemAlertsPK != null) || (this.adminPreferencesSystemAlertsPK != null && !this.adminPreferencesSystemAlertsPK.equals(other.adminPreferencesSystemAlertsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdminPreferencesSystemAlerts[ adminPreferencesSystemAlertsPK=" + adminPreferencesSystemAlertsPK + " ]";
    }
    
}
