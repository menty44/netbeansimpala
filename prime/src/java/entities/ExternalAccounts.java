/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "external_accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExternalAccounts.findAll", query = "SELECT e FROM ExternalAccounts e"),
    @NamedQuery(name = "ExternalAccounts.findById", query = "SELECT e FROM ExternalAccounts e WHERE e.id = :id"),
    @NamedQuery(name = "ExternalAccounts.findByName", query = "SELECT e FROM ExternalAccounts e WHERE e.name = :name")})
public class ExternalAccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<ExternalTransferTypes> externalTransferTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<FileMappings> fileMappingsCollection;
    @JoinColumn(name = "system_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes systemAccountId;
    @JoinColumn(name = "member_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes memberAccountId;
    @JoinColumn(name = "file_mapping_id", referencedColumnName = "id")
    @ManyToOne
    private FileMappings fileMappingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<ExternalTransferImports> externalTransferImportsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<ExternalTransfers> externalTransfersCollection;

    public ExternalAccounts() {
    }

    public ExternalAccounts(Integer id) {
        this.id = id;
    }

    public ExternalAccounts(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<ExternalTransferTypes> getExternalTransferTypesCollection() {
        return externalTransferTypesCollection;
    }

    public void setExternalTransferTypesCollection(Collection<ExternalTransferTypes> externalTransferTypesCollection) {
        this.externalTransferTypesCollection = externalTransferTypesCollection;
    }

    @XmlTransient
    public Collection<FileMappings> getFileMappingsCollection() {
        return fileMappingsCollection;
    }

    public void setFileMappingsCollection(Collection<FileMappings> fileMappingsCollection) {
        this.fileMappingsCollection = fileMappingsCollection;
    }

    public AccountTypes getSystemAccountId() {
        return systemAccountId;
    }

    public void setSystemAccountId(AccountTypes systemAccountId) {
        this.systemAccountId = systemAccountId;
    }

    public AccountTypes getMemberAccountId() {
        return memberAccountId;
    }

    public void setMemberAccountId(AccountTypes memberAccountId) {
        this.memberAccountId = memberAccountId;
    }

    public FileMappings getFileMappingId() {
        return fileMappingId;
    }

    public void setFileMappingId(FileMappings fileMappingId) {
        this.fileMappingId = fileMappingId;
    }

    @XmlTransient
    public Collection<ExternalTransferImports> getExternalTransferImportsCollection() {
        return externalTransferImportsCollection;
    }

    public void setExternalTransferImportsCollection(Collection<ExternalTransferImports> externalTransferImportsCollection) {
        this.externalTransferImportsCollection = externalTransferImportsCollection;
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
        if (!(object instanceof ExternalAccounts)) {
            return false;
        }
        ExternalAccounts other = (ExternalAccounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ExternalAccounts[ id=" + id + " ]";
    }
    
}
