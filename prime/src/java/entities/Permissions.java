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
@Table(name = "permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p"),
    @NamedQuery(name = "Permissions.findByGroupId", query = "SELECT p FROM Permissions p WHERE p.permissionsPK.groupId = :groupId"),
    @NamedQuery(name = "Permissions.findByPermission", query = "SELECT p FROM Permissions p WHERE p.permissionsPK.permission = :permission")})
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermissionsPK permissionsPK;
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Groups groups;

    public Permissions() {
    }

    public Permissions(PermissionsPK permissionsPK) {
        this.permissionsPK = permissionsPK;
    }

    public Permissions(int groupId, String permission) {
        this.permissionsPK = new PermissionsPK(groupId, permission);
    }

    public PermissionsPK getPermissionsPK() {
        return permissionsPK;
    }

    public void setPermissionsPK(PermissionsPK permissionsPK) {
        this.permissionsPK = permissionsPK;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionsPK != null ? permissionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissions)) {
            return false;
        }
        Permissions other = (Permissions) object;
        if ((this.permissionsPK == null && other.permissionsPK != null) || (this.permissionsPK != null && !this.permissionsPK.equals(other.permissionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Permissions[ permissionsPK=" + permissionsPK + " ]";
    }
    
}
