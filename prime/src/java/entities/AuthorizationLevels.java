/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "authorization_levels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthorizationLevels.findAll", query = "SELECT a FROM AuthorizationLevels a"),
    @NamedQuery(name = "AuthorizationLevels.findById", query = "SELECT a FROM AuthorizationLevels a WHERE a.id = :id"),
    @NamedQuery(name = "AuthorizationLevels.findByLevel", query = "SELECT a FROM AuthorizationLevels a WHERE a.level = :level"),
    @NamedQuery(name = "AuthorizationLevels.findByAmount", query = "SELECT a FROM AuthorizationLevels a WHERE a.amount = :amount"),
    @NamedQuery(name = "AuthorizationLevels.findByAuthorizer", query = "SELECT a FROM AuthorizationLevels a WHERE a.authorizer = :authorizer")})
public class AuthorizationLevels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "authorizer")
    private String authorizer;
    @ManyToMany(mappedBy = "authorizationLevelsCollection")
    private Collection<Groups> groupsCollection;
    @OneToMany(mappedBy = "nextAuthorizationLevelId")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    private Collection<TransferAuthorizations> transferAuthorizationsCollection;

    public AuthorizationLevels() {
    }

    public AuthorizationLevels(Integer id) {
        this.id = id;
    }

    public AuthorizationLevels(Integer id, int level, BigDecimal amount, String authorizer) {
        this.id = id;
        this.level = level;
        this.amount = amount;
        this.authorizer = authorizer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public TransferTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(TransferTypes typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<TransferAuthorizations> getTransferAuthorizationsCollection() {
        return transferAuthorizationsCollection;
    }

    public void setTransferAuthorizationsCollection(Collection<TransferAuthorizations> transferAuthorizationsCollection) {
        this.transferAuthorizationsCollection = transferAuthorizationsCollection;
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
        if (!(object instanceof AuthorizationLevels)) {
            return false;
        }
        AuthorizationLevels other = (AuthorizationLevels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AuthorizationLevels[ id=" + id + " ]";
    }
    
}
