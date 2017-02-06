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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pos.findAll", query = "SELECT p FROM Pos p"),
    @NamedQuery(name = "Pos.findById", query = "SELECT p FROM Pos p WHERE p.id = :id"),
    @NamedQuery(name = "Pos.findByPosId", query = "SELECT p FROM Pos p WHERE p.posId = :posId"),
    @NamedQuery(name = "Pos.findByDescription", query = "SELECT p FROM Pos p WHERE p.description = :description"),
    @NamedQuery(name = "Pos.findByStatus", query = "SELECT p FROM Pos p WHERE p.status = :status")})
public class Pos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "pos_id")
    private String posId;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posId")
    private Collection<MemberPos> memberPosCollection;
    @JoinColumn(name = "member_pos_id", referencedColumnName = "id")
    @ManyToOne
    private MemberPos memberPosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posId")
    private Collection<PosLogs> posLogsCollection;

    public Pos() {
    }

    public Pos(Integer id) {
        this.id = id;
    }

    public Pos(Integer id, String posId, String status) {
        this.id = id;
        this.posId = posId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<MemberPos> getMemberPosCollection() {
        return memberPosCollection;
    }

    public void setMemberPosCollection(Collection<MemberPos> memberPosCollection) {
        this.memberPosCollection = memberPosCollection;
    }

    public MemberPos getMemberPosId() {
        return memberPosId;
    }

    public void setMemberPosId(MemberPos memberPosId) {
        this.memberPosId = memberPosId;
    }

    @XmlTransient
    public Collection<PosLogs> getPosLogsCollection() {
        return posLogsCollection;
    }

    public void setPosLogsCollection(Collection<PosLogs> posLogsCollection) {
        this.posLogsCollection = posLogsCollection;
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
        if (!(object instanceof Pos)) {
            return false;
        }
        Pos other = (Pos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pos[ id=" + id + " ]";
    }
    
}
