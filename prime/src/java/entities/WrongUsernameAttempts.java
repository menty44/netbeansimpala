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
@Table(name = "wrong_username_attempts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WrongUsernameAttempts.findAll", query = "SELECT w FROM WrongUsernameAttempts w"),
    @NamedQuery(name = "WrongUsernameAttempts.findById", query = "SELECT w FROM WrongUsernameAttempts w WHERE w.id = :id"),
    @NamedQuery(name = "WrongUsernameAttempts.findByDate", query = "SELECT w FROM WrongUsernameAttempts w WHERE w.date = :date"),
    @NamedQuery(name = "WrongUsernameAttempts.findByRemoteAddress", query = "SELECT w FROM WrongUsernameAttempts w WHERE w.remoteAddress = :remoteAddress")})
public class WrongUsernameAttempts implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "remote_address")
    private String remoteAddress;

    public WrongUsernameAttempts() {
    }

    public WrongUsernameAttempts(Integer id) {
        this.id = id;
    }

    public WrongUsernameAttempts(Integer id, Date date, String remoteAddress) {
        this.id = id;
        this.date = date;
        this.remoteAddress = remoteAddress;
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

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
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
        if (!(object instanceof WrongUsernameAttempts)) {
            return false;
        }
        WrongUsernameAttempts other = (WrongUsernameAttempts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.WrongUsernameAttempts[ id=" + id + " ]";
    }
    
}
