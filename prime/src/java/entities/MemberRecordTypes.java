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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "member_record_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberRecordTypes.findAll", query = "SELECT m FROM MemberRecordTypes m"),
    @NamedQuery(name = "MemberRecordTypes.findById", query = "SELECT m FROM MemberRecordTypes m WHERE m.id = :id"),
    @NamedQuery(name = "MemberRecordTypes.findByName", query = "SELECT m FROM MemberRecordTypes m WHERE m.name = :name"),
    @NamedQuery(name = "MemberRecordTypes.findByLabel", query = "SELECT m FROM MemberRecordTypes m WHERE m.label = :label"),
    @NamedQuery(name = "MemberRecordTypes.findByEditable", query = "SELECT m FROM MemberRecordTypes m WHERE m.editable = :editable"),
    @NamedQuery(name = "MemberRecordTypes.findByShowMenuItem", query = "SELECT m FROM MemberRecordTypes m WHERE m.showMenuItem = :showMenuItem"),
    @NamedQuery(name = "MemberRecordTypes.findByLayout", query = "SELECT m FROM MemberRecordTypes m WHERE m.layout = :layout")})
public class MemberRecordTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "label")
    private String label;
    @Basic(optional = false)
    @NotNull
    @Column(name = "editable")
    private boolean editable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_menu_item")
    private boolean showMenuItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "layout")
    private String layout;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "memberRecordTypesCollection")
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "memberRecordTypesCollection1")
    private Collection<Groups> groupsCollection1;
    @ManyToMany(mappedBy = "memberRecordTypesCollection2")
    private Collection<Groups> groupsCollection2;
    @ManyToMany(mappedBy = "memberRecordTypesCollection3")
    private Collection<Groups> groupsCollection3;
    @ManyToMany(mappedBy = "memberRecordTypesCollection4")
    private Collection<Groups> groupsCollection4;
    @ManyToMany(mappedBy = "memberRecordTypesCollection5")
    private Collection<Groups> groupsCollection5;
    @ManyToMany(mappedBy = "memberRecordTypesCollection6")
    private Collection<Groups> groupsCollection6;
    @ManyToMany(mappedBy = "memberRecordTypesCollection7")
    private Collection<Groups> groupsCollection7;
    @ManyToMany(mappedBy = "memberRecordTypesCollection8")
    private Collection<Groups> groupsCollection8;
    @ManyToMany(mappedBy = "memberRecordTypesCollection9")
    private Collection<Groups> groupsCollection9;
    @ManyToMany(mappedBy = "memberRecordTypesCollection10")
    private Collection<Groups> groupsCollection10;
    @ManyToMany(mappedBy = "memberRecordTypesCollection11")
    private Collection<Groups> groupsCollection11;
    @ManyToMany(mappedBy = "memberRecordTypesCollection12")
    private Collection<Groups> groupsCollection12;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberRecordTypeId")
    private Collection<MemberRecords> memberRecordsCollection;
    @OneToMany(mappedBy = "memberRecordTypeId")
    private Collection<CustomFields> customFieldsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberRecordTypeId")
    private Collection<ImportedMemberRecords> importedMemberRecordsCollection;

    public MemberRecordTypes() {
    }

    public MemberRecordTypes(Integer id) {
        this.id = id;
    }

    public MemberRecordTypes(Integer id, String name, String label, boolean editable, boolean showMenuItem, String layout) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.editable = editable;
        this.showMenuItem = showMenuItem;
        this.layout = layout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean getEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean getShowMenuItem() {
        return showMenuItem;
    }

    public void setShowMenuItem(boolean showMenuItem) {
        this.showMenuItem = showMenuItem;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection1() {
        return groupsCollection1;
    }

    public void setGroupsCollection1(Collection<Groups> groupsCollection1) {
        this.groupsCollection1 = groupsCollection1;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection2() {
        return groupsCollection2;
    }

    public void setGroupsCollection2(Collection<Groups> groupsCollection2) {
        this.groupsCollection2 = groupsCollection2;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection3() {
        return groupsCollection3;
    }

    public void setGroupsCollection3(Collection<Groups> groupsCollection3) {
        this.groupsCollection3 = groupsCollection3;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection4() {
        return groupsCollection4;
    }

    public void setGroupsCollection4(Collection<Groups> groupsCollection4) {
        this.groupsCollection4 = groupsCollection4;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection5() {
        return groupsCollection5;
    }

    public void setGroupsCollection5(Collection<Groups> groupsCollection5) {
        this.groupsCollection5 = groupsCollection5;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection6() {
        return groupsCollection6;
    }

    public void setGroupsCollection6(Collection<Groups> groupsCollection6) {
        this.groupsCollection6 = groupsCollection6;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection7() {
        return groupsCollection7;
    }

    public void setGroupsCollection7(Collection<Groups> groupsCollection7) {
        this.groupsCollection7 = groupsCollection7;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection8() {
        return groupsCollection8;
    }

    public void setGroupsCollection8(Collection<Groups> groupsCollection8) {
        this.groupsCollection8 = groupsCollection8;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection9() {
        return groupsCollection9;
    }

    public void setGroupsCollection9(Collection<Groups> groupsCollection9) {
        this.groupsCollection9 = groupsCollection9;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection10() {
        return groupsCollection10;
    }

    public void setGroupsCollection10(Collection<Groups> groupsCollection10) {
        this.groupsCollection10 = groupsCollection10;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection11() {
        return groupsCollection11;
    }

    public void setGroupsCollection11(Collection<Groups> groupsCollection11) {
        this.groupsCollection11 = groupsCollection11;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection12() {
        return groupsCollection12;
    }

    public void setGroupsCollection12(Collection<Groups> groupsCollection12) {
        this.groupsCollection12 = groupsCollection12;
    }

    @XmlTransient
    public Collection<MemberRecords> getMemberRecordsCollection() {
        return memberRecordsCollection;
    }

    public void setMemberRecordsCollection(Collection<MemberRecords> memberRecordsCollection) {
        this.memberRecordsCollection = memberRecordsCollection;
    }

    @XmlTransient
    public Collection<CustomFields> getCustomFieldsCollection() {
        return customFieldsCollection;
    }

    public void setCustomFieldsCollection(Collection<CustomFields> customFieldsCollection) {
        this.customFieldsCollection = customFieldsCollection;
    }

    @XmlTransient
    public Collection<ImportedMemberRecords> getImportedMemberRecordsCollection() {
        return importedMemberRecordsCollection;
    }

    public void setImportedMemberRecordsCollection(Collection<ImportedMemberRecords> importedMemberRecordsCollection) {
        this.importedMemberRecordsCollection = importedMemberRecordsCollection;
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
        if (!(object instanceof MemberRecordTypes)) {
            return false;
        }
        MemberRecordTypes other = (MemberRecordTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberRecordTypes[ id=" + id + " ]";
    }
    
}
