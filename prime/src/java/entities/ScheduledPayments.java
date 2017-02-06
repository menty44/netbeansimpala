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
@Table(name = "scheduled_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledPayments.findAll", query = "SELECT s FROM ScheduledPayments s"),
    @NamedQuery(name = "ScheduledPayments.findById", query = "SELECT s FROM ScheduledPayments s WHERE s.id = :id"),
    @NamedQuery(name = "ScheduledPayments.findByDate", query = "SELECT s FROM ScheduledPayments s WHERE s.date = :date"),
    @NamedQuery(name = "ScheduledPayments.findByAmount", query = "SELECT s FROM ScheduledPayments s WHERE s.amount = :amount"),
    @NamedQuery(name = "ScheduledPayments.findByStatus", query = "SELECT s FROM ScheduledPayments s WHERE s.status = :status"),
    @NamedQuery(name = "ScheduledPayments.findByProcessDate", query = "SELECT s FROM ScheduledPayments s WHERE s.processDate = :processDate"),
    @NamedQuery(name = "ScheduledPayments.findByFeedbackDeadline", query = "SELECT s FROM ScheduledPayments s WHERE s.feedbackDeadline = :feedbackDeadline"),
    @NamedQuery(name = "ScheduledPayments.findByReserveAmount", query = "SELECT s FROM ScheduledPayments s WHERE s.reserveAmount = :reserveAmount"),
    @NamedQuery(name = "ScheduledPayments.findByShowToReceiver", query = "SELECT s FROM ScheduledPayments s WHERE s.showToReceiver = :showToReceiver")})
public class ScheduledPayments implements Serializable {

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
    @Column(name = "process_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Column(name = "feedback_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feedbackDeadline;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reserve_amount")
    private boolean reserveAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_to_receiver")
    private boolean showToReceiver;
    @OneToMany(mappedBy = "scheduledPaymentId")
    private Collection<Invoices> invoicesCollection;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;
    @JoinColumn(name = "from_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts fromAccountId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes typeId;
    @JoinColumn(name = "to_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts toAccountId;
    @OneToMany(mappedBy = "scheduledPaymentId")
    private Collection<Transfers> transfersCollection;
    @OneToMany(mappedBy = "scheduledPaymentId")
    private Collection<Refs> refsCollection;
    @OneToMany(mappedBy = "scheduledPaymentId")
    private Collection<AmountReservations> amountReservationsCollection;
    @OneToMany(mappedBy = "scheduledPaymentId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public ScheduledPayments() {
    }

    public ScheduledPayments(Integer id) {
        this.id = id;
    }

    public ScheduledPayments(Integer id, Date date, BigDecimal amount, String status, boolean reserveAmount, boolean showToReceiver) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.reserveAmount = reserveAmount;
        this.showToReceiver = showToReceiver;
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

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Date getFeedbackDeadline() {
        return feedbackDeadline;
    }

    public void setFeedbackDeadline(Date feedbackDeadline) {
        this.feedbackDeadline = feedbackDeadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(boolean reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    public boolean getShowToReceiver() {
        return showToReceiver;
    }

    public void setShowToReceiver(boolean showToReceiver) {
        this.showToReceiver = showToReceiver;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public Accounts getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Accounts fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public TransferTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(TransferTypes typeId) {
        this.typeId = typeId;
    }

    public Accounts getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Accounts toAccountId) {
        this.toAccountId = toAccountId;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    @XmlTransient
    public Collection<Refs> getRefsCollection() {
        return refsCollection;
    }

    public void setRefsCollection(Collection<Refs> refsCollection) {
        this.refsCollection = refsCollection;
    }

    @XmlTransient
    public Collection<AmountReservations> getAmountReservationsCollection() {
        return amountReservationsCollection;
    }

    public void setAmountReservationsCollection(Collection<AmountReservations> amountReservationsCollection) {
        this.amountReservationsCollection = amountReservationsCollection;
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
        if (!(object instanceof ScheduledPayments)) {
            return false;
        }
        ScheduledPayments other = (ScheduledPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ScheduledPayments[ id=" + id + " ]";
    }
    
}
