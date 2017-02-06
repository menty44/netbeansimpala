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
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findById", query = "SELECT a FROM Accounts a WHERE a.id = :id"),
    @NamedQuery(name = "Accounts.findBySubclass", query = "SELECT a FROM Accounts a WHERE a.subclass = :subclass"),
    @NamedQuery(name = "Accounts.findByCreationDate", query = "SELECT a FROM Accounts a WHERE a.creationDate = :creationDate"),
    @NamedQuery(name = "Accounts.findByLastClosingDate", query = "SELECT a FROM Accounts a WHERE a.lastClosingDate = :lastClosingDate"),
    @NamedQuery(name = "Accounts.findByOwnerName", query = "SELECT a FROM Accounts a WHERE a.ownerName = :ownerName"),
    @NamedQuery(name = "Accounts.findByCreditLimit", query = "SELECT a FROM Accounts a WHERE a.creditLimit = :creditLimit"),
    @NamedQuery(name = "Accounts.findByUpperCreditLimit", query = "SELECT a FROM Accounts a WHERE a.upperCreditLimit = :upperCreditLimit"),
    @NamedQuery(name = "Accounts.findByMemberStatus", query = "SELECT a FROM Accounts a WHERE a.memberStatus = :memberStatus"),
    @NamedQuery(name = "Accounts.findByLastLowUnitsSent", query = "SELECT a FROM Accounts a WHERE a.lastLowUnitsSent = :lastLowUnitsSent"),
    @NamedQuery(name = "Accounts.findByMemberAction", query = "SELECT a FROM Accounts a WHERE a.memberAction = :memberAction")})
public class Accounts implements Serializable {

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
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "last_closing_date")
    @Temporal(TemporalType.DATE)
    private Date lastClosingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "owner_name")
    private String ownerName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;
    @Column(name = "upper_credit_limit")
    private BigDecimal upperCreditLimit;
    @Size(max = 1)
    @Column(name = "member_status")
    private String memberStatus;
    @Column(name = "last_low_units_sent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLowUnitsSent;
    @Size(max = 1)
    @Column(name = "member_action")
    private String memberAction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AccountLimitLogs> accountLimitLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAccountId")
    private Collection<ScheduledPayments> scheduledPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toAccountId")
    private Collection<ScheduledPayments> scheduledPaymentsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AccountFeeAmounts> accountFeeAmountsCollection;
    @OneToMany(mappedBy = "systemAccountId")
    private Collection<AccountTypes> accountTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAccountId")
    private Collection<Transfers> transfersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toAccountId")
    private Collection<Transfers> transfersCollection1;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne
    private AccountTypes typeId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AccountRates> accountRatesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AmountReservations> amountReservationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<ClosedAccountBalances> closedAccountBalancesCollection;

    public Accounts() {
    }

    public Accounts(Integer id) {
        this.id = id;
    }

    public Accounts(Integer id, String subclass, Date creationDate, String ownerName) {
        this.id = id;
        this.subclass = subclass;
        this.creationDate = creationDate;
        this.ownerName = ownerName;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastClosingDate() {
        return lastClosingDate;
    }

    public void setLastClosingDate(Date lastClosingDate) {
        this.lastClosingDate = lastClosingDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getUpperCreditLimit() {
        return upperCreditLimit;
    }

    public void setUpperCreditLimit(BigDecimal upperCreditLimit) {
        this.upperCreditLimit = upperCreditLimit;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Date getLastLowUnitsSent() {
        return lastLowUnitsSent;
    }

    public void setLastLowUnitsSent(Date lastLowUnitsSent) {
        this.lastLowUnitsSent = lastLowUnitsSent;
    }

    public String getMemberAction() {
        return memberAction;
    }

    public void setMemberAction(String memberAction) {
        this.memberAction = memberAction;
    }

    @XmlTransient
    public Collection<AccountLimitLogs> getAccountLimitLogsCollection() {
        return accountLimitLogsCollection;
    }

    public void setAccountLimitLogsCollection(Collection<AccountLimitLogs> accountLimitLogsCollection) {
        this.accountLimitLogsCollection = accountLimitLogsCollection;
    }

    @XmlTransient
    public Collection<ScheduledPayments> getScheduledPaymentsCollection() {
        return scheduledPaymentsCollection;
    }

    public void setScheduledPaymentsCollection(Collection<ScheduledPayments> scheduledPaymentsCollection) {
        this.scheduledPaymentsCollection = scheduledPaymentsCollection;
    }

    @XmlTransient
    public Collection<ScheduledPayments> getScheduledPaymentsCollection1() {
        return scheduledPaymentsCollection1;
    }

    public void setScheduledPaymentsCollection1(Collection<ScheduledPayments> scheduledPaymentsCollection1) {
        this.scheduledPaymentsCollection1 = scheduledPaymentsCollection1;
    }

    @XmlTransient
    public Collection<AccountFeeAmounts> getAccountFeeAmountsCollection() {
        return accountFeeAmountsCollection;
    }

    public void setAccountFeeAmountsCollection(Collection<AccountFeeAmounts> accountFeeAmountsCollection) {
        this.accountFeeAmountsCollection = accountFeeAmountsCollection;
    }

    @XmlTransient
    public Collection<AccountTypes> getAccountTypesCollection() {
        return accountTypesCollection;
    }

    public void setAccountTypesCollection(Collection<AccountTypes> accountTypesCollection) {
        this.accountTypesCollection = accountTypesCollection;
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

    public AccountTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(AccountTypes typeId) {
        this.typeId = typeId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @XmlTransient
    public Collection<AccountRates> getAccountRatesCollection() {
        return accountRatesCollection;
    }

    public void setAccountRatesCollection(Collection<AccountRates> accountRatesCollection) {
        this.accountRatesCollection = accountRatesCollection;
    }

    @XmlTransient
    public Collection<AmountReservations> getAmountReservationsCollection() {
        return amountReservationsCollection;
    }

    public void setAmountReservationsCollection(Collection<AmountReservations> amountReservationsCollection) {
        this.amountReservationsCollection = amountReservationsCollection;
    }

    @XmlTransient
    public Collection<ClosedAccountBalances> getClosedAccountBalancesCollection() {
        return closedAccountBalancesCollection;
    }

    public void setClosedAccountBalancesCollection(Collection<ClosedAccountBalances> closedAccountBalancesCollection) {
        this.closedAccountBalancesCollection = closedAccountBalancesCollection;
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
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Accounts[ id=" + id + " ]";
    }
    
}
