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
@Table(name = "sessions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s"),
    @NamedQuery(name = "Sessions.findById", query = "SELECT s FROM Sessions s WHERE s.id = :id"),
    @NamedQuery(name = "Sessions.findByIdentifier", query = "SELECT s FROM Sessions s WHERE s.identifier = :identifier"),
    @NamedQuery(name = "Sessions.findByCreationDate", query = "SELECT s FROM Sessions s WHERE s.creationDate = :creationDate"),
    @NamedQuery(name = "Sessions.findByExpirationDate", query = "SELECT s FROM Sessions s WHERE s.expirationDate = :expirationDate"),
    @NamedQuery(name = "Sessions.findByPosWeb", query = "SELECT s FROM Sessions s WHERE s.posWeb = :posWeb"),
    @NamedQuery(name = "Sessions.findByRemoteAddr", query = "SELECT s FROM Sessions s WHERE s.remoteAddr = :remoteAddr")})
public class Sessions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "identifier")
    private String identifier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "pos_web")
    private Boolean posWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "remote_addr")
    private String remoteAddr;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public Sessions() {
    }

    public Sessions(Integer id) {
        this.id = id;
    }

    public Sessions(Integer id, String identifier, Date creationDate, Date expirationDate, String remoteAddr) {
        this.id = id;
        this.identifier = identifier;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.remoteAddr = remoteAddr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getPosWeb() {
        return posWeb;
    }

    public void setPosWeb(Boolean posWeb) {
        this.posWeb = posWeb;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
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
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sessions[ id=" + id + " ]";
    }
    
}
