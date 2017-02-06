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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "account_fee_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountFeeLogs.findAll", query = "SELECT a FROM AccountFeeLogs a"),
    @NamedQuery(name = "AccountFeeLogs.findById", query = "SELECT a FROM AccountFeeLogs a WHERE a.id = :id"),
    @NamedQuery(name = "AccountFeeLogs.findByDate", query = "SELECT a FROM AccountFeeLogs a WHERE a.date = :date"),
    @NamedQuery(name = "AccountFeeLogs.findByRechargingFailed", query = "SELECT a FROM AccountFeeLogs a WHERE a.rechargingFailed = :rechargingFailed"),
    @NamedQuery(name = "AccountFeeLogs.findByRechargeAttempt", query = "SELECT a FROM AccountFeeLogs a WHERE a.rechargeAttempt = :rechargeAttempt"),
    @NamedQuery(name = "AccountFeeLogs.findByFailedMembers", query = "SELECT a FROM AccountFeeLogs a WHERE a.failedMembers = :failedMembers"),
    @NamedQuery(name = "AccountFeeLogs.findByTotalMembers", query = "SELECT a FROM AccountFeeLogs a WHERE a.totalMembers = :totalMembers"),
    @NamedQuery(name = "AccountFeeLogs.findByFinishDate", query = "SELECT a FROM AccountFeeLogs a WHERE a.finishDate = :finishDate"),
    @NamedQuery(name = "AccountFeeLogs.findByAmount", query = "SELECT a FROM AccountFeeLogs a WHERE a.amount = :amount"),
    @NamedQuery(name = "AccountFeeLogs.findByFreeBase", query = "SELECT a FROM AccountFeeLogs a WHERE a.freeBase = :freeBase"),
    @NamedQuery(name = "AccountFeeLogs.findByBeginDate", query = "SELECT a FROM AccountFeeLogs a WHERE a.beginDate = :beginDate"),
    @NamedQuery(name = "AccountFeeLogs.findByEndDate", query = "SELECT a FROM AccountFeeLogs a WHERE a.endDate = :endDate")})
public class AccountFeeLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recharging_failed")
    private boolean rechargingFailed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recharge_attempt")
    private int rechargeAttempt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "failed_members")
    private int failedMembers;
    @Column(name = "total_members")
    private Integer totalMembers;
    @Column(name = "finish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "free_base")
    private BigDecimal freeBase;
    @Column(name = "begin_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinTable(name = "members_pending_charge", joinColumns = {
        @JoinColumn(name = "account_fee_log_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Members> membersCollection;
    @OneToMany(mappedBy = "accountFeeLogId")
    private Collection<Invoices> invoicesCollection;
    @OneToMany(mappedBy = "accountFeeLogId")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "account_fee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountFees accountFeeId;
    @OneToMany(mappedBy = "accountFeeLogId")
    private Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection;

    public AccountFeeLogs() {
    }

    public AccountFeeLogs(Integer id) {
        this.id = id;
    }

    public AccountFeeLogs(Integer id, Date date, boolean rechargingFailed, int rechargeAttempt, int failedMembers, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.rechargingFailed = rechargingFailed;
        this.rechargeAttempt = rechargeAttempt;
        this.failedMembers = failedMembers;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getRechargingFailed() {
        return rechargingFailed;
    }

    public void setRechargingFailed(boolean rechargingFailed) {
        this.rechargingFailed = rechargingFailed;
    }

    public int getRechargeAttempt() {
        return rechargeAttempt;
    }

    public void setRechargeAttempt(int rechargeAttempt) {
        this.rechargeAttempt = rechargeAttempt;
    }

    public int getFailedMembers() {
        return failedMembers;
    }

    public void setFailedMembers(int failedMembers) {
        this.failedMembers = failedMembers;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFreeBase() {
        return freeBase;
    }

    public void setFreeBase(BigDecimal freeBase) {
        this.freeBase = freeBase;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public AccountFees getAccountFeeId() {
        return accountFeeId;
    }

    public void setAccountFeeId(AccountFees accountFeeId) {
        this.accountFeeId = accountFeeId;
    }

    @XmlTransient
    public Collection<MemberAccountFeeLogs> getMemberAccountFeeLogsCollection() {
        return memberAccountFeeLogsCollection;
    }

    public void setMemberAccountFeeLogsCollection(Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection) {
        this.memberAccountFeeLogsCollection = memberAccountFeeLogsCollection;
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
        if (!(object instanceof AccountFeeLogs)) {
            return false;
        }
        AccountFeeLogs other = (AccountFeeLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountFeeLogs[ id=" + id + " ]";
    }
    
}
