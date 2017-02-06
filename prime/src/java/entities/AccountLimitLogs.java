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
@Table(name = "account_limit_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountLimitLogs.findAll", query = "SELECT a FROM AccountLimitLogs a"),
    @NamedQuery(name = "AccountLimitLogs.findById", query = "SELECT a FROM AccountLimitLogs a WHERE a.id = :id"),
    @NamedQuery(name = "AccountLimitLogs.findByDate", query = "SELECT a FROM AccountLimitLogs a WHERE a.date = :date"),
    @NamedQuery(name = "AccountLimitLogs.findByCreditLimit", query = "SELECT a FROM AccountLimitLogs a WHERE a.creditLimit = :creditLimit"),
    @NamedQuery(name = "AccountLimitLogs.findByUpperCreditLimit", query = "SELECT a FROM AccountLimitLogs a WHERE a.upperCreditLimit = :upperCreditLimit")})
public class AccountLimitLogs implements Serializable {

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
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;
    @Column(name = "upper_credit_limit")
    private BigDecimal upperCreditLimit;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts accountId;

    public AccountLimitLogs() {
    }

    public AccountLimitLogs(Long id) {
        this.id = id;
    }

    public AccountLimitLogs(Long id, Date date) {
        this.id = id;
        this.date = date;
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

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
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
        if (!(object instanceof AccountLimitLogs)) {
            return false;
        }
        AccountLimitLogs other = (AccountLimitLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountLimitLogs[ id=" + id + " ]";
    }
    
}
