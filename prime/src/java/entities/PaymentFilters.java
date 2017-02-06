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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "payment_filters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentFilters.findAll", query = "SELECT p FROM PaymentFilters p"),
    @NamedQuery(name = "PaymentFilters.findById", query = "SELECT p FROM PaymentFilters p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentFilters.findByName", query = "SELECT p FROM PaymentFilters p WHERE p.name = :name"),
    @NamedQuery(name = "PaymentFilters.findByShowInAccountHistory", query = "SELECT p FROM PaymentFilters p WHERE p.showInAccountHistory = :showInAccountHistory"),
    @NamedQuery(name = "PaymentFilters.findByShowInReports", query = "SELECT p FROM PaymentFilters p WHERE p.showInReports = :showInReports")})
public class PaymentFilters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_in_account_history")
    private boolean showInAccountHistory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_in_reports")
    private boolean showInReports;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "paymentFiltersCollection")
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "paymentFiltersCollection")
    private Collection<TransferTypes> transferTypesCollection;
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes accountTypeId;

    public PaymentFilters() {
    }

    public PaymentFilters(Integer id) {
        this.id = id;
    }

    public PaymentFilters(Integer id, String name, boolean showInAccountHistory, boolean showInReports) {
        this.id = id;
        this.name = name;
        this.showInAccountHistory = showInAccountHistory;
        this.showInReports = showInReports;
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

    public boolean getShowInAccountHistory() {
        return showInAccountHistory;
    }

    public void setShowInAccountHistory(boolean showInAccountHistory) {
        this.showInAccountHistory = showInAccountHistory;
    }

    public boolean getShowInReports() {
        return showInReports;
    }

    public void setShowInReports(boolean showInReports) {
        this.showInReports = showInReports;
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
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
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
        if (!(object instanceof PaymentFilters)) {
            return false;
        }
        PaymentFilters other = (PaymentFilters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PaymentFilters[ id=" + id + " ]";
    }
    
}
