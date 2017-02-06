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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "brokering_commission_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrokeringCommissionStatus.findAll", query = "SELECT b FROM BrokeringCommissionStatus b"),
    @NamedQuery(name = "BrokeringCommissionStatus.findById", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.id = :id"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByWhenApply", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.whenApply = :whenApply"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByAmount", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.amount = :amount"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByAmountType", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.amountType = :amountType"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByStartDate", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.startDate = :startDate"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByEndDate", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.endDate = :endDate"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByCreationDate", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.creationDate = :creationDate"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByExpiryDate", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.expiryDate = :expiryDate"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByMaxCount", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.maxCount = :maxCount"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByTotalCount", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.totalCount = :totalCount"),
    @NamedQuery(name = "BrokeringCommissionStatus.findByTotalAmount", query = "SELECT b FROM BrokeringCommissionStatus b WHERE b.totalAmount = :totalAmount")})
public class BrokeringCommissionStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "when_apply")
    private String whenApply;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount_type")
    private Character amountType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "max_count")
    private Integer maxCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_count")
    private int totalCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @JoinColumn(name = "brokering_id", referencedColumnName = "id")
    @ManyToOne
    private Brokerings brokeringId;
    @JoinColumn(name = "broker_commission_id", referencedColumnName = "id")
    @ManyToOne
    private TransactionFees brokerCommissionId;

    public BrokeringCommissionStatus() {
    }

    public BrokeringCommissionStatus(Integer id) {
        this.id = id;
    }

    public BrokeringCommissionStatus(Integer id, String whenApply, BigDecimal amount, Character amountType, Date startDate, int totalCount, BigDecimal totalAmount) {
        this.id = id;
        this.whenApply = whenApply;
        this.amount = amount;
        this.amountType = amountType;
        this.startDate = startDate;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhenApply() {
        return whenApply;
    }

    public void setWhenApply(String whenApply) {
        this.whenApply = whenApply;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Character getAmountType() {
        return amountType;
    }

    public void setAmountType(Character amountType) {
        this.amountType = amountType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Brokerings getBrokeringId() {
        return brokeringId;
    }

    public void setBrokeringId(Brokerings brokeringId) {
        this.brokeringId = brokeringId;
    }

    public TransactionFees getBrokerCommissionId() {
        return brokerCommissionId;
    }

    public void setBrokerCommissionId(TransactionFees brokerCommissionId) {
        this.brokerCommissionId = brokerCommissionId;
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
        if (!(object instanceof BrokeringCommissionStatus)) {
            return false;
        }
        BrokeringCommissionStatus other = (BrokeringCommissionStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BrokeringCommissionStatus[ id=" + id + " ]";
    }
    
}
