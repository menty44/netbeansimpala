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
@Table(name = "channels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channels.findAll", query = "SELECT c FROM Channels c"),
    @NamedQuery(name = "Channels.findById", query = "SELECT c FROM Channels c WHERE c.id = :id"),
    @NamedQuery(name = "Channels.findByInternalName", query = "SELECT c FROM Channels c WHERE c.internalName = :internalName"),
    @NamedQuery(name = "Channels.findByDisplayName", query = "SELECT c FROM Channels c WHERE c.displayName = :displayName"),
    @NamedQuery(name = "Channels.findByCredentials", query = "SELECT c FROM Channels c WHERE c.credentials = :credentials"),
    @NamedQuery(name = "Channels.findByPmtReqWsUrl", query = "SELECT c FROM Channels c WHERE c.pmtReqWsUrl = :pmtReqWsUrl")})
public class Channels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "internal_name")
    private String internalName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "display_name")
    private String displayName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "credentials")
    private String credentials;
    @Size(max = 200)
    @Column(name = "pmt_req_ws_url")
    private String pmtReqWsUrl;
    @JoinTable(name = "transfer_types_channels", joinColumns = {
        @JoinColumn(name = "channel_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransferTypes> transferTypesCollection;
    @JoinTable(name = "groups_default_channels", joinColumns = {
        @JoinColumn(name = "channel_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @JoinTable(name = "groups_channels", joinColumns = {
        @JoinColumn(name = "channel_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection1;
    @JoinTable(name = "members_channels", joinColumns = {
        @JoinColumn(name = "channel_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Members> membersCollection;
    @JoinTable(name = "groups_request_payment_channels", joinColumns = {
        @JoinColumn(name = "channel_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection2;
    @OneToMany(mappedBy = "channelId")
    private Collection<ServiceClients> serviceClientsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "channelId")
    private Collection<ChannelsPrincipals> channelsPrincipalsCollection;
    @OneToMany(mappedBy = "toChannelId")
    private Collection<Tickets> ticketsCollection;
    @OneToMany(mappedBy = "fromChannelId")
    private Collection<Tickets> ticketsCollection1;

    public Channels() {
    }

    public Channels(Integer id) {
        this.id = id;
    }

    public Channels(Integer id, String internalName, String displayName, String credentials) {
        this.id = id;
        this.internalName = internalName;
        this.displayName = displayName;
        this.credentials = credentials;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getPmtReqWsUrl() {
        return pmtReqWsUrl;
    }

    public void setPmtReqWsUrl(String pmtReqWsUrl) {
        this.pmtReqWsUrl = pmtReqWsUrl;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
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
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection2() {
        return groupsCollection2;
    }

    public void setGroupsCollection2(Collection<Groups> groupsCollection2) {
        this.groupsCollection2 = groupsCollection2;
    }

    @XmlTransient
    public Collection<ServiceClients> getServiceClientsCollection() {
        return serviceClientsCollection;
    }

    public void setServiceClientsCollection(Collection<ServiceClients> serviceClientsCollection) {
        this.serviceClientsCollection = serviceClientsCollection;
    }

    @XmlTransient
    public Collection<ChannelsPrincipals> getChannelsPrincipalsCollection() {
        return channelsPrincipalsCollection;
    }

    public void setChannelsPrincipalsCollection(Collection<ChannelsPrincipals> channelsPrincipalsCollection) {
        this.channelsPrincipalsCollection = channelsPrincipalsCollection;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection1() {
        return ticketsCollection1;
    }

    public void setTicketsCollection1(Collection<Tickets> ticketsCollection1) {
        this.ticketsCollection1 = ticketsCollection1;
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
        if (!(object instanceof Channels)) {
            return false;
        }
        Channels other = (Channels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Channels[ id=" + id + " ]";
    }
    
}
