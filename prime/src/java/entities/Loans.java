/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "loans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loans.findAll", query = "SELECT l FROM Loans l"),
    @NamedQuery(name = "Loans.findById", query = "SELECT l FROM Loans l WHERE l.id = :id"),
    @NamedQuery(name = "Loans.findByTotalAmount", query = "SELECT l FROM Loans l WHERE l.totalAmount = :totalAmount"),
    @NamedQuery(name = "Loans.findByType", query = "SELECT l FROM Loans l WHERE l.type = :type"),
    @NamedQuery(name = "Loans.findByGrantFeeValue", query = "SELECT l FROM Loans l WHERE l.grantFeeValue = :grantFeeValue"),
    @NamedQuery(name = "Loans.findByGrantFeeType", query = "SELECT l FROM Loans l WHERE l.grantFeeType = :grantFeeType"),
    @NamedQuery(name = "Loans.findByMonthlyInterest", query = "SELECT l FROM Loans l WHERE l.monthlyInterest = :monthlyInterest"),
    @NamedQuery(name = "Loans.findByExpirationFeeValue", query = "SELECT l FROM Loans l WHERE l.expirationFeeValue = :expirationFeeValue"),
    @NamedQuery(name = "Loans.findByExpirationFeeType", query = "SELECT l FROM Loans l WHERE l.expirationFeeType = :expirationFeeType"),
    @NamedQuery(name = "Loans.findByExpirationDailyInterest", query = "SELECT l FROM Loans l WHERE l.expirationDailyInterest = :expirationDailyInterest")})
public class Loans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "type")
    private String type;
    @Column(name = "grant_fee_value")
    private BigDecimal grantFeeValue;
    @Column(name = "grant_fee_type")
    private Character grantFeeType;
    @Column(name = "monthly_interest")
    private BigDecimal monthlyInterest;
    @Column(name = "expiration_fee_value")
    private BigDecimal expirationFeeValue;
    @Column(name = "expiration_fee_type")
    private Character expirationFeeType;
    @Column(name = "expiration_daily_interest")
    private BigDecimal expirationDailyInterest;
    @ManyToMany(mappedBy = "loansCollection")
    private Collection<Members> membersCollection;
    @OneToOne(mappedBy = "loanId")
    private Guarantees guarantees;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transfers transferId;
    @JoinColumn(name = "loan_group_id", referencedColumnName = "id")
    @ManyToOne
    private LoanGroups loanGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanId")
    private Collection<LoanPayments> loanPaymentsCollection;

    public Loans() {
    }

    public Loans(Integer id) {
        this.id = id;
    }

    public Loans(Integer id, BigDecimal totalAmount, String type) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getGrantFeeValue() {
        return grantFeeValue;
    }

    public void setGrantFeeValue(BigDecimal grantFeeValue) {
        this.grantFeeValue = grantFeeValue;
    }

    public Character getGrantFeeType() {
        return grantFeeType;
    }

    public void setGrantFeeType(Character grantFeeType) {
        this.grantFeeType = grantFeeType;
    }

    public BigDecimal getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(BigDecimal monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public BigDecimal getExpirationFeeValue() {
        return expirationFeeValue;
    }

    public void setExpirationFeeValue(BigDecimal expirationFeeValue) {
        this.expirationFeeValue = expirationFeeValue;
    }

    public Character getExpirationFeeType() {
        return expirationFeeType;
    }

    public void setExpirationFeeType(Character expirationFeeType) {
        this.expirationFeeType = expirationFeeType;
    }

    public BigDecimal getExpirationDailyInterest() {
        return expirationDailyInterest;
    }

    public void setExpirationDailyInterest(BigDecimal expirationDailyInterest) {
        this.expirationDailyInterest = expirationDailyInterest;
    }

    @XmlTransient
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    public Guarantees getGuarantees() {
        return guarantees;
    }

    public void setGuarantees(Guarantees guarantees) {
        this.guarantees = guarantees;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public LoanGroups getLoanGroupId() {
        return loanGroupId;
    }

    public void setLoanGroupId(LoanGroups loanGroupId) {
        this.loanGroupId = loanGroupId;
    }

    @XmlTransient
    public Collection<LoanPayments> getLoanPaymentsCollection() {
        return loanPaymentsCollection;
    }

    public void setLoanPaymentsCollection(Collection<LoanPayments> loanPaymentsCollection) {
        this.loanPaymentsCollection = loanPaymentsCollection;
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
        if (!(object instanceof Loans)) {
            return false;
        }
        Loans other = (Loans) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Loans[ id=" + id + " ]";
    }
    
}
