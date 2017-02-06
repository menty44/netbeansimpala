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
@Table(name = "payment_obligations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentObligations.findAll", query = "SELECT p FROM PaymentObligations p"),
    @NamedQuery(name = "PaymentObligations.findById", query = "SELECT p FROM PaymentObligations p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentObligations.findByStatus", query = "SELECT p FROM PaymentObligations p WHERE p.status = :status"),
    @NamedQuery(name = "PaymentObligations.findByAmount", query = "SELECT p FROM PaymentObligations p WHERE p.amount = :amount"),
    @NamedQuery(name = "PaymentObligations.findByExpirationDate", query = "SELECT p FROM PaymentObligations p WHERE p.expirationDate = :expirationDate"),
    @NamedQuery(name = "PaymentObligations.findByMaxPublishDate", query = "SELECT p FROM PaymentObligations p WHERE p.maxPublishDate = :maxPublishDate"),
    @NamedQuery(name = "PaymentObligations.findByRegistrationDate", query = "SELECT p FROM PaymentObligations p WHERE p.registrationDate = :registrationDate")})
public class PaymentObligations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_publish_date")
    @Temporal(TemporalType.DATE)
    private Date maxPublishDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "guarantee_id", referencedColumnName = "id")
    @ManyToOne
    private Guarantees guaranteeId;
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members sellerId;
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members buyerId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currencies currencyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentObligationId")
    private Collection<PaymentObligationLogs> paymentObligationLogsCollection;

    public PaymentObligations() {
    }

    public PaymentObligations(Integer id) {
        this.id = id;
    }

    public PaymentObligations(Integer id, String status, BigDecimal amount, Date expirationDate, Date maxPublishDate, Date registrationDate) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.maxPublishDate = maxPublishDate;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getMaxPublishDate() {
        return maxPublishDate;
    }

    public void setMaxPublishDate(Date maxPublishDate) {
        this.maxPublishDate = maxPublishDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Guarantees getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Guarantees guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Members getSellerId() {
        return sellerId;
    }

    public void setSellerId(Members sellerId) {
        this.sellerId = sellerId;
    }

    public Members getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Members buyerId) {
        this.buyerId = buyerId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
    }

    @XmlTransient
    public Collection<PaymentObligationLogs> getPaymentObligationLogsCollection() {
        return paymentObligationLogsCollection;
    }

    public void setPaymentObligationLogsCollection(Collection<PaymentObligationLogs> paymentObligationLogsCollection) {
        this.paymentObligationLogsCollection = paymentObligationLogsCollection;
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
        if (!(object instanceof PaymentObligations)) {
            return false;
        }
        PaymentObligations other = (PaymentObligations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PaymentObligations[ id=" + id + " ]";
    }
    
}
