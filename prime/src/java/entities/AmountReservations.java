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
@Table(name = "amount_reservations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmountReservations.findAll", query = "SELECT a FROM AmountReservations a"),
    @NamedQuery(name = "AmountReservations.findById", query = "SELECT a FROM AmountReservations a WHERE a.id = :id"),
    @NamedQuery(name = "AmountReservations.findBySubclass", query = "SELECT a FROM AmountReservations a WHERE a.subclass = :subclass"),
    @NamedQuery(name = "AmountReservations.findByDate", query = "SELECT a FROM AmountReservations a WHERE a.date = :date"),
    @NamedQuery(name = "AmountReservations.findByAmount", query = "SELECT a FROM AmountReservations a WHERE a.amount = :amount")})
public class AmountReservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "transfer_authorization_id", referencedColumnName = "id")
    @ManyToOne
    private TransferAuthorizations transferAuthorizationId;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts accountId;
    @JoinColumn(name = "scheduled_payment_id", referencedColumnName = "id")
    @ManyToOne
    private ScheduledPayments scheduledPaymentId;

    public AmountReservations() {
    }

    public AmountReservations(Long id) {
        this.id = id;
    }

    public AmountReservations(Long id, String subclass, Date date) {
        this.id = id;
        this.subclass = subclass;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
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

    public TransferAuthorizations getTransferAuthorizationId() {
        return transferAuthorizationId;
    }

    public void setTransferAuthorizationId(TransferAuthorizations transferAuthorizationId) {
        this.transferAuthorizationId = transferAuthorizationId;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
    }

    public ScheduledPayments getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(ScheduledPayments scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
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
        if (!(object instanceof AmountReservations)) {
            return false;
        }
        AmountReservations other = (AmountReservations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AmountReservations[ id=" + id + " ]";
    }
    
}
