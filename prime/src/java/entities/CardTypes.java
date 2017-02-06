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
@Table(name = "card_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardTypes.findAll", query = "SELECT c FROM CardTypes c"),
    @NamedQuery(name = "CardTypes.findById", query = "SELECT c FROM CardTypes c WHERE c.id = :id"),
    @NamedQuery(name = "CardTypes.findByName", query = "SELECT c FROM CardTypes c WHERE c.name = :name"),
    @NamedQuery(name = "CardTypes.findByCardFormatNumber", query = "SELECT c FROM CardTypes c WHERE c.cardFormatNumber = :cardFormatNumber"),
    @NamedQuery(name = "CardTypes.findByDefaultExpirationNumber", query = "SELECT c FROM CardTypes c WHERE c.defaultExpirationNumber = :defaultExpirationNumber"),
    @NamedQuery(name = "CardTypes.findByDefaultExpirationField", query = "SELECT c FROM CardTypes c WHERE c.defaultExpirationField = :defaultExpirationField"),
    @NamedQuery(name = "CardTypes.findByCardSecurityCode", query = "SELECT c FROM CardTypes c WHERE c.cardSecurityCode = :cardSecurityCode"),
    @NamedQuery(name = "CardTypes.findByShowCardSecurityCode", query = "SELECT c FROM CardTypes c WHERE c.showCardSecurityCode = :showCardSecurityCode"),
    @NamedQuery(name = "CardTypes.findByIgnoreDayInExpirationDate", query = "SELECT c FROM CardTypes c WHERE c.ignoreDayInExpirationDate = :ignoreDayInExpirationDate"),
    @NamedQuery(name = "CardTypes.findByMinCardSecurityCodeLength", query = "SELECT c FROM CardTypes c WHERE c.minCardSecurityCodeLength = :minCardSecurityCodeLength"),
    @NamedQuery(name = "CardTypes.findByMaxCardSecurityCodeLength", query = "SELECT c FROM CardTypes c WHERE c.maxCardSecurityCodeLength = :maxCardSecurityCodeLength"),
    @NamedQuery(name = "CardTypes.findBySecurityCodeBlockTimeNumber", query = "SELECT c FROM CardTypes c WHERE c.securityCodeBlockTimeNumber = :securityCodeBlockTimeNumber"),
    @NamedQuery(name = "CardTypes.findBySecurityCodeBlockTimeField", query = "SELECT c FROM CardTypes c WHERE c.securityCodeBlockTimeField = :securityCodeBlockTimeField"),
    @NamedQuery(name = "CardTypes.findByMaxSecurityCodeTries", query = "SELECT c FROM CardTypes c WHERE c.maxSecurityCodeTries = :maxSecurityCodeTries")})
public class CardTypes implements Serializable {

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
    @Size(max = 56)
    @Column(name = "card_format_number")
    private String cardFormatNumber;
    @Column(name = "default_expiration_number")
    private Integer defaultExpirationNumber;
    @Column(name = "default_expiration_field")
    private Integer defaultExpirationField;
    @Size(max = 1)
    @Column(name = "card_security_code")
    private String cardSecurityCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_card_security_code")
    private boolean showCardSecurityCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ignore_day_in_expiration_date")
    private boolean ignoreDayInExpirationDate;
    @Column(name = "min_card_security_code_length")
    private Integer minCardSecurityCodeLength;
    @Column(name = "max_card_security_code_length")
    private Integer maxCardSecurityCodeLength;
    @Column(name = "security_code_block_time_number")
    private Integer securityCodeBlockTimeNumber;
    @Column(name = "security_code_block_time_field")
    private Integer securityCodeBlockTimeField;
    @Column(name = "max_security_code_tries")
    private Integer maxSecurityCodeTries;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardTypeId")
    private Collection<Cards> cardsCollection;
    @OneToMany(mappedBy = "cardTypeId")
    private Collection<Groups> groupsCollection;

    public CardTypes() {
    }

    public CardTypes(Integer id) {
        this.id = id;
    }

    public CardTypes(Integer id, String name, boolean showCardSecurityCode, boolean ignoreDayInExpirationDate) {
        this.id = id;
        this.name = name;
        this.showCardSecurityCode = showCardSecurityCode;
        this.ignoreDayInExpirationDate = ignoreDayInExpirationDate;
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

    public String getCardFormatNumber() {
        return cardFormatNumber;
    }

    public void setCardFormatNumber(String cardFormatNumber) {
        this.cardFormatNumber = cardFormatNumber;
    }

    public Integer getDefaultExpirationNumber() {
        return defaultExpirationNumber;
    }

    public void setDefaultExpirationNumber(Integer defaultExpirationNumber) {
        this.defaultExpirationNumber = defaultExpirationNumber;
    }

    public Integer getDefaultExpirationField() {
        return defaultExpirationField;
    }

    public void setDefaultExpirationField(Integer defaultExpirationField) {
        this.defaultExpirationField = defaultExpirationField;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public boolean getShowCardSecurityCode() {
        return showCardSecurityCode;
    }

    public void setShowCardSecurityCode(boolean showCardSecurityCode) {
        this.showCardSecurityCode = showCardSecurityCode;
    }

    public boolean getIgnoreDayInExpirationDate() {
        return ignoreDayInExpirationDate;
    }

    public void setIgnoreDayInExpirationDate(boolean ignoreDayInExpirationDate) {
        this.ignoreDayInExpirationDate = ignoreDayInExpirationDate;
    }

    public Integer getMinCardSecurityCodeLength() {
        return minCardSecurityCodeLength;
    }

    public void setMinCardSecurityCodeLength(Integer minCardSecurityCodeLength) {
        this.minCardSecurityCodeLength = minCardSecurityCodeLength;
    }

    public Integer getMaxCardSecurityCodeLength() {
        return maxCardSecurityCodeLength;
    }

    public void setMaxCardSecurityCodeLength(Integer maxCardSecurityCodeLength) {
        this.maxCardSecurityCodeLength = maxCardSecurityCodeLength;
    }

    public Integer getSecurityCodeBlockTimeNumber() {
        return securityCodeBlockTimeNumber;
    }

    public void setSecurityCodeBlockTimeNumber(Integer securityCodeBlockTimeNumber) {
        this.securityCodeBlockTimeNumber = securityCodeBlockTimeNumber;
    }

    public Integer getSecurityCodeBlockTimeField() {
        return securityCodeBlockTimeField;
    }

    public void setSecurityCodeBlockTimeField(Integer securityCodeBlockTimeField) {
        this.securityCodeBlockTimeField = securityCodeBlockTimeField;
    }

    public Integer getMaxSecurityCodeTries() {
        return maxSecurityCodeTries;
    }

    public void setMaxSecurityCodeTries(Integer maxSecurityCodeTries) {
        this.maxSecurityCodeTries = maxSecurityCodeTries;
    }

    @XmlTransient
    public Collection<Cards> getCardsCollection() {
        return cardsCollection;
    }

    public void setCardsCollection(Collection<Cards> cardsCollection) {
        this.cardsCollection = cardsCollection;
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
        if (!(object instanceof CardTypes)) {
            return false;
        }
        CardTypes other = (CardTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CardTypes[ id=" + id + " ]";
    }
    
}
