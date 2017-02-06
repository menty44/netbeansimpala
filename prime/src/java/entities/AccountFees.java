/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "account_fees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountFees.findAll", query = "SELECT a FROM AccountFees a"),
    @NamedQuery(name = "AccountFees.findById", query = "SELECT a FROM AccountFees a WHERE a.id = :id"),
    @NamedQuery(name = "AccountFees.findByName", query = "SELECT a FROM AccountFees a WHERE a.name = :name"),
    @NamedQuery(name = "AccountFees.findByChargeMode", query = "SELECT a FROM AccountFees a WHERE a.chargeMode = :chargeMode"),
    @NamedQuery(name = "AccountFees.findByRunMode", query = "SELECT a FROM AccountFees a WHERE a.runMode = :runMode"),
    @NamedQuery(name = "AccountFees.findByPaymentDirection", query = "SELECT a FROM AccountFees a WHERE a.paymentDirection = :paymentDirection"),
    @NamedQuery(name = "AccountFees.findByEnabled", query = "SELECT a FROM AccountFees a WHERE a.enabled = :enabled"),
    @NamedQuery(name = "AccountFees.findByAmount", query = "SELECT a FROM AccountFees a WHERE a.amount = :amount"),
    @NamedQuery(name = "AccountFees.findByInvoiceMode", query = "SELECT a FROM AccountFees a WHERE a.invoiceMode = :invoiceMode"),
    @NamedQuery(name = "AccountFees.findByEnabledSince", query = "SELECT a FROM AccountFees a WHERE a.enabledSince = :enabledSince"),
    @NamedQuery(name = "AccountFees.findByDay", query = "SELECT a FROM AccountFees a WHERE a.day = :day"),
    @NamedQuery(name = "AccountFees.findByHour", query = "SELECT a FROM AccountFees a WHERE a.hour = :hour"),
    @NamedQuery(name = "AccountFees.findByFreeBase", query = "SELECT a FROM AccountFees a WHERE a.freeBase = :freeBase"),
    @NamedQuery(name = "AccountFees.findByRecurrenceNumber", query = "SELECT a FROM AccountFees a WHERE a.recurrenceNumber = :recurrenceNumber"),
    @NamedQuery(name = "AccountFees.findByRecurrenceField", query = "SELECT a FROM AccountFees a WHERE a.recurrenceField = :recurrenceField")})
public class AccountFees implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "charge_mode")
    private String chargeMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "run_mode")
    private String runMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "payment_direction")
    private String paymentDirection;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 1)
    @Column(name = "invoice_mode")
    private String invoiceMode;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "enabled_since")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enabledSince;
    @Column(name = "day")
    private Short day;
    @Column(name = "hour")
    private Short hour;
    @Column(name = "free_base")
    private BigDecimal freeBase;
    @Column(name = "recurrence_number")
    private Integer recurrenceNumber;
    @Column(name = "recurrence_field")
    private Integer recurrenceField;
    @ManyToMany(mappedBy = "accountFeesCollection")
    private Collection<Groups> groupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountFeeId")
    private Collection<AccountFeeAmounts> accountFeeAmountsCollection;
    @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes transferTypeId;
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes accountTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountFeeId")
    private Collection<AccountFeeLogs> accountFeeLogsCollection;

    public AccountFees() {
    }

    public AccountFees(Integer id) {
        this.id = id;
    }

    public AccountFees(Integer id, String name, String chargeMode, String runMode, String paymentDirection, boolean enabled, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.chargeMode = chargeMode;
        this.runMode = runMode;
        this.paymentDirection = paymentDirection;
        this.enabled = enabled;
        this.amount = amount;
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

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode;
    }

    public String getRunMode() {
        return runMode;
    }

    public void setRunMode(String runMode) {
        this.runMode = runMode;
    }

    public String getPaymentDirection() {
        return paymentDirection;
    }

    public void setPaymentDirection(String paymentDirection) {
        this.paymentDirection = paymentDirection;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getInvoiceMode() {
        return invoiceMode;
    }

    public void setInvoiceMode(String invoiceMode) {
        this.invoiceMode = invoiceMode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEnabledSince() {
        return enabledSince;
    }

    public void setEnabledSince(Date enabledSince) {
        this.enabledSince = enabledSince;
    }

    public Short getDay() {
        return day;
    }

    public void setDay(Short day) {
        this.day = day;
    }

    public Short getHour() {
        return hour;
    }

    public void setHour(Short hour) {
        this.hour = hour;
    }

    public BigDecimal getFreeBase() {
        return freeBase;
    }

    public void setFreeBase(BigDecimal freeBase) {
        this.freeBase = freeBase;
    }

    public Integer getRecurrenceNumber() {
        return recurrenceNumber;
    }

    public void setRecurrenceNumber(Integer recurrenceNumber) {
        this.recurrenceNumber = recurrenceNumber;
    }

    public Integer getRecurrenceField() {
        return recurrenceField;
    }

    public void setRecurrenceField(Integer recurrenceField) {
        this.recurrenceField = recurrenceField;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<AccountFeeAmounts> getAccountFeeAmountsCollection() {
        return accountFeeAmountsCollection;
    }

    public void setAccountFeeAmountsCollection(Collection<AccountFeeAmounts> accountFeeAmountsCollection) {
        this.accountFeeAmountsCollection = accountFeeAmountsCollection;
    }

    public TransferTypes getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(TransferTypes transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public AccountTypes getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountTypes accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @XmlTransient
    public Collection<AccountFeeLogs> getAccountFeeLogsCollection() {
        return accountFeeLogsCollection;
    }

    public void setAccountFeeLogsCollection(Collection<AccountFeeLogs> accountFeeLogsCollection) {
        this.accountFeeLogsCollection = accountFeeLogsCollection;
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
        if (!(object instanceof AccountFees)) {
            return false;
        }
        AccountFees other = (AccountFees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountFees[ id=" + id + " ]";
    }
    
}
