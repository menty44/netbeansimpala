/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "trace_numbers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TraceNumbers.findAll", query = "SELECT t FROM TraceNumbers t"),
    @NamedQuery(name = "TraceNumbers.findById", query = "SELECT t FROM TraceNumbers t WHERE t.id = :id"),
    @NamedQuery(name = "TraceNumbers.findByDate", query = "SELECT t FROM TraceNumbers t WHERE t.date = :date"),
    @NamedQuery(name = "TraceNumbers.findByTraceNumber", query = "SELECT t FROM TraceNumbers t WHERE t.traceNumber = :traceNumber"),
    @NamedQuery(name = "TraceNumbers.findByClientId", query = "SELECT t FROM TraceNumbers t WHERE t.clientId = :clientId")})
public class TraceNumbers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 100)
    @Column(name = "trace_number")
    private String traceNumber;
    @Column(name = "client_id")
    private BigInteger clientId;

    public TraceNumbers() {
    }

    public TraceNumbers(Long id) {
        this.id = id;
    }

    public TraceNumbers(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof TraceNumbers)) {
            return false;
        }
        TraceNumbers other = (TraceNumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TraceNumbers[ id=" + id + " ]";
    }
    
}
