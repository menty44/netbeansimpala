/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "wrong_credential_attempts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WrongCredentialAttempts.findAll", query = "SELECT w FROM WrongCredentialAttempts w"),
    @NamedQuery(name = "WrongCredentialAttempts.findById", query = "SELECT w FROM WrongCredentialAttempts w WHERE w.id = :id"),
    @NamedQuery(name = "WrongCredentialAttempts.findByDate", query = "SELECT w FROM WrongCredentialAttempts w WHERE w.date = :date"),
    @NamedQuery(name = "WrongCredentialAttempts.findByCredentialType", query = "SELECT w FROM WrongCredentialAttempts w WHERE w.credentialType = :credentialType")})
public class WrongCredentialAttempts implements Serializable {

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
    @Size(max = 1)
    @Column(name = "credential_type")
    private String credentialType;
    @JoinColumn(name = "member_pos_id", referencedColumnName = "id")
    @ManyToOne
    private MemberPos memberPosId;
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    @ManyToOne
    private Cards cardId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;

    public WrongCredentialAttempts() {
    }

    public WrongCredentialAttempts(Integer id) {
        this.id = id;
    }

    public WrongCredentialAttempts(Integer id, Date date) {
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

    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    public MemberPos getMemberPosId() {
        return memberPosId;
    }

    public void setMemberPosId(MemberPos memberPosId) {
        this.memberPosId = memberPosId;
    }

    public Cards getCardId() {
        return cardId;
    }

    public void setCardId(Cards cardId) {
        this.cardId = cardId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof WrongCredentialAttempts)) {
            return false;
        }
        WrongCredentialAttempts other = (WrongCredentialAttempts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.WrongCredentialAttempts[ id=" + id + " ]";
    }
    
}
