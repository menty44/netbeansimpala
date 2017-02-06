/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "member_account_fee_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberAccountFeeLogs.findAll", query = "SELECT m FROM MemberAccountFeeLogs m"),
    @NamedQuery(name = "MemberAccountFeeLogs.findById", query = "SELECT m FROM MemberAccountFeeLogs m WHERE m.id = :id"),
    @NamedQuery(name = "MemberAccountFeeLogs.findByDate", query = "SELECT m FROM MemberAccountFeeLogs m WHERE m.date = :date"),
    @NamedQuery(name = "MemberAccountFeeLogs.findByAmount", query = "SELECT m FROM MemberAccountFeeLogs m WHERE m.amount = :amount"),
    @NamedQuery(name = "MemberAccountFeeLogs.findBySuccess", query = "SELECT m FROM MemberAccountFeeLogs m WHERE m.success = :success"),
    @NamedQuery(name = "MemberAccountFeeLogs.findByRechargeAttempt", query = "SELECT m FROM MemberAccountFeeLogs m WHERE m.rechargeAttempt = :rechargeAttempt")})
public class MemberAccountFeeLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "success")
    private boolean success;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recharge_attempt")
    private int rechargeAttempt;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "account_fee_log_id", referencedColumnName = "id")
    @ManyToOne
    private AccountFeeLogs accountFeeLogId;
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne
    private Invoices invoiceId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members memberId;

    public MemberAccountFeeLogs() {
    }

    public MemberAccountFeeLogs(Long id) {
        this.id = id;
    }

    public MemberAccountFeeLogs(Long id, Date date, boolean success, int rechargeAttempt) {
        this.id = id;
        this.date = date;
        this.success = success;
        this.rechargeAttempt = rechargeAttempt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRechargeAttempt() {
        return rechargeAttempt;
    }

    public void setRechargeAttempt(int rechargeAttempt) {
        this.rechargeAttempt = rechargeAttempt;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public AccountFeeLogs getAccountFeeLogId() {
        return accountFeeLogId;
    }

    public void setAccountFeeLogId(AccountFeeLogs accountFeeLogId) {
        this.accountFeeLogId = accountFeeLogId;
    }

    public Invoices getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoices invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
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
        if (!(object instanceof MemberAccountFeeLogs)) {
            return false;
        }
        MemberAccountFeeLogs other = (MemberAccountFeeLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberAccountFeeLogs[ id=" + id + " ]";
    }
    
}
