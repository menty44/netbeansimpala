/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "brokerings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brokerings.findAll", query = "SELECT b FROM Brokerings b"),
    @NamedQuery(name = "Brokerings.findById", query = "SELECT b FROM Brokerings b WHERE b.id = :id"),
    @NamedQuery(name = "Brokerings.findByStartDate", query = "SELECT b FROM Brokerings b WHERE b.startDate = :startDate"),
    @NamedQuery(name = "Brokerings.findByEndDate", query = "SELECT b FROM Brokerings b WHERE b.endDate = :endDate")})
public class Brokerings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToMany(mappedBy = "brokeringId")
    private Collection<BrokerCommissionContracts> brokerCommissionContractsCollection;
    @OneToMany(mappedBy = "brokeringId")
    private Collection<BrokeringCommissionStatus> brokeringCommissionStatusCollection;
    @JoinColumn(name = "broker_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members brokerId;
    @JoinColumn(name = "brokered_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members brokeredId;

    public Brokerings() {
    }

    public Brokerings(Integer id) {
        this.id = id;
    }

    public Brokerings(Integer id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Collection<BrokerCommissionContracts> getBrokerCommissionContractsCollection() {
        return brokerCommissionContractsCollection;
    }

    public void setBrokerCommissionContractsCollection(Collection<BrokerCommissionContracts> brokerCommissionContractsCollection) {
        this.brokerCommissionContractsCollection = brokerCommissionContractsCollection;
    }

    @XmlTransient
    public Collection<BrokeringCommissionStatus> getBrokeringCommissionStatusCollection() {
        return brokeringCommissionStatusCollection;
    }

    public void setBrokeringCommissionStatusCollection(Collection<BrokeringCommissionStatus> brokeringCommissionStatusCollection) {
        this.brokeringCommissionStatusCollection = brokeringCommissionStatusCollection;
    }

    public Members getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Members brokerId) {
        this.brokerId = brokerId;
    }

    public Members getBrokeredId() {
        return brokeredId;
    }

    public void setBrokeredId(Members brokeredId) {
        this.brokeredId = brokeredId;
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
        if (!(object instanceof Brokerings)) {
            return false;
        }
        Brokerings other = (Brokerings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Brokerings[ id=" + id + " ]";
    }
    
}
