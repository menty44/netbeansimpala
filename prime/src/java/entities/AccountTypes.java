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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "account_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountTypes.findAll", query = "SELECT a FROM AccountTypes a"),
    @NamedQuery(name = "AccountTypes.findById", query = "SELECT a FROM AccountTypes a WHERE a.id = :id"),
    @NamedQuery(name = "AccountTypes.findBySubclass", query = "SELECT a FROM AccountTypes a WHERE a.subclass = :subclass"),
    @NamedQuery(name = "AccountTypes.findByName", query = "SELECT a FROM AccountTypes a WHERE a.name = :name")})
public class AccountTypes implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "group_operator_account_information_permissions", joinColumns = {
        @JoinColumn(name = "account_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @JoinTable(name = "admin_view_account_information", joinColumns = {
        @JoinColumn(name = "account_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection1;
    @ManyToMany(mappedBy = "accountTypesCollection2")
    private Collection<Groups> groupsCollection2;
    @JoinTable(name = "group_view_account_information_permissions", joinColumns = {
        @JoinColumn(name = "account_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection3;
    @OneToMany(mappedBy = "destTypeId")
    private Collection<Invoices> invoicesCollection;
    @JoinColumn(name = "system_account_id", referencedColumnName = "id")
    @ManyToOne
    private Accounts systemAccountId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currencies currencyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<AccountFees> accountFeesCollection;
    @OneToMany(mappedBy = "typeId")
    private Collection<Accounts> accountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<MemberGroupAccountSettings> memberGroupAccountSettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemAccountId")
    private Collection<ExternalAccounts> externalAccountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberAccountId")
    private Collection<ExternalAccounts> externalAccountsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<PaymentFilters> paymentFiltersCollection;
    @OneToMany(mappedBy = "accountTypeId")
    private Collection<MemberImports> memberImportsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAccountTypeId")
    private Collection<TransferTypes> transferTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toAccountTypeId")
    private Collection<TransferTypes> transferTypesCollection1;

    public AccountTypes() {
    }

    public AccountTypes(Integer id) {
        this.id = id;
    }

    public AccountTypes(Integer id, String subclass, String name) {
        this.id = id;
        this.subclass = subclass;
        this.name = name;
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
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection1() {
        return groupsCollection1;
    }

    public void setGroupsCollection1(Collection<Groups> groupsCollection1) {
        this.groupsCollection1 = groupsCollection1;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection2() {
        return groupsCollection2;
    }

    public void setGroupsCollection2(Collection<Groups> groupsCollection2) {
        this.groupsCollection2 = groupsCollection2;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection3() {
        return groupsCollection3;
    }

    public void setGroupsCollection3(Collection<Groups> groupsCollection3) {
        this.groupsCollection3 = groupsCollection3;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    public Accounts getSystemAccountId() {
        return systemAccountId;
    }

    public void setSystemAccountId(Accounts systemAccountId) {
        this.systemAccountId = systemAccountId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
    }

    @XmlTransient
    public Collection<AccountFees> getAccountFeesCollection() {
        return accountFeesCollection;
    }

    public void setAccountFeesCollection(Collection<AccountFees> accountFeesCollection) {
        this.accountFeesCollection = accountFeesCollection;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<MemberGroupAccountSettings> getMemberGroupAccountSettingsCollection() {
        return memberGroupAccountSettingsCollection;
    }

    public void setMemberGroupAccountSettingsCollection(Collection<MemberGroupAccountSettings> memberGroupAccountSettingsCollection) {
        this.memberGroupAccountSettingsCollection = memberGroupAccountSettingsCollection;
    }

    @XmlTransient
    public Collection<ExternalAccounts> getExternalAccountsCollection() {
        return externalAccountsCollection;
    }

    public void setExternalAccountsCollection(Collection<ExternalAccounts> externalAccountsCollection) {
        this.externalAccountsCollection = externalAccountsCollection;
    }

    @XmlTransient
    public Collection<ExternalAccounts> getExternalAccountsCollection1() {
        return externalAccountsCollection1;
    }

    public void setExternalAccountsCollection1(Collection<ExternalAccounts> externalAccountsCollection1) {
        this.externalAccountsCollection1 = externalAccountsCollection1;
    }

    @XmlTransient
    public Collection<PaymentFilters> getPaymentFiltersCollection() {
        return paymentFiltersCollection;
    }

    public void setPaymentFiltersCollection(Collection<PaymentFilters> paymentFiltersCollection) {
        this.paymentFiltersCollection = paymentFiltersCollection;
    }

    @XmlTransient
    public Collection<MemberImports> getMemberImportsCollection() {
        return memberImportsCollection;
    }

    public void setMemberImportsCollection(Collection<MemberImports> memberImportsCollection) {
        this.memberImportsCollection = memberImportsCollection;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection1() {
        return transferTypesCollection1;
    }

    public void setTransferTypesCollection1(Collection<TransferTypes> transferTypesCollection1) {
        this.transferTypesCollection1 = transferTypesCollection1;
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
        if (!(object instanceof AccountTypes)) {
            return false;
        }
        AccountTypes other = (AccountTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountTypes[ id=" + id + " ]";
    }
    
}
