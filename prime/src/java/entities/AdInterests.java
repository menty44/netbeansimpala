/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "ad_interests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdInterests.findAll", query = "SELECT a FROM AdInterests a"),
    @NamedQuery(name = "AdInterests.findById", query = "SELECT a FROM AdInterests a WHERE a.id = :id"),
    @NamedQuery(name = "AdInterests.findByTitle", query = "SELECT a FROM AdInterests a WHERE a.title = :title"),
    @NamedQuery(name = "AdInterests.findByTradeType", query = "SELECT a FROM AdInterests a WHERE a.tradeType = :tradeType"),
    @NamedQuery(name = "AdInterests.findByInitialPrice", query = "SELECT a FROM AdInterests a WHERE a.initialPrice = :initialPrice"),
    @NamedQuery(name = "AdInterests.findByFinalPrice", query = "SELECT a FROM AdInterests a WHERE a.finalPrice = :finalPrice"),
    @NamedQuery(name = "AdInterests.findByKeywords", query = "SELECT a FROM AdInterests a WHERE a.keywords = :keywords")})
public class AdInterests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "initial_price")
    private BigDecimal initialPrice;
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Size(max = 255)
    @Column(name = "keywords")
    private String keywords;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private AdCategories categoryId;
    @JoinColumn(name = "group_filter_id", referencedColumnName = "id")
    @ManyToOne
    private GroupFilters groupFilterId;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne
    private Currencies currencyId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members ownerId;

    public AdInterests() {
    }

    public AdInterests(Integer id) {
        this.id = id;
    }

    public AdInterests(Integer id, String title, String tradeType) {
        this.id = id;
        this.title = title;
        this.tradeType = tradeType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public AdCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(AdCategories categoryId) {
        this.categoryId = categoryId;
    }

    public GroupFilters getGroupFilterId() {
        return groupFilterId;
    }

    public void setGroupFilterId(GroupFilters groupFilterId) {
        this.groupFilterId = groupFilterId;
    }

    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    public Members getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Members ownerId) {
        this.ownerId = ownerId;
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
        if (!(object instanceof AdInterests)) {
            return false;
        }
        AdInterests other = (AdInterests) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdInterests[ id=" + id + " ]";
    }
    
}
