/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "cards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cards.findAll", query = "SELECT c FROM Cards c"),
    @NamedQuery(name = "Cards.findById", query = "SELECT c FROM Cards c WHERE c.id = :id"),
    @NamedQuery(name = "Cards.findByCardNumber", query = "SELECT c FROM Cards c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "Cards.findByCardSecurityCode", query = "SELECT c FROM Cards c WHERE c.cardSecurityCode = :cardSecurityCode"),
    @NamedQuery(name = "Cards.findByCreationDate", query = "SELECT c FROM Cards c WHERE c.creationDate = :creationDate"),
    @NamedQuery(name = "Cards.findByActivationDate", query = "SELECT c FROM Cards c WHERE c.activationDate = :activationDate"),
    @NamedQuery(name = "Cards.findByExpirationDate", query = "SELECT c FROM Cards c WHERE c.expirationDate = :expirationDate"),
    @NamedQuery(name = "Cards.findByCardSecurityCodeBlockedUntil", query = "SELECT c FROM Cards c WHERE c.cardSecurityCodeBlockedUntil = :cardSecurityCodeBlockedUntil"),
    @NamedQuery(name = "Cards.findByStatus", query = "SELECT c FROM Cards c WHERE c.status = :status")})
public class Cards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "card_number")
    private BigInteger cardNumber;
    @Size(max = 64)
    @Column(name = "card_security_code")
    private String cardSecurityCode;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "activation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Column(name = "card_security_code_blocked_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cardSecurityCodeBlockedUntil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardId")
    private Collection<CardLogs> cardLogsCollection;
    @OneToMany(mappedBy = "cardId")
    private Collection<WrongCredentialAttempts> wrongCredentialAttemptsCollection;
    @JoinColumn(name = "card_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardTypes cardTypeId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members ownerId;

    public Cards() {
    }

    public Cards(Integer id) {
        this.id = id;
    }

    public Cards(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCardSecurityCodeBlockedUntil() {
        return cardSecurityCodeBlockedUntil;
    }

    public void setCardSecurityCodeBlockedUntil(Date cardSecurityCodeBlockedUntil) {
        this.cardSecurityCodeBlockedUntil = cardSecurityCodeBlockedUntil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<CardLogs> getCardLogsCollection() {
        return cardLogsCollection;
    }

    public void setCardLogsCollection(Collection<CardLogs> cardLogsCollection) {
        this.cardLogsCollection = cardLogsCollection;
    }

    @XmlTransient
    public Collection<WrongCredentialAttempts> getWrongCredentialAttemptsCollection() {
        return wrongCredentialAttemptsCollection;
    }

    public void setWrongCredentialAttemptsCollection(Collection<WrongCredentialAttempts> wrongCredentialAttemptsCollection) {
        this.wrongCredentialAttemptsCollection = wrongCredentialAttemptsCollection;
    }

    public CardTypes getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(CardTypes cardTypeId) {
        this.cardTypeId = cardTypeId;
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
        if (!(object instanceof Cards)) {
            return false;
        }
        Cards other = (Cards) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cards[ id=" + id + " ]";
    }
    
}
