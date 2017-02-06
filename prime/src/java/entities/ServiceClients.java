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
@Table(name = "service_clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceClients.findAll", query = "SELECT s FROM ServiceClients s"),
    @NamedQuery(name = "ServiceClients.findById", query = "SELECT s FROM ServiceClients s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceClients.findByName", query = "SELECT s FROM ServiceClients s WHERE s.name = :name"),
    @NamedQuery(name = "ServiceClients.findByHostname", query = "SELECT s FROM ServiceClients s WHERE s.hostname = :hostname"),
    @NamedQuery(name = "ServiceClients.findByAddressBegin", query = "SELECT s FROM ServiceClients s WHERE s.addressBegin = :addressBegin"),
    @NamedQuery(name = "ServiceClients.findByAddressEnd", query = "SELECT s FROM ServiceClients s WHERE s.addressEnd = :addressEnd"),
    @NamedQuery(name = "ServiceClients.findByUsername", query = "SELECT s FROM ServiceClients s WHERE s.username = :username"),
    @NamedQuery(name = "ServiceClients.findByPassword", query = "SELECT s FROM ServiceClients s WHERE s.password = :password"),
    @NamedQuery(name = "ServiceClients.findByCredentialsRequired", query = "SELECT s FROM ServiceClients s WHERE s.credentialsRequired = :credentialsRequired"),
    @NamedQuery(name = "ServiceClients.findByIgnoreRegistrationValidations", query = "SELECT s FROM ServiceClients s WHERE s.ignoreRegistrationValidations = :ignoreRegistrationValidations")})
public class ServiceClients implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "hostname")
    private String hostname;
    @Size(max = 100)
    @Column(name = "address_begin")
    private String addressBegin;
    @Size(max = 100)
    @Column(name = "address_end")
    private String addressEnd;
    @Size(max = 100)
    @Column(name = "username")
    private String username;
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credentials_required")
    private boolean credentialsRequired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ignore_registration_validations")
    private boolean ignoreRegistrationValidations;
    @ManyToMany(mappedBy = "serviceClientsCollection")
    private Collection<TransferTypes> transferTypesCollection;
    @ManyToMany(mappedBy = "serviceClientsCollection1")
    private Collection<TransferTypes> transferTypesCollection1;
    @ManyToMany(mappedBy = "serviceClientsCollection")
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "serviceClientsCollection2")
    private Collection<TransferTypes> transferTypesCollection2;
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    @ManyToOne
    private Channels channelId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceClients")
    private Collection<ServiceClientPermissions> serviceClientPermissionsCollection;

    public ServiceClients() {
    }

    public ServiceClients(Integer id) {
        this.id = id;
    }

    public ServiceClients(Integer id, String name, String hostname, boolean credentialsRequired, boolean ignoreRegistrationValidations) {
        this.id = id;
        this.name = name;
        this.hostname = hostname;
        this.credentialsRequired = credentialsRequired;
        this.ignoreRegistrationValidations = ignoreRegistrationValidations;
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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getAddressBegin() {
        return addressBegin;
    }

    public void setAddressBegin(String addressBegin) {
        this.addressBegin = addressBegin;
    }

    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getCredentialsRequired() {
        return credentialsRequired;
    }

    public void setCredentialsRequired(boolean credentialsRequired) {
        this.credentialsRequired = credentialsRequired;
    }

    public boolean getIgnoreRegistrationValidations() {
        return ignoreRegistrationValidations;
    }

    public void setIgnoreRegistrationValidations(boolean ignoreRegistrationValidations) {
        this.ignoreRegistrationValidations = ignoreRegistrationValidations;
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

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection2() {
        return transferTypesCollection2;
    }

    public void setTransferTypesCollection2(Collection<TransferTypes> transferTypesCollection2) {
        this.transferTypesCollection2 = transferTypesCollection2;
    }

    public Channels getChannelId() {
        return channelId;
    }

    public void setChannelId(Channels channelId) {
        this.channelId = channelId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @XmlTransient
    public Collection<ServiceClientPermissions> getServiceClientPermissionsCollection() {
        return serviceClientPermissionsCollection;
    }

    public void setServiceClientPermissionsCollection(Collection<ServiceClientPermissions> serviceClientPermissionsCollection) {
        this.serviceClientPermissionsCollection = serviceClientPermissionsCollection;
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
        if (!(object instanceof ServiceClients)) {
            return false;
        }
        ServiceClients other = (ServiceClients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceClients[ id=" + id + " ]";
    }
    
}
