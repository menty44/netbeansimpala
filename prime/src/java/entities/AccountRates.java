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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "account_rates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountRates.findAll", query = "SELECT a FROM AccountRates a"),
    @NamedQuery(name = "AccountRates.findById", query = "SELECT a FROM AccountRates a WHERE a.id = :id"),
    @NamedQuery(name = "AccountRates.findByEmissionDate", query = "SELECT a FROM AccountRates a WHERE a.emissionDate = :emissionDate"),
    @NamedQuery(name = "AccountRates.findByExpirationDate", query = "SELECT a FROM AccountRates a WHERE a.expirationDate = :expirationDate"),
    @NamedQuery(name = "AccountRates.findByIRate", query = "SELECT a FROM AccountRates a WHERE a.iRate = :iRate"),
    @NamedQuery(name = "AccountRates.findByRateBalanceCorrection", query = "SELECT a FROM AccountRates a WHERE a.rateBalanceCorrection = :rateBalanceCorrection")})
public class AccountRates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "emission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissionDate;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "i_rate")
    private BigDecimal iRate;
    @Column(name = "rate_balance_correction")
    private BigDecimal rateBalanceCorrection;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transfers transferId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts accountId;

    public AccountRates() {
    }

    public AccountRates(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getIRate() {
        return iRate;
    }

    public void setIRate(BigDecimal iRate) {
        this.iRate = iRate;
    }

    public BigDecimal getRateBalanceCorrection() {
        return rateBalanceCorrection;
    }

    public void setRateBalanceCorrection(BigDecimal rateBalanceCorrection) {
        this.rateBalanceCorrection = rateBalanceCorrection;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
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
        if (!(object instanceof AccountRates)) {
            return false;
        }
        AccountRates other = (AccountRates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountRates[ id=" + id + " ]";
    }
    
}
