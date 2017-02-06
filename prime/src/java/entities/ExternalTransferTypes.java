/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "external_transfer_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExternalTransferTypes.findAll", query = "SELECT e FROM ExternalTransferTypes e"),
    @NamedQuery(name = "ExternalTransferTypes.findById", query = "SELECT e FROM ExternalTransferTypes e WHERE e.id = :id"),
    @NamedQuery(name = "ExternalTransferTypes.findByCode", query = "SELECT e FROM ExternalTransferTypes e WHERE e.code = :code"),
    @NamedQuery(name = "ExternalTransferTypes.findByName", query = "SELECT e FROM ExternalTransferTypes e WHERE e.name = :name"),
    @NamedQuery(name = "ExternalTransferTypes.findByAction", query = "SELECT e FROM ExternalTransferTypes e WHERE e.action = :action")})
public class ExternalTransferTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "action")
    private String action;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes transferTypeId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ExternalAccounts accountId;
    @OneToMany(mappedBy = "typeId")
    private Collection<ExternalTransfers> externalTransfersCollection;

    public ExternalTransferTypes() {
    }

    public ExternalTransferTypes(Integer id) {
        this.id = id;
    }

    public ExternalTransferTypes(Integer id, String code, String name, String action) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransferTypes getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(TransferTypes transferTypeId) {
        this.transferTypeId = transferTypeId;
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
        if (!(object instanceof ExternalTransferTypes)) {
            return false;
        }
        ExternalTransferTypes other = (ExternalTransferTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ExternalTransferTypes[ id=" + id + " ]";
    }
    
}
