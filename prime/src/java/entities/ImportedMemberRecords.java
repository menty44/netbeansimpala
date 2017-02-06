/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "imported_member_records")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImportedMemberRecords.findAll", query = "SELECT i FROM ImportedMemberRecords i"),
    @NamedQuery(name = "ImportedMemberRecords.findById", query = "SELECT i FROM ImportedMemberRecords i WHERE i.id = :id")})
public class ImportedMemberRecords implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "imported_member_id", referencedColumnName = "id")
    @ManyToOne
    private ImportedMembers importedMemberId;
    @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MemberRecordTypes memberRecordTypeId;
    @OneToMany(mappedBy = "importedMemberRecordId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public ImportedMemberRecords() {
    }

    public ImportedMemberRecords(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ImportedMembers getImportedMemberId() {
        return importedMemberId;
    }

    public void setImportedMemberId(ImportedMembers importedMemberId) {
        this.importedMemberId = importedMemberId;
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
        if (!(object instanceof ImportedMemberRecords)) {
            return false;
        }
        ImportedMemberRecords other = (ImportedMemberRecords) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ImportedMemberRecords[ id=" + id + " ]";
    }
    
}
