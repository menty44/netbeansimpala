/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "member_records")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberRecords.findAll", query = "SELECT m FROM MemberRecords m"),
    @NamedQuery(name = "MemberRecords.findById", query = "SELECT m FROM MemberRecords m WHERE m.id = :id"),
    @NamedQuery(name = "MemberRecords.findByDate", query = "SELECT m FROM MemberRecords m WHERE m.date = :date"),
    @NamedQuery(name = "MemberRecords.findByLastModified", query = "SELECT m FROM MemberRecords m WHERE m.lastModified = :lastModified")})
public class MemberRecords implements Serializable {

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
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members byId;
    @JoinColumn(name = "modified_by_id", referencedColumnName = "id")
    @ManyToOne
    private Members modifiedById;
    @JoinColumn(name = "element_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members elementId;
    @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MemberRecordTypes memberRecordTypeId;
    @OneToMany(mappedBy = "memberRecordId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public MemberRecords() {
    }

    public MemberRecords(Integer id) {
        this.id = id;
    }

    public MemberRecords(Integer id, Date date) {
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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public Members getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Members modifiedById) {
        this.modifiedById = modifiedById;
    }

    public Members getElementId() {
        return elementId;
    }

    public void setElementId(Members elementId) {
        this.elementId = elementId;
    }

    public MemberRecordTypes getMemberRecordTypeId() {
        return memberRecordTypeId;
    }

    public void setMemberRecordTypeId(MemberRecordTypes memberRecordTypeId) {
        this.memberRecordTypeId = memberRecordTypeId;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection() {
        return customFieldValuesCollection;
    }

    public void setCustomFieldValuesCollection(Collection<CustomFieldValues> customFieldValuesCollection) {
        this.customFieldValuesCollection = customFieldValuesCollection;
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
        if (!(object instanceof MemberRecords)) {
            return false;
        }
        MemberRecords other = (MemberRecords) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberRecords[ id=" + id + " ]";
    }
    
}