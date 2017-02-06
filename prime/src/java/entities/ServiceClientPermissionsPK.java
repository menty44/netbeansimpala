/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fred
 */
@Embeddable
public class ServiceClientPermissionsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "service_client_id")
    private int serviceClientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "operation")
    private String operation;

    public ServiceClientPermissionsPK() {
    }

    public ServiceClientPermissionsPK(int serviceClientId, String operation) {
        this.serviceClientId = serviceClientId;
        this.operation = operation;
    }

    public int getServiceClientId() {
        return serviceClientId;
    }

    public void setServiceClientId(int serviceClientId) {
        this.serviceClientId = serviceClientId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) serviceClientId;
        hash += (operation != null ? operation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceClientPermissionsPK)) {
            return false;
        }
        ServiceClientPermissionsPK other = (ServiceClientPermissionsPK) object;
        if (this.serviceClientId != other.serviceClientId) {
            return false;
        }
        if ((this.operation == null && other.operation != null) || (this.operation != null && !this.operation.equals(other.operation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceClientPermissionsPK[ serviceClientId=" + serviceClientId + ", operation=" + operation + " ]";
    }
    
}
