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
import javax.persistence.Lob;
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
@Table(name = "registration_agreements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrationAgreements.findAll", query = "SELECT r FROM RegistrationAgreements r"),
    @NamedQuery(name = "RegistrationAgreements.findById", query = "SELECT r FROM RegistrationAgreements r WHERE r.id = :id"),
    @NamedQuery(name = "RegistrationAgreements.findByName", query = "SELECT r FROM RegistrationAgreements r WHERE r.name = :name")})
public class RegistrationAgreements implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "contents")
    private String contents;
    @OneToMany(mappedBy = "registrationAgreementId")
    private Collection<PendingMembers> pendingMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registrationAgreementId")
    private Collection<RegistrationAgreementLogs> registrationAgreementLogsCollection;
    @OneToMany(mappedBy = "registrationAgreementId")
    private Collection<Groups> groupsCollection;

    public RegistrationAgreements() {
    }

    public RegistrationAgreements(Integer id) {
        this.id = id;
    }

    public RegistrationAgreements(Integer id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @XmlTransient
    public Collection<PendingMembers> getPendingMembersCollection() {
        return pendingMembersCollection;
    }

    public void setPendingMembersCollection(Collection<PendingMembers> pendingMembersCollection) {
        this.pendingMembersCollection = pendingMembersCollection;
    }

    @XmlTransient
    public Collection<RegistrationAgreementLogs> getRegistrationAgreementLogsCollection() {
        return registrationAgreementLogsCollection;
    }

    public void setRegistrationAgreementLogsCollection(Collection<RegistrationAgreementLogs> registrationAgreementLogsCollection) {
        this.registrationAgreementLogsCollection = registrationAgreementLogsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
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
        if (!(object instanceof RegistrationAgreements)) {
            return false;
        }
        RegistrationAgreements other = (RegistrationAgreements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RegistrationAgreements[ id=" + id + " ]";
    }
    
}
