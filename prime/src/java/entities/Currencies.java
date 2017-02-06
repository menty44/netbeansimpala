/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "currencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currencies.findAll", query = "SELECT c FROM Currencies c"),
    @NamedQuery(name = "Currencies.findById", query = "SELECT c FROM Currencies c WHERE c.id = :id"),
    @NamedQuery(name = "Currencies.findByName", query = "SELECT c FROM Currencies c WHERE c.name = :name"),
    @NamedQuery(name = "Currencies.findBySymbol", query = "SELECT c FROM Currencies c WHERE c.symbol = :symbol"),
    @NamedQuery(name = "Currencies.findByPattern", query = "SELECT c FROM Currencies c WHERE c.pattern = :pattern")})
public class Currencies implements Serializable {

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
    @Size(min = 1, max = 20)
    @Column(name = "symbol")
    private String symbol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pattern")
    private String pattern;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<GuaranteeTypes> guaranteeTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<AccountTypes> accountTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<PaymentObligations> paymentObligationsCollection;
    @JoinColumn(name = "a_rate_params_id", referencedColumnName = "id")
    @ManyToOne
    private RateParameters aRateParamsId;
    @JoinColumn(name = "d_rate_params_id", referencedColumnName = "id")
    @ManyToOne
    private RateParameters dRateParamsId;
    @JoinColumn(name = "i_rate_params_id", referencedColumnName = "id")
    @ManyToOne
    private RateParameters iRateParamsId;
    @OneToMany(mappedBy = "currencyId")
    private Collection<Ads> adsCollection;
    @OneToMany(mappedBy = "currencyId")
    private Collection<AdInterests> adInterestsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<AdImports> adImportsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<RateParameters> rateParametersCollection;
    @OneToMany(mappedBy = "currencyId")
    private Collection<Tickets> ticketsCollection;

    public Currencies() {
    }

    public Currencies(Integer id) {
        this.id = id;
    }

    public Currencies(Integer id, String name, String symbol, String pattern) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.pattern = pattern;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection() {
        return guaranteeTypesCollection;
    }

    public void setGuaranteeTypesCollection(Collection<GuaranteeTypes> guaranteeTypesCollection) {
        this.guaranteeTypesCollection = guaranteeTypesCollection;
    }

    @XmlTransient
    public Collection<AccountTypes> getAccountTypesCollection() {
        return accountTypesCollection;
    }

    public void setAccountTypesCollection(Collection<AccountTypes> accountTypesCollection) {
        this.accountTypesCollection = accountTypesCollection;
    }

    @XmlTransient
    public Collection<PaymentObligations> getPaymentObligationsCollection() {
        return paymentObligationsCollection;
    }

    public void setPaymentObligationsCollection(Collection<PaymentObligations> paymentObligationsCollection) {
        this.paymentObligationsCollection = paymentObligationsCollection;
    }

    public RateParameters getARateParamsId() {
        return aRateParamsId;
    }

    public void setARateParamsId(RateParameters aRateParamsId) {
        this.aRateParamsId = aRateParamsId;
    }

    public RateParameters getDRateParamsId() {
        return dRateParamsId;
    }

    public void setDRateParamsId(RateParameters dRateParamsId) {
        this.dRateParamsId = dRateParamsId;
    }

    public RateParameters getIRateParamsId() {
        return iRateParamsId;
    }

    public void setIRateParamsId(RateParameters iRateParamsId) {
        this.iRateParamsId = iRateParamsId;
    }

    @XmlTransient
    public Collection<Ads> getAdsCollection() {
        return adsCollection;
    }

    public void setAdsCollection(Collection<Ads> adsCollection) {
        this.adsCollection = adsCollection;
    }

    @XmlTransient
    public Collection<AdInterests> getAdInterestsCollection() {
        return adInterestsCollection;
    }

    public void setAdInterestsCollection(Collection<AdInterests> adInterestsCollection) {
        this.adInterestsCollection = adInterestsCollection;
    }

    @XmlTransient
    public Collection<AdImports> getAdImportsCollection() {
        return adImportsCollection;
    }

    public void setAdImportsCollection(Collection<AdImports> adImportsCollection) {
        this.adImportsCollection = adImportsCollection;
    }

    @XmlTransient
    public Collection<RateParameters> getRateParametersCollection() {
        return rateParametersCollection;
    }

    public void setRateParametersCollection(Collection<RateParameters> rateParametersCollection) {
        this.rateParametersCollection = rateParametersCollection;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
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
        if (!(object instanceof Currencies)) {
            return false;
        }
        Currencies other = (Currencies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Currencies[ id=" + id + " ]";
    }
    
}
