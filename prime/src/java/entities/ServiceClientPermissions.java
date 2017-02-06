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
@Table(name = "service_client_permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceClientPermissions.findAll", query = "SELECT s FROM ServiceClientPermissions s"),
    @NamedQuery(name = "ServiceClientPermissions.findByServiceClientId", query = "SELECT s FROM ServiceClientPermissions s WHERE s.serviceClientPermissionsPK.serviceClientId = :serviceClientId"),
    @NamedQuery(name = "ServiceClientPermissions.findByOperation", query = "SELECT s FROM ServiceClientPermissions s WHERE s.serviceClientPermissionsPK.operation = :operation")})
public class ServiceClientPermissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServiceClientPermissionsPK serviceClientPermissionsPK;
    @JoinColumn(name = "service_client_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServiceClients serviceClients;

    public ServiceClientPermissions() {
    }

    public ServiceClientPermissions(ServiceClientPermissionsPK serviceClientPermissionsPK) {
        this.serviceClientPermissionsPK = serviceClientPermissionsPK;
    }

    public ServiceClientPermissions(int serviceClientId, String operation) {
        this.serviceClientPermissionsPK = new ServiceClientPermissionsPK(serviceClientId, operation);
    }

    public ServiceClientPermissionsPK getServiceClientPermissionsPK() {
        return serviceClientPermissionsPK;
    }

    public void setServiceClientPermissionsPK(ServiceClientPermissionsPK serviceClientPermissionsPK) {
        this.serviceClientPermissionsPK = serviceClientPermissionsPK;
    }

    public ServiceClients getServiceClients() {
        return serviceClients;
    }

    public void setServiceClients(ServiceClients serviceClients) {
        this.serviceClients = serviceClients;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceClientPermissionsPK != null ? serviceClientPermissionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceClientPermissions)) {
            return false;
        }
        ServiceClientPermissions other = (ServiceClientPermissions) object;
        if ((this.serviceClientPermissionsPK == null && other.serviceClientPermissionsPK != null) || (this.serviceClientPermissionsPK != null && !this.serviceClientPermissionsPK.equals(other.serviceClientPermissionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceClientPermissions[ serviceClientPermissionsPK=" + serviceClientPermissionsPK + " ]";
    }
    
}
