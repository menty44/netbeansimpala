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
@Table(name = "loan_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanPayments.findAll", query = "SELECT l FROM LoanPayments l"),
    @NamedQuery(name = "LoanPayments.findById", query = "SELECT l FROM LoanPayments l WHERE l.id = :id"),
    @NamedQuery(name = "LoanPayments.findByPaymentIndex", query = "SELECT l FROM LoanPayments l WHERE l.paymentIndex = :paymentIndex"),
    @NamedQuery(name = "LoanPayments.findByExpirationDate", query = "SELECT l FROM LoanPayments l WHERE l.expirationDate = :expirationDate"),
    @NamedQuery(name = "LoanPayments.findByAmount", query = "SELECT l FROM LoanPayments l WHERE l.amount = :amount"),
    @NamedQuery(name = "LoanPayments.findByRepaidAmount", query = "SELECT l FROM LoanPayments l WHERE l.repaidAmount = :repaidAmount"),
    @NamedQuery(name = "LoanPayments.findByStatus", query = "SELECT l FROM LoanPayments l WHERE l.status = :status"),
    @NamedQuery(name = "LoanPayments.findByRepaymentDate", query = "SELECT l FROM LoanPayments l WHERE l.repaymentDate = :repaymentDate")})
public class LoanPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_index")
    private int paymentIndex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "repaid_amount")
    private BigDecimal repaidAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Column(name = "repayment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repaymentDate;
    @OneToMany(mappedBy = "loanPaymentId")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "external_transfer_id", referencedColumnName = "id")
    @ManyToOne
    private ExternalTransfers externalTransferId;
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Loans loanId;

    public LoanPayments() {
    }

    public LoanPayments(Integer id) {
        this.id = id;
    }

    public LoanPayments(Integer id, int paymentIndex, Date expirationDate, BigDecimal amount, BigDecimal repaidAmount, String status) {
        this.id = id;
        this.paymentIndex = paymentIndex;
        this.expirationDate = expirationDate;
        this.amount = amount;
        this.repaidAmount = repaidAmount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPaymentIndex() {
        return paymentIndex;
    }

    public void setPaymentIndex(int paymentIndex) {
        this.paymentIndex = paymentIndex;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRepaidAmount() {
        return repaidAmount;
    }

    public void setRepaidAmount(BigDecimal repaidAmount) {
        this.repaidAmount = repaidAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public ExternalTransfers getExternalTransferId() {
        return externalTransferId;
    }

    public void setExternalTransferId(ExternalTransfers externalTransferId) {
        this.externalTransferId = externalTransferId;
    }

    public Loans getLoanId() {
        return loanId;
    }

    public void setLoanId(Loans loanId) {
        this.loanId = loanId;
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
        if (!(object instanceof LoanPayments)) {
            return false;
        }
        LoanPayments other = (LoanPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoanPayments[ id=" + id + " ]";
    }
    
}
