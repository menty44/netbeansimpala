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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "transaction_fees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionFees.findAll", query = "SELECT t FROM TransactionFees t"),
    @NamedQuery(name = "TransactionFees.findById", query = "SELECT t FROM TransactionFees t WHERE t.id = :id"),
    @NamedQuery(name = "TransactionFees.findBySubclass", query = "SELECT t FROM TransactionFees t WHERE t.subclass = :subclass"),
    @NamedQuery(name = "TransactionFees.findByPayer", query = "SELECT t FROM TransactionFees t WHERE t.payer = :payer"),
    @NamedQuery(name = "TransactionFees.findByEnabled", query = "SELECT t FROM TransactionFees t WHERE t.enabled = :enabled"),
    @NamedQuery(name = "TransactionFees.findByName", query = "SELECT t FROM TransactionFees t WHERE t.name = :name"),
    @NamedQuery(name = "TransactionFees.findByFromAllGroups", query = "SELECT t FROM TransactionFees t WHERE t.fromAllGroups = :fromAllGroups"),
    @NamedQuery(name = "TransactionFees.findByToAllGroups", query = "SELECT t FROM TransactionFees t WHERE t.toAllGroups = :toAllGroups"),
    @NamedQuery(name = "TransactionFees.findByDeductAmount", query = "SELECT t FROM TransactionFees t WHERE t.deductAmount = :deductAmount"),
    @NamedQuery(name = "TransactionFees.findByAmount", query = "SELECT t FROM TransactionFees t WHERE t.amount = :amount"),
    @NamedQuery(name = "TransactionFees.findByAmountType", query = "SELECT t FROM TransactionFees t WHERE t.amountType = :amountType"),
    @NamedQuery(name = "TransactionFees.findByMaxFixedValue", query = "SELECT t FROM TransactionFees t WHERE t.maxFixedValue = :maxFixedValue"),
    @NamedQuery(name = "TransactionFees.findByMaxPercentageValue", query = "SELECT t FROM TransactionFees t WHERE t.maxPercentageValue = :maxPercentageValue"),
    @NamedQuery(name = "TransactionFees.findByInitialAmount", query = "SELECT t FROM TransactionFees t WHERE t.initialAmount = :initialAmount"),
    @NamedQuery(name = "TransactionFees.findByFinalAmount", query = "SELECT t FROM TransactionFees t WHERE t.finalAmount = :finalAmount"),
    @NamedQuery(name = "TransactionFees.findByReceiver", query = "SELECT t FROM TransactionFees t WHERE t.receiver = :receiver"),
    @NamedQuery(name = "TransactionFees.findByH", query = "SELECT t FROM TransactionFees t WHERE t.h = :h"),
    @NamedQuery(name = "TransactionFees.findByAFIsZero", query = "SELECT t FROM TransactionFees t WHERE t.aFIsZero = :aFIsZero"),
    @NamedQuery(name = "TransactionFees.findByF1", query = "SELECT t FROM TransactionFees t WHERE t.f1 = :f1"),
    @NamedQuery(name = "TransactionFees.findByFInfinite", query = "SELECT t FROM TransactionFees t WHERE t.fInfinite = :fInfinite"),
    @NamedQuery(name = "TransactionFees.findByFMinimal", query = "SELECT t FROM TransactionFees t WHERE t.fMinimal = :fMinimal"),
    @NamedQuery(name = "TransactionFees.findByGFIsZero", query = "SELECT t FROM TransactionFees t WHERE t.gFIsZero = :gFIsZero"),
    @NamedQuery(name = "TransactionFees.findByWhichBroker", query = "SELECT t FROM TransactionFees t WHERE t.whichBroker = :whichBroker"),
    @NamedQuery(name = "TransactionFees.findByWhenApply", query = "SELECT t FROM TransactionFees t WHERE t.whenApply = :whenApply"),
    @NamedQuery(name = "TransactionFees.findByWhenCount", query = "SELECT t FROM TransactionFees t WHERE t.whenCount = :whenCount"),
    @NamedQuery(name = "TransactionFees.findByAllBrokerGroups", query = "SELECT t FROM TransactionFees t WHERE t.allBrokerGroups = :allBrokerGroups")})
public class TransactionFees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "payer")
    private String payer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from_all_groups")
    private boolean fromAllGroups;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_all_groups")
    private boolean toAllGroups;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deduct_amount")
    private boolean deductAmount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "amount_type")
    private String amountType;
    @Column(name = "max_fixed_value")
    private BigDecimal maxFixedValue;
    @Column(name = "max_percentage_value")
    private BigDecimal maxPercentageValue;
    @Column(name = "initial_amount")
    private BigDecimal initialAmount;
    @Column(name = "final_amount")
    private BigDecimal finalAmount;
    @Size(max = 3)
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "h")
    private BigDecimal h;
    @Column(name = "a_f_is_zero")
    private BigDecimal aFIsZero;
    @Column(name = "f1")
    private BigDecimal f1;
    @Column(name = "f_infinite")
    private BigDecimal fInfinite;
    @Column(name = "f_minimal")
    private BigDecimal fMinimal;
    @Column(name = "g_f_is_zero")
    private BigDecimal gFIsZero;
    @Size(max = 1)
    @Column(name = "which_broker")
    private String whichBroker;
    @Size(max = 1)
    @Column(name = "when_apply")
    private String whenApply;
    @Column(name = "when_count")
    private Integer whenCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "all_broker_groups")
    private boolean allBrokerGroups;
    @ManyToMany(mappedBy = "transactionFeesCollection")
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "transactionFeesCollection1")
    private Collection<Groups> groupsCollection1;
    @ManyToMany(mappedBy = "transactionFeesCollection2")
    private Collection<Groups> groupsCollection2;
    @OneToMany(mappedBy = "brokerCommissionId")
    private Collection<DefaultBrokerCommissions> defaultBrokerCommissionsCollection;
    @OneToMany(mappedBy = "brokerCommissionId")
    private Collection<BrokerCommissionContracts> brokerCommissionContractsCollection;
    @OneToMany(mappedBy = "brokerCommissionId")
    private Collection<BrokeringCommissionStatus> brokeringCommissionStatusCollection;
    @JoinColumn(name = "generated_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes generatedTypeId;
    @JoinColumn(name = "from_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members fromMemberId;
    @JoinColumn(name = "to_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members toMemberId;
    @JoinColumn(name = "original_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes originalTypeId;
    @OneToMany(mappedBy = "transactionFeeId")
    private Collection<Transfers> transfersCollection;
    @OneToMany(mappedBy = "feeId")
    private Collection<Transfers> transfersCollection1;

    public TransactionFees() {
    }

    public TransactionFees(Integer id) {
        this.id = id;
    }

    public TransactionFees(Integer id, String subclass, String payer, boolean enabled, String name, boolean fromAllGroups, boolean toAllGroups, boolean deductAmount, String amountType, boolean allBrokerGroups) {
        this.id = id;
        this.subclass = subclass;
        this.payer = payer;
        this.enabled = enabled;
        this.name = name;
        this.fromAllGroups = fromAllGroups;
        this.toAllGroups = toAllGroups;
        this.deductAmount = deductAmount;
        this.amountType = amountType;
        this.allBrokerGroups = allBrokerGroups;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFromAllGroups() {
        return fromAllGroups;
    }

    public void setFromAllGroups(boolean fromAllGroups) {
        this.fromAllGroups = fromAllGroups;
    }

    public boolean getToAllGroups() {
        return toAllGroups;
    }

    public void setToAllGroups(boolean toAllGroups) {
        this.toAllGroups = toAllGroups;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(boolean deductAmount) {
        this.deductAmount = deductAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public BigDecimal getMaxFixedValue() {
        return maxFixedValue;
    }

    public void setMaxFixedValue(BigDecimal maxFixedValue) {
        this.maxFixedValue = maxFixedValue;
    }

    public BigDecimal getMaxPercentageValue() {
        return maxPercentageValue;
    }

    public void setMaxPercentageValue(BigDecimal maxPercentageValue) {
        this.maxPercentageValue = maxPercentageValue;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getH() {
        return h;
    }

    public void setH(BigDecimal h) {
        this.h = h;
    }

    public BigDecimal getAFIsZero() {
        return aFIsZero;
    }

    public void setAFIsZero(BigDecimal aFIsZero) {
        this.aFIsZero = aFIsZero;
    }

    public BigDecimal getF1() {
        return f1;
    }

    public void setF1(BigDecimal f1) {
        this.f1 = f1;
    }

    public BigDecimal getFInfinite() {
        return fInfinite;
    }

    public void setFInfinite(BigDecimal fInfinite) {
        this.fInfinite = fInfinite;
    }

    public BigDecimal getFMinimal() {
        return fMinimal;
    }

    public void setFMinimal(BigDecimal fMinimal) {
        this.fMinimal = fMinimal;
    }

    public BigDecimal getGFIsZero() {
        return gFIsZero;
    }

    public void setGFIsZero(BigDecimal gFIsZero) {
        this.gFIsZero = gFIsZero;
    }

    public String getWhichBroker() {
        return whichBroker;
    }

    public void setWhichBroker(String whichBroker) {
        this.whichBroker = whichBroker;
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

    public boolean getAllBrokerGroups() {
        return allBrokerGroups;
    }

    public void setAllBrokerGroups(boolean allBrokerGroups) {
        this.allBrokerGroups = allBrokerGroups;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection1() {
        return groupsCollection1;
    }

    public void setGroupsCollection1(Collection<Groups> groupsCollection1) {
        this.groupsCollection1 = groupsCollection1;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection2() {
        return groupsCollection2;
    }

    public void setGroupsCollection2(Collection<Groups> groupsCollection2) {
        this.groupsCollection2 = groupsCollection2;
    }

    @XmlTransient
    public Collection<DefaultBrokerCommissions> getDefaultBrokerCommissionsCollection() {
        return defaultBrokerCommissionsCollection;
    }

    public void setDefaultBrokerCommissionsCollection(Collection<DefaultBrokerCommissions> defaultBrokerCommissionsCollection) {
        this.defaultBrokerCommissionsCollection = defaultBrokerCommissionsCollection;
    }

    @XmlTransient
    public Collection<BrokerCommissionContracts> getBrokerCommissionContractsCollection() {
        return brokerCommissionContractsCollection;
    }

    public void setBrokerCommissionContractsCollection(Collection<BrokerCommissionContracts> brokerCommissionContractsCollection) {
        this.brokerCommissionContractsCollection = brokerCommissionContractsCollection;
    }

    @XmlTransient
    public Collection<BrokeringCommissionStatus> getBrokeringCommissionStatusCollection() {
        return brokeringCommissionStatusCollection;
    }

    public void setBrokeringCommissionStatusCollection(Collection<BrokeringCommissionStatus> brokeringCommissionStatusCollection) {
        this.brokeringCommissionStatusCollection = brokeringCommissionStatusCollection;
    }

    public TransferTypes getGeneratedTypeId() {
        return generatedTypeId;
    }

    public void setGeneratedTypeId(TransferTypes generatedTypeId) {
        this.generatedTypeId = generatedTypeId;
    }

    public Members getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(Members fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public Members getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(Members toMemberId) {
        this.toMemberId = toMemberId;
    }

    public TransferTypes getOriginalTypeId() {
        return originalTypeId;
    }

    public void setOriginalTypeId(TransferTypes originalTypeId) {
        this.originalTypeId = originalTypeId;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection1() {
        return transfersCollection1;
    }

    public void setTransfersCollection1(Collection<Transfers> transfersCollection1) {
        this.transfersCollection1 = transfersCollection1;
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
        if (!(object instanceof TransactionFees)) {
            return false;
        }
        TransactionFees other = (TransactionFees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransactionFees[ id=" + id + " ]";
    }
    
}
