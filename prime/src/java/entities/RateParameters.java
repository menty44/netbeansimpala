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
@Table(name = "rate_parameters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RateParameters.findAll", query = "SELECT r FROM RateParameters r"),
    @NamedQuery(name = "RateParameters.findById", query = "SELECT r FROM RateParameters r WHERE r.id = :id"),
    @NamedQuery(name = "RateParameters.findBySubclass", query = "SELECT r FROM RateParameters r WHERE r.subclass = :subclass"),
    @NamedQuery(name = "RateParameters.findByDate", query = "SELECT r FROM RateParameters r WHERE r.date = :date"),
    @NamedQuery(name = "RateParameters.findByCreationValue", query = "SELECT r FROM RateParameters r WHERE r.creationValue = :creationValue"),
    @NamedQuery(name = "RateParameters.findByEnabledSince", query = "SELECT r FROM RateParameters r WHERE r.enabledSince = :enabledSince"),
    @NamedQuery(name = "RateParameters.findByDisabledSince", query = "SELECT r FROM RateParameters r WHERE r.disabledSince = :disabledSince"),
    @NamedQuery(name = "RateParameters.findByReinitDate", query = "SELECT r FROM RateParameters r WHERE r.reinitDate = :reinitDate"),
    @NamedQuery(name = "RateParameters.findByInitValue", query = "SELECT r FROM RateParameters r WHERE r.initValue = :initValue"),
    @NamedQuery(name = "RateParameters.findByInitDate", query = "SELECT r FROM RateParameters r WHERE r.initDate = :initDate"),
    @NamedQuery(name = "RateParameters.findByInterest", query = "SELECT r FROM RateParameters r WHERE r.interest = :interest"),
    @NamedQuery(name = "RateParameters.findByBaseMalus", query = "SELECT r FROM RateParameters r WHERE r.baseMalus = :baseMalus"),
    @NamedQuery(name = "RateParameters.findByMinimalD", query = "SELECT r FROM RateParameters r WHERE r.minimalD = :minimalD")})
public class RateParameters implements Serializable {

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
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_value")
    private BigDecimal creationValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled_since")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enabledSince;
    @Column(name = "disabled_since")
    @Temporal(TemporalType.TIMESTAMP)
    private Date disabledSince;
    @Column(name = "reinit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reinitDate;
    @Column(name = "init_value")
    private BigDecimal initValue;
    @Column(name = "init_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initDate;
    @Column(name = "interest")
    private BigDecimal interest;
    @Column(name = "base_malus")
    private BigDecimal baseMalus;
    @Column(name = "minimal_d")
    private BigDecimal minimalD;
    @OneToMany(mappedBy = "aRateParamsId")
    private Collection<Currencies> currenciesCollection;
    @OneToMany(mappedBy = "dRateParamsId")
    private Collection<Currencies> currenciesCollection1;
    @OneToMany(mappedBy = "iRateParamsId")
    private Collection<Currencies> currenciesCollection2;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currencies currencyId;

    public RateParameters() {
    }

    public RateParameters(Integer id) {
        this.id = id;
    }

    public RateParameters(Integer id, String subclass, Date date, BigDecimal creationValue, Date enabledSince) {
        this.id = id;
        this.subclass = subclass;
        this.date = date;
        this.creationValue = creationValue;
        this.enabledSince = enabledSince;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCreationValue() {
        return creationValue;
    }

    public void setCreationValue(BigDecimal creationValue) {
        this.creationValue = creationValue;
    }

    public Date getEnabledSince() {
        return enabledSince;
    }

    public void setEnabledSince(Date enabledSince) {
        this.enabledSince = enabledSince;
    }

    public Date getDisabledSince() {
        return disabledSince;
    }

    public void setDisabledSince(Date disabledSince) {
        this.disabledSince = disabledSince;
    }

    public Date getReinitDate() {
        return reinitDate;
    }

    public void setReinitDate(Date reinitDate) {
        this.reinitDate = reinitDate;
    }

    public BigDecimal getInitValue() {
        return initValue;
    }

    public void setInitValue(BigDecimal initValue) {
        this.initValue = initValue;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getBaseMalus() {
        return baseMalus;
    }

    public void setBaseMalus(BigDecimal baseMalus) {
        this.baseMalus = baseMalus;
    }

    public BigDecimal getMinimalD() {
        return minimalD;
    }

    public void setMinimalD(BigDecimal minimalD) {
        this.minimalD = minimalD;
    }

    @XmlTransient
    public Collection<Currencies> getCurrenciesCollection() {
        return currenciesCollection;
    }

    public void setCurrenciesCollection(Collection<Currencies> currenciesCollection) {
        this.currenciesCollection = currenciesCollection;
    }

    @XmlTransient
    public Collection<Currencies> getCurrenciesCollection1() {
        return currenciesCollection1;
    }

    public void setCurrenciesCollection1(Collection<Currencies> currenciesCollection1) {
        this.currenciesCollection1 = currenciesCollection1;
    }

    @XmlTransient
    public Collection<Currencies> getCurrenciesCollection2() {
        return currenciesCollection2;
    }

    public void setCurrenciesCollection2(Collection<Currencies> currenciesCollection2) {
        this.currenciesCollection2 = currenciesCollection2;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
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
        if (!(object instanceof RateParameters)) {
            return false;
        }
        RateParameters other = (RateParameters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RateParameters[ id=" + id + " ]";
    }
    
}
