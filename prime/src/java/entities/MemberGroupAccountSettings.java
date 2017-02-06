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
import javax.persistence.Lob;
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
@Table(name = "member_group_account_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberGroupAccountSettings.findAll", query = "SELECT m FROM MemberGroupAccountSettings m"),
    @NamedQuery(name = "MemberGroupAccountSettings.findById", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.id = :id"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByDefaultType", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.defaultType = :defaultType"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByTransactionPasswordRequired", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.transactionPasswordRequired = :transactionPasswordRequired"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByHideWhenNoCreditLimit", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.hideWhenNoCreditLimit = :hideWhenNoCreditLimit"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByDefaultCreditLimit", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.defaultCreditLimit = :defaultCreditLimit"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByDefaultUpperCreditLimit", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.defaultUpperCreditLimit = :defaultUpperCreditLimit"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByInitialCredit", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.initialCredit = :initialCredit"),
    @NamedQuery(name = "MemberGroupAccountSettings.findByLowUnits", query = "SELECT m FROM MemberGroupAccountSettings m WHERE m.lowUnits = :lowUnits")})
public class MemberGroupAccountSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "default_type")
    private boolean defaultType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_password_required")
    private boolean transactionPasswordRequired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hide_when_no_credit_limit")
    private boolean hideWhenNoCreditLimit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "default_credit_limit")
    private BigDecimal defaultCreditLimit;
    @Column(name = "default_upper_credit_limit")
    private BigDecimal defaultUpperCreditLimit;
    @Column(name = "initial_credit")
    private BigDecimal initialCredit;
    @Column(name = "low_units")
    private BigDecimal lowUnits;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "low_units_message")
    private String lowUnitsMessage;
    @JoinColumn(name = "initial_credit_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes initialCreditTransferTypeId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Groups groupId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes typeId;

    public MemberGroupAccountSettings() {
    }

    public MemberGroupAccountSettings(Integer id) {
        this.id = id;
    }

    public MemberGroupAccountSettings(Integer id, boolean defaultType, boolean transactionPasswordRequired, boolean hideWhenNoCreditLimit, BigDecimal defaultCreditLimit) {
        this.id = id;
        this.defaultType = defaultType;
        this.transactionPasswordRequired = transactionPasswordRequired;
        this.hideWhenNoCreditLimit = hideWhenNoCreditLimit;
        this.defaultCreditLimit = defaultCreditLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getDefaultType() {
        return defaultType;
    }

    public void setDefaultType(boolean defaultType) {
        this.defaultType = defaultType;
    }

    public boolean getTransactionPasswordRequired() {
        return transactionPasswordRequired;
    }

    public void setTransactionPasswordRequired(boolean transactionPasswordRequired) {
        this.transactionPasswordRequired = transactionPasswordRequired;
    }

    public boolean getHideWhenNoCreditLimit() {
        return hideWhenNoCreditLimit;
    }

    public void setHideWhenNoCreditLimit(boolean hideWhenNoCreditLimit) {
        this.hideWhenNoCreditLimit = hideWhenNoCreditLimit;
    }

    public BigDecimal getDefaultCreditLimit() {
        return defaultCreditLimit;
    }

    public void setDefaultCreditLimit(BigDecimal defaultCreditLimit) {
        this.defaultCreditLimit = defaultCreditLimit;
    }

    public BigDecimal getDefaultUpperCreditLimit() {
        return defaultUpperCreditLimit;
    }

    public void setDefaultUpperCreditLimit(BigDecimal defaultUpperCreditLimit) {
        this.defaultUpperCreditLimit = defaultUpperCreditLimit;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }

    public BigDecimal getLowUnits() {
        return lowUnits;
    }

    public void setLowUnits(BigDecimal lowUnits) {
        this.lowUnits = lowUnits;
    }

    public String getLowUnitsMessage() {
        return lowUnitsMessage;
    }

    public void setLowUnitsMessage(String lowUnitsMessage) {
        this.lowUnitsMessage = lowUnitsMessage;
    }

    public TransferTypes getInitialCreditTransferTypeId() {
        return initialCreditTransferTypeId;
    }

    public void setInitialCreditTransferTypeId(TransferTypes initialCreditTransferTypeId) {
        this.initialCreditTransferTypeId = initialCreditTransferTypeId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public AccountTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(AccountTypes typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof MemberGroupAccountSettings)) {
            return false;
        }
        MemberGroupAccountSettings other = (MemberGroupAccountSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberGroupAccountSettings[ id=" + id + " ]";
    }
    
}
