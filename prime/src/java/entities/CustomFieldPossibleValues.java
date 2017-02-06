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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "custom_field_possible_values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomFieldPossibleValues.findAll", query = "SELECT c FROM CustomFieldPossibleValues c"),
    @NamedQuery(name = "CustomFieldPossibleValues.findById", query = "SELECT c FROM CustomFieldPossibleValues c WHERE c.id = :id"),
    @NamedQuery(name = "CustomFieldPossibleValues.findByValue", query = "SELECT c FROM CustomFieldPossibleValues c WHERE c.value = :value"),
    @NamedQuery(name = "CustomFieldPossibleValues.findByIsEnabled", query = "SELECT c FROM CustomFieldPossibleValues c WHERE c.isEnabled = :isEnabled"),
    @NamedQuery(name = "CustomFieldPossibleValues.findByIsDefault", query = "SELECT c FROM CustomFieldPossibleValues c WHERE c.isDefault = :isDefault")})
public class CustomFieldPossibleValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_default")
    private boolean isDefault;
    @OneToMany(mappedBy = "parentId")
    private Collection<CustomFieldPossibleValues> customFieldPossibleValuesCollection;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFieldPossibleValues parentId;
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFields fieldId;
    @OneToMany(mappedBy = "possibleValueId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public CustomFieldPossibleValues() {
    }

    public CustomFieldPossibleValues(Integer id) {
        this.id = id;
    }

    public CustomFieldPossibleValues(Integer id, String value, boolean isEnabled, boolean isDefault) {
        this.id = id;
        this.value = value;
        this.isEnabled = isEnabled;
        this.isDefault = isDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @XmlTransient
    public Collection<CustomFieldPossibleValues> getCustomFieldPossibleValuesCollection() {
        return customFieldPossibleValuesCollection;
    }

    public void setCustomFieldPossibleValuesCollection(Collection<CustomFieldPossibleValues> customFieldPossibleValuesCollection) {
        this.customFieldPossibleValuesCollection = customFieldPossibleValuesCollection;
    }

    public CustomFieldPossibleValues getParentId() {
        return parentId;
    }

    public void setParentId(CustomFieldPossibleValues parentId) {
        this.parentId = parentId;
    }

    public CustomFields getFieldId() {
        return fieldId;
    }

    public void setFieldId(CustomFields fieldId) {
        this.fieldId = fieldId;
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
        if (!(object instanceof CustomFieldPossibleValues)) {
            return false;
        }
        CustomFieldPossibleValues other = (CustomFieldPossibleValues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomFieldPossibleValues[ id=" + id + " ]";
    }
    
}
