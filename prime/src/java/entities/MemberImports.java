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
import javax.persistence.CascadeType;
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
@Table(name = "member_imports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberImports.findAll", query = "SELECT m FROM MemberImports m"),
    @NamedQuery(name = "MemberImports.findById", query = "SELECT m FROM MemberImports m WHERE m.id = :id"),
    @NamedQuery(name = "MemberImports.findByDate", query = "SELECT m FROM MemberImports m WHERE m.date = :date")})
public class MemberImports implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importId")
    private Collection<ImportedMembers> importedMembersCollection;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members byId;
    @JoinColumn(name = "initial_credit_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes initialCreditTransferTypeId;
    @JoinColumn(name = "initial_debit_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes initialDebitTransferTypeId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Groups groupId;
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @ManyToOne
    private AccountTypes accountTypeId;

    public MemberImports() {
    }

    public MemberImports(Integer id) {
        this.id = id;
    }

    public MemberImports(Integer id, Date date) {
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

    @XmlTransient
    public Collection<ImportedMembers> getImportedMembersCollection() {
        return importedMembersCollection;
    }

    public void setImportedMembersCollection(Collection<ImportedMembers> importedMembersCollection) {
        this.importedMembersCollection = importedMembersCollection;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public TransferTypes getInitialCreditTransferTypeId() {
        return initialCreditTransferTypeId;
    }

    public void setInitialCreditTransferTypeId(TransferTypes initialCreditTransferTypeId) {
        this.initialCreditTransferTypeId = initialCreditTransferTypeId;
    }

    public TransferTypes getInitialDebitTransferTypeId() {
        return initialDebitTransferTypeId;
    }

    public void setInitialDebitTransferTypeId(TransferTypes initialDebitTransferTypeId) {
        this.initialDebitTransferTypeId = initialDebitTransferTypeId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public AccountTypes getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountTypes accountTypeId) {
        this.accountTypeId = accountTypeId;
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
        if (!(object instanceof MemberImports)) {
            return false;
        }
        MemberImports other = (MemberImports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberImports[ id=" + id + " ]";
    }
    
}
