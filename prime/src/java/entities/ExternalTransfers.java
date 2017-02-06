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
@Table(name = "external_transfers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExternalTransfers.findAll", query = "SELECT e FROM ExternalTransfers e"),
    @NamedQuery(name = "ExternalTransfers.findById", query = "SELECT e FROM ExternalTransfers e WHERE e.id = :id"),
    @NamedQuery(name = "ExternalTransfers.findByStatus", query = "SELECT e FROM ExternalTransfers e WHERE e.status = :status"),
    @NamedQuery(name = "ExternalTransfers.findByDate", query = "SELECT e FROM ExternalTransfers e WHERE e.date = :date"),
    @NamedQuery(name = "ExternalTransfers.findByAmount", query = "SELECT e FROM ExternalTransfers e WHERE e.amount = :amount"),
    @NamedQuery(name = "ExternalTransfers.findByLineNumber", query = "SELECT e FROM ExternalTransfers e WHERE e.lineNumber = :lineNumber")})
public class ExternalTransfers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "line_number")
    private Integer lineNumber;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comments")
    private String comments;
    @OneToMany(mappedBy = "externalTransferId")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "import_id", referencedColumnName = "id")
    @ManyToOne
    private ExternalTransferImports importId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne
    private ExternalTransferTypes typeId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ExternalAccounts accountId;
    @OneToMany(mappedBy = "externalTransferId")
    private Collection<LoanPayments> loanPaymentsCollection;

    public ExternalTransfers() {
    }

    public ExternalTransfers(Integer id) {
        this.id = id;
    }

    public ExternalTransfers(Integer id, String status) {
        this.id = id;
        this.status = status;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public ExternalTransferImports getImportId() {
        return importId;
    }

    public void setImportId(ExternalTransferImports importId) {
        this.importId = importId;
    }

    public ExternalTransferTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(ExternalTransferTypes typeId) {
        this.typeId = typeId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    public ExternalAccounts getAccountId() {
        return accountId;
    }

    public void setAccountId(ExternalAccounts accountId) {
        this.accountId = accountId;
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
        if (!(object instanceof ExternalTransfers)) {
            return false;
        }
        ExternalTransfers other = (ExternalTransfers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ExternalTransfers[ id=" + id + " ]";
    }
    
}
