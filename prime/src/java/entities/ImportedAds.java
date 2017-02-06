/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "imported_ads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImportedAds.findAll", query = "SELECT i FROM ImportedAds i"),
    @NamedQuery(name = "ImportedAds.findById", query = "SELECT i FROM ImportedAds i WHERE i.id = :id"),
    @NamedQuery(name = "ImportedAds.findByLineNumber", query = "SELECT i FROM ImportedAds i WHERE i.lineNumber = :lineNumber"),
    @NamedQuery(name = "ImportedAds.findByStatus", query = "SELECT i FROM ImportedAds i WHERE i.status = :status"),
    @NamedQuery(name = "ImportedAds.findByErrorArgument1", query = "SELECT i FROM ImportedAds i WHERE i.errorArgument1 = :errorArgument1"),
    @NamedQuery(name = "ImportedAds.findByErrorArgument2", query = "SELECT i FROM ImportedAds i WHERE i.errorArgument2 = :errorArgument2"),
    @NamedQuery(name = "ImportedAds.findByPermanent", query = "SELECT i FROM ImportedAds i WHERE i.permanent = :permanent"),
    @NamedQuery(name = "ImportedAds.findByExternalPublication", query = "SELECT i FROM ImportedAds i WHERE i.externalPublication = :externalPublication"),
    @NamedQuery(name = "ImportedAds.findByTitle", query = "SELECT i FROM ImportedAds i WHERE i.title = :title"),
    @NamedQuery(name = "ImportedAds.findByTradeType", query = "SELECT i FROM ImportedAds i WHERE i.tradeType = :tradeType"),
    @NamedQuery(name = "ImportedAds.findByPrice", query = "SELECT i FROM ImportedAds i WHERE i.price = :price"),
    @NamedQuery(name = "ImportedAds.findByPublicationStart", query = "SELECT i FROM ImportedAds i WHERE i.publicationStart = :publicationStart"),
    @NamedQuery(name = "ImportedAds.findByPublicationEnd", query = "SELECT i FROM ImportedAds i WHERE i.publicationEnd = :publicationEnd"),
    @NamedQuery(name = "ImportedAds.findByIsHtml", query = "SELECT i FROM ImportedAds i WHERE i.isHtml = :isHtml")})
public class ImportedAds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "line_number")
    private Integer lineNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 200)
    @Column(name = "error_argument1")
    private String errorArgument1;
    @Size(max = 200)
    @Column(name = "error_argument2")
    private String errorArgument2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permanent")
    private boolean permanent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "external_publication")
    private boolean externalPublication;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Size(max = 1)
    @Column(name = "trade_type")
    private String tradeType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "publication_start")
    @Temporal(TemporalType.DATE)
    private Date publicationStart;
    @Column(name = "publication_end")
    @Temporal(TemporalType.DATE)
    private Date publicationEnd;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_html")
    private boolean isHtml;
    @JoinColumn(name = "imported_category_id", referencedColumnName = "id")
    @ManyToOne
    private ImportedAdCategories importedCategoryId;
    @JoinColumn(name = "existing_category_id", referencedColumnName = "id")
    @ManyToOne
    private AdCategories existingCategoryId;
    @JoinColumn(name = "import_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdImports importId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne
    private Members ownerId;
    @OneToMany(mappedBy = "importedAdId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public ImportedAds() {
    }

    public ImportedAds(Integer id) {
        this.id = id;
    }

    public ImportedAds(Integer id, String status, boolean permanent, boolean externalPublication, boolean isHtml) {
        this.id = id;
        this.status = status;
        this.permanent = permanent;
        this.externalPublication = externalPublication;
        this.isHtml = isHtml;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorArgument1() {
        return errorArgument1;
    }

    public void setErrorArgument1(String errorArgument1) {
        this.errorArgument1 = errorArgument1;
    }

    public String getErrorArgument2() {
        return errorArgument2;
    }

    public void setErrorArgument2(String errorArgument2) {
        this.errorArgument2 = errorArgument2;
    }

    public boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public boolean getExternalPublication() {
        return externalPublication;
    }

    public void setExternalPublication(boolean externalPublication) {
        this.externalPublication = externalPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublicationStart() {
        return publicationStart;
    }

    public void setPublicationStart(Date publicationStart) {
        this.publicationStart = publicationStart;
    }

    public Date getPublicationEnd() {
        return publicationEnd;
    }

    public void setPublicationEnd(Date publicationEnd) {
        this.publicationEnd = publicationEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsHtml() {
        return isHtml;
    }

    public void setIsHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    public ImportedAdCategories getImportedCategoryId() {
        return importedCategoryId;
    }

    public void setImportedCategoryId(ImportedAdCategories importedCategoryId) {
        this.importedCategoryId = importedCategoryId;
    }

    public AdCategories getExistingCategoryId() {
        return existingCategoryId;
    }

    public void setExistingCategoryId(AdCategories existingCategoryId) {
        this.existingCategoryId = existingCategoryId;
    }

    public AdImports getImportId() {
        return importId;
    }

    public void setImportId(AdImports importId) {
        this.importId = importId;
    }

    public Members getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Members ownerId) {
        this.ownerId = ownerId;
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
        if (!(object instanceof ImportedAds)) {
            return false;
        }
        ImportedAds other = (ImportedAds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ImportedAds[ id=" + id + " ]";
    }
    
}
