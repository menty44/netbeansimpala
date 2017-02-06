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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "invoice_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoicePayments.findAll", query = "SELECT i FROM InvoicePayments i"),
    @NamedQuery(name = "InvoicePayments.findById", query = "SELECT i FROM InvoicePayments i WHERE i.id = :id"),
    @NamedQuery(name = "InvoicePayments.findByDate", query = "SELECT i FROM InvoicePayments i WHERE i.date = :date"),
    @NamedQuery(name = "InvoicePayments.findByAmount", query = "SELECT i FROM InvoicePayments i WHERE i.amount = :amount")})
public class InvoicePayments implements Serializable {

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
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne
    private Invoices invoiceId;

    public InvoicePayments() {
    }

    public InvoicePayments(Integer id) {
        this.id = id;
    }

    public InvoicePayments(Integer id, Date date, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
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

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public Invoices getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoices invoiceId) {
        this.invoiceId = invoiceId;
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
        if (!(object instanceof InvoicePayments)) {
            return false;
        }
        InvoicePayments other = (InvoicePayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InvoicePayments[ id=" + id + " ]";
    }
    
}
