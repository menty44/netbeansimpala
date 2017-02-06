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
public class MemberGroupsEmailValidationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "type")
    private String type;

    public MemberGroupsEmailValidationPK() {
    }

    public MemberGroupsEmailValidationPK(int groupId, String type) {
        this.groupId = groupId;
        this.type = type;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) groupId;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberGroupsEmailValidationPK)) {
            return false;
        }
        MemberGroupsEmailValidationPK other = (MemberGroupsEmailValidationPK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberGroupsEmailValidationPK[ groupId=" + groupId + ", type=" + type + " ]";
    }
    
}
