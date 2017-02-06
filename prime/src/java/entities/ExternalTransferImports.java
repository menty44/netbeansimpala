/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "external_transfer_imports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExternalTransferImports.findAll", query = "SELECT e FROM ExternalTransferImports e"),
    @NamedQuery(name = "ExternalTransferImports.findById", query = "SELECT e FROM ExternalTransferImports e WHERE e.id = :id"),
    @NamedQuery(name = "ExternalTransferImports.findByDate", query = "SELECT e FROM ExternalTransferImports e WHERE e.date = :date")})
public class ExternalTransferImports implements Serializable {

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
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members byId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ExternalAccounts accountId;
    @OneToMany(mappedBy = "importId")
    private Collection<ExternalTransfers> externalTransfersCollection;

    public ExternalTransferImports() {
    }

    public ExternalTransferImports(Integer id) {
        this.id = id;
    }

    public ExternalTransferImports(Integer id, Date date) {
        this.id = id;
        this.date = date;
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

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public ExternalAccounts getAccountId() {
        return accountId;
    }

    public void setAccountId(ExternalAccounts accountId) {
        this.accountId = accountId;
    }

    @XmlTransient
    public Collection<ExternalTransfers> getExternalTransfersCollection() {
        return externalTransfersCollection;
    }

    public void setExternalTransfersCollection(Collection<ExternalTransfers> externalTransfersCollection) {
        this.externalTransfersCollection = externalTransfersCollection;
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
        if (!(object instanceof ExternalTransferImports)) {
            return false;
        }
        ExternalTransferImports other = (ExternalTransferImports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ExternalTransferImports[ id=" + id + " ]";
    }
    
}
