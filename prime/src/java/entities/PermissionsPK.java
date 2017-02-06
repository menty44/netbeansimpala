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
public class PermissionsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "permission")
    private String permission;

    public PermissionsPK() {
    }

    public PermissionsPK(int groupId, String permission) {
        this.groupId = groupId;
        this.permission = permission;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) groupId;
        hash += (permission != null ? permission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionsPK)) {
            return false;
        }
        PermissionsPK other = (PermissionsPK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        if ((this.permission == null && other.permission != null) || (this.permission != null && !this.permission.equals(other.permission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PermissionsPK[ groupId=" + groupId + ", permission=" + permission + " ]";
    }
    
}
