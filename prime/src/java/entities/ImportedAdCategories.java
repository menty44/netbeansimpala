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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "imported_ad_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImportedAdCategories.findAll", query = "SELECT i FROM ImportedAdCategories i"),
    @NamedQuery(name = "ImportedAdCategories.findById", query = "SELECT i FROM ImportedAdCategories i WHERE i.id = :id"),
    @NamedQuery(name = "ImportedAdCategories.findByName", query = "SELECT i FROM ImportedAdCategories i WHERE i.name = :name")})
public class ImportedAdCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "importedCategoryId")
    private Collection<ImportedAds> importedAdsCollection;
    @JoinColumn(name = "existing_parent_id", referencedColumnName = "id")
    @ManyToOne
    private AdCategories existingParentId;
    @OneToMany(mappedBy = "importedParentId")
    private Collection<ImportedAdCategories> importedAdCategoriesCollection;
    @JoinColumn(name = "imported_parent_id", referencedColumnName = "id")
    @ManyToOne
    private ImportedAdCategories importedParentId;
    @JoinColumn(name = "ad_import_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdImports adImportId;

    public ImportedAdCategories() {
    }

    public ImportedAdCategories(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Collection<ImportedAds> getImportedAdsCollection() {
        return importedAdsCollection;
    }

    public void setImportedAdsCollection(Collection<ImportedAds> importedAdsCollection) {
        this.importedAdsCollection = importedAdsCollection;
    }

    public AdCategories getExistingParentId() {
        return existingParentId;
    }

    public void setExistingParentId(AdCategories existingParentId) {
        this.existingParentId = existingParentId;
    }

    @XmlTransient
    public Collection<ImportedAdCategories> getImportedAdCategoriesCollection() {
        return importedAdCategoriesCollection;
    }

    public void setImportedAdCategoriesCollection(Collection<ImportedAdCategories> importedAdCategoriesCollection) {
        this.importedAdCategoriesCollection = importedAdCategoriesCollection;
    }

    public ImportedAdCategories getImportedParentId() {
        return importedParentId;
    }

    public void setImportedParentId(ImportedAdCategories importedParentId) {
        this.importedParentId = importedParentId;
    }

    public AdImports getAdImportId() {
        return adImportId;
    }

    public void setAdImportId(AdImports adImportId) {
        this.adImportId = adImportId;
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
        if (!(object instanceof ImportedAdCategories)) {
            return false;
        }
        ImportedAdCategories other = (ImportedAdCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ImportedAdCategories[ id=" + id + " ]";
    }
    
}
