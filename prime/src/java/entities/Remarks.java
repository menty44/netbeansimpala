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
import javax.persistence.Lob;
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
@Table(name = "remarks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remarks.findAll", query = "SELECT r FROM Remarks r"),
    @NamedQuery(name = "Remarks.findById", query = "SELECT r FROM Remarks r WHERE r.id = :id"),
    @NamedQuery(name = "Remarks.findBySubclass", query = "SELECT r FROM Remarks r WHERE r.subclass = :subclass"),
    @NamedQuery(name = "Remarks.findByDate", query = "SELECT r FROM Remarks r WHERE r.date = :date")})
public class Remarks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members subjectId;
    @JoinColumn(name = "new_broker_id", referencedColumnName = "id")
    @ManyToOne
    private Members newBrokerId;
    @JoinColumn(name = "old_group_id", referencedColumnName = "id")
    @ManyToOne
    private Groups oldGroupId;
    @JoinColumn(name = "new_group_id", referencedColumnName = "id")
    @ManyToOne
    private Groups newGroupId;
    @JoinColumn(name = "old_broker_id", referencedColumnName = "id")
    @ManyToOne
    private Members oldBrokerId;
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    @ManyToOne
    private Members writerId;

    public Remarks() {
    }

    public Remarks(Integer id) {
        this.id = id;
    }

    public Remarks(Integer id, String subclass, Date date) {
        this.id = id;
        this.subclass = subclass;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Members getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Members subjectId) {
        this.subjectId = subjectId;
    }

    public Members getNewBrokerId() {
        return newBrokerId;
    }

    public void setNewBrokerId(Members newBrokerId) {
        this.newBrokerId = newBrokerId;
    }

    public Groups getOldGroupId() {
        return oldGroupId;
    }

    public void setOldGroupId(Groups oldGroupId) {
        this.oldGroupId = oldGroupId;
    }

    public Groups getNewGroupId() {
        return newGroupId;
    }

    public void setNewGroupId(Groups newGroupId) {
        this.newGroupId = newGroupId;
    }

    public Members getOldBrokerId() {
        return oldBrokerId;
    }

    public void setOldBrokerId(Members oldBrokerId) {
        this.oldBrokerId = oldBrokerId;
    }

    public Members getWriterId() {
        return writerId;
    }

    public void setWriterId(Members writerId) {
        this.writerId = writerId;
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
        if (!(object instanceof Remarks)) {
            return false;
        }
        Remarks other = (Remarks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Remarks[ id=" + id + " ]";
    }
    
}
