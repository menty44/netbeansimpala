/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "guarantee_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuaranteeTypes.findAll", query = "SELECT g FROM GuaranteeTypes g"),
    @NamedQuery(name = "GuaranteeTypes.findById", query = "SELECT g FROM GuaranteeTypes g WHERE g.id = :id"),
    @NamedQuery(name = "GuaranteeTypes.findByName", query = "SELECT g FROM GuaranteeTypes g WHERE g.name = :name"),
    @NamedQuery(name = "GuaranteeTypes.findByModel", query = "SELECT g FROM GuaranteeTypes g WHERE g.model = :model"),
    @NamedQuery(name = "GuaranteeTypes.findByAuthorizedBy", query = "SELECT g FROM GuaranteeTypes g WHERE g.authorizedBy = :authorizedBy"),
    @NamedQuery(name = "GuaranteeTypes.findByEnabled", query = "SELECT g FROM GuaranteeTypes g WHERE g.enabled = :enabled"),
    @NamedQuery(name = "GuaranteeTypes.findByPendingGuaranteeExpirationNumber", query = "SELECT g FROM GuaranteeTypes g WHERE g.pendingGuaranteeExpirationNumber = :pendingGuaranteeExpirationNumber"),
    @NamedQuery(name = "GuaranteeTypes.findByPendingGuaranteeExpirationField", query = "SELECT g FROM GuaranteeTypes g WHERE g.pendingGuaranteeExpirationField = :pendingGuaranteeExpirationField"),
    @NamedQuery(name = "GuaranteeTypes.findByPaymentObligationPeriodNumber", query = "SELECT g FROM GuaranteeTypes g WHERE g.paymentObligationPeriodNumber = :paymentObligationPeriodNumber"),
    @NamedQuery(name = "GuaranteeTypes.findByPaymentObligationPeriodField", query = "SELECT g FROM GuaranteeTypes g WHERE g.paymentObligationPeriodField = :paymentObligationPeriodField"),
    @NamedQuery(name = "GuaranteeTypes.findByCreditFeePayer", query = "SELECT g FROM GuaranteeTypes g WHERE g.creditFeePayer = :creditFeePayer"),
    @NamedQuery(name = "GuaranteeTypes.findByIssueFeePayer", query = "SELECT g FROM GuaranteeTypes g WHERE g.issueFeePayer = :issueFeePayer"),
    @NamedQuery(name = "GuaranteeTypes.findByCreditFee", query = "SELECT g FROM GuaranteeTypes g WHERE g.creditFee = :creditFee"),
    @NamedQuery(name = "GuaranteeTypes.findByCreditFeeType", query = "SELECT g FROM GuaranteeTypes g WHERE g.creditFeeType = :creditFeeType"),
    @NamedQuery(name = "GuaranteeTypes.findByCreditFeeReadonly", query = "SELECT g FROM GuaranteeTypes g WHERE g.creditFeeReadonly = :creditFeeReadonly"),
    @NamedQuery(name = "GuaranteeTypes.findByIssueFee", query = "SELECT g FROM GuaranteeTypes g WHERE g.issueFee = :issueFee"),
    @NamedQuery(name = "GuaranteeTypes.findByIssueFeeType", query = "SELECT g FROM GuaranteeTypes g WHERE g.issueFeeType = :issueFeeType"),
    @NamedQuery(name = "GuaranteeTypes.findByIssueFeeReadonly", query = "SELECT g FROM GuaranteeTypes g WHERE g.issueFeeReadonly = :issueFeeReadonly")})
public class GuaranteeTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "authorized_by")
    private String authorizedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "pending_guarantee_expiration_number")
    private Integer pendingGuaranteeExpirationNumber;
    @Column(name = "pending_guarantee_expiration_field")
    private Integer pendingGuaranteeExpirationField;
    @Column(name = "payment_obligation_period_number")
    private Integer paymentObligationPeriodNumber;
    @Column(name = "payment_obligation_period_field")
    private Integer paymentObligationPeriodField;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "credit_fee_payer")
    private String creditFeePayer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "issue_fee_payer")
    private String issueFeePayer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit_fee")
    private BigDecimal creditFee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "credit_fee_type")
    private String creditFeeType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit_fee_readonly")
    private boolean creditFeeReadonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issue_fee")
    private BigDecimal issueFee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "issue_fee_type")
    private String issueFeeType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issue_fee_readonly")
    private boolean issueFeeReadonly;
    @ManyToMany(mappedBy = "guaranteeTypesCollection")
    private Collection<Groups> groupsCollection;
    @JoinTable(name = "admin_preferences_guarantee_types", joinColumns = {
        @JoinColumn(name = "guarantee_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "preference_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection;
    @JoinColumn(name = "credit_fee_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes creditFeeTransferTypeId;
    @JoinColumn(name = "issue_fee_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes issueFeeTransferTypeId;
    @JoinColumn(name = "loan_transfer_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes loanTransferTypeId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currencies currencyId;
    @JoinColumn(name = "forward_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes forwardTransferTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guaranteeTypeId")
    private Collection<Guarantees> guaranteesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guaranteeTypeId")
    private Collection<Certifications> certificationsCollection;

    public GuaranteeTypes() {
    }

    public GuaranteeTypes(Integer id) {
        this.id = id;
    }

    public GuaranteeTypes(Integer id, String name, String model, String authorizedBy, boolean enabled, String creditFeePayer, String issueFeePayer, BigDecimal creditFee, String creditFeeType, boolean creditFeeReadonly, BigDecimal issueFee, String issueFeeType, boolean issueFeeReadonly) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.authorizedBy = authorizedBy;
        this.enabled = enabled;
        this.creditFeePayer = creditFeePayer;
        this.issueFeePayer = issueFeePayer;
        this.creditFee = creditFee;
        this.creditFeeType = creditFeeType;
        this.creditFeeReadonly = creditFeeReadonly;
        this.issueFee = issueFee;
        this.issueFeeType = issueFeeType;
        this.issueFeeReadonly = issueFeeReadonly;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getPendingGuaranteeExpirationNumber() {
        return pendingGuaranteeExpirationNumber;
    }

    public void setPendingGuaranteeExpirationNumber(Integer pendingGuaranteeExpirationNumber) {
        this.pendingGuaranteeExpirationNumber = pendingGuaranteeExpirationNumber;
    }

    public Integer getPendingGuaranteeExpirationField() {
        return pendingGuaranteeExpirationField;
    }

    public void setPendingGuaranteeExpirationField(Integer pendingGuaranteeExpirationField) {
        this.pendingGuaranteeExpirationField = pendingGuaranteeExpirationField;
    }

    public Integer getPaymentObligationPeriodNumber() {
        return paymentObligationPeriodNumber;
    }

    public void setPaymentObligationPeriodNumber(Integer paymentObligationPeriodNumber) {
        this.paymentObligationPeriodNumber = paymentObligationPeriodNumber;
    }

    public Integer getPaymentObligationPeriodField() {
        return paymentObligationPeriodField;
    }

    public void setPaymentObligationPeriodField(Integer paymentObligationPeriodField) {
        this.paymentObligationPeriodField = paymentObligationPeriodField;
    }

    public String getCreditFeePayer() {
        return creditFeePayer;
    }

    public void setCreditFeePayer(String creditFeePayer) {
        this.creditFeePayer = creditFeePayer;
    }

    public String getIssueFeePayer() {
        return issueFeePayer;
    }

    public void setIssueFeePayer(String issueFeePayer) {
        this.issueFeePayer = issueFeePayer;
    }

    public BigDecimal getCreditFee() {
        return creditFee;
    }

    public void setCreditFee(BigDecimal creditFee) {
        this.creditFee = creditFee;
    }

    public String getCreditFeeType() {
        return creditFeeType;
    }

    public void setCreditFeeType(String creditFeeType) {
        this.creditFeeType = creditFeeType;
    }

    public boolean getCreditFeeReadonly() {
        return creditFeeReadonly;
    }

    public void setCreditFeeReadonly(boolean creditFeeReadonly) {
        this.creditFeeReadonly = creditFeeReadonly;
    }

    public BigDecimal getIssueFee() {
        return issueFee;
    }

    public void setIssueFee(BigDecimal issueFee) {
        this.issueFee = issueFee;
    }

    public String getIssueFeeType() {
        return issueFeeType;
    }

    public void setIssueFeeType(String issueFeeType) {
        this.issueFeeType = issueFeeType;
    }

    public boolean getIssueFeeReadonly() {
        return issueFeeReadonly;
    }

    public void setIssueFeeReadonly(boolean issueFeeReadonly) {
        this.issueFeeReadonly = issueFeeReadonly;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<AdminNotificationPreferences> getAdminNotificationPreferencesCollection() {
        return adminNotificationPreferencesCollection;
    }

    public void setAdminNotificationPreferencesCollection(Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection) {
        this.adminNotificationPreferencesCollection = adminNotificationPreferencesCollection;
    }

    public TransferTypes getCreditFeeTransferTypeId() {
        return creditFeeTransferTypeId;
    }

    public void setCreditFeeTransferTypeId(TransferTypes creditFeeTransferTypeId) {
        this.creditFeeTransferTypeId = creditFeeTransferTypeId;
    }

    public TransferTypes getIssueFeeTransferTypeId() {
        return issueFeeTransferTypeId;
    }

    public void setIssueFeeTransferTypeId(TransferTypes issueFeeTransferTypeId) {
        this.issueFeeTransferTypeId = issueFeeTransferTypeId;
    }

    public TransferTypes getLoanTransferTypeId() {
        return loanTransferTypeId;
    }

    public void setLoanTransferTypeId(TransferTypes loanTransferTypeId) {
        this.loanTransferTypeId = loanTransferTypeId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
    }

    public TransferTypes getForwardTransferTypeId() {
        return forwardTransferTypeId;
    }

    public void setForwardTransferTypeId(TransferTypes forwardTransferTypeId) {
        this.forwardTransferTypeId = forwardTransferTypeId;
    }

    @XmlTransient
    public Collection<Guarantees> getGuaranteesCollection() {
        return guaranteesCollection;
    }

    public void setGuaranteesCollection(Collection<Guarantees> guaranteesCollection) {
        this.guaranteesCollection = guaranteesCollection;
    }

    @XmlTransient
    public Collection<Certifications> getCertificationsCollection() {
        return certificationsCollection;
    }

    public void setCertificationsCollection(Collection<Certifications> certificationsCollection) {
        this.certificationsCollection = certificationsCollection;
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
        if (!(object instanceof GuaranteeTypes)) {
            return false;
        }
        GuaranteeTypes other = (GuaranteeTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GuaranteeTypes[ id=" + id + " ]";
    }
    
}
