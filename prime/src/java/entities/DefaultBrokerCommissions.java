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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "default_broker_commissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DefaultBrokerCommissions.findAll", query = "SELECT d FROM DefaultBrokerCommissions d"),
    @NamedQuery(name = "DefaultBrokerCommissions.findById", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.id = :id"),
    @NamedQuery(name = "DefaultBrokerCommissions.findByAmount", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.amount = :amount"),
    @NamedQuery(name = "DefaultBrokerCommissions.findByAmountType", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.amountType = :amountType"),
    @NamedQuery(name = "DefaultBrokerCommissions.findByWhenApply", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.whenApply = :whenApply"),
    @NamedQuery(name = "DefaultBrokerCommissions.findByWhenCount", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.whenCount = :whenCount"),
    @NamedQuery(name = "DefaultBrokerCommissions.findBySetByBroker", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.setByBroker = :setByBroker"),
    @NamedQuery(name = "DefaultBrokerCommissions.findBySuspended", query = "SELECT d FROM DefaultBrokerCommissions d WHERE d.suspended = :suspended")})
public class DefaultBrokerCommissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount_type")
    private Character amountType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "when_apply")
    private String whenApply;
    @Column(name = "when_count")
    private Integer whenCount;
    @Column(name = "set_by_broker")
    private Boolean setByBroker;
    @Column(name = "suspended")
    private Boolean suspended;
    @JoinColumn(name = "broker_id", referencedColumnName = "id")
    @ManyToOne
    private Members brokerId;
    @JoinColumn(name = "broker_commission_id", referencedColumnName = "id")
    @ManyToOne
    private TransactionFees brokerCommissionId;

    public DefaultBrokerCommissions() {
    }

    public DefaultBrokerCommissions(Integer id) {
        this.id = id;
    }

    public DefaultBrokerCommissions(Integer id, BigDecimal amount, Character amountType, String whenApply) {
        this.id = id;
        this.amount = amount;
        this.amountType = amountType;
        this.whenApply = whenApply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Character getAmountType() {
        return amountType;
    }

    public void setAmountType(Character amountType) {
        this.amountType = amountType;
    }

    public String getWhenApply() {
        return whenApply;
    }

    public void setWhenApply(String whenApply) {
        this.whenApply = whenApply;
    }

    public Integer getWhenCount() {
        return whenCount;
    }

    public void setWhenCount(Integer whenCount) {
        this.whenCount = whenCount;
    }

    public Boolean getSetByBroker() {
        return setByBroker;
    }

    public void setSetByBroker(Boolean setByBroker) {
        this.setByBroker = setByBroker;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public Members getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Members brokerId) {
        this.brokerId = brokerId;
    }

    public TransactionFees getBrokerCommissionId() {
        return brokerCommissionId;
    }

    public void setBrokerCommissionId(TransactionFees brokerCommissionId) {
        this.brokerCommissionId = brokerCommissionId;
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
        if (!(object instanceof DefaultBrokerCommissions)) {
            return false;
        }
        DefaultBrokerCommissions other = (DefaultBrokerCommissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DefaultBrokerCommissions[ id=" + id + " ]";
    }
    
}
