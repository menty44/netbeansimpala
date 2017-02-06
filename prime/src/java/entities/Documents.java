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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d"),
    @NamedQuery(name = "Documents.findById", query = "SELECT d FROM Documents d WHERE d.id = :id"),
    @NamedQuery(name = "Documents.findBySubclass", query = "SELECT d FROM Documents d WHERE d.subclass = :subclass"),
    @NamedQuery(name = "Documents.findByName", query = "SELECT d FROM Documents d WHERE d.name = :name"),
    @NamedQuery(name = "Documents.findByVisibility", query = "SELECT d FROM Documents d WHERE d.visibility = :visibility")})
public class Documents implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 1)
    @Column(name = "visibility")
    private String visibility;
    @ManyToMany(mappedBy = "documentsCollection")
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "documentsCollection1")
    private Collection<Groups> groupsCollection1;
    @JoinColumn(name = "document_page_id", referencedColumnName = "id")
    @ManyToOne
    private Files documentPageId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @JoinColumn(name = "form_page_id", referencedColumnName = "id")
    @ManyToOne
    private Files formPageId;
    @JoinColumn(name = "binary_file_id", referencedColumnName = "id")
    @ManyToOne
    private BinaryFiles binaryFileId;
    @OneToMany(mappedBy = "documentId")
    private Collection<Files> filesCollection;

    public Documents() {
    }

    public Documents(Integer id) {
        this.id = id;
    }

    public Documents(Integer id, String subclass, String name) {
        this.id = id;
        this.subclass = subclass;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
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

    public Files getDocumentPageId() {
        return documentPageId;
    }

    public void setDocumentPageId(Files documentPageId) {
        this.documentPageId = documentPageId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    public Files getFormPageId() {
        return formPageId;
    }

    public void setFormPageId(Files formPageId) {
        this.formPageId = formPageId;
    }

    public BinaryFiles getBinaryFileId() {
        return binaryFileId;
    }

    public void setBinaryFileId(BinaryFiles binaryFileId) {
        this.binaryFileId = binaryFileId;
    }

    @XmlTransient
    public Collection<Files> getFilesCollection() {
        return filesCollection;
    }

    public void setFilesCollection(Collection<Files> filesCollection) {
        this.filesCollection = filesCollection;
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
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Documents[ id=" + id + " ]";
    }
    
}
