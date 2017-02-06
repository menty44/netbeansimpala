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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "field_mappings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FieldMappings.findAll", query = "SELECT f FROM FieldMappings f"),
    @NamedQuery(name = "FieldMappings.findById", query = "SELECT f FROM FieldMappings f WHERE f.id = :id"),
    @NamedQuery(name = "FieldMappings.findByOrderIndex", query = "SELECT f FROM FieldMappings f WHERE f.orderIndex = :orderIndex"),
    @NamedQuery(name = "FieldMappings.findByName", query = "SELECT f FROM FieldMappings f WHERE f.name = :name"),
    @NamedQuery(name = "FieldMappings.findByField", query = "SELECT f FROM FieldMappings f WHERE f.field = :field")})
public class FieldMappings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_index")
    private int orderIndex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "field")
    private String field;
    @JoinColumn(name = "file_mapping_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FileMappings fileMappingId;
    @JoinColumn(name = "member_field_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFields memberFieldId;

    public FieldMappings() {
    }

    public FieldMappings(Integer id) {
        this.id = id;
    }

    public FieldMappings(Integer id, int orderIndex, String name, String field) {
        this.id = id;
        this.orderIndex = orderIndex;
        this.name = name;
        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FileMappings getFileMappingId() {
        return fileMappingId;
    }

    public void setFileMappingId(FileMappings fileMappingId) {
        this.fileMappingId = fileMappingId;
    }

    public CustomFields getMemberFieldId() {
        return memberFieldId;
    }

    public void setMemberFieldId(CustomFields memberFieldId) {
        this.memberFieldId = memberFieldId;
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
        if (!(object instanceof FieldMappings)) {
            return false;
        }
        FieldMappings other = (FieldMappings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FieldMappings[ id=" + id + " ]";
    }
    
}
