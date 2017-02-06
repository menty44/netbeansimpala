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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "loan_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanGroups.findAll", query = "SELECT l FROM LoanGroups l"),
    @NamedQuery(name = "LoanGroups.findById", query = "SELECT l FROM LoanGroups l WHERE l.id = :id"),
    @NamedQuery(name = "LoanGroups.findByName", query = "SELECT l FROM LoanGroups l WHERE l.name = :name")})
public class LoanGroups implements Serializable {

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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "members_loan_groups", joinColumns = {
        @JoinColumn(name = "loan_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Members> membersCollection;
    @OneToMany(mappedBy = "loanGroupId")
    private Collection<Loans> loansCollection;
    @OneToMany(mappedBy = "loanGroupId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public LoanGroups() {
    }

    public LoanGroups(Integer id) {
        this.id = id;
    }

    public LoanGroups(Integer id, String name) {
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
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    @XmlTransient
    public Collection<Loans> getLoansCollection() {
        return loansCollection;
    }

    public void setLoansCollection(Collection<Loans> loansCollection) {
        this.loansCollection = loansCollection;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection() {
        return customFieldValuesCollection;
    }

    public void setCustomFieldValuesCollection(Collection<CustomFieldValues> customFieldValuesCollection) {
        this.customFieldValuesCollection = customFieldValuesCollection;
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
        if (!(object instanceof LoanGroups)) {
            return false;
        }
        LoanGroups other = (LoanGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoanGroups[ id=" + id + " ]";
    }
    
}
