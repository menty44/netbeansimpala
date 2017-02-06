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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "reference_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenceHistory.findAll", query = "SELECT r FROM ReferenceHistory r"),
    @NamedQuery(name = "ReferenceHistory.findById", query = "SELECT r FROM ReferenceHistory r WHERE r.id = :id"),
    @NamedQuery(name = "ReferenceHistory.findByLevel", query = "SELECT r FROM ReferenceHistory r WHERE r.level = :level"),
    @NamedQuery(name = "ReferenceHistory.findByStartDate", query = "SELECT r FROM ReferenceHistory r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "ReferenceHistory.findByEndDate", query = "SELECT r FROM ReferenceHistory r WHERE r.endDate = :endDate")})
public class ReferenceHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private short level;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "from_member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members fromMemberId;
    @JoinColumn(name = "to_member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members toMemberId;

    public ReferenceHistory() {
    }

    public ReferenceHistory(Integer id) {
        this.id = id;
    }

    public ReferenceHistory(Integer id, short level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Members getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(Members fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public Members getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(Members toMemberId) {
        this.toMemberId = toMemberId;
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
        if (!(object instanceof ReferenceHistory)) {
            return false;
        }
        ReferenceHistory other = (ReferenceHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReferenceHistory[ id=" + id + " ]";
    }
    
}
