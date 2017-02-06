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

/**
 *
 * @author fred
 */
@Embeddable
public class OperatorGroupsMaxAmountPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transfer_type_id")
    private int transferTypeId;

    public OperatorGroupsMaxAmountPK() {
    }

    public OperatorGroupsMaxAmountPK(int groupId, int transferTypeId) {
        this.groupId = groupId;
        this.transferTypeId = transferTypeId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) groupId;
        hash += (int) transferTypeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperatorGroupsMaxAmountPK)) {
            return false;
        }
        OperatorGroupsMaxAmountPK other = (OperatorGroupsMaxAmountPK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        if (this.transferTypeId != other.transferTypeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperatorGroupsMaxAmountPK[ groupId=" + groupId + ", transferTypeId=" + transferTypeId + " ]";
    }
    
}
