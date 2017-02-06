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
@Table(name = "broker_commission_contracts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrokerCommissionContracts.findAll", query = "SELECT b FROM BrokerCommissionContracts b"),
    @NamedQuery(name = "BrokerCommissionContracts.findById", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.id = :id"),
    @NamedQuery(name = "BrokerCommissionContracts.findByAmountValue", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.amountValue = :amountValue"),
    @NamedQuery(name = "BrokerCommissionContracts.findByAmountType", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.amountType = :amountType"),
    @NamedQuery(name = "BrokerCommissionContracts.findByStartDate", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.startDate = :startDate"),
    @NamedQuery(name = "BrokerCommissionContracts.findByEndDate", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.endDate = :endDate"),
    @NamedQuery(name = "BrokerCommissionContracts.findByStatus", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.status = :status"),
    @NamedQuery(name = "BrokerCommissionContracts.findByStatusBeforeSuspension", query = "SELECT b FROM BrokerCommissionContracts b WHERE b.statusBeforeSuspension = :statusBeforeSuspension")})
public class BrokerCommissionContracts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount_value")
    private BigDecimal amountValue;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Size(max = 1)
    @Column(name = "status_before_suspension")
    private String statusBeforeSuspension;
    @JoinColumn(name = "cancelled_by_id", referencedColumnName = "id")
    @ManyToOne
    private Members cancelledById;
    @JoinColumn(name = "brokering_id", referencedColumnName = "id")
    @ManyToOne
    private Brokerings brokeringId;
    @JoinColumn(name = "broker_commission_id", referencedColumnName = "id")
    @ManyToOne
    private TransactionFees brokerCommissionId;
    @OneToMany(mappedBy = "brokerCommissionContractId")
    private Collection<Transfers> transfersCollection;

    public BrokerCommissionContracts() {
    }

    public BrokerCommissionContracts(Integer id) {
        this.id = id;
    }

    public BrokerCommissionContracts(Integer id, BigDecimal amountValue, Character amountType, Date startDate, String status) {
        this.id = id;
        this.amountValue = amountValue;
        this.amountType = amountType;
        this.startDate = startDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(BigDecimal amountValue) {
        this.amountValue = amountValue;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusBeforeSuspension() {
        return statusBeforeSuspension;
    }

    public void setStatusBeforeSuspension(String statusBeforeSuspension) {
        this.statusBeforeSuspension = statusBeforeSuspension;
    }

    public Members getCancelledById() {
        return cancelledById;
    }

    public void setCancelledById(Members cancelledById) {
        this.cancelledById = cancelledById;
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

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
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
        if (!(object instanceof BrokerCommissionContracts)) {
            return false;
        }
        BrokerCommissionContracts other = (BrokerCommissionContracts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BrokerCommissionContracts[ id=" + id + " ]";
    }
    
}
