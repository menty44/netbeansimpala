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
@Table(name = "pos_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PosLogs.findAll", query = "SELECT p FROM PosLogs p"),
    @NamedQuery(name = "PosLogs.findById", query = "SELECT p FROM PosLogs p WHERE p.id = :id"),
    @NamedQuery(name = "PosLogs.findByDate", query = "SELECT p FROM PosLogs p WHERE p.date = :date"),
    @NamedQuery(name = "PosLogs.findByPosStatus", query = "SELECT p FROM PosLogs p WHERE p.posStatus = :posStatus"),
    @NamedQuery(name = "PosLogs.findByMemberPosStatus", query = "SELECT p FROM PosLogs p WHERE p.memberPosStatus = :memberPosStatus")})
public class PosLogs implements Serializable {

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
    @Size(min = 1, max = 1)
    @Column(name = "pos_status")
    private String posStatus;
    @Size(max = 1)
    @Column(name = "member_pos_status")
    private String memberPosStatus;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;
    @JoinColumn(name = "assigned_to", referencedColumnName = "id")
    @ManyToOne
    private Members assignedTo;
    @JoinColumn(name = "pos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pos posId;

    public PosLogs() {
    }

    public PosLogs(Integer id) {
        this.id = id;
    }

    public PosLogs(Integer id, Date date, String posStatus) {
        this.id = id;
        this.date = date;
        this.posStatus = posStatus;
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

    public String getPosStatus() {
        return posStatus;
    }

    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus;
    }

    public String getMemberPosStatus() {
        return memberPosStatus;
    }

    public void setMemberPosStatus(String memberPosStatus) {
        this.memberPosStatus = memberPosStatus;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public Members getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Members assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Pos getPosId() {
        return posId;
    }

    public void setPosId(Pos posId) {
        this.posId = posId;
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
        if (!(object instanceof PosLogs)) {
            return false;
        }
        PosLogs other = (PosLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PosLogs[ id=" + id + " ]";
    }
    
}
