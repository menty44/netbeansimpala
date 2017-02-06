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
import javax.persistence.Lob;
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
@Table(name = "tickets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findById", query = "SELECT t FROM Tickets t WHERE t.id = :id"),
    @NamedQuery(name = "Tickets.findBySubclass", query = "SELECT t FROM Tickets t WHERE t.subclass = :subclass"),
    @NamedQuery(name = "Tickets.findByStatus", query = "SELECT t FROM Tickets t WHERE t.status = :status"),
    @NamedQuery(name = "Tickets.findByTicket", query = "SELECT t FROM Tickets t WHERE t.ticket = :ticket"),
    @NamedQuery(name = "Tickets.findByCreationDate", query = "SELECT t FROM Tickets t WHERE t.creationDate = :creationDate"),
    @NamedQuery(name = "Tickets.findByAmount", query = "SELECT t FROM Tickets t WHERE t.amount = :amount"),
    @NamedQuery(name = "Tickets.findByReturnUrl", query = "SELECT t FROM Tickets t WHERE t.returnUrl = :returnUrl"),
    @NamedQuery(name = "Tickets.findByClientAddress", query = "SELECT t FROM Tickets t WHERE t.clientAddress = :clientAddress"),
    @NamedQuery(name = "Tickets.findByMemberAddress", query = "SELECT t FROM Tickets t WHERE t.memberAddress = :memberAddress"),
    @NamedQuery(name = "Tickets.findByTraceData", query = "SELECT t FROM Tickets t WHERE t.traceData = :traceData")})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ticket")
    private String ticket;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 150)
    @Column(name = "return_url")
    private String returnUrl;
    @Size(max = 40)
    @Column(name = "client_address")
    private String clientAddress;
    @Size(max = 40)
    @Column(name = "member_address")
    private String memberAddress;
    @Size(max = 50)
    @Column(name = "trace_data")
    private String traceData;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "to_channel_id", referencedColumnName = "id")
    @ManyToOne
    private Channels toChannelId;
    @JoinColumn(name = "from_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members fromMemberId;
    @JoinColumn(name = "to_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members toMemberId;
    @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes transferTypeId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne
    private Currencies currencyId;
    @JoinColumn(name = "from_channel_id", referencedColumnName = "id")
    @ManyToOne
    private Channels fromChannelId;

    public Tickets() {
    }

    public Tickets(Integer id) {
        this.id = id;
    }

    public Tickets(Integer id, String subclass, String status, String ticket) {
        this.id = id;
        this.subclass = subclass;
        this.status = status;
        this.ticket = ticket;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getTraceData() {
        return traceData;
    }

    public void setTraceData(String traceData) {
        this.traceData = traceData;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public Channels getToChannelId() {
        return toChannelId;
    }

    public void setToChannelId(Channels toChannelId) {
        this.toChannelId = toChannelId;
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

    public TransferTypes getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(TransferTypes transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
    }

    public Channels getFromChannelId() {
        return fromChannelId;
    }

    public void setFromChannelId(Channels fromChannelId) {
        this.fromChannelId = fromChannelId;
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
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tickets[ id=" + id + " ]";
    }
    
}
