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
@Table(name = "closed_account_balances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClosedAccountBalances.findAll", query = "SELECT c FROM ClosedAccountBalances c"),
    @NamedQuery(name = "ClosedAccountBalances.findById", query = "SELECT c FROM ClosedAccountBalances c WHERE c.id = :id"),
    @NamedQuery(name = "ClosedAccountBalances.findByDate", query = "SELECT c FROM ClosedAccountBalances c WHERE c.date = :date"),
    @NamedQuery(name = "ClosedAccountBalances.findByBalance", query = "SELECT c FROM ClosedAccountBalances c WHERE c.balance = :balance"),
    @NamedQuery(name = "ClosedAccountBalances.findByReserved", query = "SELECT c FROM ClosedAccountBalances c WHERE c.reserved = :reserved")})
public class ClosedAccountBalances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private BigDecimal balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reserved")
    private BigDecimal reserved;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts accountId;

    public ClosedAccountBalances() {
    }

    public ClosedAccountBalances(Long id) {
        this.id = id;
    }

    public ClosedAccountBalances(Long id, Date date, BigDecimal balance, BigDecimal reserved) {
        this.id = id;
        this.date = date;
        this.balance = balance;
        this.reserved = reserved;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getReserved() {
        return reserved;
    }

    public void setReserved(BigDecimal reserved) {
        this.reserved = reserved;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
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
        if (!(object instanceof ClosedAccountBalances)) {
            return false;
        }
        ClosedAccountBalances other = (ClosedAccountBalances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClosedAccountBalances[ id=" + id + " ]";
    }
    
}
