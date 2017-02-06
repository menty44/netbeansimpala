/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "ad_imports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdImports.findAll", query = "SELECT a FROM AdImports a"),
    @NamedQuery(name = "AdImports.findById", query = "SELECT a FROM AdImports a WHERE a.id = :id"),
    @NamedQuery(name = "AdImports.findByDate", query = "SELECT a FROM AdImports a WHERE a.date = :date")})
public class AdImports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importId")
    private Collection<ImportedAds> importedAdsCollection;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members byId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currencies currencyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adImportId")
    private Collection<ImportedAdCategories> importedAdCategoriesCollection;

    public AdImports() {
    }

    public AdImports(Integer id) {
        this.id = id;
    }

    public AdImports(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<ImportedAds> getImportedAdsCollection() {
        return importedAdsCollection;
    }

    public void setImportedAdsCollection(Collection<ImportedAds> importedAdsCollection) {
        this.importedAdsCollection = importedAdsCollection;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
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
        if (!(object instanceof AdImports)) {
            return false;
        }
        AdImports other = (AdImports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdImports[ id=" + id + " ]";
    }
    
}
