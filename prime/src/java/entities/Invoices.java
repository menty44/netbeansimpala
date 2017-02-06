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
@Table(name = "invoices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findById", query = "SELECT i FROM Invoices i WHERE i.id = :id"),
    @NamedQuery(name = "Invoices.findByDate", query = "SELECT i FROM Invoices i WHERE i.date = :date"),
    @NamedQuery(name = "Invoices.findByAmount", query = "SELECT i FROM Invoices i WHERE i.amount = :amount"),
    @NamedQuery(name = "Invoices.findByStatus", query = "SELECT i FROM Invoices i WHERE i.status = :status")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "account_fee_log_id", referencedColumnName = "id")
    @ManyToOne
    private AccountFeeLogs accountFeeLogId;
    @JoinColumn(name = "from_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members fromMemberId;
    @JoinColumn(name = "to_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members toMemberId;
    @JoinColumn(name = "performed_by_id", referencedColumnName = "id")
    @ManyToOne
    private Members performedById;
    @JoinColumn(name = "sent_by_id", referencedColumnName = "id")
    @ManyToOne
    private Members sentById;
    @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes transferTypeId;
    @JoinColumn(name = "scheduled_payment_id", referencedColumnName = "id")
    @ManyToOne
    private ScheduledPayments scheduledPaymentId;
    @JoinColumn(name = "dest_type_id", referencedColumnName = "id")
    @ManyToOne
    private AccountTypes destTypeId;
    @OneToMany(mappedBy = "invoiceId")
    private Collection<InvoicePayments> invoicePaymentsCollection;
    @OneToMany(mappedBy = "invoiceId")
    private Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection;
    @OneToMany(mappedBy = "invoiceId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public Invoices() {
    }

    public Invoices(Integer id) {
        this.id = id;
    }

    public Invoices(Integer id, Date date, BigDecimal amount, String status) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public AccountFeeLogs getAccountFeeLogId() {
        return accountFeeLogId;
    }

    public void setAccountFeeLogId(AccountFeeLogs accountFeeLogId) {
        this.accountFeeLogId = accountFeeLogId;
    }

    public Members getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(Members fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public Members getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(Members toMemberId) {
        this.toMemberId = toMemberId;
    }

    public Members getPerformedById() {
        return performedById;
    }

    public void setPerformedById(Members performedById) {
        this.performedById = performedById;
    }

    public Members getSentById() {
        return sentById;
    }

    public void setSentById(Members sentById) {
        this.sentById = sentById;
    }

    public TransferTypes getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(TransferTypes transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public ScheduledPayments getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(ScheduledPayments scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
    }

    public AccountTypes getDestTypeId() {
        return destTypeId;
    }

    public void setDestTypeId(AccountTypes destTypeId) {
        this.destTypeId = destTypeId;
    }

    @XmlTransient
    public Collection<InvoicePayments> getInvoicePaymentsCollection() {
        return invoicePaymentsCollection;
    }

    public void setInvoicePaymentsCollection(Collection<InvoicePayments> invoicePaymentsCollection) {
        this.invoicePaymentsCollection = invoicePaymentsCollection;
    }

    @XmlTransient
    public Collection<MemberAccountFeeLogs> getMemberAccountFeeLogsCollection() {
        return memberAccountFeeLogsCollection;
    }

    public void setMemberAccountFeeLogsCollection(Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection) {
        this.memberAccountFeeLogsCollection = memberAccountFeeLogsCollection;
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
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Invoices[ id=" + id + " ]";
    }
    
}
