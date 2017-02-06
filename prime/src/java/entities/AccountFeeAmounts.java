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
@Table(name = "account_fee_amounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountFeeAmounts.findAll", query = "SELECT a FROM AccountFeeAmounts a"),
    @NamedQuery(name = "AccountFeeAmounts.findById", query = "SELECT a FROM AccountFeeAmounts a WHERE a.id = :id"),
    @NamedQuery(name = "AccountFeeAmounts.findByDate", query = "SELECT a FROM AccountFeeAmounts a WHERE a.date = :date"),
    @NamedQuery(name = "AccountFeeAmounts.findByAvailableBalance", query = "SELECT a FROM AccountFeeAmounts a WHERE a.availableBalance = :availableBalance"),
    @NamedQuery(name = "AccountFeeAmounts.findByAmount", query = "SELECT a FROM AccountFeeAmounts a WHERE a.amount = :amount")})
public class AccountFeeAmounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_balance")
    private BigDecimal availableBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts accountId;
    @JoinColumn(name = "account_fee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountFees accountFeeId;

    public AccountFeeAmounts() {
    }

    public AccountFeeAmounts(Integer id) {
        this.id = id;
    }

    public AccountFeeAmounts(Integer id, Date date, BigDecimal availableBalance, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.availableBalance = availableBalance;
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

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
    }

    public AccountFees getAccountFeeId() {
        return accountFeeId;
    }

    public void setAccountFeeId(AccountFees accountFeeId) {
        this.accountFeeId = accountFeeId;
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
        if (!(object instanceof AccountFeeAmounts)) {
            return false;
        }
        AccountFeeAmounts other = (AccountFeeAmounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountFeeAmounts[ id=" + id + " ]";
    }
    
}
