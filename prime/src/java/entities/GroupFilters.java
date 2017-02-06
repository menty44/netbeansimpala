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
@Table(name = "group_filters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupFilters.findAll", query = "SELECT g FROM GroupFilters g"),
    @NamedQuery(name = "GroupFilters.findById", query = "SELECT g FROM GroupFilters g WHERE g.id = :id"),
    @NamedQuery(name = "GroupFilters.findByName", query = "SELECT g FROM GroupFilters g WHERE g.name = :name"),
    @NamedQuery(name = "GroupFilters.findByLoginPageName", query = "SELECT g FROM GroupFilters g WHERE g.loginPageName = :loginPageName"),
    @NamedQuery(name = "GroupFilters.findByRootUrl", query = "SELECT g FROM GroupFilters g WHERE g.rootUrl = :rootUrl"),
    @NamedQuery(name = "GroupFilters.findByContainerUrl", query = "SELECT g FROM GroupFilters g WHERE g.containerUrl = :containerUrl"),
    @NamedQuery(name = "GroupFilters.findByShowInProfile", query = "SELECT g FROM GroupFilters g WHERE g.showInProfile = :showInProfile")})
public class GroupFilters implements Serializable {

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
    @Size(max = 20)
    @Column(name = "login_page_name")
    private String loginPageName;
    @Size(max = 100)
    @Column(name = "root_url")
    private String rootUrl;
    @Size(max = 100)
    @Column(name = "container_url")
    private String containerUrl;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_in_profile")
    private boolean showInProfile;
    @JoinTable(name = "group_filters_viewable_by", joinColumns = {
        @JoinColumn(name = "group_filter_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @OneToMany(mappedBy = "groupFilterId")
    private Collection<AdInterests> adInterestsCollection;
    @OneToMany(mappedBy = "groupFilterId")
    private Collection<Files> filesCollection;

    public GroupFilters() {
    }

    public GroupFilters(Integer id) {
        this.id = id;
    }

    public GroupFilters(Integer id, String name, boolean showInProfile) {
        this.id = id;
        this.name = name;
        this.showInProfile = showInProfile;
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

    public String getLoginPageName() {
        return loginPageName;
    }

    public void setLoginPageName(String loginPageName) {
        this.loginPageName = loginPageName;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getContainerUrl() {
        return containerUrl;
    }

    public void setContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getShowInProfile() {
        return showInProfile;
    }

    public void setShowInProfile(boolean showInProfile) {
        this.showInProfile = showInProfile;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<AdInterests> getAdInterestsCollection() {
        return adInterestsCollection;
    }

    public void setAdInterestsCollection(Collection<AdInterests> adInterestsCollection) {
        this.adInterestsCollection = adInterestsCollection;
    }

    @XmlTransient
    public Collection<Files> getFilesCollection() {
        return filesCollection;
    }

    public void setFilesCollection(Collection<Files> filesCollection) {
        this.filesCollection = filesCollection;
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
        if (!(object instanceof GroupFilters)) {
            return false;
        }
        GroupFilters other = (GroupFilters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GroupFilters[ id=" + id + " ]";
    }
    
}
