/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "member_sms_status_locks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberSmsStatusLocks.findAll", query = "SELECT m FROM MemberSmsStatusLocks m"),
    @NamedQuery(name = "MemberSmsStatusLocks.findById", query = "SELECT m FROM MemberSmsStatusLocks m WHERE m.id = :id")})
public class MemberSmsStatusLocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    public MemberSmsStatusLocks() {
    }

    public MemberSmsStatusLocks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof MemberSmsStatusLocks)) {
            return false;
        }
        MemberSmsStatusLocks other = (MemberSmsStatusLocks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberSmsStatusLocks[ id=" + id + " ]";
    }
    
}
