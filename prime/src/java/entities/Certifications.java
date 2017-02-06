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
@Table(name = "certifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certifications.findAll", query = "SELECT c FROM Certifications c"),
    @NamedQuery(name = "Certifications.findById", query = "SELECT c FROM Certifications c WHERE c.id = :id"),
    @NamedQuery(name = "Certifications.findByAmount", query = "SELECT c FROM Certifications c WHERE c.amount = :amount"),
    @NamedQuery(name = "Certifications.findByBeginDate", query = "SELECT c FROM Certifications c WHERE c.beginDate = :beginDate"),
    @NamedQuery(name = "Certifications.findByEndDate", query = "SELECT c FROM Certifications c WHERE c.endDate = :endDate"),
    @NamedQuery(name = "Certifications.findByStatus", query = "SELECT c FROM Certifications c WHERE c.status = :status")})
public class Certifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "certificationId")
    private Collection<CertificationLogs> certificationLogsCollection;
    @OneToMany(mappedBy = "certificationId")
    private Collection<Guarantees> guaranteesCollection;
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members buyerId;
    @JoinColumn(name = "guarantee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GuaranteeTypes guaranteeTypeId;
    @JoinColumn(name = "issuer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members issuerId;

    public Certifications() {
    }

    public Certifications(Integer id) {
        this.id = id;
    }

    public Certifications(Integer id, BigDecimal amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
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

    @XmlTransient
    public Collection<CertificationLogs> getCertificationLogsCollection() {
        return certificationLogsCollection;
    }

    public void setCertificationLogsCollection(Collection<CertificationLogs> certificationLogsCollection) {
        this.certificationLogsCollection = certificationLogsCollection;
    }

    @XmlTransient
    public Collection<Guarantees> getGuaranteesCollection() {
        return guaranteesCollection;
    }

    public void setGuaranteesCollection(Collection<Guarantees> guaranteesCollection) {
        this.guaranteesCollection = guaranteesCollection;
    }

    public Members getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Members buyerId) {
        this.buyerId = buyerId;
    }

    public GuaranteeTypes getGuaranteeTypeId() {
        return guaranteeTypeId;
    }

    public void setGuaranteeTypeId(GuaranteeTypes guaranteeTypeId) {
        this.guaranteeTypeId = guaranteeTypeId;
    }

    public Members getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Members issuerId) {
        this.issuerId = issuerId;
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
        if (!(object instanceof Certifications)) {
            return false;
        }
        Certifications other = (Certifications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Certifications[ id=" + id + " ]";
    }
    
}
