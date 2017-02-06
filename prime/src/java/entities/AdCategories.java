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
@Table(name = "ad_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdCategories.findAll", query = "SELECT a FROM AdCategories a"),
    @NamedQuery(name = "AdCategories.findById", query = "SELECT a FROM AdCategories a WHERE a.id = :id"),
    @NamedQuery(name = "AdCategories.findByOrderIndex", query = "SELECT a FROM AdCategories a WHERE a.orderIndex = :orderIndex"),
    @NamedQuery(name = "AdCategories.findByName", query = "SELECT a FROM AdCategories a WHERE a.name = :name"),
    @NamedQuery(name = "AdCategories.findByActive", query = "SELECT a FROM AdCategories a WHERE a.active = :active")})
public class AdCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_index")
    private short orderIndex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @OneToMany(mappedBy = "existingCategoryId")
    private Collection<ImportedAds> importedAdsCollection;
    @OneToMany(mappedBy = "parentId")
    private Collection<AdCategories> adCategoriesCollection;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private AdCategories parentId;
    @OneToMany(mappedBy = "categoryId")
    private Collection<Ads> adsCollection;
    @OneToMany(mappedBy = "categoryId")
    private Collection<AdInterests> adInterestsCollection;
    @OneToMany(mappedBy = "existingParentId")
    private Collection<ImportedAdCategories> importedAdCategoriesCollection;

    public AdCategories() {
    }

    public AdCategories(Integer id) {
        this.id = id;
    }

    public AdCategories(Integer id, short orderIndex, String name, boolean active) {
        this.id = id;
        this.orderIndex = orderIndex;
        this.name = name;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(short orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<ImportedAds> getImportedAdsCollection() {
        return importedAdsCollection;
    }

    public void setImportedAdsCollection(Collection<ImportedAds> importedAdsCollection) {
        this.importedAdsCollection = importedAdsCollection;
    }

    @XmlTransient
    public Collection<AdCategories> getAdCategoriesCollection() {
        return adCategoriesCollection;
    }

    public void setAdCategoriesCollection(Collection<AdCategories> adCategoriesCollection) {
        this.adCategoriesCollection = adCategoriesCollection;
    }

    public AdCategories getParentId() {
        return parentId;
    }

    public void setParentId(AdCategories parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public Collection<Ads> getAdsCollection() {
        return adsCollection;
    }

    public void setAdsCollection(Collection<Ads> adsCollection) {
        this.adsCollection = adsCollection;
    }

    @XmlTransient
    public Collection<AdInterests> getAdInterestsCollection() {
        return adInterestsCollection;
    }

    public void setAdInterestsCollection(Collection<AdInterests> adInterestsCollection) {
        this.adInterestsCollection = adInterestsCollection;
    }

    @XmlTransient
    public Collection<ImportedAdCategories> getImportedAdCategoriesCollection() {
        return importedAdCategoriesCollection;
    }

    public void setImportedAdCategoriesCollection(Collection<ImportedAdCategories> importedAdCategoriesCollection) {
        this.importedAdCategoriesCollection = importedAdCategoriesCollection;
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
        if (!(object instanceof AdCategories)) {
            return false;
        }
        AdCategories other = (AdCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdCategories[ id=" + id + " ]";
    }
    
}
