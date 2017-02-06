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
@Table(name = "application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findById", query = "SELECT a FROM Application a WHERE a.id = :id"),
    @NamedQuery(name = "Application.findByVersion", query = "SELECT a FROM Application a WHERE a.version = :version"),
    @NamedQuery(name = "Application.findByOnline", query = "SELECT a FROM Application a WHERE a.online = :online"),
    @NamedQuery(name = "Application.findByAccountStatusEnabledSince", query = "SELECT a FROM Application a WHERE a.accountStatusEnabledSince = :accountStatusEnabledSince"),
    @NamedQuery(name = "Application.findByPasswordHash", query = "SELECT a FROM Application a WHERE a.passwordHash = :passwordHash"),
    @NamedQuery(name = "Application.findByLastIndexRebuildingTime", query = "SELECT a FROM Application a WHERE a.lastIndexRebuildingTime = :lastIndexRebuildingTime")})
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "online")
    private boolean online;
    @Column(name = "account_status_enabled_since")
    @Temporal(TemporalType.DATE)
    private Date accountStatusEnabledSince;
    @Size(max = 1)
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "last_index_rebuilding_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastIndexRebuildingTime;

    public Application() {
    }

    public Application(Integer id) {
        this.id = id;
    }

    public Application(Integer id, boolean online) {
        this.id = id;
        this.online = online;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean getOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Date getAccountStatusEnabledSince() {
        return accountStatusEnabledSince;
    }

    public void setAccountStatusEnabledSince(Date accountStatusEnabledSince) {
        this.accountStatusEnabledSince = accountStatusEnabledSince;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getLastIndexRebuildingTime() {
        return lastIndexRebuildingTime;
    }

    public void setLastIndexRebuildingTime(Date lastIndexRebuildingTime) {
        this.lastIndexRebuildingTime = lastIndexRebuildingTime;
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
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Application[ id=" + id + " ]";
    }
    
}
