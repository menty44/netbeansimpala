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
@Table(name = "ads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ads.findAll", query = "SELECT a FROM Ads a"),
    @NamedQuery(name = "Ads.findById", query = "SELECT a FROM Ads a WHERE a.id = :id"),
    @NamedQuery(name = "Ads.findByPermanent", query = "SELECT a FROM Ads a WHERE a.permanent = :permanent"),
    @NamedQuery(name = "Ads.findByExternalPublication", query = "SELECT a FROM Ads a WHERE a.externalPublication = :externalPublication"),
    @NamedQuery(name = "Ads.findByTitle", query = "SELECT a FROM Ads a WHERE a.title = :title"),
    @NamedQuery(name = "Ads.findByTradeType", query = "SELECT a FROM Ads a WHERE a.tradeType = :tradeType"),
    @NamedQuery(name = "Ads.findByPrice", query = "SELECT a FROM Ads a WHERE a.price = :price"),
    @NamedQuery(name = "Ads.findByPublicationStart", query = "SELECT a FROM Ads a WHERE a.publicationStart = :publicationStart"),
    @NamedQuery(name = "Ads.findByPublicationEnd", query = "SELECT a FROM Ads a WHERE a.publicationEnd = :publicationEnd"),
    @NamedQuery(name = "Ads.findByDeleteDate", query = "SELECT a FROM Ads a WHERE a.deleteDate = :deleteDate"),
    @NamedQuery(name = "Ads.findByCreationDate", query = "SELECT a FROM Ads a WHERE a.creationDate = :creationDate"),
    @NamedQuery(name = "Ads.findByIsHtml", query = "SELECT a FROM Ads a WHERE a.isHtml = :isHtml"),
    @NamedQuery(name = "Ads.findByMembersNotified", query = "SELECT a FROM Ads a WHERE a.membersNotified = :membersNotified")})
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permanent")
    private boolean permanent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "external_publication")
    private boolean externalPublication;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
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
    @Column(name = "delete_date")
    @Temporal(TemporalType.DATE)
    private Date deleteDate;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_html")
    private boolean isHtml;
    @Basic(optional = false)
    @NotNull
    @Column(name = "members_notified")
    private boolean membersNotified;
    @OneToMany(mappedBy = "adId")
    private Collection<Images> imagesCollection;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private AdCategories categoryId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne
    private Currencies currencyId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members ownerId;
    @OneToMany(mappedBy = "adId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public Ads() {
    }

    public Ads(Integer id) {
        this.id = id;
    }

    public Ads(Integer id, boolean permanent, boolean externalPublication, String title, String tradeType, boolean isHtml, boolean membersNotified) {
        this.id = id;
        this.permanent = permanent;
        this.externalPublication = externalPublication;
        this.title = title;
        this.tradeType = tradeType;
        this.isHtml = isHtml;
        this.membersNotified = membersNotified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean getIsHtml() {
        return isHtml;
    }

    public void setIsHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    public boolean getMembersNotified() {
        return membersNotified;
    }

    public void setMembersNotified(boolean membersNotified) {
        this.membersNotified = membersNotified;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public AdCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(AdCategories categoryId) {
        this.categoryId = categoryId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
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
        if (!(object instanceof Ads)) {
            return false;
        }
        Ads other = (Ads) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ads[ id=" + id + " ]";
    }
    
}
