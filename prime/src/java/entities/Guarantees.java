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
import javax.persistence.OneToOne;
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
@Table(name = "guarantees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guarantees.findAll", query = "SELECT g FROM Guarantees g"),
    @NamedQuery(name = "Guarantees.findById", query = "SELECT g FROM Guarantees g WHERE g.id = :id"),
    @NamedQuery(name = "Guarantees.findByStatus", query = "SELECT g FROM Guarantees g WHERE g.status = :status"),
    @NamedQuery(name = "Guarantees.findByAmount", query = "SELECT g FROM Guarantees g WHERE g.amount = :amount"),
    @NamedQuery(name = "Guarantees.findByCreditFee", query = "SELECT g FROM Guarantees g WHERE g.creditFee = :creditFee"),
    @NamedQuery(name = "Guarantees.findByCreditFeeType", query = "SELECT g FROM Guarantees g WHERE g.creditFeeType = :creditFeeType"),
    @NamedQuery(name = "Guarantees.findByIssueFee", query = "SELECT g FROM Guarantees g WHERE g.issueFee = :issueFee"),
    @NamedQuery(name = "Guarantees.findByIssueFeeType", query = "SELECT g FROM Guarantees g WHERE g.issueFeeType = :issueFeeType"),
    @NamedQuery(name = "Guarantees.findByBeginDate", query = "SELECT g FROM Guarantees g WHERE g.beginDate = :beginDate"),
    @NamedQuery(name = "Guarantees.findByEndDate", query = "SELECT g FROM Guarantees g WHERE g.endDate = :endDate"),
    @NamedQuery(name = "Guarantees.findByRegistrationDate", query = "SELECT g FROM Guarantees g WHERE g.registrationDate = :registrationDate")})
public class Guarantees implements Serializable {

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
    @Column(name = "credit_fee")
    private BigDecimal creditFee;
    @Size(max = 1)
    @Column(name = "credit_fee_type")
    private String creditFeeType;
    @Column(name = "issue_fee")
    private BigDecimal issueFee;
    @Size(max = 1)
    @Column(name = "issue_fee_type")
    private String issueFeeType;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guaranteeId")
    private Collection<GuaranteeLogs> guaranteeLogsCollection;
    @OneToMany(mappedBy = "guaranteeId")
    private Collection<PaymentObligations> paymentObligationsCollection;
    @JoinColumn(name = "certification_id", referencedColumnName = "id")
    @ManyToOne
    private Certifications certificationId;
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne
    private Members sellerId;
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members buyerId;
    @JoinColumn(name = "guarantee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GuaranteeTypes guaranteeTypeId;
    @JoinColumn(name = "issuer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members issuerId;
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    @OneToOne
    private Loans loanId;
    @OneToMany(mappedBy = "guaranteeId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public Guarantees() {
    }

    public Guarantees(Integer id) {
        this.id = id;
    }

    public Guarantees(Integer id, String status, BigDecimal amount, Date registrationDate) {
        this.id = id;
        this.status = status;
        this.amount = amount;
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

    public BigDecimal getCreditFee() {
        return creditFee;
    }

    public void setCreditFee(BigDecimal creditFee) {
        this.creditFee = creditFee;
    }

    public String getCreditFeeType() {
        return creditFeeType;
    }

    public void setCreditFeeType(String creditFeeType) {
        this.creditFeeType = creditFeeType;
    }

    public BigDecimal getIssueFee() {
        return issueFee;
    }

    public void setIssueFee(BigDecimal issueFee) {
        this.issueFee = issueFee;
    }

    public String getIssueFeeType() {
        return issueFeeType;
    }

    public void setIssueFeeType(String issueFeeType) {
        this.issueFeeType = issueFeeType;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @XmlTransient
    public Collection<GuaranteeLogs> getGuaranteeLogsCollection() {
        return guaranteeLogsCollection;
    }

    public void setGuaranteeLogsCollection(Collection<GuaranteeLogs> guaranteeLogsCollection) {
        this.guaranteeLogsCollection = guaranteeLogsCollection;
    }

    @XmlTransient
    public Collection<PaymentObligations> getPaymentObligationsCollection() {
        return paymentObligationsCollection;
    }

    public void setPaymentObligationsCollection(Collection<PaymentObligations> paymentObligationsCollection) {
        this.paymentObligationsCollection = paymentObligationsCollection;
    }

    public Certifications getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Certifications certificationId) {
        this.certificationId = certificationId;
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

    public Loans getLoanId() {
        return loanId;
    }

    public void setLoanId(Loans loanId) {
        this.loanId = loanId;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection() {
        return customFieldValuesCollection;
    }

    public void setCustomFieldValuesCollection(Collection<CustomFieldValues> customFieldValuesCollection) {
        this.customFieldValuesCollection = customFieldValuesCollection;
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
        if (!(object instanceof Guarantees)) {
            return false;
        }
        Guarantees other = (Guarantees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Guarantees[ id=" + id + " ]";
    }
    
}
