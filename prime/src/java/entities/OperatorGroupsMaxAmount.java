/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "operator_groups_max_amount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperatorGroupsMaxAmount.findAll", query = "SELECT o FROM OperatorGroupsMaxAmount o"),
    @NamedQuery(name = "OperatorGroupsMaxAmount.findByGroupId", query = "SELECT o FROM OperatorGroupsMaxAmount o WHERE o.operatorGroupsMaxAmountPK.groupId = :groupId"),
    @NamedQuery(name = "OperatorGroupsMaxAmount.findByAmount", query = "SELECT o FROM OperatorGroupsMaxAmount o WHERE o.amount = :amount"),
    @NamedQuery(name = "OperatorGroupsMaxAmount.findByTransferTypeId", query = "SELECT o FROM OperatorGroupsMaxAmount o WHERE o.operatorGroupsMaxAmountPK.transferTypeId = :transferTypeId")})
public class OperatorGroupsMaxAmount implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OperatorGroupsMaxAmountPK operatorGroupsMaxAmountPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Groups groups;
    @JoinColumn(name = "transfer_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TransferTypes transferTypes;

    public OperatorGroupsMaxAmount() {
    }

    public OperatorGroupsMaxAmount(OperatorGroupsMaxAmountPK operatorGroupsMaxAmountPK) {
        this.operatorGroupsMaxAmountPK = operatorGroupsMaxAmountPK;
    }

    public OperatorGroupsMaxAmount(OperatorGroupsMaxAmountPK operatorGroupsMaxAmountPK, BigDecimal amount) {
        this.operatorGroupsMaxAmountPK = operatorGroupsMaxAmountPK;
        this.amount = amount;
    }

    public OperatorGroupsMaxAmount(int groupId, int transferTypeId) {
        this.operatorGroupsMaxAmountPK = new OperatorGroupsMaxAmountPK(groupId, transferTypeId);
    }

    public OperatorGroupsMaxAmountPK getOperatorGroupsMaxAmountPK() {
        return operatorGroupsMaxAmountPK;
    }

    public void setOperatorGroupsMaxAmountPK(OperatorGroupsMaxAmountPK operatorGroupsMaxAmountPK) {
        this.operatorGroupsMaxAmountPK = operatorGroupsMaxAmountPK;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public TransferTypes getTransferTypes() {
        return transferTypes;
    }

    public void setTransferTypes(TransferTypes transferTypes) {
        this.transferTypes = transferTypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operatorGroupsMaxAmountPK != null ? operatorGroupsMaxAmountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperatorGroupsMaxAmount)) {
            return false;
        }
        OperatorGroupsMaxAmount other = (OperatorGroupsMaxAmount) object;
        if ((this.operatorGroupsMaxAmountPK == null && other.operatorGroupsMaxAmountPK != null) || (this.operatorGroupsMaxAmountPK != null && !this.operatorGroupsMaxAmountPK.equals(other.operatorGroupsMaxAmountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperatorGroupsMaxAmount[ operatorGroupsMaxAmountPK=" + operatorGroupsMaxAmountPK + " ]";
    }
    
}
