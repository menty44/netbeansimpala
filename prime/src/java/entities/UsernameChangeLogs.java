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
@Table(name = "username_change_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsernameChangeLogs.findAll", query = "SELECT u FROM UsernameChangeLogs u"),
    @NamedQuery(name = "UsernameChangeLogs.findById", query = "SELECT u FROM UsernameChangeLogs u WHERE u.id = :id"),
    @NamedQuery(name = "UsernameChangeLogs.findByDate", query = "SELECT u FROM UsernameChangeLogs u WHERE u.date = :date"),
    @NamedQuery(name = "UsernameChangeLogs.findByPreviousUsername", query = "SELECT u FROM UsernameChangeLogs u WHERE u.previousUsername = :previousUsername"),
    @NamedQuery(name = "UsernameChangeLogs.findByNewUsername", query = "SELECT u FROM UsernameChangeLogs u WHERE u.newUsername = :newUsername")})
public class UsernameChangeLogs implements Serializable {

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
    @Column(name = "previous_username")
    private String previousUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "new_username")
    private String newUsername;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members byId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public UsernameChangeLogs() {
    }

    public UsernameChangeLogs(Integer id) {
        this.id = id;
    }

    public UsernameChangeLogs(Integer id, Date date, String previousUsername, String newUsername) {
        this.id = id;
        this.date = date;
        this.previousUsername = previousUsername;
        this.newUsername = newUsername;
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

    public String getPreviousUsername() {
        return previousUsername;
    }

    public void setPreviousUsername(String previousUsername) {
        this.previousUsername = previousUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
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
        if (!(object instanceof UsernameChangeLogs)) {
            return false;
        }
        UsernameChangeLogs other = (UsernameChangeLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsernameChangeLogs[ id=" + id + " ]";
    }
    
}
